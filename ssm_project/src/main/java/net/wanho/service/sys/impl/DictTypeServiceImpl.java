package net.wanho.service.sys.impl;


import lombok.extern.slf4j.Slf4j;
import net.wanho.mapper.sys.DictTypeMapper;
import net.wanho.po.sys.DictType;
import net.wanho.service.sys.DictTypeServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;
/**
* @项目名称:		[cms]
* @类名称:	    [DictTypeServiceImpl]
* @类描述:	    [字典类型表业务逻辑层实现]
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
public class DictTypeServiceImpl  implements DictTypeServiceI {

	@Autowired
	private DictTypeMapper dictTypeMapper;

	/**
	 * @方法名:	    [selectDictTypeById]
	 * @方法描述:		[查询字典类型表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-09-30 10:36:08]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public DictType selectDictTypeById(Long dictId){
		try{
			return dictTypeMapper.selectDictTypeById(dictId);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [selectDictTypeList]
	 * @方法描述:		[查询字典类型表列表]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-09-30 10:36:08]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public List<DictType> selectDictTypeList(DictType dictType){
		try{
			return dictTypeMapper.selectDictTypeList(dictType);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [insertDictType]
	 * @方法描述:		[新增字典类型表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-09-30 10:36:08]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int insertDictType(@RequestBody  DictType dictType){
		try{
			//todo 获取登录名
			dictType.setCreateBy("admin");
			dictType.setCreateTime(new Date());
			return dictTypeMapper.insertDictType(dictType);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [updateDictType]
	 * @方法描述:		[修改字典类型表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-09-30 10:36:08]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int updateDictType(@RequestBody DictType dictType){
		try{
			return dictTypeMapper.updateDictType(dictType);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [deleteDictTypeByIds]
	 * @方法描述:		[删除字典类型表信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-09-30 10:36:08]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int deleteDictTypeByIds(String ids){
		try{
			return dictTypeMapper.deleteDictTypeByIds(ids.split(","));
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

}
