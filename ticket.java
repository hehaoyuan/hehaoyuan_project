/**
* @Author: HeHaoYuan
* @Date: 2019/4/23
* @Description:
runnableʵ�ֹ���

*/
//import java.lang.*;
//class Ticket implements Runnable {
//    private int ticket=10;
//
//    @Override
//    public void run() {
//        while (this.ticket>0){
//            System.out.println("Ʊ��ʣ��:"+this.ticket--);
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
//            System.out.println(Thread.currentThread().getName() + " ������ " + sum);
//
//        }, "Thread-Compute-��˹����");
//        thread.start();
//
//        //main
//        //Java (JVM) ����
//        //����һ���߳���Ϊ������ڣ����̣߳�����main
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
//            //��ȡ��ǰ�߳�
//            Thread thread = Thread.currentThread();
//            //��ȡ��ǰ�߳�����
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
//        System.out.println("main��ʼ");
//
//        Thread myThread = new Thread(runnable);
//        myThread.start();//start()->start0()->run()->target.run()->runnable.run()
//        for (int i = 0; i < 10; i++) {
//            System.out.println("main " + i);
//        }
//        System.out.println("main����");
//    }
//
//    public static void code2(){
//        System.out.println("main��ʼ");
//        Thread myThread = new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                System.out.println("runnable " + i);
//            }
//        });
//        myThread.start();//start()->start0()->run()->target.run()->runnable.run()
//        for (int i = 0; i < 10; i++) {
//            System.out.println("main " + i);
//        }
//        System.out.println("main����");
//    }
//
//    public static void code3(){
//        System.out.println("main��ʼ");
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
//        System.out.println("main����");
//    }
//
//    public static void main(String[] args) {
//        //��һ�ַ�ʽ
//        /*
//        1. Thread �������Ǳ����߳�
//        2. ʵ���� Runnable�ӿ�  run()-> target.run()
//         */
//        Thread thread = new MyThread("My-Thread");
//        thread.start();
//
//        //1.Runnable     ����ӿ�
//        //2.MyRunnable implements Runnable  ҵ����
//        //3.MyThread   implements Runnable
//        //3.Thread     implements Runnable  ������
//        //  �ṩ��һ��������Runnable�������Լ����췽��
//
//        //�ڶ��ַ�ʽ
//        /*
//        1. MyRunnable ʵ����Runnable
//        2. Runnable��ʵ�����ʵ��������
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


