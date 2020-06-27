package com.example.business.controller.admin;

import com.example.server.dto.ChapterDto;
import com.example.server.service.ChapterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
//尽量与包名一直
@RequestMapping("/admin")
public class ChapterController {

    @Resource
    private ChapterService chapterService;


    @RequestMapping("/chapter")
    public List<ChapterDto> list() {
        return chapterService.list();
    }

}
