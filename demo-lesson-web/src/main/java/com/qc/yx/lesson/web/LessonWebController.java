package com.qc.yx.lesson.web;

import com.github.pagehelper.PageInfo;
import com.qc.yx.bean.Lesson;
import com.qc.yx.service.ILessonService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author qc
 * @date 2019/8/14
 * @description
 * @model lesson-web
 * @project Dubbo-RedisDemo
 */
//TODO:
@Controller
@RequestMapping("/lesson/web")
public class LessonWebController {
    @Reference
    ILessonService lessonService;

    @PostMapping("list")
    public String list(Model model, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                       @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        PageInfo<Lesson> all = lessonService.getAll(pageNum, pageSize);
        model.addAttribute("lessons", all);
        return "list";
    }
}
