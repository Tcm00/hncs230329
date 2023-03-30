package com.example.hncs.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hncs.domain.*;
import com.example.hncs.service.IResultService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;

/**
 * resultInfoController
 *
 * @author tangcanming
 * @date 2023-03-30
 */
@Api(tags = "成绩信息管理")
@RestController
@RequestMapping("/system/result")
public class ResultController extends BaseController {
    @Autowired
    private IResultService resultService;

    /**
     * 查询resultInfo列表
     */
    //@PreAuthorize("@ss.hasPermi('system:result:list')")
    @ApiOperation(value = "管理员查看所有成绩")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNumber",value = "当前页数(默认1)",dataType = "Long",example = "1"),
            @ApiImplicitParam(name = "size",value = "每页容量(默认10)",dataType = "Long",example = "2"),
    })
    @GetMapping("/list")
    public ResultBody list(@RequestParam(defaultValue = "1") @NotEmpty Long pageNumber,
                           @RequestParam(defaultValue = "2") @NotEmpty Long size,
                           @ApiParam Result result) {
        Page<Result> Page = new Page<>(pageNumber, size);
        return resultService.selectResultListPage(Page,result);
    }

    /**
     * 获取resultInfo详细信息
     */
    //@PreAuthorize("@ss.hasPermi('system:result:query')")
    @ApiOperation(value = "根据id查成绩表")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(resultService.selectResultById(id));
    }

    /**
     * 新增resultInfo
     */
    //@PreAuthorize("@ss.hasPermi('system:result:add')")
    //@Log(title = "resultInfo", businessType = BusinessType.INSERT)
    @PostMapping
    @ApiOperation(value = "管理员新增成绩表")
    public ResultBody add(@RequestBody @ApiParam Result result) {
        return resultService.insertResult(result);
    }

    /**
     * 修改resultInfo
     */
    //@PreAuthorize("@ss.hasPermi('system:result:edit')")
    //@Log(title = "resultInfo", businessType = BusinessType.UPDATE)
    @PutMapping
    @ApiOperation(value = "管理员修改成绩表")
    public ResultBody edit(@RequestBody @ApiParam Result result) {
        return resultService.updateResult(result);
    }

    /**
     * 删除resultInfo
     */
    //@PreAuthorize("@ss.hasPermi('system:result:remove')")
    //@Log(title = "resultInfo", businessType = BusinessType.DELETE)
    @ApiOperation(value = "管理员删除成绩表信息")
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(resultService.deleteResultByIds(ids));
    }
}
