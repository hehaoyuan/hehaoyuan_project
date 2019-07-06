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
//        //创建线程默认就是用户线程
//        //设置线程为守护线程需要调用setDaemon(true),必须在start之前调用
//        System.out.println("主线程开始");
//        threadA.setDaemon(true);
//        threadA.start();
//
//        Thread threadB = new Thread(new MyDaemonRunnable(), "Thread-B");
//        threadB.start();
//
//        //主线程休眠
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        threadB.interrupt();//中断
//        //threadB结束
//        System.out.println("主线程结束");
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
//                System.out.println(Thread.currentThread().getName() + "发生中断");
//                break;
//            }
//            System.out.println("线程名-" + Thread.currentThread().getName() + " 是否是守护线程：" +
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
//            System.out.println("当前线程是：" + Thread.currentThread().getName() + " " + i);
//        }
//    }
//}



/**
 * 通过多线程卖票的例子引出同步问题
 * <p>
 * Author: secondriver
 * Created: 2019/4/24
 */
//class TickTest{
//public static void main(String[] args) {
//        Runnable runnable = new MyTickRunnable();
//        new Thread(runnable, "Thread-黄牛A").start();
//        new Thread(runnable, "Thread-黄牛B").start();
//        new Thread(runnable, "Thread-黄牛C").start();
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
//            //多线程现在共享Runnable
//            synchronized(this) {
//                if (this.tick > 0) {
//                    System.out.println(Thread.currentThread().getName() + " 买票， 剩余 " + (--this.tick));
//                }
//            }
//        }
//    }
//}


// class TestJoin {
//
//    public static void main(String[] args) throws InterruptedException {
//
//        System.out.println(Thread.currentThread().getName() + " main方法开始执行");
//
//        Runnable runnable = new MyJoinRunnable();
//        Thread thread = new Thread(runnable, "Thread-A");
//        thread.start();
//
//        //希望Thread-A执行完成之后，继续执行main方法中的代码
//        try {
//            thread.join();//等待线程thread执行完毕
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//
//
//
//        System.out.println(Thread.currentThread().getName() + " main方法结束执行");
//    }
//}
//
//class MyJoinRunnable implements Runnable {
//
//    @Override
//    public void run() {
//        System.out.println(Thread.currentThread().getName() + " 执行开始");
//        for (int i = 0; i < 10; i++) {
//            try {
//                Thread.sleep(500);
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + " 执行完成");
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
//        System.out.println("主方法结束");
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
//                //阻塞
//                Thread.sleep(1000);
//
//                //code1
//                //code2
//                //判断当前线程是否中断
//                boolean bool = Thread.currentThread().isInterrupted();
//                if (bool) {
//                    System.out.println("非阻塞状态下的线程状态：" + bool);
//                    //通过中断的状态，自己来决定如何处理程序
//                    break;
//                }
//                System.out.println(Thread.currentThread().getName() + " " + i++);
//            } catch (InterruptedException e) {
//                e.printStackTrace();//sleep中断
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

 synchronized锁多对象:
通过上述代码以及运行结果我们可以发现，没有看到synchronized起到作用，三个线程同时运行test()方法。
实际上，synchronized(this)以及非static的synchronized方法，只能防止多个线程同时执行同一个对象的同步代码段。
即synchronized锁住的是括号里的对象，而不是代码。对于非static的synchronized方法，锁的就是对象本身 也就是this。
当synchronized锁住一个对象后，别的线程如果也想拿到这个对象的锁，就必须等待这个线程执行完成释放锁，
才能 再次给对象加锁，这样才达到线程同步的目的。即使两个不同的代码段，
都要锁同一个对象,/那么这两个代码段也不能在多线程环境下同时运行。


 */
