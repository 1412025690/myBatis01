package com.kkb.test;

import java.util.ArrayList;
import java.util.List;

public class ThreadLocalTest {
    //可以理解为一个容器,特殊点:只能存放一个数据
    private ThreadLocal<String> threadLocal = new ThreadLocal<>();
    private List<String> list = new ArrayList<>();

    class MyThread1 extends Thread {
        @Override
        public void run() {
            threadLocal.set("贾宝玉---");
            list.add("AAAA");
            System.out.println("线程1----threadLocal = "+threadLocal.get());
            System.out.println("线程1----list = "+list.get(0));
        }
    }
    class MyThread2 extends Thread {
        @Override
        public void run() {
            threadLocal.set("林黛玉---");
            list.add("bbbb");
            System.out.println("线程2----threadLocal = "+threadLocal.get());
            System.out.println("线程2----list = "+list.get(0));
        }
    }

    public static void main(String[] args) {
        ThreadLocalTest test = new ThreadLocalTest();
        MyThread1 test1 = test.new MyThread1();
        MyThread2 test2 = test.new MyThread2();
        test1.start();
        test2.start();
    }


    public static void main1(String[] args) {
        ThreadLocalTest test = new ThreadLocalTest();
        //添加数据
        test.threadLocal.set("贾宝玉");  //再次添加会覆盖前一个值
        //获取数据
        String s = test.threadLocal.get();
        System.out.println(s);
    }
}
