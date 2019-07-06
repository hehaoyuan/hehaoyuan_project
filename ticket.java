/**
* @Author: HeHaoYuan
* @Date: 2019/4/23
* @Description:
runnable实现共享

*/
//import java.lang.*;
//class Ticket implements Runnable {
//    private int ticket=10;
//
//    @Override
//    public void run() {
//        while (this.ticket>0){
//            System.out.println("票还剩下:"+this.ticket--);
//
//        }
//    }
//}
//class Test{
//    public static void main(String[] args) {
//        Ticket ticket1=new Ticket();
//        new Thread(ticket1).start();
//        new Thread(ticket1).start();
//    }
//}







//*1
// class TestThreadName {
//
//    public static void main(String[] args) {
//
//        Thread thread = new Thread(() -> {
//            // 1 + 2 + .. + n
//            //sum  = (n+1)*n/2
//            int n = 100;
//            int sum = (n + 1) * n / 2;
//            System.out.println(Thread.currentThread().getName() + " 计算结果 " + sum);
//
//        }, "Thread-Compute-高斯函数");
//        thread.start();
//
//        //main
//        //Java (JVM) 进程
//        //创建一个线程作为程序入口，主线程，名称main
//        Thread currentThread = Thread.currentThread();
//        System.out.println(currentThread.getName());
//
//
//    }
//}

//class MyThreadName extends Thread {
//
//    public MyThreadName(String name) {
//        super(name);
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 10; i++) {
//            //获取当前线程
//            Thread thread = Thread.currentThread();
//            //获取当前线程名称
//            String name = thread.getName();
//            System.out.println(name + " " + i);
//        }
//    }
//}



//MyThread2

//public class MyThread2 {
//
//    public static void code1() {
//        Runnable runnable = new MyRunnable("MyRunnable");
//
//        System.out.println("main开始");
//
//        Thread myThread = new Thread(runnable);
//        myThread.start();//start()->start0()->run()->target.run()->runnable.run()
//        for (int i = 0; i < 10; i++) {
//            System.out.println("main " + i);
//        }
//        System.out.println("main结束");
//    }
//
//    public static void code2(){
//        System.out.println("main开始");
//        Thread myThread = new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                System.out.println("runnable " + i);
//            }
//        });
//        myThread.start();//start()->start0()->run()->target.run()->runnable.run()
//        for (int i = 0; i < 10; i++) {
//            System.out.println("main " + i);
//        }
//        System.out.println("main结束");
//    }
//
//    public static void code3(){
//        System.out.println("main开始");
//        Runnable runnable = new MyRunnable("MyRunnable");
//
//        Thread myThread1 = new Thread(runnable);
//        myThread1.start();
//        Thread myThread2 = new Thread(runnable);
//        myThread2.start();
//
//        for (int i = 0; i < 10; i++) {
//            System.out.println("main " + i);
//        }
//        System.out.println("main结束");
//    }
//
//    public static void main(String[] args) {
//        //第一种方式
//        /*
//        1. Thread 关联的是本地线程
//        2. 实现了 Runnable接口  run()-> target.run()
//         */
//        Thread thread = new MyThread("My-Thread");
//        thread.start();
//
//        //1.Runnable     代理接口
//        //2.MyRunnable implements Runnable  业务类
//        //3.MyThread   implements Runnable
//        //3.Thread     implements Runnable  代理类
//        //  提供了一个类型是Runnable的属性以及构造方法
//
//        //第二种方式
//        /*
//        1. MyRunnable 实现了Runnable
//        2. Runnable的实现类的实例化对象
//        3. new Thread(Runnable target)
//         */
//        Runnable runnable = new MyRunnable("MyRunnable");
//        Thread myThread1 = new Thread(runnable);
//        myThread1.start();
//
//
//
//    }
//}
//
//class MyRunnable implements Runnable {
//
//    private String title;
//
//    MyRunnable(String title) {
//        this.title = title;
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 10; i++) {
//            System.out.println(this.title + " " + i);
//        }
//    }
//}


