package www.bit.hhy;

//import java.lang.Thread;
//
//
////��˳��ִ��run(),��run()�꣬��ִ��start()����������start()��ϴ���ִ�У������Ǹ��Ե�start()�ڲ�ִ��˳�򲻱�
//
//class MyThread extends Thread {
//
//    // �߳�������
//private String title ;
//public MyThread(String title) {
//    this.title = title;
//}
//    @Override
//    public void run() {
//    // �����̴߳Ӵ˴���ʼִ��
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
//    // �߳�������
//    private String title ;
//    public MyThread(String title) {
//        this.title = title;
//    }    @Override
//    public void run()
//    {
//        // �����̴߳Ӵ˴���ʼִ��
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
//��ķ����ʽ��
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
//�����ڲ���:
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







