package net.wanho.service.sys.impl;


import lombok.extern.slf4j.Slf4j;
import net.wanho.mapper.sys.DictDataMapper;
import net.wanho.po.sys.DictData;
import net.wanho.service.sys.DictDataServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;
/**
* @项目名称:		[cms]
* @类名称:	    [DictDataServiceImpl]
* @类描述:	    [字典数据表业务逻辑层实现]
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
public class DictDataServiceImpl  implements DictDataServiceI {

	@Autowired
	private DictDataMapper dictDataMapper;

	/**
	 * @方法名:	    [selectDictDataById]
	 * @方法描述:		[查询字典数据表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-09-30 10:36:08]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public DictData selectDictDataById(Long dictCode){
		try{
			return dictDataMapper.selectDictDataById(dictCode);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [selectDictDataList]
	 * @方法描述:		[查询字典数据表列表]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-09-30 10:36:08]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public List<DictData> selectDictDataList(DictData dictData){
		try{
			return dictDataMapper.selectDictDataList(dictData);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [insertDictData]
	 * @方法描述:		[新增字典数据表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-09-30 10:36:08]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int insertDictData(@RequestBody  DictData dictData){
		try{
			//todo 登录时获取
			dictData.setCreateBy("admin");
			dictData.setCreateTime(new Date());
			return dictDataMapper.insertDictData(dictData);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [updateDictData]
	 * @方法描述:		[修改字典数据表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-09-30 10:36:08]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int updateDictData(@RequestBody DictData dictData){
		try{

			//todo 登录时获取
			dictData.setUpdateBy("admin");
			dictData.setUpdateTime(new Date());
			return dictDataMapper.updateDictData(dictData);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [deleteDictDataByIds]
	 * @方法描述:		[删除字典数据表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-09-30 10:36:08]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int deleteDictDataByIds(String ids){
		try{
			return dictDataMapper.deleteDictDataByIds(ids.split(","));
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	@Override
	public List<DictData> byType(String type) {
		return dictDataMapper.byType(type);
	}


}
