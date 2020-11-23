package net.wanho.mapper.sys;
import net.wanho.po.sys.DictData;
import java.util.List;
/**
 * @项目名称:	    [cms]
 * @类名称:	    [DictDataMapper]
 * @类描述:	    [字典数据表数据访问层接口]
 * @创建人:	    [choco]
 * @创建时间:	    [2020-09-30 10:36:08]
 * @修改人:	    []
 * @修改时间:	    []
 * @修改备注:	    []
 * @版本:		[]
 * @版权:		[]
 */
public interface DictDataMapper {
        /**
         * @方法名:	    [selectDictDataById]
         * @方法描述:	    [查询字典数据表信息]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-09-30 10:36:08]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public DictData selectDictDataById(Long dictCode);

        /**
         * @方法名:	    [selectDictDataList]
         * @方法描述:	    [查询字典数据表列表]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-09-30 10:36:08]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public List<DictData> selectDictDataList(DictData dictData);

        /**
         * @方法名:	    [insertDictData]
         * @方法描述:	    [新增字典数据表信息]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-09-30 10:36:08]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int insertDictData(DictData dictData);

        /**
         * @方法名:	    [updateDictData dictData]
         * @方法描述:	    [修改字典数据表信息]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-09-30 10:36:08]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int updateDictData(DictData dictData);

        /**
         * @方法名:	    [deleteDictDataById]
         * @方法描述:	    [删除字典数据表信息]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-09-30 10:36:08]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int deleteDictDataById(Long dictCode);

        /**
         * @方法名:	    [deleteDictDataByIds]
         * @方法描述:	    [批量删除字典数据表]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-09-30 10:36:08]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int deleteDictDataByIds(String[] dictCodes);

    List<DictData> byType(String type);
}
