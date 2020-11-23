package net.wanho.service.sys;

import net.wanho.po.sys.Ext.UserExt;
import net.wanho.po.sys.User;
import java.util.List;
/**
* @项目名称:	    [cms]
* @类名称:	    [UserServiceI]
* @类描述:	    [用户信息表业务逻辑层接口]
* @创建人:	    [choco]
* @创建时间:	    [2020-10-09 09:39:59]
* @修改人:	    []
* @修改时间:	    []
* @修改备注:	    []
* @版本:		    []
* @版权:		    []
*/
public interface UserServiceI {

    /**
     * @方法名:	    [selectUserById]
     * @方法描述:	    [查询用户信息表信息]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:59]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public UserExt selectUserById(Long userId);

    /**
     * @方法名:	    [selectUserList]
     * @方法描述:	    [查询用户信息表列表]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:59]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public List<UserExt> selectUserList(UserExt userExt);

    /**
     * @方法名:	    [insertUser]
     * @方法描述:	    [新增用户信息表删除]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:59]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public int insertUserExt(UserExt userExt);

    /**
     * @方法名:	    [updateUser]
     * @方法描述:	    [修改用户信息表删除]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:59]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public int updateUser(UserExt userExt);

    /**
     * @方法名:	    [deleteUserByIds]
     * @方法描述:	    [删除用户信息表信息]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:59]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public void deleteUserByIds(String ids);


    public void login(User user);

    void resetPass(String userId, String password);
}
