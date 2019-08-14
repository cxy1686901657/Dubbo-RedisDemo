package com.qc.yx.utils;

import java.util.Random;

/**
 * @author qc
 * @date 2019/8/9
 * @description
 * @model
 * @project Dubbo-RedisDemo
 */

public class RandomPrimaryKeyUtil {
    private RandomPrimaryKeyUtil(){ }
    public static synchronized String generateKey(){
        Integer number = new Random().nextInt(90000) + 10000;
        Long l = System.currentTimeMillis()+number;
        String substring = l.toString();

        return substring.substring(6, 11);
    }
    public static void main(String[] args){
        System.out.println(generateKey());
    }

}
