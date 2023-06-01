package com.ruoyi.web.controller.complex;

import com.ruoyi.common.core.page.TableDataInfo;
import com.zhangchuang.complex.service.LastScoreService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 上次成绩控制层
 *
 * @author Zhangchuang
 * @create 2023/6/1 13:43
 */
@RestController
@RequestMapping("/school/complex/student/last/ratings")
public class LastScoreController {

    private final LastScoreService lastScoreService;

    public LastScoreController(LastScoreService lastScoreService) {
        this.lastScoreService = lastScoreService;
    }


    @PreAuthorize("@ss.hasPermi('complex:rating:list')")
    @GetMapping("/list")
    public TableDataInfo list() {

        return null;
    }
}
