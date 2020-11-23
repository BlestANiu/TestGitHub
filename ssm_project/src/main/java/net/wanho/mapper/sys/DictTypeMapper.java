package net.wanho.mapper.sys;
import net.wanho.po.sys.DictType;
import java.util.List;
/**
 * @项目名称:	    [cms]
 * @类名称:	    [DictTypeMapper]
 * @类描述:	    [字典类型表数据访问层接口]
 * @创建人:	    [choco]
 * @创建时间:	    [2020-09-30 10:36:08]
 * @修改人:	    []
 * @修改时间:	    []
 * @修改备注:	    []
 * @版本:		[]
 * @版权:		[]
 */
public interface DictTypeMapper {
        /**
         * @方法名:	    [selectDictTypeById]
         * @方法描述:	    [查询字典类型表信息]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-09-30 10:36:08]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public DictType selectDictTypeById(Long dictId);

        /**
         * @方法名:	    [selectDictTypeList]
         * @方法描述:	    [查询字典类型表列表]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-09-30 10:36:08]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public List<DictType> selectDictTypeList(DictType dictType);

        /**
         * @方法名:	    [insertDictType]
         * @方法描述:	    [新增字典类型表信息]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-09-30 10:36:08]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int insertDictType(DictType dictType);

        /**
         * @方法名:	    [updateDictType dictType]
         * @方法描述:	    [修改字典类型表信息]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-09-30 10:36:08]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int updateDictType(DictType dictType);

        /**
         * @方法名:	    [deleteDictTypeById]
         * @方法描述:	    [删除字典类型表信息]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-09-30 10:36:08]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int deleteDictTypeById(Long dictId);

        /**
         * @方法名:	    [deleteDictTypeByIds]
         * @方法描述:	    [批量删除字典类型表]
         * @创建人:	    [choco]
         * @创建时间:	    [2020-09-30 10:36:08]
         * @修改人:	    []
         * @修改时间:	    []
         * @修改备注:	    []
         */
        public int deleteDictTypeByIds(String[] dictIds);

}