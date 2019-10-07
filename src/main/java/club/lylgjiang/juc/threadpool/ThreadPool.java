package club.lylgjiang.juc.threadpool;

/**
 * @Classname ThreadPool
 * @Description 线程池
 * @Date 2019/10/7 22:49
 * @Created by Jiavg
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 *  第四种获取线程的方法：线程池，一个 ExecutorService，它使用可能的几个池线程之
 *   一执行每个提交的任务，通常使用 Executors 工厂方法配置。
 *  线程池可以解决两个不同问题：由于减少了每个任务调用的开销，它们通常可以在
 *   执行大量异步任务时提供增强的性能，并且还可以提供绑定和管理资源（包括执行
 *   任务集时使用的线程）的方法。每个 ThreadPoolExecutor 还维护着一些基本的统计数
 *   据，如完成的任务数。
 *  为了便于跨大量上下文使用，此类提供了很多可调整的参数和扩展钩子 (hook)。但
 *   是，强烈建议程序员使用较为方便的 Executors 工厂方法 ：
 *       Executors.newCachedThreadPool()（无界线程池，可以进行自动线程回收）
 *       Executors.newFixedThreadPool(int)（固定大小线程池）
 *       Executors.newSingleThreadExecutor()（单个后台线程）
 *   它们均为大多数使用场景预定义了设置。
 */

/*
 * 一、线程池：提供了一个线程队列，队列中保存着所有等待状态的线程。避免了创建与销毁额外开销，提高了响应的速度。
 *
 * 二、线程池的体系结构：
 * 	java.util.concurrent.Executor : 负责线程的使用与调度的根接口
 * 		|--**ExecutorService 子接口: 线程池的主要接口
 * 			|--ThreadPoolExecutor 线程池的实现类
 * 			|--ScheduledExecutorService 子接口：负责线程的调度
 * 				|--ScheduledThreadPoolExecutor ：继承 ThreadPoolExecutor， 实现 ScheduledExecutorService
 *
 * 三、工具类 : Executors
 * ExecutorService newFixedThreadPool() : 创建固定大小的线程池
 * ExecutorService newCachedThreadPool() : 缓存线程池，线程池的数量不固定，可以根据需求自动的更改数量。
 * ExecutorService newSingleThreadExecutor() : 创建单个线程池。线程池中只有一个线程
 *
 * ScheduledExecutorService newScheduledThreadPool() : 创建固定大小的线程，可以延迟或定时的执行任务。
 */
public class ThreadPool {

    public static void main(String[] args) {
        // 1.创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // 2.为线程池分配任务
//        RunTask task = new RunTask();
//        for (int i = 0; i < 100; i++) {
//            executorService.submit(task);
//        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Future<Integer> submit = executorService.submit(() -> {
                int sum = 0;
                for (int j = 0; j <= 100; j++) {
                    sum += j;
                }
                return sum;
            });
            try {
                list.add(submit.get() + i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (Integer integer : list) {
            System.out.println(integer);
        }


        // 3.关闭线程池
        executorService.shutdown();
    }
    
}

class RunTask implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "---->" + i);
        }
    }
}