package com.jc.ehcache.service;

import com.jc.ehcache.dao.Dao;
import com.jc.ehcache.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

@org.springframework.stereotype.Service
@CacheConfig(cacheNames = {"users"})
public class Service {
    @Autowired
    private Dao dao;

   @CachePut(key = "#user.id")
   public User save(User user) {
        System.out.println("save user");
        return dao.save(user);
    }

    //@CacheEvict(key = "#user.id")
    @CachePut(key = "#user.id")
    public User update(User user) {
        System.out.println("update user");
        User res = dao.update(user);
        return res;
    }


    @CacheEvict(key = "#id")   //删除缓存
    public boolean delete(Integer id) {
        System.out.println("delete user");
        return dao.delete(id);
    }

   @Cacheable(key = "#id")
    public User select(Integer id) {
        System.out.println("find user");
        return dao.findById(id);
    }

}
