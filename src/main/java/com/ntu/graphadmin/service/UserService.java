package com.ntu.graphadmin.service;

import com.ntu.graphadmin.entity.User;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private Map<String, String> database;

    public UserService() {
        database = new HashMap<>();
        List<String> passwords = Arrays.asList("123456", "123456", "123456", "123456", "123456");
        List<String> usernames = Arrays.asList("admin1","admin2","admin3","admin4","admin5");
        for(int i = 0;i<5;i++){
            database.put(usernames.get(i),passwords.get(i));
        }
    }

    public int verifyUser(User user){
        String password = user.getPassword();
        String username = user.getUsername();
        //对password hmac
        String pwd = database.get(username);
        if(password.equals(pwd)){
            return 1;// successful login
        }
        return 0;
    }
}
