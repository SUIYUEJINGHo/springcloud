/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.zy.util;

import java.io.Serializable;

/**
 * Function : this is my String
 * Created by Zy... on 2018/11/11.
 */
public final class MyString implements java.io.Serializable {

    // 用于存储字符串信息
    private char value[];

    public MyString(String content) {
        this.value = content.toCharArray();
    }
    /**
     * Method : 对比两个字符串内容
     *
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        // 1 ,先判断自身是否相等
        if (this == obj) {
            return true;
        }
        // 2 ,在判断是否存是自己的实例
        if (obj instanceof MyString) {
            MyString anOtherObj = (MyString) obj;
            // 3 ，判断是否数量相等
            int n = this.value.length;
            if (n == anOtherObj.value.length) {
                char v1[] = this.value;
                char v2[] = anOtherObj.value;
                // 下标计数值
                int i = 0;
                while (n-- != 0) {
                    if (v1[i] != v2[i]) {
                        return false;
                    }
                    i++;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        MyString a = new MyString("aaa");
        MyString b = new MyString("aab");
        System.out.println(a.equals(b));
    }
}
