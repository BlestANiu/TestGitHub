package net.wanho.service.sys.impl;


import lombok.extern.slf4j.Slf4j;
import net.wanho.mapper.sys.UserPostMapper;
import net.wanho.po.sys.UserPost;
import net.wanho.service.sys.UserPostServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
/**
* @项目名称:		[cms]
* @类名称:	    [UserPostServiceImpl]
* @类描述:	    [用户与岗位关联表业务逻辑层实现]
* @创建人:	    [choco]
* @创建时间:		[2020-10-09 09:39:59]
* @修改人:	    []
* @修改时间:		[]
* @修改备注:		[]
* @版本:			[]
* @版权:			[]
*/
@Service
@Slf4j
public class UserPostServiceImpl  implements UserPostServiceI {

	@Autowired
	private UserPostMapper userPostMapper;

	/**
	 * @方法名:	    [selectUserPostById]
	 * @方法描述:		[查询用户与岗位关联表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:59]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public UserPost selectUserPostById(Long userId){
		try{
			return userPostMapper.selectUserPostById(userId);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [selectUserPostList]
	 * @方法描述:		[查询用户与岗位关联表列表]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:59]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public List<UserPost> selectUserPostList(UserPost userPost){
		try{
			return userPostMapper.selectUserPostList(userPost);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [insertUserPost]
	 * @方法描述:		[新增用户与岗位关联表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:59]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int insertUserPost(@RequestBody  UserPost userPost){
		try{
			return userPostMapper.insertUserPost(userPost);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [updateUserPost]
	 * @方法描述:		[修改用户与岗位关联表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:59]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int updateUserPost(@RequestBody UserPost userPost){
		try{
			return userPostMapper.updateUserPost(userPost);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [deleteUserPostByIds]
	 * @方法描述:		[删除用户与岗位关联表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:59]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int deleteUserPostByIds(String ids){
		try{
			return userPostMapper.deleteUserPostByIds(ids.split(","));
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}
}
