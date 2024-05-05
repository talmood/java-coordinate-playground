package service;

import java.lang.reflect.Proxy;

public abstract class CoordinateCalculatorCreator {

    public static CoordinateCalculator createRetryable() {
        return (CoordinateCalculator) Proxy.newProxyInstance(
                CoordinateCalculator.class.getClassLoader(),
                new Class[]{CoordinateCalculator.class},
                new RetryableCalculatorProxy(new ConsoleCoordinateCalculator())
        );
    }
}
