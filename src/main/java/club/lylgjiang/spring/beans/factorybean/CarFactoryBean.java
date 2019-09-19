package club.lylgjiang.spring.beans.factorybean;

import club.lylgjiang.spring.beans.pojo.Car;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Classname CarFactoryBean
 * @Description Car的工厂Bean
 * @Date 2019/9/19 23:05
 * @Created by Jiavg
 */
public class CarFactoryBean implements FactoryBean<Car> {
    
    private String brand;
    
    private String company;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public Car getObject() throws Exception {
        
        System.out.println("CarFactoryBean's getObject is run...");
        
        return new Car(brand, company);
    }

    @Override
    public Class<?> getObjectType() {
        
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
