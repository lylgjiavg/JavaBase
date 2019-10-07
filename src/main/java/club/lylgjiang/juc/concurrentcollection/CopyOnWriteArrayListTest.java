package club.lylgjiang.juc.concurrentcollection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Classname CopyOnWriteArrayListTest
 * @Description "写入并复制"
 * @Date 2019/10/6 18:31
 * @Created by Jiavg
 */

/**
 * ConcurrentHashMap
 *  Java 5.0 在 java.util.concurrent 包中提供了多种并发容器类来改进同步容器的性能。
 *  ConcurrentHashMap 同步容器类是Java 5 增加的一个线程安全的哈希表。对与多线程的操作，
 *   介于 HashMap 与 Hashtable 之间。内部采用“锁分段”机制替代 Hashtable 的独占锁。进而
 *   提高性能。(Java 8.0改进了ConcurrentHashMap)
 *  此包还提供了设计用于多线程上下文中的 Collection 实现：
 *    ConcurrentHashMap、ConcurrentSkipListMap、ConcurrentSkipListSet、
 *    CopyOnWriteArrayList 和 CopyOnWriteArraySet。当期望许多线程访问一个给
 *    定 collection 时，ConcurrentHashMap 通常优于同步的 HashMap，
 *    ConcurrentSkipListMap 通常优于同步的 TreeMap。当期望的读数和遍历远远
 *    大于列表的更新数时，CopyOnWriteArrayList 优于同步的 ArrayList。
 */
public class CopyOnWriteArrayListTest {

    public static void main(String[] args) {

//        RunTask runTask = new RunTask();
        RunConcurrentTask runTask = new RunConcurrentTask();

        for (int i = 0; i < 10; i++) {
            new Thread(runTask).start();
        }
        
    }
    
}

class RunTask implements Runnable{

    private static ArrayList list = new ArrayList();
    
    static {
        list.add("AA");
        list.add("BB");
        list.add("CC");
    }
    
    @Override
    public void run() {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(iterator.next());
            // Exception in thread "Thread-5" java.util.ConcurrentModificationException
            list.add("DD");
        }
    }
    
}

class RunConcurrentTask implements Runnable{

    private static CopyOnWriteArrayList list = new CopyOnWriteArrayList();
    
    static {
        list.add("AA");
        list.add("BB");
        list.add("CC");
    }
    
    @Override
    public void run() {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(iterator.next());
            list.add("DD");
        }
    }
    
}