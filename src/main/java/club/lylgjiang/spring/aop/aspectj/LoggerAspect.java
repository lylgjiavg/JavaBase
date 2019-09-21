package club.lylgjiang.spring.aop.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Classname LoggerAspect
 * @Description 切面
 * @Date 2019/9/20 14:31
 * @Created by Jiavg
 */
/*
配置切面:
    切面必须是 IOC 中的 bean: 实际添加了 @Component 注解    
    声明是一个切面: 添加 @Aspect
 */
/**
    可以使用 @Order 注解指定切面的优先级, 值越小优先级越高
 */
@Order(2)
@Aspect
@Component
public class LoggerAspect {
    
    // 声明通知: 即额外加入功能对应的方法. 
    /**
     * 在 AspectJ 中, 切入点表达式可以通过操作符 &&, ||, ! 结合起来. 
     * 
     * 最典型的切入点表达式时根据方法的签名来匹配各种方法:
     * execution * com.atguigu.spring.ArithmeticCalculator.*(..): 
     * 匹配 ArithmeticCalculator 中声明的所有方法,第一个 * 代表任意修饰符及任意返回值. 
     * 第二个 * 代表任意方法. .. 匹配任意数量的参数. 若目标类与接口与该切面在同一个包中,
     * 可以省略包名.
     * 
     * execution public * ArithmeticCalculator.*(..): 
     * 匹配 ArithmeticCalculator 接口的所有公有方法.
     * 
     * execution public double ArithmeticCalculator.*(..): 
     * 匹配 ArithmeticCalculator 中返回 double 类型数值的方法
     * 
     * execution public double ArithmeticCalculator.*(double, ..): 
     * 匹配第一个参数为 double 类型的方法, .. 匹配任意数量任意类型的参数
     * 
     * execution public double ArithmeticCalculator.*(double, double):
     * 匹配参数类型为 double, double 类型的方法.
     */

    /**
     * 定义一个方法, 用于声明切入点表达式. 一般地, 该方法中再不需要添入其他的代码. 
     * 使用 @Pointcut 来声明切入点表达式. 
     * 后面的其他通知直接使用方法名来引用当前的切入点表达式. 
     */
    @Pointcut("execution(* club.lylgjiang.spring.aop.aspectj.*.* (int, int))")
    public void declarePointcut(){}
    
    /**
     * @Before 表示在目标方法执行之前执行 @Before 标记的方法的方法体. 
     * @Before 里面的是切入点表达式: 
     * 在通知中访问连接细节: 可以在通知方法中添加 JoinPoint 类型的参数, 从中可以访问到方法的签名和方法的参数. 
     * @param joinPoint
     */
    @Before("declarePointcut()")
    public void before(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        System.out.println("method " + methodName + " begin with arg" + Arrays.asList(args));
    }

    /**
     * 在方法执行之后执行的代码. 无论该方法是否出现异常
     * @param joinPoint
     */
    @After("execution(* club.lylgjiang.spring.aop.aspectj.*.* (int, int))")
    public void After(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();

        System.out.println("method " + methodName + " end");
    }

    /**
     * 在方法法正常结束受执行的代码
     * 返回通知是可以访问到方法的返回值的!
     * 
     * 在返回通知中, 只要将 returning 属性添加到 @AfterReturning 注解中, 
     * 就可以访问连接点的返回值. 该属性的值即为用来传入返回值的参数名称. 
     * 
     * 必须在通知方法的签名中添加一个同名参数. 在运行时, Spring AOP 会通过这个参数传递返回值.
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = "execution(* club.lylgjiang.spring.aop.aspectj.*.* (int, int))",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, int result){
        String methodName = joinPoint.getSignature().getName();

        System.out.println("method " + methodName + " end with result = " + result);
    }

    /**
     * 在目标方法出现异常时会执行的代码.
     * 可以访问到异常对象; 且可以指定在出现特定异常时在执行通知代码
     *
     * 将 throwing 属性添加到 @AfterThrowing 注解中, 也可以访问连接点抛出的异常.
     * Throwable 是所有错误和异常类的超类. 所以在异常通知方法可以捕获到任何错误和异常.
     * 
     * 如果只对某种特殊的异常类型感兴趣, 可以将参数声明为其他异常的参数类型. 
     * 然后通知就只在抛出这个类型及其子类的异常时才被执行.
     * @param joinPoint
     * @param exception
     */
    @AfterThrowing(value = "execution(* club.lylgjiang.spring.aop.aspectj.*.* (int, int))", 
            throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, NullPointerException exception){
        String name = joinPoint.getSignature().getDeclaringType().getName();

        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        System.out.println(name + "." + methodName + "(" + Arrays.asList(args) + ")" + "产生异常: " + exception);
    }

    /**
     * 环绕通知需要携带 ProceedingJoinPoint 类型的参数. 
     * 环绕通知类似于动态代理的全过程: ProceedingJoinPoint 类型的参数可以决定是否执行目标方法.
     * 且环绕通知必须有返回值, 返回值即为目标方法的返回值
     * 
     * 环绕通知是所有通知类型中功能最为强大的, 能够全面地控制连接点. 甚至可以控制是否执行连接点.
     * 对于环绕通知来说, 连接点的参数类型必须是 ProceedingJoinPoint . 它是 JoinPoint 的子接口, 
     * 允许控制何时执行, 是否执行连接点.
     * 
     * 在环绕通知中需要明确调用 ProceedingJoinPoint 的 proceed() 方法来执行被代理的方法. 
     * 如果忘记这样做就会导致通知被执行了, 但目标方法没有被执行.
     * 
     * 注意: 环绕通知的方法需要返回目标方法执行之后的结果, 即调用 joinPoint.proceed(); 的返回值, 
     * 否则会出现空指针异常
     */
    /*@Around(value = "execution(* club.lylgjiang.spring.aop.aspectj.*.* (int, int))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint){
        Object proceed = null;
        try {
            System.out.println("前置通知");
            proceed = proceedingJoinPoint.proceed();
            System.out.println("后置返回通知");
        } catch (Throwable throwable) {
//            throwable.printStackTrace();
            System.out.println("异常通知");
        }finally {
            System.out.println("后置通知");
        }

        return proceed;
    } */
    
}
