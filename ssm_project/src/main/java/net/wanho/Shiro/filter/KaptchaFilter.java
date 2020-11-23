package net.wanho.Shiro.filter;

import cn.hutool.json.JSONUtil;
import com.google.code.kaptcha.Constants;
import net.wanho.vo.AjaxResult;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;

public class KaptchaFilter extends AccessControlFilter {

   // 是否允许访问,判断验证码是否正确
   @Override
   protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {

      HttpServletRequest request = (HttpServletRequest) servletRequest;
      // 当用户输入的验证码跟kaptcha的验证码一样，则允许
      String inputValidateCode = servletRequest.getParameter("validateCode");
      String genValidateCode = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
      if(inputValidateCode.equalsIgnoreCase(genValidateCode))
         return true;
      return false;
   }

   // 访问拒绝给予的提示
   @Override
   protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
      // 设置响应内容和编码
      servletResponse.setContentType("application/json;charset=utf-8");
      PrintWriter out = servletResponse.getWriter();
      // 创建返回对象
      AjaxResult ajaxResult = new AjaxResult(false,500,"验证码不正确",null);
      // hutool把ajax对象转字符串
      String res = JSONUtil.toJsonStr(ajaxResult);
      out.print(res);
      out.close();
      return false;
   }
}
