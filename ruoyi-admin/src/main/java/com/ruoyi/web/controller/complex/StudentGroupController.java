package com.ruoyi.web.controller.complex;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.zhangchuang.complex.entity.StudentGroup;
import com.zhangchuang.complex.service.StudentGroupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Zhangchuang
 * @create 2023/5/23 0:37
 */
@RestController
@RequestMapping("/complex/student/group")
public class StudentGroupController extends BaseController {
    private final StudentGroupService studentGroupService;

    public StudentGroupController(StudentGroupService studentGroupService) {
        this.studentGroupService = studentGroupService;
    }

    @GetMapping("/list")
    public TableDataInfo list(StudentGroup studentGroup) {
        startPage();
        List<StudentGroup> list = studentGroupService.selectStudentGroupList(studentGroup);
        return getDataTable(list);
    }


}
