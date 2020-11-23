package net.wanho.service.sys.impl;


import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import net.wanho.Shiro.dao.ShiroSessionDao;
import net.wanho.async.AsyncFactory;
import net.wanho.async.AsyncTask;
import net.wanho.mapper.sys.UserMapper;
import net.wanho.mapper.sys.UserPostMapper;
import net.wanho.mapper.sys.UserRoleMapper;
import net.wanho.po.sys.Ext.UserExt;
import net.wanho.po.sys.User;
import net.wanho.po.sys.UserPost;
import net.wanho.po.sys.UserRole;
import net.wanho.service.sys.UserServiceI;
import net.wanho.util.ServletUtils;
import net.wanho.util.ShiroUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
/**
* @项目名称:		[cms]
* @类名称:	    [UserServiceImpl]
* @类描述:	    [用户信息表业务逻辑层实现]
* @创建人:	    [choco]
* @创建时间:		[2020-10-09 09:39:59]
* @修改人:	    []
* @修改时间:		[]
* @修改备注:		[]
* @版本:			[]
* @版权:			[]
*/
@Service
@Slf4j
public class UserServiceImpl  implements UserServiceI {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserRoleMapper userRoleMapper;

	@Autowired
	private UserPostMapper userPostMapper;

	@Autowired
	private ShiroSessionDao shiroSessionDao;

	/**
	 * @方法名:	    [selectUserById]
	 * @方法描述:		[查询用户信息表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:59]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public UserExt selectUserById(Long userId){
		try{
			UserExt userExt= userMapper.selectUserById(userId);
			List<UserRole> userRoleList = userExt.getUserRoleList();
			List<UserPost> userPostList = userExt.getUserPostList();

			Long[] postIds = new Long[userPostList.size()];
			for(int i=0;i<userPostList.size();i++){
				postIds[i]=userPostList.get(i).getPostId();
			}

			Long[] roleIds = new Long[userRoleList.size()];
			for(int i=0;i<userRoleList.size();i++){
				roleIds[i]=userRoleList.get(i).getRoleId();
			}

			userExt.setRoleIds(roleIds);
			userExt.setPostIds(postIds);
			return userExt;
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [selectUserList]
	 * @方法描述:		[查询用户信息表列表]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:59]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public List<UserExt> selectUserList(UserExt userExt){
		try{
			return userMapper.selectUserList(userExt);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [insertUser]
	 * @方法描述:		[新增用户信息表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:59]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int insertUserExt( UserExt userExt){
		try{
			userExt.setDeptId(userExt.getDept().getDeptId());
			userExt.setCreateBy(ShiroUtils.getUserName());
			userExt.setCreateTime(new Date());
			userExt.setSalt(RandomUtil.randomNumbers(6));
			userExt.setPassword(ShiroUtils.getEncryptPass(userExt.getPassword(),userExt.getSalt()));

			// 向用户增加
			int res = userMapper.insertUser(userExt);

			// 向用户岗位增加
			insertUserPost(userExt);

			// 向用户角色增加
			insertUserRole(userExt);

			return res;

		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}
	/**
	 * 向用户岗位增加
	 * @param userExt
	 */
	private void insertUserRole(UserExt userExt) {
		List<UserRole> userRoleList = new ArrayList<>();
		if(ArrayUtil.isNotEmpty(userExt.getRoleIds())){
			for(Long roleId:userExt.getRoleIds()){
				UserRole userRole = new UserRole();
				userRole.setUserId(userExt.getUserId());
				userRole.setRoleId(roleId);
				userRoleList.add(userRole);
			}
		}
		if(userRoleList.size()>0)
			userRoleMapper.batchInsertUserRole(userRoleList);
	}

	/**
	 * 向用户角色增加
	 * @param userExt
	 */
	private void insertUserPost(UserExt userExt) {

		List<UserPost> userPostList = new ArrayList<>();
		if(ArrayUtil.isNotEmpty(userExt.getPostIds())){
			for(Long postId:userExt.getPostIds()){
				UserPost userPost = new UserPost();
				userPost.setUserId(userExt.getUserId());
				userPost.setPostId(postId);
				userPostList.add(userPost);
			}
		}
		if(userPostList.size()>0)
			userPostMapper.batchInsertUserPost(userPostList);
	}


