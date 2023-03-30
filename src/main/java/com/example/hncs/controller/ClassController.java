package com.example.hncs.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hncs.domain.*;
import com.example.hncs.service.IClassInfoService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * classInfoController
 *
 * @author hncs
 * @date 2023-03-29
 */
@Api(tags = "班级信息管理")
@RestController
@RequestMapping("/system/class")
public class ClassController extends BaseController {
    @Autowired
    private IClassInfoService classService;

    /**
     * 查询classInfo列表
     */
    //@PreAuthorize("@ss.hasPermi('system:class:list')")
    @ApiOperation(value = "管理员查看所有班级信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNumber",value = "当前页数(默认1)",dataType = "Long",example = "1"),
            @ApiImplicitParam(name = "size",value = "每页容量(默认10)",dataType = "Long",example = "10"),
    })
    @GetMapping("/list")
    public ResultBody list(
            @RequestParam(defaultValue = "1") @NotEmpty Long pageNumber,
            @RequestParam(defaultValue = "2") @NotEmpty Long size,
            ClassInfo classInfo) {
        Page<ClassInfo> Page = new Page<>(pageNumber, size);
        return classService.selectClassListPage(Page,classInfo);
    }

    /**
     * 获取classInfo详细信息
     */
    //@PreAuthorize("@ss.hasPermi('system:class:query')")
    @ApiOperation(value = "根据id查班级信息")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(classService.selectClassById(id));
    }

    /**
     * 新增classInfo
     */
    //@PreAuthorize("@ss.hasPermi('system:class:add')")
    //@Log(title = "classInfo", businessType = BusinessType.INSERT)
    @ApiOperation(value = "管理员新增班级信息")
    @PostMapping
    public AjaxResult add(@RequestBody @ApiParam ClassInfo classInfo) {
        return toAjax(classService.insertClass(classInfo));
    }

    /**
     * 修改classInfo
     */
    //@PreAuthorize("@ss.hasPermi('system:class:edit')")
    //@Log(title = "classInfo", businessType = BusinessType.UPDATE)
    @ApiOperation(value = "管理员修改班级信息")
    @PutMapping
    public AjaxResult edit(@RequestBody @ApiParam ClassInfo classInfo) {
        return toAjax(classService.updateClass(classInfo));
    }

    /**
     * 删除classInfo
     */
    //@PreAuthorize("@ss.hasPermi('system:class:remove')")
    //@Log(title = "classInfo", businessType = BusinessType.DELETE)
    @ApiOperation(value = "管理员删除班级信息")
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(classService.deleteClassByIds(ids));
    }
}
