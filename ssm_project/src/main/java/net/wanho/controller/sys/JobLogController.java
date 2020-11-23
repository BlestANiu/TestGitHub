package net.wanho.controller.sys;

import lombok.extern.slf4j.Slf4j;
import net.wanho.controller.BaseController;
import net.wanho.po.sys.JobLog;
import net.wanho.service.sys.JobLogServiceI;
import net.wanho.vo.AjaxResult;
import net.wanho.vo.PageVo;
import net.wanho.vo.TableDataInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

/**
* @项目名称:	    [cms]
* @类名称:	    [JobLogController]
* @类描述:	    [定时任务调度日志表的控制器]
* @创建人:	    [choco]
* @创建时间:	    [2020-10-09 09:39:58]
* @修改人:	    []
* @修改时间:	    []
* @修改备注:	    []
* @版本:		    []
* @版权:		    []
*/
@Controller
@RequestMapping("/sys/jobLog")
@ResponseBody
@Slf4j
public class JobLogController extends BaseController {
	private static final long serialVersionUID = 1L;

    @Autowired
    private JobLogServiceI jobLogService;

    @RequiresPermissions("sys:jobLog:view")
    @GetMapping()
    public ModelAndView JobLog(){
        ModelAndView mv = new ModelAndView("/sys/jobLog");
        return mv;
    }

    /**
    * @方法名:	    [list]
    * @方法描述:	    [查询定时任务调度日志表列表]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:58]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @GetMapping("/list")
    public TableDataInfo list(JobLog jobLog) {
        try {
            startPage();
            List<JobLog> list = jobLogService.selectJobLogList(jobLog);
            return this.getTableDataInfo(list);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("服务器正忙，请稍后再试");
        }
    }

    /**
    * @方法名:	    [remove]
    * @方法描述:	    [删除定时任务调度日志表列表]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:58]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @DeleteMapping("/remove/{ids}")
    public AjaxResult remove(@PathVariable String ids) {
        try {
            jobLogService.deleteJobLogByIds(ids);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
     * 新增定时任务调度日志表
     */
    @GetMapping("/add")
    public String add(){
        return  "/sys/jobLog/add";
    }

    /**
    * @方法名:	    [add]
    * @方法描述:	    [增加定时任务调度日志表信息]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:58]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @PostMapping
    @RequiresPermissions("sys:jobLog:add")
    public AjaxResult add(JobLog jobLog){

        try {
            jobLogService.insertJobLog(jobLog);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
     * @方法名:	    [getByJobLogById]
     * @方法描述:	    [查询定时任务调度日志表信息]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:58]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    @GetMapping("/{jobLogId}")
    public AjaxResult getByJobLogById(@PathVariable Long jobLogId){
        try {
            JobLog jobLog = jobLogService.selectJobLogById(jobLogId);
            return success(jobLog);
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
    * @方法名:	    [update]
    * @方法描述:	    [修改定时任务调度日志表信息]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:58]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @PutMapping
    @RequiresPermissions("sys:JobLog:edit")
    public AjaxResult update(JobLog jobLog){

        try {
            jobLogService.updateJobLog(jobLog);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }
    }
}
