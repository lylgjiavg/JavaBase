package club.lylgjiang.spring.beans.pojo;

/**
 * @Classname Car
 * @Description 汽车类
 * @Date 2019/9/18 22:55
 * @Created by Jiavg
 */
public class Car {
    
    // 名称
    public String name;
    // 公司
    private String company;
    // 价格
    private Integer price;
    // 车轮周长
    private Double wheelPerimeter;

    public Car() {
    }

    public Car(String name, String company) {
        this.name = name;
        this.company = company;
    }

    public Car(String name, String company, Integer price) {
        this.name = name;
        this.company = company;
        this.price = price;
    }

    /**
     * 初始化方法
     */
    public void init(){
        System.out.println("Car's is init...");
    }

    /**
     * 销毁方法
     */
    public void destroy(){
        System.out.println("Car's is destroy...");
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public Integer getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setWheelPerimeter(Double wheelPerimeter) {
        this.wheelPerimeter = wheelPerimeter;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", price=" + price +
                ", wheelPerimeter=" + wheelPerimeter +
                '}';
    }
}
