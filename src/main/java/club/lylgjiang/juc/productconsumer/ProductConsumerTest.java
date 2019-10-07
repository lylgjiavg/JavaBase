package club.lylgjiang.juc.productconsumer;

/**
 * @Classname ProductConsumerTest
 * @Description 生产者消费者问题
 * @Date 2019/10/7 10:10
 * @Created by Jiavg
 */
public class ProductConsumerTest {

    public static void main(String[] args) {
        
        Clerk clerk = new Clerk();

        new Thread(new Consumer(clerk), "消费者 B").start();
        new Thread(new Product(clerk), "生产者 A").start();
        
         new Thread(new Consumer(clerk), "消费者 C").start();
        new Thread(new Product(clerk), "生产者 D").start();
        
    }
    
}

class Clerk {
    
    private Integer product = 0;
    
    public synchronized void get(){
        
        while (product >= 1){
            System.out.println("仓库已满!");
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println(Thread.currentThread().getName() + "进货:" + ++product);
        this.notifyAll();
    }
    
    public synchronized void sale(){
        while (product <= 0){
            System.out.println("缺货!");
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println(Thread.currentThread().getName() + "买货:" + --product);
        this.notifyAll();
    }
    
}
// 生产者
class Product implements Runnable{

    private Clerk clerk;

    public Product(Clerk clerk) {
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
class Consumer implements Runnable{

    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            clerk.sale();
        }
    }
}