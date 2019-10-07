package club.lylgjiang.juc.atomic;

/**
 * @Classname CASTest
 * @Description CAS算法模拟
 * @Date 2019/10/6 17:17
 * @Created by Jiavg
 */

import java.util.Random;

/**
 *      CAS (Compare-And-Swap) 是一种硬件对并发的支持，针对多处理器操作而设计的处理器中的
 *  一种特殊指令，用于管理对共享数据的并发访问。
 *       CAS 是一种无锁的非阻塞算法的实现。
 *       CAS 包含了 3 个操作数：
 *           需要读写的内存值 V
 *           进行比较的值 A
 *           拟写入的新值 B
 *       当且仅当 V 的值等于 A 时，CAS 通过原子方式用新值 B 来更新 V 的
 *  值，否则不会执行任何操作。
 */
public class CASTest {

    public static void main(String[] args) {

        MyAtomicInteger atomicInteger = new MyAtomicInteger();
        
        for (int i = 0; i <10; i++) {
            new Thread(() -> {
                boolean set = atomicInteger.set(atomicInteger.getValue(), new Random().nextInt());
                System.out.println(set);
            }).start();
        }
        
    }
    
}

/**
 * CAS 是一种无锁的非阻塞算法的实现。
 *      此处使用阻塞的synchronized来模拟,具体的CAS是使用底层CAS算法来达到类似的效果.
 */
class MyAtomicInteger{
    
    private Integer value = 0;
    
    public synchronized Integer getValue(){
        return value;
    }
    
    public synchronized Integer getAndIncrease(Integer compare, Integer newValue){
        int value = this.value;
        if (value == compare) {
            this.value = newValue;
        }
        
        return this.value;
    } 
    
    public synchronized boolean set(Integer compare, Integer newValue){
        return getValue() == getAndIncrease(compare, newValue);
    }
}