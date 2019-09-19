package club.lylgjiang.spring.beans.factory;

import club.lylgjiang.spring.beans.pojo.Car;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname StaticFactory
 * @Description 静态工厂方法
 * @Date 2019/9/19 22:39
 * @Created by Jiavg
 */
public class StaticFactory {
    
    private static Map<String, Car> carMap;
    
    static {
        carMap = new HashMap<>();
        carMap.put("A", new Car("宝马", "德国宝马", 300000));
        carMap.put("B", new Car("大众", "一汽大众", 200000));
    }
    
    public static Car newInstance(String type){
        
        switch (type){
            case "宝马":
                return carMap.get("A");
            case "大众":
                return carMap.get("B");
        }
        
        return null;
    }
    
}
