package net.wanho.controller.sys;

import lombok.extern.slf4j.Slf4j;
import net.wanho.controller.BaseController;
import net.wanho.po.sys.UserRole;
import net.wanho.service.sys.UserRoleServiceI;
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
* @类名称:	    [UserRoleController]
* @类描述:	    [用户和角色关联表的控制器]
* @创建人:	    [choco]
* @创建时间:	    [2020-10-09 09:39:59]
* @修改人:	    []
* @修改时间:	    []
* @修改备注:	    []
* @版本:		    []
* @版权:		    []
*/
@Controller
@RequestMapping("/sys/userRole")
@ResponseBody
@Slf4j
public class UserRoleController extends BaseController {
	private static final long serialVersionUID = 1L;

    @Autowired
    private UserRoleServiceI userRoleService;

    @RequiresPermissions("sys:userRole:view")
    @GetMapping()
    public ModelAndView UserRole(){
        ModelAndView mv = new ModelAndView("/sys/userRole");
        return mv;
    }

    /**
    * @方法名:	    [list]
    * @方法描述:	    [查询用户和角色关联表列表]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:59]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @GetMapping("/list")
    public TableDataInfo list(UserRole userRole) {
        try {
            startPage();
            List<UserRole> list = userRoleService.selectUserRoleList(userRole);
            return this.getTableDataInfo(list);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("服务器正忙，请稍后再试");
        }
    }

    /**
    * @方法名:	    [remove]
    * @方法描述:	    [删除用户和角色关联表列表]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:59]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @DeleteMapping("/remove/{ids}")
    public AjaxResult remove(@PathVariable String ids) {
        try {
            userRoleService.deleteUserRoleByIds(ids);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
     * 新增用户和角色关联表
     */
    @GetMapping("/add")
    public String add(){
        return  "/sys/userRole/add";
    }

    /**
    * @方法名:	    [add]
    * @方法描述:	    [增加用户和角色关联表信息]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:59]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @PostMapping
    @RequiresPermissions("sys:userRole:add")
    public AjaxResult add(UserRole userRole){

        try {
            userRoleService.insertUserRole(userRole);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
     * @方法名:	    [getByUserRoleById]
     * @方法描述:	    [查询用户和角色关联表信息]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:59]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    @GetMapping("/{userId}")
    public AjaxResult getByUserRoleById(@PathVariable Long userId){
        try {
            UserRole userRole = userRoleService.selectUserRoleById(userId);
            return success(userRole);
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
    * @方法名:	    [update]
    * @方法描述:	    [修改用户和角色关联表信息]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:59]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @PutMapping
    @RequiresPermissions("sys:UserRole:edit")
    public AjaxResult update(UserRole userRole){

        try {
            userRoleService.updateUserRole(userRole);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }
    }
}
