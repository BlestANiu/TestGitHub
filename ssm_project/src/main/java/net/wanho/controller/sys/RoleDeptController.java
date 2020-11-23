package net.wanho.controller.sys;

import lombok.extern.slf4j.Slf4j;
import net.wanho.controller.BaseController;
import net.wanho.po.sys.RoleDept;
import net.wanho.service.sys.RoleDeptServiceI;
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
* @类名称:	    [RoleDeptController]
* @类描述:	    [角色和部门关联表的控制器]
* @创建人:	    [choco]
* @创建时间:	    [2020-10-09 09:39:59]
* @修改人:	    []
* @修改时间:	    []
* @修改备注:	    []
* @版本:		    []
* @版权:		    []
*/
@Controller
@RequestMapping("/sys/roleDept")
@ResponseBody
@Slf4j
public class RoleDeptController extends BaseController {
	private static final long serialVersionUID = 1L;

    @Autowired
    private RoleDeptServiceI roleDeptService;

    @RequiresPermissions("sys:roleDept:view")
    @GetMapping()
    public ModelAndView RoleDept(){
        ModelAndView mv = new ModelAndView("/sys/roleDept");
        return mv;
    }

    /**
    * @方法名:	    [list]
    * @方法描述:	    [查询角色和部门关联表列表]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:59]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @GetMapping("/list")
    public TableDataInfo list(RoleDept roleDept) {
        try {
            startPage();
            List<RoleDept> list = roleDeptService.selectRoleDeptList(roleDept);
            return this.getTableDataInfo(list);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("服务器正忙，请稍后再试");
        }
    }

    /**
    * @方法名:	    [remove]
    * @方法描述:	    [删除角色和部门关联表列表]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:59]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @DeleteMapping("/remove/{ids}")
    public AjaxResult remove(@PathVariable String ids) {
        try {
            roleDeptService.deleteRoleDeptByIds(ids);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
     * 新增角色和部门关联表
     */
    @GetMapping("/add")
    public String add(){
        return  "/sys/roleDept/add";
    }

    /**
    * @方法名:	    [add]
    * @方法描述:	    [增加角色和部门关联表信息]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:59]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @PostMapping
    @RequiresPermissions("sys:roleDept:add")
    public AjaxResult add(RoleDept roleDept){

        try {
            roleDeptService.insertRoleDept(roleDept);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
     * @方法名:	    [getByRoleDeptById]
     * @方法描述:	    [查询角色和部门关联表信息]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:59]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    @GetMapping("/{roleId}")
    public AjaxResult getByRoleDeptById(@PathVariable Long roleId){
        try {
            RoleDept roleDept = roleDeptService.selectRoleDeptById(roleId);
            return success(roleDept);
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
    * @方法名:	    [update]
    * @方法描述:	    [修改角色和部门关联表信息]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:59]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @PutMapping
    @RequiresPermissions("sys:RoleDept:edit")
    public AjaxResult update(RoleDept roleDept){

        try {
            roleDeptService.updateRoleDept(roleDept);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }
    }
}
