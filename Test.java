//package www.bit.hhy;
//
///**
// * @Information:
// * @Author: HeHaoYuan
// * @Date: Created at 11:21 on 2019/4/26
// * @Package_Name: www.bit.hhy
// */
// class TestDaemon {
//
//    public static void main(String[] args) {
//
//        Thread threadA = new Thread(new MyDaemonRunnable(), "Thread-A");
//        //�����߳�Ĭ�Ͼ����û��߳�
//        //�����߳�Ϊ�ػ��߳���Ҫ����setDaemon(true),������start֮ǰ����
//        System.out.println("���߳̿�ʼ");
//        threadA.setDaemon(true);
//        threadA.start();
//
//        Thread threadB = new Thread(new MyDaemonRunnable(), "Thread-B");
//        threadB.start();
//
//        //���߳�����
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        threadB.interrupt();//�ж�
//        //threadB����
//        System.out.println("���߳̽���");
//    }
//
//
//}
//class MyDaemonRunnable implements Runnable {
//
//    @Override
//    public void run() {
//        while (true) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//                System.out.println(Thread.currentThread().getName() + "�����ж�");
//                break;
//            }
//            System.out.println("�߳���-" + Thread.currentThread().getName() + " �Ƿ����ػ��̣߳�" +
//                    Thread.currentThread().isDaemon());
//        }
//    }
//}

// class TestSleep {
//
//    public static void main(String[] args) {
//        Runnable runnable = new MySleepRunnable();
//        new Thread(runnable, "Thread-A").start();
//        new Thread(runnable, "Thread-B").start();
//        new Thread(runnable, "Thread-C").start();
//    }
//}
//
//
//class MySleepRunnable implements Runnable {
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 10; i++) {
////            try {
////                Thread.sleep(1000);
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
//            Thread.yield();
//            System.out.println("��ǰ�߳��ǣ�" + Thread.currentThread().getName() + " " + i);
//        }
//    }
//}



/**
 * ͨ�����߳���Ʊ����������ͬ������
 * <p>
 * Author: secondriver
 * Created: 2019/4/24
 */
//class TickTest{
//public static void main(String[] args) {
//        Runnable runnable = new MyTickRunnable();
//        new Thread(runnable, "Thread-��ţA").start();
//        new Thread(runnable, "Thread-��ţB").start();
//        new Thread(runnable, "Thread-��ţC").start();
//
//        }
//        }
//
//
//class MyTickRunnable implements Runnable {
//
//    private int tick = 10;
//
//    @Override
//    public void run() {
//        while (this.tick > 0) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            //--this.tick
//            //this.tick-1
//            //this.tick = this.tick-1
//            //this.tick
//            //���߳����ڹ���Runnable
//            synchronized(this) {
//                if (this.tick > 0) {
//                    System.out.println(Thread.currentThread().getName() + " ��Ʊ�� ʣ�� " + (--this.tick));
//                }
//            }
//        }
//    }
//}


// class TestJoin {
//
//    public static void main(String[] args) throws InterruptedException {
//
//        System.out.println(Thread.currentThread().getName() + " main������ʼִ��");
//
//        Runnable runnable = new MyJoinRunnable();
//        Thread thread = new Thread(runnable, "Thread-A");
//        thread.start();
//
//        //ϣ��Thread-Aִ�����֮�󣬼���ִ��main�����еĴ���
//        try {
//            thread.join();//�ȴ��߳�threadִ�����
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//
//
//
//        System.out.println(Thread.currentThread().getName() + " main��������ִ��");
//    }
//}
//
//class MyJoinRunnable implements Runnable {
//
//    @Override
//    public void run() {
//        System.out.println(Thread.currentThread().getName() + " ִ�п�ʼ");
//        for (int i = 0; i < 10; i++) {
//            try {
//                Thread.sleep(500);
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + " ִ�����");
//        }
//    }
//}

//class TestThreadStop {
//
//    public static void main(String[] args) {
//
//        Runnable runnable = new MyRunnableStopFlag();
//        Thread thread = new Thread(runnable,"Thread-Flag");
////        thread.setName("Thread-Flag");
//        thread.start();
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        //CCE
//        //((MyRunnableStopFlag) runnable).setFlag(false);
////        thread.stop();
//        thread.interrupt();
//        System.out.println("����������");
//    }
//
//}
//
//class MyRunnableStopFlag implements Runnable {
//
//    private boolean flag = true;
//
//    @Override
//    public void run() {
//        int i = 0;
//        while (flag) {
//            try {
//                //����
//                Thread.sleep(1000);
//
//                //code1
//                //code2
//                //�жϵ�ǰ�߳��Ƿ��ж�
//                boolean bool = Thread.currentThread().isInterrupted();
//                if (bool) {
//                    System.out.println("������״̬�µ��߳�״̬��" + bool);
//                    //ͨ���жϵ�״̬���Լ���������δ������
//                    break;
//                }
//                System.out.println(Thread.currentThread().getName() + " " + i++);
//            } catch (InterruptedException e) {
//                e.printStackTrace();//sleep�ж�
//                boolean bool = Thread.currentThread().isInterrupted();
//                System.out.println(bool);
//                return;
//            }
//
//        }
//    }
//
////    public boolean isFlag() {
////        return flag;
////    }
//
//    public void setFlag(boolean flag) {
//        this.flag = flag;
//    }
//}


