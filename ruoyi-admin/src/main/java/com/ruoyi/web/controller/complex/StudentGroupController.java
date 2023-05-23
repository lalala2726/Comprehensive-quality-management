package com.ruoyi.web.controller.complex;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.zhangchuang.complex.entity.GroupStudentDataInfo;
import com.zhangchuang.complex.entity.StudentGroup;
import com.zhangchuang.complex.service.StudentGroupDataService;
import com.zhangchuang.complex.service.StudentGroupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    private final StudentGroupDataService studentGroupDataService;

    public StudentGroupController(StudentGroupService studentGroupService, StudentGroupDataService studentGroupDataService) {
        this.studentGroupService = studentGroupService;
        this.studentGroupDataService = studentGroupDataService;
    }


    /**
     * 获取小组列表
     *
     * @param studentGroup 小组
     * @return 小组列表
     */
    @GetMapping("/list")
    public TableDataInfo list(StudentGroup studentGroup) {
        startPage();
        List<StudentGroup> list = studentGroupService.selectStudentGroupList(studentGroup);
        return getDataTable(list);
    }

    /**
     * 获取小组成员信息
     *
     * @return 成员信息
     */
    @GetMapping("/{groupId}")
    public TableDataInfo getGroupInfo(@PathVariable Long groupId) {
        startPage();
        List<GroupStudentDataInfo> list = studentGroupDataService.selectGroupStudentList(groupId);
        return getDataTable(list);
    }


}
