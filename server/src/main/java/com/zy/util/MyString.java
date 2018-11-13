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

    private int hash;

    public MyString(String value) {
        this.value = value.toCharArray();
    }

    public MyString(char[] value){
        this.value = value;
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

    /**
     * Method : 重写一个针对String的hashCode方法 因为要判断每个字母所以用到了char的特性
     * <p>
     * char ：特性和一个数字相加减乘除的时候可以将这个字符串转换成acs码表对应的数字
     * 31 * 本身 + 字符串ars码表
     *
     * @return
     */
    public int getHashCode() {
        int h = hash;
        // 判断是否有内容
        if (hash == 0 && this.value.length > 0) {
            char c[] = value;
            for (int i = 0; i < this.value.length; i++) {
                h = 31 * h + c[i];
            }
        }
        return h;
    }

    /**
     * Method : 将字符串转换成char数组
     *
     * @return
     */
    public char[] toCharArray() {
        char result[] = new char[value.length];
        System.arraycopy(value, 0, result, 0, value.length);
        return result;
    }

    public static void main(String[] args) {
        MyString my = new MyString("aaa");
        System.out.println(my.getHashCode());
        System.out.println( my.toCharArray());

        char ac[] = {'a','b'};
        String  a = new String(ac);
        System.out.println(a);

        MyString n = new MyString(ac);
        System.out.println(n);
    }

}
