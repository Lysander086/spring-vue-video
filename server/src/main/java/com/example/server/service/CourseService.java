package com.example.server.service;

import com.example.server.domain.Course;
import com.example.server.domain.CourseExample;
import com.example.server.dto.CourseDto;
import com.example.server.dto.PageDto;
import com.example.server.mapper.CourseMapper;
import com.example.server.util.CopyUtil;
import com.example.server.util.UuidUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Resource
    private CourseMapper courseMapper;

    public void list(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPage(), pageDto.getSize());
        CourseExample example = new CourseExample();
        List<Course> courseList = courseMapper.selectByExample(example);
        PageInfo<Course> pageInfo = new PageInfo<>(courseList);
        pageDto.setTotal(pageInfo.getTotal());
        List<CourseDto> courseDtoList = new ArrayList<>();
        for (int i = 0, l = courseList.size(); i < l; i++) {
            Course course = courseList.get(i);
            CourseDto courseDto = CopyUtil.copy(course, CourseDto.class);
            courseDtoList.add(courseDto);
        }
        pageDto.setList(courseDtoList);
    }

    public void save(CourseDto courseDto) {
        Course course = CopyUtil.copy(courseDto, Course.class);
        if (StringUtils.isEmpty(courseDto.getId())) {
            this.insert(course);
        } else {
            this.update(course);
        }
    }

    private void insert(Course course) {
        course.setId(UuidUtil.getShortUuid());
        courseMapper.insert(course);
    }

    private void update(Course course) {
        courseMapper.updateByPrimaryKey(course);
    }

    public void delete(String id) {
        courseMapper.deleteByPrimaryKey(id);
    }
}