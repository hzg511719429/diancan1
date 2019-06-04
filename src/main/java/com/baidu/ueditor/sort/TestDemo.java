package com.baidu.ueditor.sort;

/**
 * @ClassName: TestDemo
 * @Author: guang
 * @CreateDate: 2019/5/8 20:01
 */
public class TestDemo {
    static {
        int x = 5;
    }
    static int x,y;
    public static void main(String[] args) {
        x--;
        myMethod();
        System.out.println(x+y+ ++x);
    }

    private static void myMethod() {
        y = x++ + ++x;
    }
}
