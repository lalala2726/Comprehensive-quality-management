package com.ruoyi.web.controller.complex;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.zhangchuang.complex.entity.StudentLastScore;
import com.zhangchuang.complex.service.LastScoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 上次成绩控制层
 *
 * @author Zhangchuang
 * @create 2023/6/1 13:43
 */
@RestController
@RequestMapping("/school/complex/student/last/ratings")
public class LastScoreController extends BaseController {

    private final LastScoreService lastScoreService;

    public LastScoreController(LastScoreService lastScoreService) {
        this.lastScoreService = lastScoreService;
    }

    /**
     * 获取学生上次的成绩列表
     *
     * @param studentLastScore 参数信息
     * @return 成绩列表
     */

    @GetMapping("/list")
    public TableDataInfo list(StudentLastScore studentLastScore) {
        startPage();
        List<StudentLastScore> list = lastScoreService.selectStudentLastScoreList(studentLastScore);
        return getDataTable(list);
    }


    /**
     * 根据ID获取学生详细信息
     *
     * @param id 学生ID
     * @return 成绩信息
     */
    @GetMapping("/{id}")
    public AjaxResult getStudentDetailById(@PathVariable String id) {
        return AjaxResult.success(lastScoreService.getStudentDetailById(id));
    }

    /**
     * 修改成绩信息
     *
     * @param studentLastScore 参数
     * @return 修改结果
     */
    @PutMapping
    public AjaxResult updateStudentScore(@RequestBody StudentLastScore studentLastScore) {
        if (lastScoreService.updateStudentScore(studentLastScore) < 0) {
            AjaxResult.error("修改失败！");
        }
        return AjaxResult.success();
    }
}
