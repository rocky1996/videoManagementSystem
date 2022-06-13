package com.example.videomanagementsystem.dao.impl;

import com.example.videomanagementsystem.dao.KeywordsDao;
import com.example.videomanagementsystem.domain.VideoSystemKeywords;
import com.example.videomanagementsystem.mapper.VideoSystemKeywordsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class KeywordsDaoImpl implements KeywordsDao {

    @Resource
    private VideoSystemKeywordsMapper videoSystemKeywordsMapper;

    @Override
    public void insert(VideoSystemKeywords videoSystemKeywords) {
        videoSystemKeywordsMapper.insertSelective(videoSystemKeywords);
    }
}
