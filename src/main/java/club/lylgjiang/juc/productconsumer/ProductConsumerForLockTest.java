package club.lylgjiang.juc.productconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname ProductConsumerTest
 * @Description 生产者消费者问题
 * @Date 2019/10/7 10:10
 * @Created by Jiavg
 */

/**
 *   Condition
 *  Condition 接口描述了可能会与锁有关联的条件变量。这些变量在用
 *   法上与使用 Object.wait 访问的隐式监视器类似，但提供了更强大的
 *   功能。需要特别指出的是，单个 Lock 可能与多个 Condition 对象关
 *   联。为了避免兼容性问题，Condition 方法的名称与对应的 Object 版
 *   本中的不同。
 *  在 Condition 对象中，与 wait、notify 和 notifyAll 方法对应的分别是
 *   await、signal 和 signalAll。
 *  Condition 实例实质上被绑定到一个锁上。要为特定 Lock 实例获得
 *   Condition 实例，请使用其 newCondition() 方法。
 */
public class ProductConsumerForLockTest {

    public static void main(String[] args) {
        Clerk1 clerk = new Clerk1();

        new Thread(new Consumer1(clerk), "消费者 B").start();
        new Thread(new Product1(clerk), "生产者 A").start();
        
        new Thread(new Consumer1(clerk), "消费者 C").start();
        new Thread(new Product1(clerk), "生产者 D").start();
    }
}

class Clerk1 {
    
    private Integer product = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    
    public void get(){
        lock.lock();
        try {
            while (product >= 1){
                System.out.println("仓库已满!");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                }
            }
            System.out.println(Thread.currentThread().getName() + "进货:" + ++product);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
    
    public synchronized void sale(){
        lock.lock();
        try {
            while (product <= 0){
                System.out.println("缺货!");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                }
            }
            System.out.println(Thread.currentThread().getName() + "买货:" + --product);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
    
}

// 生产者
class Product1 implements Runnable{

    private Clerk1 clerk;

    public Product1(Clerk1 clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
            clerk.get();
        }
    }
}

// 消费者
class Consumer1 implements Runnable{

    private Clerk1 clerk;

    public Consumer1(Clerk1 clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            clerk.sale();
        }
    }
}