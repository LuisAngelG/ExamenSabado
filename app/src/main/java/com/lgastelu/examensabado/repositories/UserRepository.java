package com.lgastelu.examensabado.repositories;

import com.lgastelu.examensabado.models.User;
import com.orm.SugarRecord;

import java.util.List;

public class UserRepository {
    public static List<User>list(){
        List<User>users= SugarRecord.listAll(User.class);
        return users;
    }

    public static User read(String username, String password){
        User user= (User) SugarRecord.find(User.class, username, password);
        return user;
    }

    public static void create(String name, String username, String email, String password){
        User user=new User(name,username,email,password);
        SugarRecord.save(user);
    }

    public static void update(String name, String username, String email, String password, Long id){
        User user=SugarRecord.findById(User.class, id);
        user.setName(name);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        SugarRecord.save(user);
    }

    public static void delete(Long id){
        User user=SugarRecord.findById(User.class, id);
        SugarRecord.delete(user);
    }

    public static void checkUser(Long id){
        User user=SugarRecord.findById(User.class, id);

    }

}
