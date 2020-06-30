package com.example.business.controller.admin;

import com.example.server.dto.SectionDto;
import com.example.server.dto.PageDto;
import com.example.server.dto.ResponseDto;
import com.example.server.service.SectionService;
import com.example.server.util.ValidatorUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/chapter")
public class SectionController {

    @Resource
    private SectionService chapterService;

    private static final String BUSINESS_NAME = "小节";

    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto) {
        chapterService.list(pageDto);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setContent(pageDto);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody SectionDto chapterDto) {
        // 保存校验
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
