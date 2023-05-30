package com.ruoyi.web.controller.complex;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.zhangchuang.complex.entity.StudentGrade;
import com.zhangchuang.complex.service.RatingsService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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
    @PreAuthorize("@ss.hasPermi('complex:rating:query')")
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
    @PreAuthorize("@ss.hasPermi('complex:rating:query')")
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
    @PreAuthorize("@ss.hasPermi('complex:rating:edit')")
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

    /**
     * 添加学生信息
     *
     * @param studentGrade 学生信息
     * @return 返回执行结果
     */
    @PreAuthorize("@ss.hasPermi('complex:rating:add')")
    @Log(title = "成绩管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StudentGrade studentGrade) {
        System.out.println("获取的信息为:" + studentGrade);
        studentGrade.setCreateBy(getUsername());
        if (ratingsService.checkStudentExist(studentGrade.getStudentId()) <= 0)
            return AjaxResult.error("未找到此用户的账号,请先添加学生账号！");
        if (ratingsService.checkRatingExist(studentGrade.getStudentId()) > 0)
            return AjaxResult.error("学生成绩表已存在学生信息，无法再次添加！");
        if (ratingsService.addStudentRating(studentGrade) < 0) return AjaxResult.error("添加失败！");
        return AjaxResult.success();
    }

    /**
     * 删除学生成绩信息
     *
     * @param id 参数
     * @return 返回删除结果
     */
    @PreAuthorize("@ss.hasPermi('complex:rating:remove')")
    @Log(title = "成绩管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable String[] id) {
        ratingsService.delete(id);
        return AjaxResult.success();
    }

    /**
     * 将成绩信息导出为excel
     *
     * @param response     相应信息
     * @param studentGrade 参数
     */
    @PreAuthorize("@ss.hasPermi('complex:rating:export')")
    @Log(title = "成绩管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StudentGrade studentGrade) {
        List<StudentGrade> list = ratingsService.selectRatingsList(studentGrade);
        ExcelUtil<StudentGrade> util = new ExcelUtil<StudentGrade>(StudentGrade.class);
        util.exportExcel(response, list, "学生成绩信息");
    }


    /**
     * 修改提交状态
     *
     * @param status 参数
     * @return 返回修改结果
     */
    @PreAuthorize("@ss.hasPermi('complex:rating:edit')")
    @Log(title = "成绩管理", businessType = BusinessType.UPDATE)
    @PostMapping("/submitChange/{status}")
    public AjaxResult submitChange(@PathVariable Integer status) {
        if (ratingsService.submitChange(status) < 0) {
            AjaxResult.error("修改失败！");
        }
        return AjaxResult.success();
    }

}
