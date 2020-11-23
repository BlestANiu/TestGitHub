package net.wanho.controller.sys;

import lombok.extern.slf4j.Slf4j;
import net.wanho.controller.BaseController;
import net.wanho.po.sys.Ext.UserExt;
import net.wanho.po.sys.User;
import net.wanho.service.sys.UserServiceI;
import net.wanho.util.ShiroUtils;
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
* @类名称:	    [UserController]
* @类描述:	    [用户信息表的控制器]
* @创建人:	    [choco]
* @创建时间:	    [2020-10-09 09:39:59]
* @修改人:	    []
* @修改时间:	    []
* @修改备注:	    []
* @版本:		    []
* @版权:		    []
*/
@Controller
@RequestMapping("/sys/user")
@ResponseBody
@Slf4j
public class UserController extends BaseController {
	private static final long serialVersionUID = 1L;

    @Autowired
    private UserServiceI userService;

    /**
     * @方法名:	    [login]
     * @方法描述:	    [登录功能]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:59]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    @PostMapping("/login")
    public AjaxResult login(User user){
        // 用户登录业务
        userService.login(user);
        return success();
    }
    /**
     * @方法名:	    [currentUser]
     * @方法描述:	    [获取当前用户]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:59]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    @GetMapping("/currentUser")
    public AjaxResult currentUser(){
        return success(ShiroUtils.getUser());
    }

    @RequiresPermissions("sys:user:view")
    @GetMapping()
    public ModelAndView User(){
        ModelAndView mv = new ModelAndView("/sys/user");
        return mv;
    }



    /**
    * @方法名:	    [list]
    * @方法描述:	    [查询用户信息表列表]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:59]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @RequiresPermissions("sys:user:list")
    @GetMapping("/list")
    public TableDataInfo list(UserExt userExt) {
        try {
            startPage();
            List<UserExt> list = userService.selectUserList(userExt);
            return this.getTableDataInfo(list);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("服务器正忙，请稍后再试");
        }
    }

    /**
    * @方法名:	    [remove]
    * @方法描述:	    [删除用户信息表列表]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:59]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @RequiresPermissions("sys:user:remove")
    @DeleteMapping("/remove/{ids}")
    public AjaxResult remove(@PathVariable String ids) {
            userService.deleteUserByIds(ids);
            return success();
    }

    /**
     * 新增用户信息表
     */
    @GetMapping("/add")
    public String add(){
        return  "/sys/user/add";
    }

    /**
    * @方法名:	    [add]
    * @方法描述:	    [增加用户信息表信息]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:59]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @PostMapping
    @RequiresPermissions("sys:user:add")
    public AjaxResult add(@RequestBody UserExt userExt){

        try {
            userService.insertUserExt(userExt);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
     * @方法名:	    [resetPass]
     * @方法描述:	    [重置用户密码]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:59]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    @PostMapping("/resetPwd")
    public AjaxResult resetPass(@RequestParam("userId") String userId,@RequestParam("password")String password){
        try {
            userService.resetPass(userId,password);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }
    }


    /**
     * @方法名:	    [getByUserById]
     * @方法描述:	    [查询用户信息表信息]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:59]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    @GetMapping("/{userId}")
    public AjaxResult getByUserById(@PathVariable Long userId){
        try {
            UserExt userExt = userService.selectUserById(userId);
            return success(userExt);
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
    * @方法名:	    [update]
    * @方法描述:	    [修改用户信息表信息]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:59]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @PutMapping
    @RequiresPermissions("sys:User:edit")
    public AjaxResult update(@RequestBody UserExt userExt){

        try {
            userService.updateUser(userExt);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }
    }
}
