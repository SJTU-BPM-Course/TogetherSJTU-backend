package com.sjtu.together;

import com.alibaba.fastjson.JSON;
import com.sjtu.together.entity.Activity;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Test {

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

    @org.junit.Test
    public void myTest() {
        Activity activity = new Activity();
        activity.setActivityID(1);
        activity.setActivityTitle("物联网体系结构");
        activity.setActivityDescription("目前物联网架构通常分为感知层、网络层和应用层三个层次。");
        activity.setActivityPlace("陈瑞球楼303A");
        activity.setActivityCreator("王东");
        activity.setImageURL("https://www.jsr9.com/img/2020/relatedpic/p2558920738.jpg");
        System.out.println(JSON.toJSONString(activity));
    }

}
