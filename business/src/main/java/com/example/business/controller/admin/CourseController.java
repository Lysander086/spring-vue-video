// Generated via controller.ftl
package com.example.business.controller.admin;

import com.example.server.dto.CourseDto;
import com.example.server.dto.PageDto;
import com.example.server.dto.ResponseDto;
import com.example.server.service.CourseService;
import com.example.server.util.ValidatorUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/course")
public class CourseController {

    @Resource
    private CourseService courseService;
    private static final String BUSINESS_NAME = "课程";

    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto) {
        courseService.list(pageDto);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setContent(pageDto);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody CourseDto courseDto) {
        // 保存校验
        ValidatorUtil.require(courseDto.getName(), "名称");
        ValidatorUtil.length(courseDto.getName(), "名称", 1, 50);
        ValidatorUtil.length(courseDto.getSummary(), "概述", 1, 2000);
        ValidatorUtil.length(courseDto.getImage(), "封面", 1, 100);

        ResponseDto responseDto = new ResponseDto();
        courseService.save(courseDto);
        responseDto.setContent(courseDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id) {
        ResponseDto responseDto = new ResponseDto();
        courseService.delete(id);
        return responseDto;
    }

}
