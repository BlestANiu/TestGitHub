package net.wanho.service.sys.impl;


import lombok.extern.slf4j.Slf4j;
import net.wanho.mapper.sys.ConfigMapper;
import net.wanho.po.sys.Config;
import net.wanho.service.sys.ConfigServiceI;
import net.wanho.util.*;
import java.util.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
* @项目名称:		[cms]
* @类名称:	    [ConfigServiceImpl]
* @类描述:	    [参数配置表业务逻辑层实现]
* @创建人:	    [choco]
* @创建时间:		[2020-10-09 09:39:58]
* @修改人:	    []
* @修改时间:		[]
* @修改备注:		[]
* @版本:			[]
* @版权:			[]
*/
@Service
@Slf4j
public class ConfigServiceImpl  implements ConfigServiceI {

	@Autowired
	private ConfigMapper configMapper;

	/**
	 * @方法名:	    [selectConfigById]
	 * @方法描述:		[查询参数配置表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:58]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public Config selectConfigById(Integer configId){
		try{
			return configMapper.selectConfigById(configId);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [selectConfigList]
	 * @方法描述:		[查询参数配置表列表]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:58]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public List<Config> selectConfigList(Config config){
		try{
			return configMapper.selectConfigList(config);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [insertConfig]
	 * @方法描述:		[新增参数配置表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:58]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int insertConfig(@RequestBody  Config config){
		try{
			return configMapper.insertConfig(config);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [updateConfig]
	 * @方法描述:		[修改参数配置表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:58]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int updateConfig(@RequestBody Config config){
		try{
			return configMapper.updateConfig(config);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [deleteConfigByIds]
	 * @方法描述:		[删除参数配置表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:58]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int deleteConfigByIds(String ids){
		try{
			return configMapper.deleteConfigByIds(ids.split(","));
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

}
