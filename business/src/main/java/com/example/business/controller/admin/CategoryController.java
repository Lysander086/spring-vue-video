// Generated via controller.ftl
package com.example.business.controller.admin;

import com.example.server.dto.CategoryDto;
import com.example.server.dto.PageDto;
import com.example.server.dto.ResponseDto;
import com.example.server.service.CategoryService;
import com.example.server.util.ValidatorUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;
    private static final String BUSINESS_NAME = "分类";

    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto) {
        categoryService.list(pageDto);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setContent(pageDto);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody CategoryDto categoryDto) {
        // 保存校验
        ValidatorUtil.require(categoryDto.getParent(), "父id");
        ValidatorUtil.require(categoryDto.getName(), "名称");
        ValidatorUtil.length(categoryDto.getName(), "名称", 1, 50);

        ResponseDto responseDto = new ResponseDto();
        categoryService.save(categoryDto);
        responseDto.setContent(categoryDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id) {
        ResponseDto responseDto = new ResponseDto();
        categoryService.delete(id);
        return responseDto;
    }

}
