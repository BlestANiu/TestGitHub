package net.wanho.controller.sys;

import lombok.extern.slf4j.Slf4j;
import net.wanho.controller.BaseController;
import net.wanho.po.sys.Ext.MenuExt;
import net.wanho.po.sys.Menu;
import net.wanho.service.sys.MenuServiceI;
import net.wanho.util.ShiroUtils;
import net.wanho.vo.AjaxResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
* @项目名称:	    [cms]
* @类名称:	    [MenuController]
* @类描述:	    [菜单权限表的控制器]
* @创建人:	    [choco]
* @创建时间:	    [2020-10-09 09:39:58]
* @修改人:	    []
* @修改时间:	    []
* @修改备注:	    []
* @版本:		    []
* @版权:		    []
*/
@Controller
@RequestMapping("/sys/menu")
@ResponseBody
@Slf4j
public class MenuController extends BaseController {
	private static final long serialVersionUID = 1L;

    @Autowired
    private MenuServiceI menuService;

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


    /**
     * @方法名:	        [tree]
     * @方法描述:	    [跳转到图标]
     * @创建人:	        [choco]
     * @创建时间:	    [2020-10-09 09:39:58]
     * @修改人:	        []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    @GetMapping("/icon")
    public ModelAndView icon(){
        ModelAndView mv = new ModelAndView("sys/icon");
        return mv;
    }

    @RequiresPermissions("sys:menu:view")
    @GetMapping()
    public ModelAndView Menu(){
        ModelAndView mv = new ModelAndView("/sys/menu");
        return mv;
    }

    /**
    * @方法名:	    [list]
    * @方法描述:	    [查询菜单权限表列表]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:58]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @GetMapping("/list")
    public List<Menu> list(Menu menu) {
        try {
            Long userId = ShiroUtils.getUser().getUserId();
            if(userId.intValue()==1){
                // 管理员加载所有
                return menuService.selectMenuList(new Menu());
            }else {
                // 普通用户根据id查询
                return    menuService.selectMenuListByUserId(userId);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("服务器正忙，请稍后再试");
        }
    }

    /**
    * @方法名:	    [remove]
    * @方法描述:	    [删除菜单权限表列表]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:58]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @DeleteMapping("/remove/{ids}")
    public AjaxResult remove(@PathVariable String ids) {
            menuService.deleteMenuByIds(ids);
            return success();
    }

    /**
     * 新增菜单权限表
     */
    @GetMapping("/add")
    public String add(){
        return  "/sys/menu/add";
    }

    /**
    * @方法名:	    [add]
    * @方法描述:	    [增加菜单权限表信息]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:58]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @PostMapping
    @RequiresPermissions("sys:menu:add")
    public AjaxResult add(@RequestBody  Menu menu){

        try {
            menuService.insertMenu(menu);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
     * @方法名:	    [getByMenuById]
     * @方法描述:	    [查询菜单权限表信息]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:58]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    @GetMapping("/{menuId}")
    public AjaxResult getByMenuById(@PathVariable Long menuId){
        try {
            MenuExt menuExt = menuService.selectMenuById(menuId);
            return success(menuExt);
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }


    @GetMapping("/findByRoleId/{roleId}/list")
    public List<MenuExt> findByRoleId(@PathVariable Long roleId){
        try {
            return menuService.selectMenuExtList(roleId);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("服务器正忙，请稍后再试");
        }
    }

    /**
    * @方法名:	    [update]
    * @方法描述:	    [修改菜单权限表信息]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:58]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @PutMapping
    @RequiresPermissions("sys:Menu:edit")
    public AjaxResult update(@RequestBody Menu menu){

        try {
            menuService.updateMenu(menu);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }
    }
}
