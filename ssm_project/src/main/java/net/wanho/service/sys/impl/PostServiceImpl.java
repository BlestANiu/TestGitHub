package net.wanho.service.sys.impl;


import lombok.extern.slf4j.Slf4j;
import net.wanho.mapper.sys.PostMapper;
import net.wanho.po.sys.Post;
import net.wanho.service.sys.PostServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;
/**
* @项目名称:		[cms]
* @类名称:	    [PostServiceImpl]
* @类描述:	    [岗位信息表业务逻辑层实现]
* @创建人:	    [choco]
* @创建时间:		[2020-09-30 10:36:08]
* @修改人:	    []
* @修改时间:		[]
* @修改备注:		[]
* @版本:			[]
* @版权:			[]
*/
@Service
@Slf4j
public class PostServiceImpl  implements PostServiceI {

	@Autowired
	private PostMapper postMapper;

	/**
	 * @方法名:	    [selectPostById]
	 * @方法描述:		[查询岗位信息表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-09-30 10:36:08]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public Post selectPostById(Long postId){
		try{
			return postMapper.selectPostById(postId);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [selectPostList]
	 * @方法描述:		[查询岗位信息表列表]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-09-30 10:36:08]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public List<Post> selectPostList(Post post){
		try{
			return postMapper.selectPostList(post);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [insertPost]
	 * @方法描述:		[新增岗位信息表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-09-30 10:36:08]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int insertPost(@RequestBody  Post post){
		try{

			// todo 应该从登录名获取
			//post.setCreateBy();
			post.setCreateTime(new Date());
			return postMapper.insertPost(post);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [updatePost]
	 * @方法描述:		[修改岗位信息表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-09-30 10:36:08]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int updatePost(@RequestBody Post post){
		try{
			// todo 后面完善
			//post.setUpdateBy();
			post.setUpdateTime(new Date());
			return postMapper.updatePost(post);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [deletePostByIds]
	 * @方法描述:		[删除岗位信息表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-09-30 10:36:08]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int deletePostByIds(String ids){
		try{
			return postMapper.deletePostByIds(ids.split(","));
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

}
