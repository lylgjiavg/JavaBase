package club.lylgjiang.juc.readwritelock;

/**
 * @Classname ReadWriteLockTest
 * @Description 读写锁
 * @Date 2019/10/7 13:43
 * @Created by Jiavg
 */

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读-写锁 ReadWriteLock
 * 
 *  ReadWriteLock 维护了一对相关的锁，一个用于只读操作，另一个用于写入操作。
 *   只要没有 writer，读取锁可以由多个 reader 线程同时保持。写入锁是独占的。
 *   
 *  ReadWriteLock 读取操作通常不会改变共享资源，但执行写入操作时，必须独占
 *   方式来获取锁。对于读取操作占多数的数据结构。 ReadWriteLock 能提供比独占锁
 *   更高的并发性。而对于只读的数据结构，其中包含的不变性可以完全不需要考虑加锁
 *   操作。
 */
public class ReadWriteLockTest {

    public static void main(String[] args) {
        
        ReadAndWrite readAndWrite = new ReadAndWrite();
        
        new Thread(() -> {
            readAndWrite.write(new Random().nextInt());
        }, "Write").start();
        
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                readAndWrite.read();
            }, "Read").start();
        }
        
    }
}

class ReadAndWrite {

    private Integer num = 10;
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    
    public void read(){
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + ":" + num);
        } finally {
            lock.readLock().unlock();
        }
    }
    
    public void write(Integer num) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + ":" + num);
            this.num = num;
        } finally {
            lock.writeLock().unlock();
        }
    }
    
}
