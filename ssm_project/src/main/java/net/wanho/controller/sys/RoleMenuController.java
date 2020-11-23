package net.wanho.controller.sys;

import lombok.extern.slf4j.Slf4j;
import net.wanho.controller.BaseController;
import net.wanho.po.sys.RoleMenu;
import net.wanho.service.sys.RoleMenuServiceI;
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
* @类名称:	    [RoleMenuController]
* @类描述:	    [角色和菜单关联表的控制器]
* @创建人:	    [choco]
* @创建时间:	    [2020-10-09 09:39:59]
* @修改人:	    []
* @修改时间:	    []
* @修改备注:	    []
* @版本:		    []
* @版权:		    []
*/
@Controller
@RequestMapping("/sys/roleMenu")
@ResponseBody
@Slf4j
public class RoleMenuController extends BaseController {
	private static final long serialVersionUID = 1L;

    @Autowired
    private RoleMenuServiceI roleMenuService;

    @RequiresPermissions("sys:roleMenu:view")
    @GetMapping()
    public ModelAndView RoleMenu(){
        ModelAndView mv = new ModelAndView("/sys/roleMenu");
        return mv;
    }

    /**
    * @方法名:	    [list]
    * @方法描述:	    [查询角色和菜单关联表列表]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:59]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @GetMapping("/list")
    public TableDataInfo list(RoleMenu roleMenu) {
        try {
            startPage();
            List<RoleMenu> list = roleMenuService.selectRoleMenuList(roleMenu);
            return this.getTableDataInfo(list);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("服务器正忙，请稍后再试");
        }
    }

    /**
    * @方法名:	    [remove]
    * @方法描述:	    [删除角色和菜单关联表列表]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:59]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @DeleteMapping("/remove/{ids}")
    public AjaxResult remove(@PathVariable String ids) {
        try {
            roleMenuService.deleteRoleMenuByIds(ids);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
     * 新增角色和菜单关联表
     */
    @GetMapping("/add")
    public String add(){
        return  "/sys/roleMenu/add";
    }

    /**
    * @方法名:	    [add]
    * @方法描述:	    [增加角色和菜单关联表信息]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:59]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @PostMapping
    @RequiresPermissions("sys:roleMenu:add")
    public AjaxResult add(RoleMenu roleMenu){

        try {
            roleMenuService.insertRoleMenu(roleMenu);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
     * @方法名:	    [getByRoleMenuById]
     * @方法描述:	    [查询角色和菜单关联表信息]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:59]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    @GetMapping("/{roleId}")
    public AjaxResult getByRoleMenuById(@PathVariable Long roleId){
        try {
            List<RoleMenu> roleMenu = roleMenuService.selectRoleMenuById(roleId);
            return success(roleMenu);
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
    * @方法名:	    [update]
    * @方法描述:	    [修改角色和菜单关联表信息]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:59]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @PutMapping
    @RequiresPermissions("sys:RoleMenu:edit")
    public AjaxResult update(RoleMenu roleMenu){

        try {
            roleMenuService.updateRoleMenu(roleMenu);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }
    }
}
