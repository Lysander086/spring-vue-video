package com.example.business.controller.admin;

import com.example.server.dto.ChapterDto;
import com.example.server.dto.PageDto;
import com.example.server.dto.ResponseDto;
import com.example.server.exception.ValidatorException;
import com.example.server.service.ChapterService;
import com.example.server.util.ValidatorUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
//尽量与包名一致
@RequestMapping("/admin/chapter")
public class ChapterController {

    @Resource
    private ChapterService chapterService;

    private static final String BUSINESS_NAME = "大章";

    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto) {
        chapterService.list(pageDto);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setContent(pageDto);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody ChapterDto chapterDto) {
        //        保存校验
        ValidatorUtil.require(chapterDto.getName(), "名称");
        ValidatorUtil.require(chapterDto.getCourseId(), "课程ID");
        ValidatorUtil.length(chapterDto.getCourseId(), "课程ID", 1, 8);

        chapterService.save(chapterDto);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setContent(chapterDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id) {
        ResponseDto responseDto = new ResponseDto();
        chapterService.delete(id);
        return responseDto;
    }

}
