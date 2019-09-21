package club.lylgjiang.spring.aop.dynamicproxy;

/**
 * @Classname Calculate
 * @Description 计算类:目标实现类
 * @Date 2019/9/20 14:00
 * @Created by Jiavg
 */
public class Calculate implements ICalculate{
    @Override
    public int add(int i, int j) {
        int result = i + j;
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = i - j;
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result = i * j;
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result = i / j;
        return result;
    }
}
