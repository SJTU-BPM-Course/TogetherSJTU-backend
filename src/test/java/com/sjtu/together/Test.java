package com.sjtu.together;

import com.alibaba.fastjson.JSON;
import com.sjtu.together.entity.Activity;
import com.sjtu.together.entity.QRCodeData;
import org.springframework.util.DigestUtils;

import java.sql.Timestamp;
import java.util.*;

public class Test {

    @org.junit.Test
    public void testDeserialize() {
        System.out.println("11" + JSON.parse(""));

        HashSet<Integer> set = new HashSet<>((List<Integer>)JSON.parse("null"));
        System.out.println(set);
        System.out.println(JSON.toJSONString(set));
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

    @org.junit.Test
    public void myTest() {
        QRCodeData codeData = new QRCodeData(1);
        System.out.println(JSON.toJSONString(codeData));
    }

}
