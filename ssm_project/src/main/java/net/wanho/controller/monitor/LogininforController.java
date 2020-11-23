package net.wanho.controller.monitor;

import lombok.extern.slf4j.Slf4j;
import net.wanho.controller.BaseController;
import net.wanho.po.sys.Logininfor;
import net.wanho.service.sys.LogininforServiceI;
import net.wanho.vo.AjaxResult;
import net.wanho.vo.TableDataInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
* @项目名称:	    [cms]
* @类名称:	    [LogininforController]
* @类描述:	    [系统访问记录的控制器]
* @创建人:	    [choco]
* @创建时间:	    [2020-10-09 09:39:58]
* @修改人:	    []
* @修改时间:	    []
* @修改备注:	    []
* @版本:		    []
* @版权:		    []
*/
@Controller
@RequestMapping("/monitor/logininfor")
@ResponseBody
@Slf4j
public class LogininforController extends BaseController {
	private static final long serialVersionUID = 1L;

    @Autowired
    private LogininforServiceI logininforService;

    @RequiresPermissions("sys:logininfor:view")
    @GetMapping()
    public ModelAndView Logininfor(){
        ModelAndView mv = new ModelAndView("/monitor/logininfor");
        return mv;
    }

    /**
    * @方法名:	    [list]
    * @方法描述:	    [查询系统访问记录列表]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:58]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @GetMapping("/list")
    public TableDataInfo list(Logininfor logininfor) {
        try {
            startPage();
            List<Logininfor> list = logininforService.selectLogininforList(logininfor);
            return this.getTableDataInfo(list);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("服务器正忙，请稍后再试");
        }
    }

    /**
    * @方法名:	    [remove]
    * @方法描述:	    [删除系统访问记录列表]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:58]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @DeleteMapping("/remove/{ids}")
    public AjaxResult remove(@PathVariable String ids) {
        try {
            logininforService.deleteLogininforByIds(ids);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
     * 新增系统访问记录
     */
    @GetMapping("/add")
    public String add(){
        return  "/monitor/logininfor/add";
    }

    /**
    * @方法名:	    [add]
    * @方法描述:	    [增加系统访问记录信息]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:58]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @PostMapping
    @RequiresPermissions("sys:logininfor:add")
    public AjaxResult add(Logininfor logininfor){

        try {
            logininforService.insertLogininfor(logininfor);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
     * @方法名:	    [getByLogininforById]
     * @方法描述:	    [查询系统访问记录信息]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:58]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    @GetMapping("/{infoId}")
    public AjaxResult getByLogininforById(@PathVariable Long infoId){
        try {
            Logininfor logininfor = logininforService.selectLogininforById(infoId);
            return success(logininfor);
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
    * @方法名:	    [update]
    * @方法描述:	    [修改系统访问记录信息]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:58]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @PutMapping
    @RequiresPermissions("sys:Logininfor:edit")
    public AjaxResult update(Logininfor logininfor){

        try {
            logininforService.updateLogininfor(logininfor);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }
    }
}
