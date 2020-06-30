package com.example.business.controller.admin;

import com.example.server.dto.ChapterDto;
import com.example.server.dto.PageDto;
import com.example.server.service.ChapterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
//尽量与包名一致
@RequestMapping("/admin/chapter")
@Slf4j
public class ChapterController {

    @Resource
    private ChapterService chapterService;

    @RequestMapping("/list")
    public PageDto list(@RequestBody PageDto pageDto) {
        log.info("pageDto: {}" , pageDto);
        chapterService.list(pageDto);
        return pageDto;
    }
    @RequestMapping("/save")
    public ChapterDto save(@RequestBody ChapterDto chapterDto) {
        log.info("chapterDto: {}" , chapterDto);
        chapterService.save(chapterDto);
        return chapterDto;
    }
}
