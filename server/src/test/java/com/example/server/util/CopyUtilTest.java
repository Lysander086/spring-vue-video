package com.example.server.util;

import com.example.server.domain.Course;
import com.example.server.dto.CategoryDto;
import com.example.server.dto.CourseDto;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CopyUtilTest {

    CourseDto courseDto;

    @Before
    public void setUp(){
        courseDto = new CourseDto();
        List<CategoryDto> list = new ArrayList<>();
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(UuidUtil.getShortUuid());
        list.add(categoryDto);
        courseDto.setName("Lysander");
        courseDto.setCategorys(list);
    }

    @Test
    public void copy() {
        Course course = CopyUtil.copy(courseDto, Course.class);
        System.out.println(courseDto.toString());
        System.out.println(course.toString());

    }
}