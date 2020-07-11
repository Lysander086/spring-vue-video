// Generated via service.ftl
package com.example.server.service;

import com.example.server.domain.Course;
import com.example.server.domain.CourseContent;
import com.example.server.domain.CourseExample;
import com.example.server.dto.CourseContentDto;
import com.example.server.dto.CourseDto;
import com.example.server.dto.PageDto;
import com.example.server.dto.SortDto;
import com.example.server.mapper.CourseContentMapper;
import com.example.server.mapper.CourseMapper;
import com.example.server.mapper.my.MyCourseMapper;
import com.example.server.util.CopyUtil;
import com.example.server.util.UuidUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class CourseService {

    @Resource
    private CourseMapper courseMapper;

    @Resource
    private MyCourseMapper myCourseMapper;

    @Resource
    private CourseCategoryService courseCategoryService;


    @Resource
    private CourseContentMapper courseContentMapper;

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

    @Transactional
    public void save(CourseDto courseDto) {
        Course course = CopyUtil.copy(courseDto, Course.class);
        if (StringUtils.isEmpty(courseDto.getId())) {
            this.insert(course);
        } else {
            this.update(course);
        }

        // 批量保存分类
        courseCategoryService.saveBatch(course.getId(), courseDto.getCategorys());
    }

    private void insert(Course course) {
        Date now = new Date();
        course.setCreatedAt(now);
        course.setUpdatedAt(now);
        course.setId(UuidUtil.getShortUuid());
        courseMapper.insert(course);
    }

    /**
     * 更新
     */
    private void update(Course course) {
        course.setUpdatedAt(new Date());
        courseMapper.updateByPrimaryKey(course);
    }

    public void delete(String id) {
        courseMapper.deleteByPrimaryKey(id);
    }

    /**
     * 更新时长
     *
     * @param courseId
     * @return
     */
    public void updateTime(String courseId) {
        myCourseMapper.updateTime(courseId);
    }

    /**
     * 保存课程内容，包含新增和修改
     */
    public int saveContent(CourseContentDto contentDto) {
        CourseContent content = CopyUtil.copy(contentDto, CourseContent.class);
        int i = courseContentMapper.updateByPrimaryKeyWithBLOBs(content);
        if (i == 0) {
            i = courseContentMapper.insert(content);
        }
        return i;
    }

    /**
     * 查找课程内容
     */
    public CourseContentDto findContent(String id) {
        CourseContent content = courseContentMapper.selectByPrimaryKey(id);
        if (content == null) {
            return null;
        }
        return CopyUtil.copy(content, CourseContentDto.class);
    }

    @Transactional
    public void sort(SortDto sortDto) {
        // 修改当前记录的排序值
        myCourseMapper.updateSort(sortDto);

        // 如果排序值变大
        if (sortDto.getNewSort() > sortDto.getOldSort()) {
            myCourseMapper.moveSortsForward(sortDto);
        }

        // 如果排序值变小
        if (sortDto.getNewSort() < sortDto.getOldSort()) {
            myCourseMapper.moveSortsBackward(sortDto);
        }
    }

}