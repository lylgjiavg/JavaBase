package club.lylgjiang.juc.thread8lock;

/**
 * @Classname Thread8Lock
 * @Description 线程八锁
 * @Date 2019/10/7 22:30
 * @Created by Jiavg
 */

/*
 * 题目：判断打印的 "one" or "two" ？
 *
 * 1. 两个普通同步方法，两个线程，标准打印， 打印?           // one two
 * 2. 新增 Thread.sleep() 给 getOne() ,打印?             // one two
 * 3. 新增普通方法 getThree() , 打印?                   //three one two
 * 4. 两个普通同步方法，两个 Number 对象，打印?         // two one
 * 5. 修改 getOne() 为静态同步方法，打印?               // two one
 * 6. 修改两个方法均为静态同步方法，一个 Number 对象?  // one two
 * 7. 一个静态同步方法，一个非静态同步方法，两个 Number 对象? // two one
 * 8. 两个静态同步方法，两个 Number 对象?    // two one
 *
 * 线程八锁的关键：
 * ①非静态方法的锁默认为 this,静态方法的锁为对应的Class实例
 * ②某一个时刻内，只能有一个线程持有锁，无论几个方法。
 */

/**
 * • 一个对象里面如果有多个synchronized方法，某一个时刻内，只要一个线程去调用
 *   其中的一个synchronized方法了，其它的线程都只能等待，换句话说，某一个时刻
 *   内，只能有唯一一个线程去访问这些synchronized方法
 * • 锁的是当前对象this，被锁定后，其它的线程都不能进入到当前对象的其它的
 *   synchronized方法
 * • 加个普通方法后发现和同步锁无关
 * • 换成两个对象后，不是同一把锁了，情况立刻变化。
 * • 都换成静态同步方法后，情况又变化
 * • 所有的非静态同步方法用的都是同一把锁——实例对象本身，也就是说如果一个实
 *   例对象的非静态同步方法获取锁后，该实例对象的其他非静态同步方法必须等待获
 *   取锁的方法释放锁后才能获取锁，可是别的实例对象的非静态同步方法因为跟该实
 *   例对象的非静态同步方法用的是不同的锁，所以毋须等待该实例对象已获取锁的非
 *   静态同步方法释放锁就可以获取他们自己的锁。
 * • 所有的静态同步方法用的也是同一把锁——类对象本身，这两把锁是两个不同的对
 *   象，所以静态同步方法与非静态同步方法之间是不会有竞态条件的。但是一旦一个
 *   静态同步方法获取锁后，其他的静态同步方法都必须等待该方法释放锁后才能获取
 *   锁，而不管是同一个实例对象的静态同步方法之间，还是不同的实例对象的静态同
 *   步方法之间，只要它们同一个类的实例对象！
 */
public class Thread8Lock {

    public static void main(String[] args) {
        
        RunTask task1 = new RunTask();
        RunTask task2 = new RunTask();
        
        new Thread(() -> {
            task1.getOne();
        }).start();
        
        new Thread(() -> {
            task2.getTwo();
        }).start();
        
//        new Thread(() -> {
//            task.getThree();
//        }).start();
        
    }
    
}

class RunTask {
    
    public   synchronized void getOne() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("one");
    }
    
    public static synchronized void getTwo() {
        System.out.println("two");
    }
    
    public void getThree() {
        System.out.println("three");
    }
    
}
