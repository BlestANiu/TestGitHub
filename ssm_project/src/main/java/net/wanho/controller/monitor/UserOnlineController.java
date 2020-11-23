package net.wanho.controller.monitor;

import net.wanho.controller.BaseController;
import net.wanho.service.monitor.UserOnlineServiceI;
import net.wanho.vo.AjaxResult;
import net.wanho.vo.PageVo;
import net.wanho.vo.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/monitor/online")
public class UserOnlineController extends BaseController {

   @Autowired
   private UserOnlineServiceI userOnlineService;

   @GetMapping
   public ModelAndView Dept(){
      ModelAndView mv = new ModelAndView("/monitor/online");
      return mv;
   }

   @GetMapping("/list")
   public TableDataInfo list(PageVo pageVo){
      return  userOnlineService.list(pageVo);
   }

   @PostMapping("/forceLogout")
   public AjaxResult forceLogout(String sessionId){
      userOnlineService.forceLogout(sessionId);
      return success("强制退出成功");
   }
}
