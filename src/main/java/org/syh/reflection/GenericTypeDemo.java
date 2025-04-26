package org.syh.reflection;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

interface DataProcessor<T> {
    void process(T data);
}

class StringProcessor implements DataProcessor<String> {
    @Override
    public void process(String data) {
        System.out.println("Processing string: " + data);
    }
}

public class GenericTypeDemo {
    public static void main(String[] args) {
        StringProcessor processor = new StringProcessor();
        Class<?> clazz = processor.getClass();

        Type[] interfaces = clazz.getGenericInterfaces();
        System.out.println("The generic interfaces implemented by the class: " + Arrays.toString(interfaces));

        if (interfaces.length > 0 && interfaces[0] instanceof ParameterizedType) {
            Type superInterfaceType = interfaces[0];
            System.out.println("The first generic interface type: " + superInterfaceType);

            ParameterizedType parameterizedType = (ParameterizedType) superInterfaceType;

            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            System.out.println("Actual type arguments: " + Arrays.toString(actualTypeArguments));

            if (actualTypeArguments.length > 0) {
                Type actualTypeArgument = actualTypeArguments[0];
                System.out.println("The first actual type argument: " + actualTypeArgument);

                if (actualTypeArgument instanceof Class) {
                    Class<?> actualClass = (Class<?>) actualTypeArgument;
                    System.out.println("Class of the first actual type argument: " + actualClass.getName());
                }
            }
        }
    }
}
