package com.blogmanager.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogUserPowerService {

    private static final Logger LOG = LoggerFactory.getLogger(BlogUserPowerService.class);

    /**
     * 获取用户权限
     * @param userId
     * @return
     */
    public List<String> listPowers(String userId){
//        return blogUserPowerDao.list(map);
        LOG.info(userId);
        return new ArrayList<>();
    }

}
