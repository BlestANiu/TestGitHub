package net.wanho.service.monitor.impl;

import cn.hutool.core.util.ObjectUtil;
import net.wanho.Shiro.dao.ShiroSessionDao;
import net.wanho.Shiro.session.ShiroSession;
import net.wanho.po.sys.Ext.UserExt;
import net.wanho.service.monitor.UserOnlineServiceI;
import net.wanho.vo.PageVo;
import net.wanho.vo.TableDataInfo;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserOnlineServiceImpl implements UserOnlineServiceI {

   @Autowired
   private ShiroSessionDao shiroSessionDao;

   @Override
   public TableDataInfo list(PageVo pageVo) {
      /*获取所有登录session
       *       目前Session中扩展信息五个中有2个已经赋值（os,browser）
       *       目前是查询所有，并没有分页
       *       要实现分页两种方式：（假分页）
       *           1.使用前端分页（后端传所有数据，前端来分页）
       *           2.使用后端分页，虽然都查出来了，但给对应页码的数据（我们使用）
       */
      Collection<Session> sessions = shiroSessionDao.getActiveSessions();

      // 把Collection<Session> 转 List<ShiroSession>
      List<ShiroSession> shiroSessions = new ArrayList<>();
      for(Session session: sessions){
         SimplePrincipalCollection simplePrincipalCollection = (SimplePrincipalCollection) session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
         if(ObjectUtil.isEmpty(simplePrincipalCollection))
            continue;
         UserExt userExt = (UserExt) simplePrincipalCollection.getPrimaryPrincipal();
         if(ObjectUtil.isEmpty(userExt))
            continue;
         if(session!=null && session instanceof ShiroSession){
            ShiroSession shiroSession = (ShiroSession) session;
            shiroSession.setUserId(userExt.getUserId());
            shiroSession.setLoginName(userExt.getUserName());
            shiroSession.setDeptName(userExt.getDept().getDeptName());
            shiroSessions.add(shiroSession);
         }
      }

      int start =(pageVo.getPageNum()-1)*pageVo.getPageSize();
      int end = start+pageVo.getPageSize();
      List<ShiroSession> currentPageUser = shiroSessions.subList(start, end>shiroSessions.size()?shiroSessions.size():end);

      // 创建TableDataInfo对象
      TableDataInfo tableDataInfo = new TableDataInfo();
      tableDataInfo.setRows(currentPageUser);
      tableDataInfo.setTotal(new Long(shiroSessions.size()));
      return  tableDataInfo;
   }

   @Override
   public void forceLogout(String sessionId) {
      Session session = shiroSessionDao.doReadSession(sessionId);
      if(ObjectUtil.isNotEmpty(session)) {
         session.stop();
         shiroSessionDao.doDelete(session);
      }
   }
}
