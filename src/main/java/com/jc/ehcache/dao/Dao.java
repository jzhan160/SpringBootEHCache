package com.jc.ehcache.dao;

import com.jc.ehcache.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class Dao {
    private static HashMap<Integer,String> db;
    static {
        db = new HashMap<>();
        //db.put(1,"jiacheng");
    }

    public User save(User user){
        if (db.containsKey(user.getId())){
            User user_ = new User();
            user.setId(-1);
            user.setName("exist");
            return user_;
        }
        db.put(user.getId(),user.getName());
        return user;
    }

    public boolean delete(Integer id){
        if (!db.containsKey(id))
            return false;
        db.remove(id);
        return true;
    }

    public User update(User user){
        User user_ = new User();
        user_.setId(-1);
        if (!db.containsKey(user.getId()))
            return user_;
        db.put(user.getId(),user.getName());
        return user;
    }

    public User findById(Integer id){
        System.out.println("find in db");
        User user = new User();
        user.setId(-1);
        user.setName("NA");
        if (!db.containsKey(id))
            return user;
        user.setId(id);
        user.setName(db.get(id));
        return user;
    }
}
