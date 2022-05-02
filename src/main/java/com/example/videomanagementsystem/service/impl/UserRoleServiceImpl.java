package com.example.videomanagementsystem.service.impl;

import com.example.videomanagementsystem.dao.UserRoleDao;
import com.example.videomanagementsystem.domain.VideoSystemRole;
import com.example.videomanagementsystem.service.UserRoleService;
import com.example.videomanagementsystem.util.JacksonUtil;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleDao userRoleDao;

    private final LoadingCache<Integer, Optional<VideoSystemRole>> roleCache = CacheBuilder.newBuilder()
            .maximumSize(10000)
            .expireAfterWrite(5, TimeUnit.MINUTES)
            .build(new CacheLoader<Integer, Optional<VideoSystemRole>>() {

                @Override
                public Optional<VideoSystemRole> load(Integer id) {
                    return Optional.ofNullable(userRoleDao.selectRole(id));
                }

                @Override
                public Map<Integer, Optional<VideoSystemRole>> loadAll(Iterable<? extends Integer> ids) {
                    return userRoleDao.selectRoles(Lists.newArrayList(ids)).stream()
                            .collect(Collectors.toMap(VideoSystemRole::getId, Optional::of));
                }
            });

    @Override
    public VideoSystemRole getRole(int id) {
        return roleCache.getUnchecked(id).orElse(null);
    }

    @Override
    public Map<Integer, VideoSystemRole> getRoles(List<Integer> ids) {
        try {
            return roleCache.getAll(ids).entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, role -> role.getValue().get()));
        } catch (Exception e) {
            throw new RuntimeException(String.format("获取角色信息失败. ids: %s", JacksonUtil.beanToStr(ids)), e);
        }
    }
}
