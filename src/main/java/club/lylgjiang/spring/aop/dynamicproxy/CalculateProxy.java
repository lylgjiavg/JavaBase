package club.lylgjiang.spring.aop.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @Classname CalculateProxy
 * @Description 代理对象
 * @Date 2019/9/20 14:04
 * @Created by Jiavg
 */
public class CalculateProxy {
    
    private ICalculate calculate;

    public CalculateProxy(ICalculate calculate) {
        this.calculate = calculate;
    }
    
    public ICalculate getLoggerProxy(){

        ClassLoader classLoader = this.getClass().getClassLoader();
        
        Class<?>[] classes = new Class[]{ICalculate.class};
        
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("method " + method.getName() + " begin with arg" + Arrays.asList(args));

                int result = (int) method.invoke(calculate, args);

                return result;
            }
        };
        /**
         * classLoader: 代理对象使用的类加载器。 
         * classes: 指定代理对象的类型. 即代理代理对象中可以有哪些方法. 
         * invocationHandler: 当具体调用代理对象的方法时, 应该如何进行响应, 实际上就是调用 InvocationHandler 的 invoke 方法
         */
        ICalculate proxyInstance = (ICalculate) Proxy.newProxyInstance(classLoader, classes, invocationHandler);

        return proxyInstance;
    }
    
}