//class TestPriority {
//
//    public static void main(String[] args) {
////        Thread thread1 = new MyPriorityThread();
////        thread1.setName("Thread-1");
////        thread1.setPriority(Thread.MAX_PRIORITY); //oldPriority ?
////        Thread thread2 = new MyPriorityThread();
////        thread2.setName("Thread-2");
////        thread2.setPriority(Thread.NORM_PRIORITY);
//        Thread thread3 = new MyPriorityThread();
//        thread3.setName("Thread-3");
//        thread3.setPriority(Thread.MIN_PRIORITY);
//
////        thread1.start();
////        thread2.start();
//        thread3.start();
//
//
//        System.out.println("main priority : " + Thread.currentThread().getPriority());
//    }
//
//}
//
//class MyPriorityThread extends Thread {
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 10; i++) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + " " + this.getPriority());
//
//            Thread thread = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getPriority());
//                }
//            }, Thread.currentThread().getName() + i);
//            thread.start();
//
//        }
//    }
//}


/**
* @Author: HeHaoYuan
* @Date: 2019/4/27
* @Description:

 synchronized�������:
ͨ�����������Լ����н�����ǿ��Է��֣�û�п���synchronized�����ã������߳�ͬʱ����test()������
ʵ���ϣ�synchronized(this)�Լ���static��synchronized������ֻ�ܷ�ֹ����߳�ͬʱִ��ͬһ�������ͬ������Ρ�
��synchronized��ס����������Ķ��󣬶����Ǵ��롣���ڷ�static��synchronized���������ľ��Ƕ����� Ҳ����this��
��synchronized��סһ������󣬱���߳����Ҳ���õ��������������ͱ���ȴ�����߳�ִ������ͷ�����
���� �ٴθ���������������Ŵﵽ�߳�ͬ����Ŀ�ġ���ʹ������ͬ�Ĵ���Σ�
��Ҫ��ͬһ������,/��ô�����������Ҳ�����ڶ��̻߳�����ͬʱ���С�


 */
