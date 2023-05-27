package com.ruoyi.web.controller.complex;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.zhangchuang.complex.entity.GroupStudentDataInfo;
import com.zhangchuang.complex.entity.StudentGrade;
import com.zhangchuang.complex.service.SmallGroupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    public SmallGroupController(SmallGroupService smallGroupService) {
        this.smallGroupService = smallGroupService;
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
}
