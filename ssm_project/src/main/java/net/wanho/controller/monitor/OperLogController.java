package net.wanho.controller.monitor;

import lombok.extern.slf4j.Slf4j;
import net.wanho.controller.BaseController;
import net.wanho.po.sys.OperLog;
import net.wanho.service.sys.OperLogServiceI;
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
* @类名称:	    [OperLogController]
* @类描述:	    [操作日志记录的控制器]
* @创建人:	    [choco]
* @创建时间:	    [2020-10-09 09:39:59]
* @修改人:	    []
* @修改时间:	    []
* @修改备注:	    []
* @版本:		    []
* @版权:		    []
*/
@Controller
@RequestMapping("/monitor/operLog")
@ResponseBody
@Slf4j
public class OperLogController extends BaseController {
	private static final long serialVersionUID = 1L;

    @Autowired
    private OperLogServiceI operLogService;

    @RequiresPermissions("sys:operLog:view")
    @GetMapping()
    public ModelAndView OperLog(){
        ModelAndView mv = new ModelAndView("/monitor/operLog");
        return mv;
    }

    /**
    * @方法名:	    [list]
    * @方法描述:	    [查询操作日志记录列表]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:59]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @GetMapping("/list")
    public TableDataInfo list(OperLog operLog) {
        try {
            startPage();
            List<OperLog> list = operLogService.selectOperLogList(operLog);
            return this.getTableDataInfo(list);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("服务器正忙，请稍后再试");
        }
    }

    /**
    * @方法名:	    [remove]
    * @方法描述:	    [删除操作日志记录列表]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:59]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @DeleteMapping("/remove/{ids}")
    public AjaxResult remove(@PathVariable String ids) {
        try {
            operLogService.deleteOperLogByIds(ids);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
     * 新增操作日志记录
     */
    @GetMapping("/add")
    public String add(){
        return  "/monitor/operLog/add";
    }

    /**
    * @方法名:	    [add]
    * @方法描述:	    [增加操作日志记录信息]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:59]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @PostMapping
    @RequiresPermissions("sys:operLog:add")
    public AjaxResult add(OperLog operLog){

        try {
            operLogService.insertOperLog(operLog);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
     * @方法名:	    [getByOperLogById]
     * @方法描述:	    [查询操作日志记录信息]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:59]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    @GetMapping("/{operId}")
    public AjaxResult getByOperLogById(@PathVariable Long operId){
        try {
            OperLog operLog = operLogService.selectOperLogById(operId);
            return success(operLog);
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
    * @方法名:	    [update]
    * @方法描述:	    [修改操作日志记录信息]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:59]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @PutMapping
    @RequiresPermissions("sys:OperLog:edit")
    public AjaxResult update(OperLog operLog){

        try {
            operLogService.updateOperLog(operLog);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }
    }
}
