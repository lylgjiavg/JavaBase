package club.lylgjiang.juc.threadcondition;

/**
 * @Classname ThreadConditionTest
 * @Description 线程按序交替
 * @Date 2019/10/7 10:58
 * @Created by Jiavg
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程按序交替
 *  编写一个程序，开启 3 个线程，这三个线程的 ID 分别为
 *   A、B、C，每个线程将自己的 ID 在屏幕上打印 10 遍，要
 *   求输出的结果必须按顺序显示。
 *   如：ABCABCABC…… 依次递归
 */
public class ThreadConditionTest {

    public static void main(String[] args) {

        ConditionTask task = new ConditionTask();
        
        new Thread(() -> {
            for (int i = 0; i <= 20; i++) {
                task.loopA(i);
            }
        }, "A").start();
        
        new Thread(() -> {
            for (int i = 0; i <= 20; i++) {
                task.loopB(i);
            }
        }, "B").start();
         
        new Thread(() -> {
            for (int i = 0; i <= 20; i++) {
                task.loopC(i);
            }
        }, "C").start();
        
    }
    
    
}

class ConditionTask {
    
    private Integer index = 1;
    
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    
    public void loopA(Integer count) {
        lock.lock();
        try {
            if(index != 1){
                try {
                    condition1.await();
                    for (int i = 0; i < 1; i++) {
                        System.out.println(Thread.currentThread().getName() + "\t" + count);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            index = 2;
            condition2.signal();
        } finally {
            lock.unlock();
        }
    }
    
    public void loopB(Integer count) {
        lock.lock();
        try {
            if(index != 2){
                try {
                    condition2.await();
                    for (int i = 0; i < 1; i++) {
                        System.out.println(Thread.currentThread().getName() + "\t" + count);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            index = 3;
            condition3.signal();
        } finally {
            lock.unlock();
        }
    }
    
    public void loopC(Integer count) {
        lock.lock();
        try {
            if(index != 3){
                try {
                    condition3.await();
                    for (int i = 0; i < 1; i++) {
                        System.out.println(Thread.currentThread().getName() + "\t" + count);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            index = 1;
            condition1.signal();
        } finally {
            lock.unlock();
        }
    }
}
