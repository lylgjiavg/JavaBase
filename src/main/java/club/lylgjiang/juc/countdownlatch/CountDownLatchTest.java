package club.lylgjiang.juc.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @Classname CountDownLatchTest
 * @Description 闭锁
 * @Date 2019/10/6 18:58
 * @Created by Jiavg
 */

/**
 * CountDownLatch
 *  Java 5.0 在 java.util.concurrent 包中提供了多种并发容器类来改进同步容器的性能。
 *  CountDownLatch 一个同步辅助类，在完成一组正在其他线程中执行的操作之前，它允许
 *   一个或多个线程一直等待。
 *  闭锁可以延迟线程的进度直到其到达终止状态，闭锁可以用来确保某些活动直到其他活动
 *   都完成才继续执行：
 *       确保某个计算在其需要的所有资源都被初始化之后才继续执行;
 *       确保某个服务在其依赖的所有其他服务都已经启动之后才启动;
 *       等待直到某个操作所有参与者都准备就绪再继续执行。
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        
        CountDownLatch latch = new CountDownLatch(5);
        RunTask task = new RunTask(latch);

        long start = System.currentTimeMillis();

        for (int i = 0; i < 5; i++) {
            new Thread(task).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("总用时:" + (end-start));
    }
    
}

class RunTask implements Runnable{

    private CountDownLatch latch;

    public RunTask() {
    }
    public RunTask(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10000; i++) {
                if (i % 2 == 0){
                    System.out.println(i);
                }
            }
        }finally {
            latch.countDown();   
        }        
    }
}