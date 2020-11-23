package net.wanho.Shiro.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionFactory;

public class ShiroSessionFactory implements SessionFactory {
   public Session createSession(SessionContext initData) {
      ShiroSession shiroSession = new ShiroSession();
      // 设置浏览器
      shiroSession.setBrowser("chrome");
      // 设置操作系统
      shiroSession.setOs("windows");
      // 设置ip
      shiroSession.setIpaddr("127.0.0.1");
      // 设置ip真实中文地址
      shiroSession.setLoginLocation("南京");

      return shiroSession;

   }
}
