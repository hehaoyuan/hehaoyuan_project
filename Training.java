package www.bit.hhy;

//import java.lang.Thread;
//
//
////先顺序执行run(),等run()完，再执行start()，多个对象的start()混合穿插执行，但他们各自的start()内部执行顺序不变
//
//class MyThread extends Thread {
//
//    // 线程主体类
//private String title ;
//public MyThread(String title) {
//    this.title = title;
//}
//    @Override
//    public void run() {
//    // 所有线程从此处开始执行
//             for (int i = 0; i < 10 ; i++) {
//                 System.out.println(this.title+",i = " + i);
//             }
//}
//}
// class Test {
///**
//* @Author: HeHaoYuan
//* @Date: 2019/4/23
//* @Description:
//
//
//
//
//
//
//
//*/
//    public static void main(String[] args) {
//        MyThread myThread1 = new MyThread("thread1") ;
//        MyThread myThread2 = new MyThread("thread2") ;
//        MyThread myThread3 = new MyThread("thread3") ;
//        myThread1.start();
////        myThread2.start();
////        myThread3.run();
//    }
//}



//-----------------------------------------
//import java.lang.*;
//class MyThread implements Runnable {
//    // 线程主体类
//    private String title ;
//    public MyThread(String title) {
//        this.title = title;
//    }    @Override
//    public void run()
//    {
//        // 所有线程从此处开始执行
//        for (int i = 0; i < 10 ; i++) {
//            System.out.println(this.title+",i = " + i);
//        }
//    }
//}
//
///**
//* @Author: HeHaoYuan
//* @Date: 2019/4/23
//* @Description:
//拉姆达表达式：
//
//*/
// class TestDemo {
//    public static void main(String[] args) {
//        Runnable runnable = () -> System.out.println("Hello World");
//        new Thread(runnable).start();
//    }
//}
//
//
///**
//* @Author: HeHaoYuan
//* @Date: 2019/4/23
//* @Description:
//匿名内部类:
//
//*/
////class TestDemo {
////    public static void main(String[] args) {
////        new Thread(new Runnable() {
////            @Override
////            public void run() {
////                System.out.println("Hello World");
////            }
////        }).start();
////
////    }
////}







