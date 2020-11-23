package net.wanho.service.sys.impl;


import lombok.extern.slf4j.Slf4j;
import net.wanho.mapper.sys.LogininforMapper;
import net.wanho.po.sys.Logininfor;
import net.wanho.service.sys.LogininforServiceI;
import net.wanho.util.*;
import java.util.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
* @项目名称:		[cms]
* @类名称:	    [LogininforServiceImpl]
* @类描述:	    [系统访问记录业务逻辑层实现]
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
public class LogininforServiceImpl  implements LogininforServiceI {

	@Autowired
	private LogininforMapper logininforMapper;

	/**
	 * @方法名:	    [selectLogininforById]
	 * @方法描述:		[查询系统访问记录信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:58]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public Logininfor selectLogininforById(Long infoId){
		try{
			return logininforMapper.selectLogininforById(infoId);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [selectLogininforList]
	 * @方法描述:		[查询系统访问记录列表]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:58]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public List<Logininfor> selectLogininforList(Logininfor logininfor){
		try{
			return logininforMapper.selectLogininforList(logininfor);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [insertLogininfor]
	 * @方法描述:		[新增系统访问记录信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:58]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int insertLogininfor(@RequestBody  Logininfor logininfor){
		try{
			return logininforMapper.insertLogininfor(logininfor);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [updateLogininfor]
	 * @方法描述:		[修改系统访问记录信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:58]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int updateLogininfor(@RequestBody Logininfor logininfor){
		try{
			return logininforMapper.updateLogininfor(logininfor);
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

	/**
	 * @方法名:	    [deleteLogininforByIds]
	 * @方法描述:		[删除系统访问记录信息]
	 * @创建人:	    [choco]
	 * @创建时间:		[2020-10-09 09:39:58]
	 * @修改人:	    []
	 * @修改时间:		[]
	 * @修改备注:		[]
	 */
	@Override
	public int deleteLogininforByIds(String ids){
		try{
			return logininforMapper.deleteLogininforByIds(ids.split(","));
		} catch (Exception e) {
		    log.error(e.getMessage());
		    throw new RuntimeException(e);
		}
	}

}
