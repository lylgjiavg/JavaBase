package club.lylgjiang.juc.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Classname CallableTest
 * @Description Callable
 * @Date 2019/10/6 19:39
 * @Created by Jiavg
 */

/**
 *  Java 5.0 在 java.util.concurrent 提供了一个新的创建执行
 * 线程的方式：Callable 接口
 *  Callable 接口类似于 Runnable，两者都是为那些其实例可
 * 能被另一个线程执行的类设计的。但是 Runnable 不会返
 * 回结果，并且无法抛出经过检查的异常。
 *  Callable 需要依赖FutureTask ，FutureTask 也可以用作闭
 * 锁。
 */
public class CallableTest {

    public static void main(String[] args) {
        
        CallableTask task = new CallableTask();
        FutureTask<Integer> futureTask = new FutureTask(task);
        
        Thread thread = new Thread(futureTask);
        
        thread.start();
        try {
            System.out.println(futureTask.get());
            System.out.println("------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}

class CallableTask implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
        
        return sum;
    }
}