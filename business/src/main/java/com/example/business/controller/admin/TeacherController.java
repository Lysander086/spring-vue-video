// Generated via controller.ftl
package com.example.business.controller.admin;

import com.example.server.dto.PageDto;
import com.example.server.dto.ResponseDto;
import com.example.server.dto.TeacherDto;
import com.example.server.service.TeacherService;
import com.example.server.util.ValidatorUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin/teacher")
public class TeacherController {

    @Resource
    private TeacherService teacherService;
    private static final String BUSINESS_NAME = "讲师";

    @PostMapping("/all")
    public ResponseDto all() {
        List<TeacherDto> categoryDtoList =  teacherService.all();
        ResponseDto responseDto = new ResponseDto();
        responseDto.setContent(categoryDtoList);
        return responseDto;
    }

    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto) {
        teacherService.list(pageDto);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setContent(pageDto);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody TeacherDto teacherDto) {
        // 保存校验
        ValidatorUtil.require(teacherDto.getName(), "姓名");
        ValidatorUtil.length(teacherDto.getName(), "姓名", 1, 50);
        ValidatorUtil.length(teacherDto.getNickname(), "昵称", 1, 50);
        ValidatorUtil.length(teacherDto.getImage(), "头像", 1, 100);
        ValidatorUtil.length(teacherDto.getPosition(), "职位", 1, 50);
        ValidatorUtil.length(teacherDto.getMotto(), "座右铭", 1, 50);
        ValidatorUtil.length(teacherDto.getIntro(), "简介", 1, 500);

        ResponseDto responseDto = new ResponseDto();
        teacherService.save(teacherDto);
        responseDto.setContent(teacherDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id) {
        ResponseDto responseDto = new ResponseDto();
        teacherService.delete(id);
        return responseDto;
    }

}
