package net.wanho.controller.sys;

import lombok.extern.slf4j.Slf4j;
import net.wanho.controller.BaseController;
import net.wanho.po.sys.DictData;
import net.wanho.service.sys.DictDataServiceI;
import net.wanho.vo.AjaxResult;
import net.wanho.vo.TableDataInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
* @项目名称:	    [cms]
* @类名称:	    [DictDataController]
* @类描述:	    [字典数据表的控制器]
* @创建人:	    [choco]
* @创建时间:	    [2020-09-30 10:36:08]
* @修改人:	    []
* @修改时间:	    []
* @修改备注:	    []
* @版本:		    []
* @版权:		    []
*/
@Controller
@RequestMapping("/sys/dictData")
@ResponseBody
@Slf4j
public class DictDataController extends BaseController {
	private static final long serialVersionUID = 1L;

    @Autowired
    private DictDataServiceI dictDataService;

    @RequiresPermissions("sys:dictData:view")
    @GetMapping
    public ModelAndView DictData(){
        ModelAndView mv = new ModelAndView("/sys/dictData");
        return mv;
    }

    @GetMapping("/byType")
    public AjaxResult byType(String type){
        return success("根据类型查询",dictDataService.byType(type));
    }


    /**
    * @方法名:	    [list]
    * @方法描述:	    [查询字典数据表列表]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-09-30 10:36:08]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @GetMapping("/list")
    public TableDataInfo list(DictData dictData) {
        try {
            startPage();
            List<DictData> list = dictDataService.selectDictDataList(dictData);
            return this.getTableDataInfo(list);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("服务器正忙，请稍后再试");
        }
    }

    /**
    * @方法名:	    [remove]
    * @方法描述:	    [删除字典数据表列表]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-09-30 10:36:08]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @DeleteMapping("/remove/{ids}")
    public AjaxResult remove(@PathVariable String ids) {
        try {
            dictDataService.deleteDictDataByIds(ids);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
     * 新增字典数据表
     */
    @GetMapping("/add")
    public String add(){
        return  "/sys/dictData/add";
    }

    /**
    * @方法名:	    [add]
    * @方法描述:	    [增加字典数据表信息]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-09-30 10:36:08]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @PostMapping
    @RequiresPermissions("sys:dictData:add")
    public AjaxResult add(@RequestBody DictData dictData){

        try {

            dictDataService.insertDictData(dictData);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
     * @方法名:	    [getByDictDataById]
     * @方法描述:	    [查询字典数据表信息]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-09-30 10:36:08]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    @GetMapping("/{dictCode}")
    public AjaxResult getByDictDataById(@PathVariable Long dictCode){
        try {
            DictData dictData = dictDataService.selectDictDataById(dictCode);
            return success(dictData);
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
    * @方法名:	    [update]
    * @方法描述:	    [修改字典数据表信息]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-09-30 10:36:08]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @PutMapping
    @RequiresPermissions("sys:DictData:edit")
    public AjaxResult update(@RequestBody DictData dictData){

        try {
            dictDataService.updateDictData(dictData);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }
    }
}
