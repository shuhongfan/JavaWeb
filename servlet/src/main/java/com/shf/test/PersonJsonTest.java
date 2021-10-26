package com.shf.test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.shf.pojo.Person;
import com.shf.pojo.PersonJson;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class PersonJsonTest {
//    1.2.1 javaBean和json的互转
    @Test
    public void test1(){
        PersonJson personJson = new PersonJson(1,"张三");
//        创建Gson对象
        Gson gson = new Gson();
//        toJson方法可以把java对象转换成json字符串
        String personJsonString = gson.toJson(personJson);
        System.out.println(personJsonString);

//        fromJson把 java字符串转换成json
        PersonJson fromJson = gson.fromJson(personJsonString, PersonJson.class);
        System.out.println(fromJson);
    }

//    List和json互转
    @Test
    public void test2(){
        ArrayList<PersonJson> personJsonArrayList = new ArrayList<>();

        personJsonArrayList.add(new PersonJson(1,"张三"));
        personJsonArrayList.add(new PersonJson(2,"康师傅"));

//        创建Gson实例
        Gson gson = new Gson();
        String toJson = gson.toJson(personJsonArrayList);
        System.out.println(toJson);

        List<PersonJson> list = gson.fromJson(toJson, new PersonListType().getType());
        System.out.println(list);
        PersonJson PersonJson = list.get(0);
        System.out.println(PersonJson);
    }

//    map和json互转
    @Test
    public void test3(){
        HashMap<Integer, PersonJson> personJsonHashMap = new HashMap<>();
        personJsonHashMap.put(1,new PersonJson(1,"国哥"));
        personJsonHashMap.put(2,new PersonJson(2,"康师傅"));

        Gson gson = new Gson();
        String toJson = gson.toJson(personJsonHashMap);
        System.out.println(toJson);

//        HashMap<Integer, PersonJson> map = gson.fromJson(toJson, new PersonJsonMapType().getType());
//        匿名内部类
        HashMap<Integer, PersonJson> map = gson.fromJson(toJson, new TypeToken<Map<Integer,PersonJson>>(){}.getType());
        System.out.println(map);
        PersonJson personJson = map.get(1);
        System.out.println(personJson);

    }
}