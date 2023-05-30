package com.ruoyi.web.controller.complex;

import com.ruoyi.common.core.domain.AjaxResult;
import com.zhangchuang.complex.service.DisplayService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * 数据可视化
 *
 * @author Zhangchuang
 * @create 2023/5/28 20:58
 */

@RestController
@RequestMapping("/school/complex/student/display")
public class DisplayController {

    private final DisplayService displayService;

    public DisplayController(DisplayService displayService) {
        this.displayService = displayService;
    }

    /**
     * 根据ID查询小组的成绩信息
     *
     * @param id 小组ID
     * @return 返回ID信息
     */
    @GetMapping("/{id}")
    public AjaxResult getGroupDataById(@PathVariable Integer id) {
        return AjaxResult.success(displayService.getGroupDataById(id));
    }

    /**
     * 展示成绩分析数据
     *
     * @return 数据
     */
    @GetMapping("/all")
    public AjaxResult displayDashboardData() {
        HashMap<String, Object> stringObjectHashMap = displayService.displayDashboardData();
        return AjaxResult.success(stringObjectHashMap);
    }
}
