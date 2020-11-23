package net.wanho.service.sys.impl;


import lombok.extern.slf4j.Slf4j;
import net.wanho.mapper.sys.OperLogMapper;
import net.wanho.po.sys.OperLog;
import net.wanho.service.sys.OperLogServiceI;
import net.wanho.util.*;
import java.util.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
* @项目名称:		[cms]
* @类名称:	    [OperLogServiceImpl]
* @类描述:	    [操作日志记录业务逻辑层实现]
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
public class OperLogServiceImpl  implements OperLogServiceI {

	@Autowired
	private OperLogMapper operLogMapper;

	/**
	 * @方法名:	    [selectOperLogById]
	 * @方法描述:		[查询操作日志记录信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:59]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public OperLog selectOperLogById(Long operId){
		try{
			return operLogMapper.selectOperLogById(operId);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [selectOperLogList]
	 * @方法描述:		[查询操作日志记录列表]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:59]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public List<OperLog> selectOperLogList(OperLog operLog){
		try{
			return operLogMapper.selectOperLogList(operLog);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [insertOperLog]
	 * @方法描述:		[新增操作日志记录信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:59]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int insertOperLog(@RequestBody  OperLog operLog){
		try{
			return operLogMapper.insertOperLog(operLog);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [updateOperLog]
	 * @方法描述:		[修改操作日志记录信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:59]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int updateOperLog(@RequestBody OperLog operLog){
		try{
			return operLogMapper.updateOperLog(operLog);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [deleteOperLogByIds]
	 * @方法描述:		[删除操作日志记录信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:59]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int deleteOperLogByIds(String ids){
		try{
			return operLogMapper.deleteOperLogByIds(ids.split(","));
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

}
