package club.lylgjiang.spring.beans.factory;

import club.lylgjiang.spring.beans.pojo.Car;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname InstanceFactory
 * @Description 实例工厂
 * @Date 2019/9/19 22:54
 * @Created by Jiavg
 */
public class InstanceFactory {

    private Map<String, Car> carMap;

    public InstanceFactory() {
        
        carMap = new HashMap<>();
        carMap.put("A", new Car("法拉利", "德国法拉利", 300000));
        carMap.put("B", new Car("大唐", "中国大唐", 200000));
        
    }
    
    public Car newInstance(String type){
        
        switch (type){
            case "法拉利":
                return carMap.get("A");
            case "大唐":
                return carMap.get("B");
        }

        return null;
    }
    
}
