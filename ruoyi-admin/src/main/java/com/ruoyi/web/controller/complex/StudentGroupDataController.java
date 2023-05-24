package com.ruoyi.web.controller.complex;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.zhangchuang.complex.entity.GroupStudentDataInfo;
import com.zhangchuang.complex.service.StudentGroupDataService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 小组管理
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


    /**
     * 获取当前小组的学生列表
     *
     * @param dataInfo 搜索参数
     * @return 学生列表
     */
    @GetMapping("/list")
    public TableDataInfo list(GroupStudentDataInfo dataInfo) {
        startPage();
        List<GroupStudentDataInfo> list = dataService.serachGroupStudentList(dataInfo);
        return getDataTable(list);
    }

    /**
     * 将学生删除小组
     *
     * @param id 学生ID
     * @return 返回结果
     */
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable Long[] id) {
        return AjaxResult.success(dataService.removeStudent(id));
    }

}
