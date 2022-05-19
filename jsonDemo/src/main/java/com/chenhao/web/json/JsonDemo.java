package com.chenhao.web.json;

import com.alibaba.fastjson.JSON;
import com.chenhao.pojo.User;

public class JsonDemo {
    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setUsername("张三");
        user.setPassword("123");

        String s = JSON.toJSONString(user);
        System.out.println(s);

        String json = "{\"id\":2,\"password\":\"368\",\"username\":\"李四\"}";

        User user1 = JSON.parseObject(json, User.class);

        System.out.println(user1);
    }
}