//static synchronized和synchronized(Sync.class)为开始-结束，synchronized和Synchrononized(this)为开始,开始,开始
//class Sync {
//    public  static synchronized void test() {
////        synchronized (Sync.class){
//        System.out.println("test方法开始，当前线程为 " + Thread.currentThread().getName());
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("test方法结束，当前线程为 " + Thread.currentThread().getName());
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
//            System.out.println(Thread.currentThread().getName() + "  开始执行");
////            this.monitor.notify(); //一个线程
//            this.monitor.notifyAll();//多个线程
//            System.out.println(Thread.currentThread().getName() + "  结束执行");
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
//            System.out.println(Thread.currentThread().getName() + "  开始执行");
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
//            System.out.println(Thread.currentThread().getName() + "  结束执行");
//        }
//    }
//}




//class Sync {
//    public  static synchronized void test() {
//
//            System.out.println("test方法开始，当前线程为 " + Thread.currentThread().getName());
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("test方法结束，当前线程为 " + Thread.currentThread().getName());
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
// * 消费者：
// * 1. 消费商品
// * 2. 从容器中取出商品
// * 3. 如果容器为空，通知生产者生产
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
//                    System.out.println(Thread.currentThread().getName()+"容器已空，请继续生产");
//                    this.queue.notifyAll();
//                }else{
//                    Goods goods = this.queue.poll();
//                    if(goods != null){
//                        System.out.println(Thread.currentThread().getName()+"正在消费商品"+goods);
//                    }
//                }
//            }
//        }
//    }
//}
//
///**
// * 商品
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
// *  生产者：
// * 1. 生产商品
// * 2. 将生产的商品添加到容器
// * 3. 如果容器已经满了，等待消费（等通知）
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
//                    System.out.println(Thread.currentThread().getName() + " 容器满了  等待消费");
//                    try {
//                        this.queue.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                } else {
//                    Goods goods = new Goods(
//                            String.valueOf(id.getAndIncrement()),
//                            "商品"
//                    );
//                    System.out.println(Thread.currentThread().getName() + " 生产商品 " + goods);
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
//        //容器  file ,db , kafka, redis, mq , zookeeper
//        final Queue<Goods> queue = new LinkedList<>();
//        //生产者的业务类
//        final Runnable produce = new Producer(queue);
//        //消费者的业务类
//        final Runnable customer = new Customer(queue);
//
//        //生产者线程
//        for (int i = 0; i < 5; i++) {
//            new Thread(produce, "Thread-Produce-" + i).start();
//        }
//        //消费者线程
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
//        System.out.println("run 开始");//1
//        for (int i = 0; i < 10; i++) {//2
//            System.out.println(this.title + "  " + i);
//        }
//        System.out.println("run 结束");//3
//    }
//
//
//    public static void main(String[] args) {
//
//        System.out.println("这是主方法开始");//1
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
//            System.out.println("这是主方法的循环：" + i);
//        }
//        myThread1.start();
//        System.out.println("这是主方法结束");//4
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
1. 创建线程独享的变量
2. ThreadLocal.withInitial()获取具有默认值的ThreadLocal对象

如果多线程访问同一个变量，不希望相互干扰：
1. 在使用变量的时候，在线程中创建变量的副本进行使用
2. 使用ThreadLocal对象

引用方式：
1. 强引用

2. 软引用
3. 弱引用
4. 虚幻引用（幽灵引用）

 */
//class TestThreadLocal {
//
////    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
//
//    private static ThreadLocal<String> threadLocal =
//            ThreadLocal.withInitial(() -> "默认值");
//
//    private static String strValue;
//
//    public static void code1() {
//        //main线程
//        strValue = "main线程修改";
//        threadLocal.set("main线程修改");
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                strValue = "Thread-A修改";
////                threadLocal.set("Thread-A修改");
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
//        //main线程获取值
//        //main,Thread-A 同时访问strValue , threadLocal
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
//  //1加锁，1次释放锁
//
//  //锁的消除
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
//  System.out.println("是否shutdown:" + executorService.isShutdown());
//  System.out.println("是否terminated:" + executorService.isTerminated());
//
//  while (true){
//   try {
//    Thread.sleep(1000);
//   } catch (InterruptedException e) {
//    e.printStackTrace();
//   }
//   System.out.println("是否terminated:" + executorService.isTerminated());
//  }
// }
//}
//


