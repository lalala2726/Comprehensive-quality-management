package com.ruoyi.web.controller.complex;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.zhangchuang.complex.entity.StudentGrade;
import com.zhangchuang.complex.service.RatingsService;
import com.zhangchuang.complex.service.SmallGroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * 小组管理
 *
 * @author Zhangchuang
 * @create 2023/5/25 21:33
 */
@RestController
@RequestMapping("/complex/student/manage/group")
public class SmallGroupController extends BaseController {
    private final SmallGroupService smallGroupService;
    private final RatingsService ratingsService;

    public SmallGroupController(SmallGroupService smallGroupService, RatingsService ratingsService) {
        this.smallGroupService = smallGroupService;
        this.ratingsService = ratingsService;
    }


    /**
     * 获取小组学生信息
     *
     * @param studentGrade 参数
     * @return 小组学生信息
     */
    @GetMapping("/list")
    public TableDataInfo list(StudentGrade studentGrade) {
        startPage();
        List<StudentGrade> list = smallGroupService.selectGroupList(studentGrade, getUsername());
        return getDataTable(list);
    }


    /**
     * 修改成绩信息
     *
     * @param studentGrade 参数
     * @return 返回结果
     */
    @Log(title = "成绩管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult updateRating(@RequestBody StudentGrade studentGrade) {
        if (smallGroupService.checkStatus(studentGrade.getStudentId()) == 1) {
            return AjaxResult.error("你已经提交过！无法再次进行修改！");
        }
        studentGrade.setUpdateBy(getUsername());
        Integer result = smallGroupService.updateRating(studentGrade);
        if (result < 0) {
            AjaxResult.error("修改失败！！");
        }
        return AjaxResult.success();
    }

    /**
     * 通过ID获取详细信息
     *
     * @param id ID
     * @return 返回参数
     */
    @GetMapping("/{id}")
    public AjaxResult getRatingInfoById(@PathVariable String id) {
        StudentGrade result = ratingsService.getRatingInfoById(id);
        if (Objects.isNull(result)) return AjaxResult.error("未找到此用户信息!");
        return AjaxResult.success(result);
    }
}
