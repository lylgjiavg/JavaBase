package club.lylgjiang.juc.atomic;

/**
 * @Classname AtomicTest
 * @Description 原子性问题
 * @Date 2019/10/6 16:51
 * @Created by Jiavg
 */

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 一.i++的原子性问题:i++的操作实际分为三步"读-改-写"
 *      int i = 10;
 *      i = i++;// 10
 *      
 *      int temp = 10;
 *      temp = temp + 1;
 *      i = temp;
 *      
 * 二.原子变量:JDK1.5后java.util.concurrent.atomic包下提供了常用的原子变量:
 *            这些原子变量使用如下技术来保证原子性
 *      1.volatile保证内存可见性
 *      2.CAS(Compare And Swap)算法保证数据的原子性
 *          CAS算法是硬件对于并发操作共享数据的支持
 *          CAS包含了三个操作数:
 *          内存值 V
 *          预估值 A
 *          更新值 B
 *          当且仅当 V == A 时, V = B .否则,不做任何操作.
 */

/**
 * 原子变量
 *  类的小工具包，支持在单个变量上解除锁的线程安全编程。事实上，此包中的类可
 *  将 volatile 值、字段和数组元素的概念扩展到那些也提供原子条件更新操作的类。
 *  类 AtomicBoolean、AtomicInteger、AtomicLong 和 AtomicReference 的实例各自提供对
 *  相应类型单个变量的访问和更新。每个类也为该类型提供适当的实用工具方法。
 *  AtomicIntegerArray、AtomicLongArray 和 AtomicReferenceArray 类进一步扩展了原子操
 *  作，对这些类型的数组提供了支持。这些类在为其数组元素提供 volatile 访问语义方
 *  面也引人注目，这对于普通数组来说是不受支持的。
 *  核心方法：boolean compareAndSet(expectedValue, updateValue)
 *  java.util.concurrent.atomic 包下提供了一些原子操作的常用类:
 *       AtomicBoolean 、AtomicInteger 、AtomicLong 、 AtomicReference
 *       AtomicIntegerArray 、AtomicLongArray
 *       AtomicMarkableReference
 *       AtomicReferenceArray
 *       AtomicStampedReference
 */
public class AtomicTest {

    public static void main(String[] args) {
        // 不能保证数据的原子性
        /*RunTask runTask = new RunTask();

        for (int i = 0; i < 10; i++) {
            new Thread(runTask).start();
        }*/

        // 使用CAS算法的原子变量,保证了数据的原子性
        RunAtomicTask runTask = new RunAtomicTask();

        for (int i = 0; i < 10; i++) {
            new Thread(runTask).start();
        }
    }
    
}

class RunTask implements Runnable{

    private Integer serialNumber = 0;
    
    @Override
    public void run() {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(getSerialNumber());
    }

    public Integer getSerialNumber() {
        return serialNumber++;
    }
}


class RunAtomicTask implements Runnable{

    private AtomicInteger serialNumber = new AtomicInteger(0);
    
    @Override
    public void run() {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(getSerialNumber());
    }

    public Integer getSerialNumber() {
        return serialNumber.getAndIncrement();
    }
}