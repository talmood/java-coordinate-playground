package service;

import util.Console;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RetryableCalculatorProxy implements InvocationHandler {

    private static final String RETRY_NAVIGATION = "> 계산을 계속하시겠습니까?";
    private static final String END_CALCULATE_NAVIGATION = "> 계산을 종료합니다.";
    private final Object target;

    public RetryableCalculatorProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(target, args);

        System.out.println(RETRY_NAVIGATION);
        String isRetry = Console.readLine();
        System.out.println();

        if (isRetry.equals("yes")) {
            return this.invoke(proxy, method, args);
        }

        if (isRetry.equals("no")) {
            System.out.println(END_CALCULATE_NAVIGATION + "\n");
            return invoke;
        }

        throw new IllegalArgumentException("[ERROR] 종료 여부는 yes 아니면 no만 입력이 가능합니다.");
    }
}
