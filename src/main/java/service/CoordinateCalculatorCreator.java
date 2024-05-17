package service;

import java.lang.reflect.Proxy;

public abstract class CoordinateCalculatorCreator {

    public static CoordinateCalculator createWithExceptionHandling() {
        return (CoordinateCalculator) Proxy.newProxyInstance(
                CoordinateCalculator.class.getClassLoader(),
                new Class[]{CoordinateCalculator.class},
                new CalculatorProcessorExceptionHandler(new RetryCoordinateCalculatorProxy(new ConsoleCoordinateCalculator()))
        );
    }
}