	/**
	 * @方法名:	    [updateUser]
	 * @方法描述:		[修改用户信息表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:59]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int updateUser(UserExt userExt){
		try{
			userExt.setUpdateBy(ShiroUtils.getUserName());
			userExt.setUpdateTime(new Date());
			Long userId = userExt.getUserId();
			UserExt dbUserExt = this.selectUserById(userId);
			//密码如果是数据库原始密码，则不需要加密
			if(!dbUserExt.getPassword().equalsIgnoreCase(userExt.getPassword())){
				userExt.setPassword(ShiroUtils.getEncryptPass(userExt.getPassword(),dbUserExt.getSalt()));
			}

			//修改user_post表
			userPostMapper.deleteUserPostById(userId);
			insertUserPost(userExt);

			//修改user_role表
			userRoleMapper.deleteUserRoleById(userId);
			insertUserRole(userExt);


			return userMapper.updateUser(userExt);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [deleteUserByIds]
	 * @方法描述:		[删除用户信息表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:59]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public void deleteUserByIds(String ids){
		try{
			//return userMapper.deleteUserByIds(ids.split(","));
			userMapper.updateBatchUser(ids.split(","));
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [login]
	 * @方法描述:		[登录用户信息表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:59]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public void login(User user) {
		Subject subject = SecurityUtils.getSubject();
		String msg="";
		AuthenticationToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
		try {
			// 登录功能
			subject.login(token);


			// 写入登录日志
			AsyncFactory.getInstance().schedule(AsyncTask.recordLogininfor(ServletUtils.getRequest(), user.getUserName(), "0", "登录成功"));

		} catch (IncorrectCredentialsException e) {
			msg="用户名或密码不正确";
			// 写入登录日志
			AsyncFactory.getInstance().schedule(AsyncTask.recordLogininfor(ServletUtils.getRequest(), user.getUserName(), "1", msg));
			throw new RuntimeException(msg);
		} catch (UnknownAccountException e) {
			msg="用户名不存在";
			// 写入登录日志
			AsyncFactory.getInstance().schedule(AsyncTask.recordLogininfor(ServletUtils.getRequest(), user.getUserName(), "1", msg));
			throw new RuntimeException("用户名不存在");
		} catch (AuthenticationException e) {
			msg=e.getMessage();
			// 写入登录日志
			AsyncFactory.getInstance().schedule(AsyncTask.recordLogininfor(ServletUtils.getRequest(), user.getUserName(), "1", msg));
			throw new RuntimeException(e.getMessage());
		}

	}

	private void singleLogin() {
		// 获取当前登录的用户
		UserExt currentLoginUser = ShiroUtils.getUser();

		Serializable currentSessionId  = SecurityUtils.getSubject().getSession().getId();

		// 获取所有在线用户
		Collection<Session> activeSessions = shiroSessionDao.getActiveSessions();
		for(Session session:activeSessions){
			// 当前用户，则不比较
			if(session.getId().equals(currentSessionId)){
				continue;
			}
			SimplePrincipalCollection simplePrincipalCollection = (SimplePrincipalCollection) session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
			UserExt userExt = (UserExt) simplePrincipalCollection.getPrimaryPrincipal();
			// 已经登录过
			if(userExt.getUserId().intValue()==currentLoginUser.getUserId().intValue()){
				session.stop();
				shiroSessionDao.doDelete(session);
			}
		}

	}

	@Override
	public void resetPass(String userId, String password) {
		try{
			UserExt dbUserExt = this.selectUserById(Long.valueOf(userId));
			dbUserExt.setPassword(ShiroUtils.getEncryptPass(password,dbUserExt.getSalt()));
			userMapper.resetPass(dbUserExt);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new RuntimeException(e);
		}
	}

}
