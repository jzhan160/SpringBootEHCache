package com.jc.ehcache;

import com.jc.ehcache.model.User;
import com.jc.ehcache.service.Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableCaching
public class TestCache {

    @Autowired
    private Service service;



    @org.junit.Test
    public void test() {
        User user = new User();
        user.setId(1);
        user.setName("Jiacheng");
        service.save(user); //create a new user and put it into cache

        user = service.select(1); //get user from cache
        System.out.println("first query: "+user);
        user = service.select(1);  //get user from cache
        System.out.println("second query: "+user);

        User user_update = new User();
        user_update.setId(1);
        user_update.setName("Zhang");
        service.update(user_update); //update user and cache

        user = service.select(1); //get user from cache
        System.out.println("first query: "+user);
        user = service.select(1);//get user from cache
        System.out.println("second query: "+user);

       service.delete(1); //delete user and cache

      user = service.select(1);
      System.out.println("query after deletion: "+user);

    }

}
