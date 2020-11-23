package net.wanho.mapper.sys;
import net.wanho.po.sys.UserRole;
import java.util.List;
/**
 * @项目名称:	    [cms]
 * @类名称:	    [UserRoleMapper]
 * @类描述:	    [用户和角色关联表数据访问层接口]
 * @创建人:	    [choco]
 * @创建时间:	    [2020-10-09 09:39:59]
 * @修改人:	    []
 * @修改时间:	    []
 * @修改备注:	    []
 * @版本:		[]
 * @版权:		[]
 */
public interface UserRoleMapper {
        /**
         * @方法名:	    [selectUserRoleById]
         * @方法描述:	    [查询用户和角色关联表信息]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:59]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public UserRole selectUserRoleById(Long userId);

        /**
         * @方法名:	    [selectUserRoleList]
         * @方法描述:	    [查询用户和角色关联表列表]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:59]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public List<UserRole> selectUserRoleList(UserRole userRole);

        /**
         * @方法名:	    [insertUserRole]
         * @方法描述:	    [新增用户和角色关联表信息]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:59]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int insertUserRole(UserRole userRole);

        /**
         * @方法名:	    [updateUserRole userRole]
         * @方法描述:	    [修改用户和角色关联表信息]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:59]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int updateUserRole(UserRole userRole);

        /**
         * @方法名:	    [deleteUserRoleById]
         * @方法描述:	    [删除用户和角色关联表信息]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:59]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int deleteUserRoleById(Long userId);

        /**
         * @方法名:	    [deleteUserRoleByIds]
         * @方法描述:	    [批量删除用户和角色关联表]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:59]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int deleteUserRoleByIds(String[] userIds);


        void batchInsertUserRole(List<UserRole> userRoleList);
}