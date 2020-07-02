// Generated via service.ftl
package com.example.server.service;

import com.example.server.domain.Category;
import com.example.server.domain.CategoryExample;
import com.example.server.dto.CategoryDto;
import com.example.server.dto.PageDto;
import com.example.server.mapper.CategoryMapper;
import com.example.server.util.CopyUtil;
import com.example.server.util.UuidUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    public void list(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPage(), pageDto.getSize());
        CategoryExample categoryExample = new CategoryExample();
        List<Category> categoryList = categoryMapper.selectByExample(categoryExample);
        PageInfo<Category> pageInfo = new PageInfo<>(categoryList);
        pageDto.setTotal(pageInfo.getTotal());
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        for (Category category : categoryList) {
            CategoryDto categoryDto = CopyUtil.copy(category, CategoryDto.class);
            categoryDtoList.add(categoryDto);
        }
        pageDto.setList(categoryDtoList);
    }

    public void save(CategoryDto categoryDto) {
        Category category = CopyUtil.copy(categoryDto, Category.class);
        if (StringUtils.isEmpty(categoryDto.getId())) {
            this.insert(category);
        } else {
            this.update(category);
        }
    }

    /**
     * 新增
     */
    private void insert(Category category) {
        category.setId(UuidUtil.getShortUuid());
        categoryMapper.insert(category);
    }

    private void update(Category category) {
        categoryMapper.updateByPrimaryKey(category);
    }

    public void delete(String id) {
        categoryMapper.deleteByPrimaryKey(id);
    }
}