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

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", price=" + price +
                '}';
    }
}
