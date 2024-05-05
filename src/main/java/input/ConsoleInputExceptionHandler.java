package input;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ConsoleInputExceptionHandler implements InvocationHandler {

    private final Object target;

    public ConsoleInputExceptionHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        try {
            return method.invoke(target, args);
        } catch (Exception e) {
            System.out.println(e.getCause().getMessage() + "\n");
            return this.invoke(proxy, method, args);
        }
    }
}
