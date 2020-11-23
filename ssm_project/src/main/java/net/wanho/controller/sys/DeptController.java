package net.wanho.controller.sys;

import lombok.extern.slf4j.Slf4j;
import net.wanho.controller.BaseController;
import net.wanho.po.sys.Dept;
import net.wanho.po.sys.Ext.DeptExt;
import net.wanho.service.sys.DeptServiceI;
import net.wanho.vo.AjaxResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
* @项目名称:	    [cms]
* @类名称:	    [DeptController]
* @类描述:	    [部门表的控制器]
* @创建人:	    [choco]
* @创建时间:	    [2020-10-09 09:39:58]
* @修改人:	    []
* @修改时间:	    []
* @修改备注:	    []
* @版本:		    []
* @版权:		    []
*/
@Controller
@RequestMapping("/sys/dept")
@ResponseBody
@Slf4j
public class DeptController extends BaseController {
	private static final long serialVersionUID = 1L;

    @Autowired
    private DeptServiceI deptService;

    /**
     * @方法名:	        [tree]
     * @方法描述:	    [跳转到部门树]
     * @创建人:	        [choco]
     * @创建时间:	    [2020-10-09 09:39:58]
     * @修改人:	        []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    @GetMapping("/tree")
    public ModelAndView tree(){
        ModelAndView mv = new ModelAndView("sys/tree");
        return mv;
    }


    @RequiresPermissions("sys:dept:view")
    @GetMapping
    public ModelAndView Dept(){
        ModelAndView mv = new ModelAndView("/sys/dept");
        return mv;
    }

    /**
    * @方法名:	    [list]
    * @方法描述:	    [查询部门表列表]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:58]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @GetMapping("/list")
    public List<Dept> list(Dept dept) {
        try {
            List<Dept> list = deptService.selectDeptList(dept);
            return list;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("服务器正忙，请稍后再试");
        }
    }

    /**
    * @方法名:	    [remove]
    * @方法描述:	    [删除部门表列表]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:58]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @DeleteMapping("/remove/{ids}")
    public AjaxResult remove(@PathVariable String ids) {
            deptService.deleteDeptByIds(ids);
            return success();
    }

    /**
     * 新增部门表
     */
    @GetMapping("/add")
    public String add(){
        return  "/sys/dept/add";
    }

    /**
    * @方法名:	    [add]
    * @方法描述:	    [增加部门表信息]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:58]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @PostMapping
    @RequiresPermissions("sys:dept:add")
    public AjaxResult add(@RequestBody  Dept dept){

        try {
            deptService.insertDept(dept);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
     * @方法名:	    [getByDeptById]
     * @方法描述:	    [查询部门表信息]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:58]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    @GetMapping("/{deptId}")
    public AjaxResult getByDeptById(@PathVariable Long deptId){
        try {
            DeptExt deptExt = deptService.selectDeptById(deptId);
            return success(deptExt);
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
    * @方法名:	    [update]
    * @方法描述:	    [修改部门表信息]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:58]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @PutMapping
    @RequiresPermissions("sys:Dept:edit")
    public AjaxResult update(@RequestBody  Dept dept){

        try {
            deptService.updateDept(dept);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }
    }
}
