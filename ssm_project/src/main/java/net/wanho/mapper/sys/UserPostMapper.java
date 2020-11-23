package net.wanho.mapper.sys;
import net.wanho.po.sys.UserPost;
import java.util.List;
/**
 * @项目名称:	    [cms]
 * @类名称:	    [UserPostMapper]
 * @类描述:	    [用户与岗位关联表数据访问层接口]
 * @创建人:	    [choco]
 * @创建时间:	    [2020-10-09 09:39:59]
 * @修改人:	    []
 * @修改时间:	    []
 * @修改备注:	    []
 * @版本:		[]
 * @版权:		[]
 */
public interface UserPostMapper {
        /**
         * @方法名:	    [selectUserPostById]
         * @方法描述:	    [查询用户与岗位关联表信息]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:59]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public UserPost selectUserPostById(Long userId);

        /**
         * @方法名:	    [selectUserPostList]
         * @方法描述:	    [查询用户与岗位关联表列表]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:59]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public List<UserPost> selectUserPostList(UserPost userPost);

        /**
         * @方法名:	    [insertUserPost]
         * @方法描述:	    [新增用户与岗位关联表信息]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:59]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int insertUserPost(UserPost userPost);

        /**
         * @方法名:	    [updateUserPost userPost]
         * @方法描述:	    [修改用户与岗位关联表信息]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:59]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int updateUserPost(UserPost userPost);

        /**
         * @方法名:	    [deleteUserPostById]
         * @方法描述:	    [删除用户与岗位关联表信息]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:59]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int deleteUserPostById(Long userId);

        /**
         * @方法名:	    [deleteUserPostByIds]
         * @方法描述:	    [批量删除用户与岗位关联表]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:59]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int deleteUserPostByIds(String[] userIds);


        void batchInsertUserPost(List<UserPost> userPostList);
}