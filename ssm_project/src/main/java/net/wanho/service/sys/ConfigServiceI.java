package net.wanho.service.sys;

import net.wanho.po.sys.Config;
import java.util.List;
/**
* @项目名称:	    [cms]
* @类名称:	    [ConfigServiceI]
* @类描述:	    [参数配置表业务逻辑层接口]
* @创建人:	    [choco]
* @创建时间:	    [2020-10-09 09:39:58]
* @修改人:	    []
* @修改时间:	    []
* @修改备注:	    []
* @版本:		    []
* @版权:		    []
*/
public interface ConfigServiceI {

    /**
     * @方法名:	    [selectConfigById]
     * @方法描述:	    [查询参数配置表信息]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:58]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public Config selectConfigById(Integer configId);

    /**
     * @方法名:	    [selectConfigList]
     * @方法描述:	    [查询参数配置表列表]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:58]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public List<Config> selectConfigList(Config config);

    /**
     * @方法名:	    [insertConfig]
     * @方法描述:	    [新增参数配置表删除]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:58]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public int insertConfig(Config config);

    /**
     * @方法名:	    [updateConfig]
     * @方法描述:	    [修改参数配置表删除]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:58]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public int updateConfig(Config config);

    /**
     * @方法名:	    [deleteConfigByIds]
     * @方法描述:	    [删除参数配置表信息]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-10-09 09:39:58]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    public int deleteConfigByIds(String ids);



}
