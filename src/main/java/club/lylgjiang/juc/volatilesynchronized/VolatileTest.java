package club.lylgjiang.juc.volatilesynchronized;

/**
 * @Classname VolatileTest
 * @Description Volatile关键字
 * @Date 2019/10/6 10:24
 * @Created by Jiavg
 */

/**
 * 一.Volatile关键字:当多个线程进行操作共享数据时,可以保证内存中数据可见.
 *      相较于synchronized是一种较为轻量级的同步策略.
 *      
 * 内存可见性:
 * ①内存可见性（Memory Visibility）是指当某个线程正在使用对象状态而另一个线程在同时修改该状态，
 * 需要确保当一个线程修改了对象状态后，其他线程能够看到发生的状态变化。
 * ②可见性错误是指当读操作与写操作在不同的线程中执行时，我们无法确保执行读操作的线程能适时地看
 * 到其他线程写入的值，有时甚至是根本不可能的事情。
 * ③我们可以通过同步来保证对象被安全地发布。除此之外我们也可以使用一种更加轻量级的 volatile 变量。
 *  
 * 二.Java 提供了一种稍弱的同步机制，即 volatile 变量，用来确保将变量的更新操作通知到其他线程。
 * 可以将 volatile 看做一个轻量级的锁，但是又与锁有些不同：
 *  对于多线程，不是一种互斥关系
 *  不能保证变量状态的“原子性操作”
 */
public class VolatileTest {

    /**
     * 存在问题:每个子线程访问主存中的flag时都会在自己的内存中"复制"一个flag
     *  写线程(thread):复制一个flag到自己的线程中,修改后在吧自己内存中的flag状态写入到主存中
     *  读线程(main):复制一个flag到自己的线程中,由于while非常底层,以至于每次循环"来不及"从主存中
     *              重新获取flag状态值,而是使用自己线程内的flag.
     * 正是由于以上两个问题导致程序不能终止(即主存中的flag已经为true,而main线程却不能及时获得flag状态并break)
     * @param args
     */
    /*public static void main(String[] args) {
        RunTask1 task1 = new RunTask1();
        Thread thread = new Thread(task1);
        thread.start();

        while (true) {
            if (task1.isFlag()) {
                System.out.println("---------------");
                break;
            }
        }
    }*/


    /**
     * synchronized解决了以上问题,但是导致运行效率下降
     * @param args
     */
    /*public static void main(String[] args) {
        RunTask1 task1 = new RunTask1();
        Thread thread = new Thread(task1);
        thread.start();

        while (true) {
            synchronized (task1){
                if (task1.isFlag()) {
                    System.out.println("---------------");
                    break;
                }
            }
        }
    }*/


    /**
     * Volatile保证内存中数据可见性.
     * @param args
     */
    public static void main(String[] args) {
        RunTask2 task2 = new RunTask2();
        Thread thread = new Thread(task2);
        thread.start();

        while (true) {
            if (task2.isFlag()) {
                System.out.println("---------------");
                break;
            }
        }
    }
    
    
    
}

class RunTask1 implements Runnable{

    private boolean flag = false;
    
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("Flag=" + flag);
    }

    public boolean isFlag() {
        return flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

class RunTask2 implements Runnable{

    private volatile boolean flag = false;
    
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("Flag=" + flag);
    }

    public boolean isFlag() {
        return flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
