package org.syh.annotation.initdemo;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InitProcessor {
    public static void main(String[] args) throws
            ClassNotFoundException, IllegalAccessException,
            IllegalArgumentException, InstantiationException,
            InvocationTargetException {
        Class<?> clazz = Class.forName("org.syh.annotation.initdemo.InitDemo");
        Method[] methods = clazz.getMethods();

        if (methods != null) {
            for (Method method: methods) {
                boolean isInit = method.isAnnotationPresent(InitMethod.class);
                if (isInit) {
                    method.invoke(clazz.newInstance(), null);
                    Annotation annotation = method.getAnnotation(InitMethod.class);
                    InitMethod initMethod = (InitMethod) annotation;
                    System.out.println(initMethod.flag());
                }
            }
        }
    }
}
