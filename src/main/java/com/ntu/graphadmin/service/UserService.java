package com.ntu.graphadmin.service;

import com.ntu.graphadmin.entity.User;
import com.ntu.graphadmin.util.HmacUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private final Map<String, String> database;
    private final String key;
    public UserService() {
        database = new HashMap<>();
        key = "WKWSCI";

        List<String> passwords = Arrays.asList("123456", "123456", "123456", "123456", "123456");
        List<String> usernames = Arrays.asList("admin1","admin2","admin3","admin4","admin5");
        for(int i = 0;i<5;i++){
            String password = HmacUtil.encode(passwords.get(i),key);
            System.out.println(password);
            database.put(usernames.get(i),password);
        }


    }

    public int verifyUser(User user, HttpServletResponse response){
        String password = user.getPassword();
        String username = user.getUsername();
        //check empty string
        if(username.length()==0||password.length()==0){
            return 0;
        }

        //对password hmac
        password = HmacUtil.encode(password,key);
        System.out.println(database);
        System.out.println(password);
        String pwd = database.get(username);
        if(password.equals(pwd)){
            //keep session
            //set session id in the cookie
            return 1;// successful login
        }
        return 0;
    }
}
