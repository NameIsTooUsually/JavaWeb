package com.chenhao.example;

import java.util.HashMap;
import java.util.TreeSet;
/*
    请自行选择比较器排序和自然排序两种方式；
    要求：存入四个字符串，"c","ab","df","qwer"
    按照长度排序，如果一样长则按照首字母排序
*/
public class Demo {
    public static void main(String[] args) {
        //创建一个TreeSet集合，创建对象的时候传递一个比较器对象
        TreeSet<String> treeSet = new TreeSet<String>(
                (o1,o2)->{int result = o1.length()-o2.length();
                                result = result==0? o1.compareTo(o2):result;
                                return -result;});
        //添加元素
        treeSet.add("c");
        treeSet.add("ab");
        treeSet.add("df");
        treeSet.add("qwer");
        //打印展示排序结果
        System.out.println(treeSet);


    }
}