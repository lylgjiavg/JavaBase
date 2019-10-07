package club.lylgjiang.juc.threadpool;

/**
 * @Classname ScheduledExecutorServiceTest
 * @Description 线程调度
 * @Date 2019/10/7 23:11
 * @Created by Jiavg
 */

import java.util.Random;
import java.util.concurrent.*;

/**
 * ScheduledExecutorService
 *  一个 ExecutorService，可安排在给定的延迟后运行或定
 *   期执行的命令。
 */
public class ScheduledExecutorServiceTest {

    public static void main(String[] args) {

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 10; i++) {
            ScheduledFuture<Integer> schedule = executorService.schedule(() -> {
                int num = new Random().nextInt(100);
                return num;
            }, 3, TimeUnit.SECONDS);

            try {
                System.out.println(schedule.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
    }
    
}
