package club.lylgjiang.spring.beans.annotation.pojo;

/**
 * @Classname Cart
 * @Description 购物车
 * @Date 2019/9/20 0:34
 * @Created by Jiavg
 */
public class Cart {
    
    // 所属人
    private String own;

    public void setOwn(String own) {
        this.own = own;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "own='" + own + '\'' +
                '}';
    }
}
