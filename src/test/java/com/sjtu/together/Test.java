package com.sjtu.together;

import com.alibaba.fastjson.JSON;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Test {

    @org.junit.Test
    public void myTest() {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        System.out.println(timestamp);
    }


    @org.junit.Test
    public void testDeserialize() {
        List<Integer> list = (List<Integer>) JSON.parse("[1,2,3]");
        for (Integer x : list) {
            System.out.println(x);
        }
    }

    @org.junit.Test
    public void testSerialize() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        for (Integer x : list) {
            System.out.print(x);
        }
        System.out.print("=>");
        String str = JSON.toJSONString(list);
        System.out.println(str);


    }

}
