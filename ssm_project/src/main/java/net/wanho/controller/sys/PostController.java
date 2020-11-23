package net.wanho.controller.sys;

import lombok.extern.slf4j.Slf4j;
import net.wanho.controller.BaseController;
import net.wanho.po.sys.Post;
import net.wanho.service.sys.PostServiceI;
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
* @类名称:	    [PostController]
* @类描述:	    [岗位信息表的控制器]
* @创建人:	    [choco]
* @创建时间:	    [2020-09-30 10:36:08]
* @修改人:	    []
* @修改时间:	    []
* @修改备注:	    []
* @版本:		    []
* @版权:		    []
*/
@Controller
@RequestMapping("/sys/post")
@ResponseBody
@Slf4j
public class PostController extends BaseController {
	private static final long serialVersionUID = 1L;

    @Autowired
    private PostServiceI postService;

    @RequiresPermissions("sys:post:view")
    @GetMapping
    public ModelAndView Post(){
        ModelAndView mv = new ModelAndView("/sys/post");
        return mv;
    }

    /**
    * @方法名:	    [list]
    * @方法描述:	    [查询岗位信息表列表]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-09-30 10:36:08]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @GetMapping("/list")
    public TableDataInfo list(Post post) {
        try {
            startPage();
            List<Post> list = postService.selectPostList(post);
            return this.getTableDataInfo(list);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("服务器正忙，请稍后再试");
        }
    }



    /**
     * @方法名:	    [listAll]
     * @方法描述:	    [查询所有岗位]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-09-30 10:36:08]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    @GetMapping("/listAll")
    public AjaxResult listAll(Post post) {
        try {
            List<Post> list = postService.selectPostList(post);
            return success(list);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("服务器正忙，请稍后再试");
        }
    }

    /**
    * @方法名:	    [remove]
    * @方法描述:	    [删除岗位信息表列表]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-09-30 10:36:08]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @DeleteMapping("/remove/{ids}")
    public AjaxResult remove(@PathVariable String ids) {
        try {
            postService.deletePostByIds(ids);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
     * 新增岗位信息表
     */
    @GetMapping("/add")
    public String add(){
        return  "/sys/post/add";
    }

    /**
    * @方法名:	    [add]
    * @方法描述:	    [增加岗位信息表信息]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-09-30 10:36:08]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @PostMapping
    @RequiresPermissions("sys:post:add")
    public AjaxResult add(@RequestBody Post post){

        try {
            postService.insertPost(post);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
     * @方法名:	    [getByPostById]
     * @方法描述:	    [查询岗位信息表信息]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-09-30 10:36:08]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    @GetMapping("/{postId}")
    public AjaxResult getByPostById(@PathVariable Long postId){
        try {
            Post post = postService.selectPostById(postId);
            return success(post);
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
    * @方法名:	    [update]
    * @方法描述:	    [修改岗位信息表信息]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-09-30 10:36:08]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @PutMapping
    @RequiresPermissions("sys:Post:edit")
    public AjaxResult update(@RequestBody  Post post){

        try {
            postService.updatePost(post);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }
    }
}
