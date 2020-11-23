package net.wanho.controller.sys;

import lombok.extern.slf4j.Slf4j;
import net.wanho.controller.BaseController;
import net.wanho.po.sys.DictType;
import net.wanho.service.sys.DictTypeServiceI;
import net.wanho.vo.AjaxResult;
import net.wanho.vo.TableDataInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
* @项目名称:	    [cms]
* @类名称:	    [DictTypeController]
* @类描述:	    [字典类型表的控制器]
* @创建人:	    [choco]
* @创建时间:	    [2020-09-30 10:36:08]
* @修改人:	    []
* @修改时间:	    []
* @修改备注:	    []
* @版本:		    []
* @版权:		    []
*/
@Controller
@RequestMapping("/sys/dictType")
@ResponseBody
@Slf4j
public class DictTypeController extends BaseController {
	private static final long serialVersionUID = 1L;

    @Autowired
    private DictTypeServiceI dictTypeService;

    /**
     * @方法名:	        [dictData]
     * @方法描述:	    [跳转到字典数据列表]
     * @创建人:	        [choco]
     * @创建时间:	    [2020-09-30 10:36:08]
     * @修改人:	        []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    @GetMapping("/dictData")
    public ModelAndView modelAndView(){
        ModelAndView modelAndView = new ModelAndView("sys/dictData");
        return modelAndView;
    }

    @RequiresPermissions("sys:dictType:view")
    @GetMapping()
    public ModelAndView DictType(){
        ModelAndView mv = new ModelAndView("/sys/dictType");
        return mv;
    }

    /**
    * @方法名:	    [list]
    * @方法描述:	    [查询字典类型表列表]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-09-30 10:36:08]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @GetMapping("/list")
    public TableDataInfo list(DictType dictType) {
        try {
            startPage();
            List<DictType> list = dictTypeService.selectDictTypeList(dictType);
            return this.getTableDataInfo(list);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("服务器正忙，请稍后再试");
        }
    }

    /**
    * @方法名:	    [remove]
    * @方法描述:	    [删除字典类型表列表]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-09-30 10:36:08]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @DeleteMapping("/remove/{ids}")
    public AjaxResult remove(@PathVariable String ids) {
        try {
            dictTypeService.deleteDictTypeByIds(ids);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
     * 新增字典类型表
     */
    @GetMapping("/add")
    public String add(){
        return  "/sys/dictType/add";
    }

    /**
    * @方法名:	    [add]
    * @方法描述:	    [增加字典类型表信息]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-09-30 10:36:08]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @PostMapping
    @RequiresPermissions("sys:dictType:add")
    public AjaxResult add(@RequestBody  DictType dictType){

        try {
            dictTypeService.insertDictType(dictType);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
     * @方法名:	    [getByDictTypeById]
     * @方法描述:	    [查询字典类型表信息]
     * @创建人:	    [choco]
     * @创建时间:	    [2020-09-30 10:36:08]
     * @修改人:	    []
     * @修改时间:	    []
     * @修改备注:	    []
     */
    @GetMapping("/{dictId}")
    public AjaxResult getByDictTypeById(@PathVariable Long dictId){
        try {
            DictType dictType = dictTypeService.selectDictTypeById(dictId);
            return success(dictType);
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }

    }

    /**
    * @方法名:	    [update]
    * @方法描述:	    [修改字典类型表信息]
    * @创建人:	    [choco]
    * @创建时间:	    [2020-09-30 10:36:08]
    * @修改人:	    []
    * @修改时间:	    []
    * @修改备注:	    []
    */
    @PutMapping
    @RequiresPermissions("sys:DictType:edit")
    public AjaxResult update(@RequestBody DictType dictType){

        try {
            // todo 登录时获取
            dictType.setUpdateBy("admin");
            dictType.setUpdateTime(new Date());

            dictTypeService.updateDictType(dictType);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return error();
        }
    }
}
