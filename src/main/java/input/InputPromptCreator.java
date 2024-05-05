package input;

import java.lang.reflect.Proxy;

public abstract class InputPromptCreator {

    public static InputPrompt createExceptionHandlingCoordinate() {
        return (InputPrompt) Proxy.newProxyInstance(
                InputPrompt.class.getClassLoader(),
                new Class[]{InputPrompt.class},
                new ConsoleInputExceptionHandler(new CoordinateInputPrompt())
        );
    }
}
