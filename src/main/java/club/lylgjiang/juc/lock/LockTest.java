package club.lylgjiang.juc.lock;

/**
 * @Classname LockTest
 * @Description 显示锁 Lock
 * @Date 2019/10/6 19:59
 * @Created by Jiavg
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 一.用于解决多线程安全问题的方式:
 * ①同步代码块
 * ②同步方法
 * JDK 1.5后
 * ③同步锁Lock
 *   注意:是一个显示锁,需要通过lock()方法上锁,必须通过unlock()方法释放锁.
 * 
 *  在 Java 5.0 之前，协调共享对象的访问时可以使用的机制只有 synchronized 和 volatile 。
 *   Java 5.0 后增加了一些新的机制，但并不是一种替代内置锁的方法，而是当内置锁不适用时，
 *   作为一种可选择的高级功能。
 *  ReentrantLock 实现了 Lock 接口，并提供了与synchronized 相同的互斥性和内存可见性。
 *   但相较于synchronized 提供了更高的处理锁的灵活性。
 */
public class LockTest {

    public static void main(String[] args) {
        
        RunTask task = new RunTask();
        for (int i = 0; i < 3; i++) {
            new Thread(task, "一号窗口").start();
            new Thread(task, "二号窗口").start();
            new Thread(task, "三号窗口").start();
        }
        
    }
    
}

class RunTask implements Runnable{

    private Integer ticket = 100;
    private Lock lock = new ReentrantLock();
    
    @Override
    public void run() {
        while (true){
            lock.lock();
            try {
                if(ticket > 0){
                    System.out.println(Thread.currentThread().getName() + ":" + ticket);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ticket--;
                }
            }finally {
                lock.unlock();
            }
            
        }
    }
}
