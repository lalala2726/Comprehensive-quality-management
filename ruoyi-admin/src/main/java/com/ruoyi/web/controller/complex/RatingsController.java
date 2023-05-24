package com.ruoyi.web.controller.complex;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.zhangchuang.complex.entity.StudentGrade;
import com.zhangchuang.complex.service.RatingsService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * 学生成绩管理
 *
 * @author Zhangchuang
 * @create 2023/5/24 16:07
 */
@RestController
@RequestMapping("/school/complex/student/ratings")
public class RatingsController extends BaseController {

    private final RatingsService ratingsService;

    public RatingsController(RatingsService ratingsService) {
        this.ratingsService = ratingsService;
    }

    /**
     * 查询查询成绩信息
     *
     * @param studentGrade 参数
     * @return 成绩信息
     */
    @GetMapping("/list")
    public TableDataInfo list(StudentGrade studentGrade) {
        startPage();
        List<StudentGrade> list = ratingsService.selectRatingsList(studentGrade);
        return getDataTable(list);
    }

    /**
     * 通过ID获取用户详细信息
     *
     * @param id 学生ID
     * @return 成绩信息
     */
    @GetMapping("/{id}")
    public AjaxResult getRatingInfoById(@PathVariable Long id) {
        StudentGrade result = ratingsService.getRatingInfoById(id);
        if (Objects.isNull(result)) return AjaxResult.error("未找到此用户信息!");
        return AjaxResult.success(result);
    }

    /**
     * 修改成绩信息
     *
     * @param studentGrade 参数
     * @return 返回结果
     */
    @PreAuthorize("@ss.hasPermi('studnet:rating:update')")
    @Log(title = "成绩管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult updateRating(@RequestBody StudentGrade studentGrade) {
        studentGrade.setUpdateBy(getUsername());
        Integer result = ratingsService.updateRating(studentGrade);
        if (result < 0) {
            AjaxResult.error("删除失败！");
        }
        return AjaxResult.success();
    }
}
