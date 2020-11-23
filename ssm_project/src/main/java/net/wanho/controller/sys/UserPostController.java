package net.wanho.controller.sys;

import lombok.extern.slf4j.Slf4j;
import net.wanho.controller.BaseController;
import net.wanho.po.sys.UserPost;
import net.wanho.service.sys.UserPostServiceI;
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
* @类名称:	    [UserPostController]
* @类描述:	    [用户与岗位关联表的控制器]
* @创建人:	    [choco]
* @创建时间:	    [2020-10-09 09:39:59]
* @修改人:	    []
* @修改时间:	    []
* @修改备注:	    []
* @版本:		    []
* @版权:		    []
*/
@Controller
@RequestMapping("/sys/userPost")
@ResponseBody
@Slf4j
public class UserPostController extends BaseController {
	private static final long serialVersionUID = 1L;

    @Autowired
    private UserPostServiceI userPostService;

    @RequiresPermissions("sys:userPost:view")
    @GetMapping()
    public ModelAndView UserPost(){
        ModelAndView mv = new ModelAndView("/sys/userPost");
        return mv;
    }

    /**
    * @方法名:	    [list]
    * @方法描述:	    [查询用户与岗位关联表列表]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:59]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @GetMapping("/list")
    public TableDataInfo list(UserPost userPost) {
        try {
            startPage();
            List<UserPost> list = userPostService.selectUserPostList(userPost);
            return this.getTableDataInfo(list);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("服务器正忙，请稍后再试");
        }
    }

    /**
    * @方法名:	    [remove]
    * @方法描述:	    [删除用户与岗位关联表列表]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:59]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @DeleteMapping("/remove/{ids}")
    public AjaxResult remove(@PathVariable String ids) {
        try {
            userPostService.deleteUserPostByIds(ids);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
     * 新增用户与岗位关联表
     */
    @GetMapping("/add")
    public String add(){
        return  "/sys/userPost/add";
    }

    /**
    * @方法名:	    [add]
    * @方法描述:	    [增加用户与岗位关联表信息]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:59]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @PostMapping
    @RequiresPermissions("sys:userPost:add")
    public AjaxResult add(UserPost userPost){

        try {
            userPostService.insertUserPost(userPost);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
     * @方法名:	    [getByUserPostById]
     * @方法描述:	    [查询用户与岗位关联表信息]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:59]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    @GetMapping("/{userId}")
    public AjaxResult getByUserPostById(@PathVariable Long userId){
        try {
            UserPost userPost = userPostService.selectUserPostById(userId);
            return success(userPost);
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
    * @方法名:	    [update]
    * @方法描述:	    [修改用户与岗位关联表信息]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-10-09 09:39:59]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @PutMapping
    @RequiresPermissions("sys:UserPost:edit")
    public AjaxResult update(UserPost userPost){

        try {
            userPostService.updateUserPost(userPost);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }
    }
}
