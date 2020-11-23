package net.wanho.controller.sys;

import lombok.extern.slf4j.Slf4j;
import net.wanho.controller.BaseController;
import net.wanho.po.sys.Ext.RoleExt;
import net.wanho.po.sys.Role;
import net.wanho.service.sys.RoleServiceI;
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
* @类名称:	    [RoleController]
* @类描述:	    [角色信息表的控制器]
* @创建人:	    [choco]
* @创建时间:	    [2020-10-09 09:39:59]
* @修改人:	    []
* @修改时间:	    []
* @修改备注:	    []
* @版本:		    []
* @版权:		    []
*/
@Controller
@RequestMapping("/sys/role")
@ResponseBody
@Slf4j
public class RoleController extends BaseController {
	private static final long serialVersionUID = 1L;

    @Autowired
    private RoleServiceI roleService;

    @RequiresPermissions("sys:role:view")
    @GetMapping()
    public ModelAndView Role(){
        ModelAndView mv = new ModelAndView("/sys/role");
        return mv;
    }

    /**
    * @方法名:	    [list]
    * @方法描述:	    [查询角色信息表列表]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:59]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @GetMapping("/list")
    public TableDataInfo list(Role role) {
        try {
            startPage();
            List<Role> list = roleService.selectRoleList(role);
            return this.getTableDataInfo(list);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("服务器正忙，请稍后再试");
        }
    }


    /**
     * @方法名:	    [listAll]
     * @方法描述:	    [查询所有角色]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-09-30 10:36:08]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    @GetMapping("/listAll")
    public AjaxResult listAll(Role role) {
        try {
            List<Role> list = roleService.selectRoleList(role);
            return success(list);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("服务器正忙，请稍后再试");
        }
    }

    /**
    * @方法名:	    [remove]
    * @方法描述:	    [删除角色信息表列表]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:59]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @DeleteMapping("/remove/{ids}")
    public AjaxResult remove(@PathVariable String ids) {
        try {
            roleService.deleteRoleByIds(ids);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
     * 新增角色信息表
     */
    @GetMapping("/add")
    public String add(){
        return  "/sys/role/add";
    }

    /**
    * @方法名:	    [add]
    * @方法描述:	    [增加角色信息表信息]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:59]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @PostMapping
    @RequiresPermissions("sys:role:add")
    public AjaxResult add(@RequestBody RoleExt roleExt){

        try {
            roleService.insertRole(roleExt);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
     * @方法名:	    [getByRoleById]
     * @方法描述:	    [查询角色信息表信息]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:59]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    @GetMapping("/{roleId}")
    public AjaxResult getByRoleById(@PathVariable Long roleId){
        try {
            RoleExt roleExt = roleService.selectRoleById(roleId);
            return success(roleExt);
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
    * @方法名:	    [update]
    * @方法描述:	    [修改角色信息表信息]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:59]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @PutMapping
    @RequiresPermissions("sys:Role:edit")
    public AjaxResult update(@RequestBody RoleExt roleExt){

        try {
            roleService.updateRole(roleExt);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }
    }
}
