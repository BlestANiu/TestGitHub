package net.wanho.Shiro.session;

import net.wanho.Shiro.dao.ShiroSessionDao;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.session.mgt.WebSessionKey;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import java.io.Serializable;

public class ShiroSessionManager extends DefaultWebSessionManager {

   @Autowired
   private ShiroSessionDao shiroSessionDao;


   /**
    * 获取session
    * 优化单次请求需要多次访问redis的问题
    *
    * @param sessionKey
    * @return
    * @throws UnknownSessionException
    */
   @Override
   protected Session retrieveSession(SessionKey sessionKey) throws UnknownSessionException {
      Serializable sessionId = getSessionId(sessionKey);

      ServletRequest request = null;
      if (sessionKey instanceof WebSessionKey) {
         request = ((WebSessionKey) sessionKey).getServletRequest();
      }

      if (sessionId != null) {
         Object sessionObj = request.getAttribute(sessionId.toString());
         if (sessionObj != null) {
            System.out.println("read session from request");
            return (Session) sessionObj;
         }
      }

      Session session;
      //sessionId不存在时，是在登录页面，调用父类方法创建session并保存到redis中
      if (sessionId == null)
         session = super.retrieveSession(sessionKey);
         //sessionId存在，则直接从redis中获取
      else {
         session = shiroSessionDao.doReadSession(sessionId);

      }

      if (null != session) {
         request.setAttribute(sessionId.toString(), session);
      }
      return session;
   }
}
