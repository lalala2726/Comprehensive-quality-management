package com.ruoyi.web.controller.complex;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.zhangchuang.complex.entity.StudentGrade;
import com.zhangchuang.complex.service.RatingsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
