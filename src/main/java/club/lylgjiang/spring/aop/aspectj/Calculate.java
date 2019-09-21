package club.lylgjiang.spring.aop.aspectj;

import org.springframework.stereotype.Component;

/**
 * @Classname Calculate
 * @Description 计算类:目标实现类
 * @Date 2019/9/20 14:00
 * @Created by Jiavg
 */
@Component
public class Calculate implements ICalculate {
    @Override
    public int add(int i, int j) {
        int result = i + j;
        System.out.println("------execution add...------");
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = i - j;
        System.out.println("------execution sub...------");
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result = i * j;
        System.out.println("------execution mul...------");
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result = i / j;
        System.out.println("------execution div...------");
        return result;
    }
}
