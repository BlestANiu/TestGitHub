package net.wanho.mapper.sys;
import net.wanho.po.sys.Ext.RoleExt;
import net.wanho.po.sys.Role;
import java.util.List;
/**
 * @项目名称:	    [cms]
 * @类名称:	    [RoleMapper]
 * @类描述:	    [角色信息表数据访问层接口]
 * @创建人:	    [choco]
 * @创建时间:	    [2020-10-09 09:39:59]
 * @修改人:	    []
 * @修改时间:	    []
 * @修改备注:	    []
 * @版本:		[]
 * @版权:		[]
 */
public interface RoleMapper {
        /**
         * @方法名:	    [selectRoleById]
         * @方法描述:	    [查询角色信息表信息]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:59]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public RoleExt selectRoleById(Long roleId);

        /**
         * @方法名:	    [selectRoleList]
         * @方法描述:	    [查询角色信息表列表]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:59]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public List<Role> selectRoleList(Role role);

        /**
         * @方法名:	    [insertRole]
         * @方法描述:	    [新增角色信息表信息]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:59]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int insertRole(RoleExt roleExt);

        /**
         * @方法名:	    [updateRole role]
         * @方法描述:	    [修改角色信息表信息]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:59]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int updateRole(Role role);

        /**
         * @方法名:	    [deleteRoleById]
         * @方法描述:	    [删除角色信息表信息]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:59]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int deleteRoleById(Long roleId);

        /**
         * @方法名:	    [deleteRoleByIds]
         * @方法描述:	    [批量删除角色信息表]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-10-09 09:39:59]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int deleteRoleByIds(String[] roleIds);

}