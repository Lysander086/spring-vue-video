package com.example.server.service;

import com.example.server.domain.Section;
import com.example.server.domain.SectionExample;
import com.example.server.dto.SectionDto;
import com.example.server.dto.PageDto;
import com.example.server.mapper.SectionMapper;
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
public class SectionService {

    @Resource
    private SectionMapper sectionMapper;

    public void list(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPage(), pageDto.getSize());
        SectionExample example = new SectionExample();
        List<Section> sectionList = sectionMapper.selectByExample(example);
        PageInfo<Section> pageInfo = new PageInfo<>(sectionList);
        pageDto.setTotal(pageInfo.getTotal());
        List<SectionDto> sectionDtoList = new ArrayList<>();
        for (int i = 0, l = sectionList.size(); i < l; i++) {
            Section section = sectionList.get(i);
            SectionDto sectionDto = CopyUtil.copy(section, SectionDto.class);
            sectionDtoList.add(sectionDto);
        }
        pageDto.setList(sectionDtoList);
    }

    public void save(SectionDto sectionDto) {
        Section section = CopyUtil.copy(sectionDto, Section.class);
        if (StringUtils.isEmpty(sectionDto.getId())) {
            this.insert(section);
        } else {
            this.update(section);
        }
    }

    private void insert(Section section) {
        section.setId(UuidUtil.getShortUuid());
        sectionMapper.insert(section);
    }

    private void update(Section section) {
        sectionMapper.updateByPrimaryKey(section);
    }

    public void delete(String id) {
        sectionMapper.deleteByPrimaryKey(id);
    }
}