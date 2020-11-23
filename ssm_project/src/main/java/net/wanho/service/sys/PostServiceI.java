package net.wanho.service.sys;

import net.wanho.po.sys.Post;
import java.util.List;
/**
* @项目名称:	    [cms]
* @类名称:	    [PostServiceI]
* @类描述:	    [岗位信息表业务逻辑层接口]
* @创建人:	    [choco]
* @创建时间:	    [2020-09-30 10:36:08]
* @修改人:	    []
* @修改时间:	    []
* @修改备注:	    []
* @版本:		    []
* @版权:		    []
*/
public interface PostServiceI {

    /**
     * @方法名:	    [selectPostById]
     * @方法描述:	    [查询岗位信息表信息]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-09-30 10:36:08]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public Post selectPostById(Long postId);

    /**
     * @方法名:	    [selectPostList]
     * @方法描述:	    [查询岗位信息表列表]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-09-30 10:36:08]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public List<Post> selectPostList(Post post);

    /**
     * @方法名:	    [insertPost]
     * @方法描述:	    [新增岗位信息表删除]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-09-30 10:36:08]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public int insertPost(Post post);

    /**
     * @方法名:	    [updatePost]
     * @方法描述:	    [修改岗位信息表删除]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-09-30 10:36:08]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public int updatePost(Post post);

    /**
     * @方法名:	    [deletePostByIds]
     * @方法描述:	    [删除岗位信息表信息]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-09-30 10:36:08]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public int deletePostByIds(String ids);



}
