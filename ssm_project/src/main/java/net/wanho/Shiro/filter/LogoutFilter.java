package net.wanho.Shiro.filter;

import net.wanho.async.AsyncFactory;
import net.wanho.async.AsyncTask;
import net.wanho.util.ShiroUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogoutFilter extends org.apache.shiro.web.filter.authc.LogoutFilter {

   @Override
   protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {

      // 删除会话和缓存
      // logoutService.deleteSessionAndCache();

      String userName = ShiroUtils.getUserName();
      // 退出日志的记录
      AsyncFactory.getInstance().schedule(AsyncTask.recordLogininfor((HttpServletRequest) request,userName,"0","退出成功"));


      // 调用默认方法
      return super.preHandle(request, response);
   }

   @Override
   public String getRedirectUrl() {
      return "/login.html";
   }
}
