package net.wanho.controller.sys;

import lombok.extern.slf4j.Slf4j;
import net.wanho.controller.BaseController;
import net.wanho.po.sys.Job;
import net.wanho.service.sys.JobServiceI;
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
* @类名称:	    [JobController]
* @类描述:	    [定时任务调度表的控制器]
* @创建人:	    [choco]
* @创建时间:	    [2020-10-09 09:39:58]
* @修改人:	    []
* @修改时间:	    []
* @修改备注:	    []
* @版本:		    []
* @版权:		    []
*/
@Controller
@RequestMapping("/sys/job")
@ResponseBody
@Slf4j
public class JobController extends BaseController {
	private static final long serialVersionUID = 1L;

    @Autowired
    private JobServiceI jobService;

    @RequiresPermissions("sys:job:view")
    @GetMapping()
    public ModelAndView Job(){
        ModelAndView mv = new ModelAndView("/sys/job");
        return mv;
    }

    /**
    * @方法名:	    [list]
    * @方法描述:	    [查询定时任务调度表列表]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:58]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @GetMapping("/list")
    public TableDataInfo list(Job job) {
        try {
            startPage();
            List<Job> list = jobService.selectJobList(job);
            return this.getTableDataInfo(list);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("服务器正忙，请稍后再试");
        }
    }

    /**
    * @方法名:	    [remove]
    * @方法描述:	    [删除定时任务调度表列表]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:58]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @DeleteMapping("/remove/{ids}")
    public AjaxResult remove(@PathVariable String ids) {
        try {
            jobService.deleteJobByIds(ids);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
     * 新增定时任务调度表
     */
    @GetMapping("/add")
    public String add(){
        return  "/sys/job/add";
    }

    /**
    * @方法名:	    [add]
    * @方法描述:	    [增加定时任务调度表信息]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:58]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @PostMapping
    @RequiresPermissions("sys:job:add")
    public AjaxResult add(Job job){

        try {
            jobService.insertJob(job);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
     * @方法名:	    [getByJobById]
     * @方法描述:	    [查询定时任务调度表信息]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:58]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    @GetMapping("/{jobId}")
    public AjaxResult getByJobById(@PathVariable Long jobId){
        try {
            Job job = jobService.selectJobById(jobId);
            return success(job);
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
    * @方法名:	    [update]
    * @方法描述:	    [修改定时任务调度表信息]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:58]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @PutMapping
    @RequiresPermissions("sys:Job:edit")
    public AjaxResult update(Job job){

        try {
            jobService.updateJob(job);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }
    }
}