//static synchronized��synchronized(Sync.class)Ϊ��ʼ-������synchronized��Synchrononized(this)Ϊ��ʼ,��ʼ,��ʼ
//class Sync {
//    public  static synchronized void test() {
////        synchronized (Sync.class){
//        System.out.println("test������ʼ����ǰ�߳�Ϊ " + Thread.currentThread().getName());
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("test������������ǰ�߳�Ϊ " + Thread.currentThread().getName());
//   // }
//    }
//}
//class MyThread extends Thread {
//    @Override
//    public void run() {
//        Sync sync = new Sync() ;
//        sync.test();
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        for (int i = 0; i < 3; i++) {
//            Thread thread = new MyThread();
//            thread.start();
//        }
//    }
//}






//class TestNotify {
//
//    public static void main(String[] args) {
//
//        final Object monitor = new Object();
//        Thread threadWait = new MyWaitThread(monitor);
//        threadWait.setName("Thread-wait");
//
//        Thread threadNotify = new MyNotifyThread(monitor);
//        threadNotify.setName("Thread-notify");
//
//        Thread threadWait2 = new MyWaitThread(monitor);
//        threadWait2.setName("Thread-wait2");
//
//        threadWait2.start();
//        threadWait.start();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        threadNotify.start();
//    }
//}
//
//class MyNotifyThread extends Thread {
//
//    private final Object monitor;
//
//    public MyNotifyThread(Object monitor) {
//        this.monitor = monitor;
//    }
//
//    @Override
//    public void run() {
//        synchronized(this.monitor) {
//            System.out.println(Thread.currentThread().getName() + "  ��ʼִ��");
////            this.monitor.notify(); //һ���߳�
//            this.monitor.notifyAll();//����߳�
//            System.out.println(Thread.currentThread().getName() + "  ����ִ��");
//        }
//
//    }
//}
//
//class MyWaitThread extends Thread {
//
//    private final Object monitor;
//
//    public MyWaitThread(Object monitor) {
//        this.monitor = monitor;
//    }
//
//    @Override
//    public void run() {
//        synchronized(this.monitor) {
//            System.out.println(Thread.currentThread().getName() + "  ��ʼִ��");
//            try {
//                this.monitor.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "  ����ִ��");
//        }
//    }
//}




//class Sync {
//    public  static synchronized void test() {
//
//            System.out.println("test������ʼ����ǰ�߳�Ϊ " + Thread.currentThread().getName());
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("test������������ǰ�߳�Ϊ " + Thread.currentThread().getName());
//
//    }
//}
//class MyThread extends Thread {
//    private Sync sync ;
//    public MyThread(Sync sync) {
//        this.sync = sync ;   }
//        @Override
//        public void run() {
//        this.sync.test();
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        Sync sync = new Sync() ;
//        for (int i = 0; i < 3 ; i++) {
//            Thread thread = new MyThread(sync) ;
//            thread.start();
//        }
//    }
//}

//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.concurrent.atomic.AtomicInteger;
///**
// * �����ߣ�
// * 1. ������Ʒ
// * 2. ��������ȡ����Ʒ
// * 3. �������Ϊ�գ�֪ͨ����������
// */
//
//class Customer implements Runnable{
//    private final Queue<Goods> queue;
//
//    public Customer(Queue<Goods> queue) {
//        this.queue = queue;
//    }
//
//    @Override
//    public void run() {
//        while (true){
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            synchronized (this.queue){
//                if(this.queue.isEmpty()){
//                    System.out.println(Thread.currentThread().getName()+"�����ѿգ����������");
//                    this.queue.notifyAll();
//                }else{
//                    Goods goods = this.queue.poll();
//                    if(goods != null){
//                        System.out.println(Thread.currentThread().getName()+"����������Ʒ"+goods);
//                    }
//                }
//            }
//        }
//    }
//}
//
///**
// * ��Ʒ
// */
//class Goods{
//    private final String id;
//    private final String name;
//
//    public Goods(String id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    @Override
//    public String toString() {
//        return "Goods{" +
//                "id='" + id + '\'' +
//                ", name='" + name + '\'' +
//                '}';
//    }
//}
//
///**
// *  �����ߣ�
// * 1. ������Ʒ
// * 2. ����������Ʒ��ӵ�����
// * 3. ��������Ѿ����ˣ��ȴ����ѣ���֪ͨ��
// */
//class Producer implements Runnable{
//    private final Queue<Goods> queue;
//    private final Integer maxCapacity = 10;
//    private final AtomicInteger id = new AtomicInteger(0);
//    public Producer(Queue<Goods> queue) {
//        this.queue = queue;
//    }
//
//    @Override
//    public void run() {
//        while(true){
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }synchronized(this.queue) {
//                if (this.queue.size() == maxCapacity) {
//                    //wait
//                    System.out.println(Thread.currentThread().getName() + " ��������  �ȴ�����");
//                    try {
//                        this.queue.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                } else {
//                    Goods goods = new Goods(
//                            String.valueOf(id.getAndIncrement()),
//                            "��Ʒ"
//                    );
//                    System.out.println(Thread.currentThread().getName() + " ������Ʒ " + goods);
//                    this.queue.add(goods);
//                }
//            }
//        }
//    }
//
//}
//
//class text_Subject {
//    public static void main(String[] args) {
//        //����  file ,db , kafka, redis, mq , zookeeper
//        final Queue<Goods> queue = new LinkedList<>();
//        //�����ߵ�ҵ����
//        final Runnable produce = new Producer(queue);
//        //�����ߵ�ҵ����
//        final Runnable customer = new Customer(queue);
//
//        //�������߳�
//        for (int i = 0; i < 5; i++) {
//            new Thread(produce, "Thread-Produce-" + i).start();
//        }
//        //�������߳�
//        for (int i = 0; i < 8; i++) {
//            new Thread(customer, "Thread-Customer-" + i).start();
//        }
//    }
//}




//class MyThread extends Thread {
//
//    private String title;
//
//    public MyThread(String title) {
//        this.title = title;
//    }
//
//
//    @Override
//    public void run() {
//        System.out.println("run ��ʼ");//1
//        for (int i = 0; i < 10; i++) {//2
//            System.out.println(this.title + "  " + i);
//        }
//        System.out.println("run ����");//3
//    }
//
//
//    public static void main(String[] args) {
//
//        System.out.println("������������ʼ");//1
//
//        MyThread myThread1 = new MyThread("My-Thread1");
////        MyThread myThread2 = new MyThread("My-Thread2");
////        MyThread myThread3 = new MyThread("My-Thread3");
//
////        myThread1.run();
////        myThread2.run();
////        myThread3.run();
//        myThread1.start();//2
////        myThread2.start();
////        myThread3.start();
//        for (int i = 0; i < 10; i++) {//3
//            System.out.println("������������ѭ����" + i);
//        }
//        myThread1.start();
//        System.out.println("��������������");//4
//
//    }
//}




//import com.sun.deploy.uitoolkit.Window;
//import com.sun.org.apache.xerces.internal.parsers.CachingParserPool;
//import sun.plugin2.os.windows.Windows;

import org.omg.CORBA.*;
import org.omg.CORBA.Object;

import java.util.Arrays;

/**
 * @Information:
 * @Author: HeHaoYuan
 * @Date: Created at 11:11 on 2019/4/28
 * @Package_Name: www.bit.hhy
 */
/*
ThreadLocal:
1. �����̶߳���ı���
2. ThreadLocal.withInitial()��ȡ����Ĭ��ֵ��ThreadLocal����

������̷߳���ͬһ����������ϣ���໥���ţ�
1. ��ʹ�ñ�����ʱ�����߳��д��������ĸ�������ʹ��
2. ʹ��ThreadLocal����

���÷�ʽ��
1. ǿ����

2. ������
3. ������
4. ������ã��������ã�

 */
//class TestThreadLocal {
//
////    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
//
//    private static ThreadLocal<String> threadLocal =
//            ThreadLocal.withInitial(() -> "Ĭ��ֵ");
//
//    private static String strValue;
//
//    public static void code1() {
//        //main�߳�
//        strValue = "main�߳��޸�";
//        threadLocal.set("main�߳��޸�");
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                strValue = "Thread-A�޸�";
////                threadLocal.set("Thread-A�޸�");
//                System.out.println(Thread.currentThread().getName() + " " + threadLocal.get());
//            }
//        }, "Thread-A").start();
//
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        //main�̻߳�ȡֵ
//        //main,Thread-A ͬʱ����strValue , threadLocal
//        System.out.println(strValue);
//        System.out.println(threadLocal.get());
//        threadLocal.remove();
//        System.out.println(threadLocal.get());
//    }
//
//    public static void main(String[] args) {
//        String abc = new String("abc");
//        WeakReference<String> weakReference = new WeakReference<>(abc);
//        System.out.println(weakReference.get());
//    }
//}
//


// class TestLock {
//
////    public static StringBuffer sb = new StringBuffer();
//
////    public static StringBuilder sb = new StringBuilder();
//
// public static void main(String[] args) {
//  //1������1���ͷ���
//
//  //��������
//  StringBuilder sb = new StringBuilder();
//  sb.append("a");
//  sb.append("b");
//  sb.append("c");
// }
//}




import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: secondriver
 * Created: 2019/5/9
        */
//class TestThreadPool {
//
// public static void main(String[] args) {
//
//  ExecutorService executorService = new ThreadPoolExecutor(
//          5,
//          8,
//          1,
//          TimeUnit.MINUTES,
//          new ArrayBlockingQueue<>(10),
//          new ThreadFactory() {
//           private final AtomicInteger id = new AtomicInteger(0);
//
//           @Override
//           public Thread newThread(Runnable r) {
//            Thread thread = new Thread(r);
//            thread.setName("Thread-Execute-Task-" + id.getAndIncrement());
//            return thread;
//           }
//          }
//  );
////        for (int i = 0; i < 20; i++) {
////            executorService.execute(new Runnable() {
////                @Override
////                public void run() {
////
////                    System.out.println(Thread.currentThread().getName() + " " + LocalDateTime.now());
////                }
////            });
////        }
//  final List<Future<String>> futureList = new ArrayList<>();
//  for (int i = 0; i < 10; i++) {
//   Future<String> future = executorService.submit(() -> {
//    Thread.sleep(new Random().nextInt(3000));
//    return Thread.currentThread().getName() + " " + LocalDateTime.now();
//   });
//   futureList.add(future);
//  }
//
//  for (Future<String> future : futureList) {
//   try {
//    System.out.println(future.get());
//   } catch (InterruptedException e) {
//    e.printStackTrace();
//   } catch (ExecutionException e) {
//    e.printStackTrace();
//   }
//  }
//
//  executorService.shutdownNow();
//
//  System.out.println("�Ƿ�shutdown:" + executorService.isShutdown());
//  System.out.println("�Ƿ�terminated:" + executorService.isTerminated());
//
//  while (true){
//   try {
//    Thread.sleep(1000);
//   } catch (InterruptedException e) {
//    e.printStackTrace();
//   }
//   System.out.println("�Ƿ�terminated:" + executorService.isTerminated());
//  }
// }
//}
//


