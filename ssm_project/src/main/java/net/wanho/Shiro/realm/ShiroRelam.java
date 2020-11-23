package net.wanho.Shiro.realm;

import cn.hutool.core.util.ObjectUtil;
import net.wanho.mapper.sys.UserMapper;
import net.wanho.po.sys.Ext.UserExt;
import net.wanho.po.sys.User;
import net.wanho.service.sys.MenuServiceI;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroRelam extends AuthorizingRealm {

   @Autowired
   private UserMapper userMapper;

   @Autowired
   private MenuServiceI menuService;

   // 认证
   @Override
   protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
      UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
      String username = token.getUsername();
      // 根据用户名从数据库查询用户,可以再加上未删除、未停用条件
      //User user = new User();
      //user.setUserName(username);
      //List<User> users = userMapper.selectUserList(user);
      UserExt userExt= userMapper.selectUserExt(username);
      //hutool工具类
      if (ObjectUtil.isNotEmpty(userExt)) {

         // 判断是否是删除的用户
         if(userExt.getDelFlag().equals("2")){
            throw  new AuthenticationException("用户已经被删除!");
         }
         // 判断是否停用的用户
         if(userExt.getStatus().equals("1")){
            throw  new AuthenticationException("用户已经被停用!");
         }

         // 认证的关键代码
         return new SimpleAuthenticationInfo(userExt, userExt.getPassword(), ByteSource.Util.bytes(userExt.getSalt()), this.getName());
      }
      return null;
   }

   // 授权
   @Override
   protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

      SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
      //主身份
      User user = (User) principalCollection.getPrimaryPrincipal();
      Long userId = user.getUserId();
      //如果是管理员，则放行所有请求
      if(userId.intValue()==1){
         simpleAuthorizationInfo.addStringPermission("*:*:*");
      }else{
         // 从数据库查询资源菜单   user user_role  role role_menu  menu
         simpleAuthorizationInfo.addStringPermissions( menuService.selectPermsByUserId(userId));
      }
      return simpleAuthorizationInfo;
   }
}
