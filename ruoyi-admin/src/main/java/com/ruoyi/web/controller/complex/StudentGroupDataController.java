package com.ruoyi.web.controller.complex;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.zhangchuang.complex.entity.GroupStudentDataInfo;
import com.zhangchuang.complex.service.StudentGroupDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 学生管理
 *
 * @author Zhangchuang
 * @create 2023/5/23 13:42
 */
@RestController
@RequestMapping("/school/complex/student/data")
public class StudentGroupDataController extends BaseController {

    private final StudentGroupDataService dataService;

    public StudentGroupDataController(StudentGroupDataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/list")
    public TableDataInfo list(GroupStudentDataInfo dataInfo) {
        startPage();
        List<GroupStudentDataInfo> list = dataService.serachGroupStudentList(dataInfo);
        return getDataTable(list);
    }

}
