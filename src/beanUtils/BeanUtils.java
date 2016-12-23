package beanUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * Created by Administrator on 04.11.16.
 */
public class BeanUtils {
    public static void assign(Object to, Object from) {
        Class<?> clazz1 = from.getClass();
        Class<?> clazz2 = to.getClass();

        for (Method methodFrom : clazz1.getMethods()) {
            for (Method methodTo : clazz2.getMethods()) {
                if (methodFrom.getName().startsWith("get")
                        && methodFrom.getParameterCount() == 0
                        && methodFrom.getReturnType() != void.class) {

                    String parameterName = methodFrom.getName().substring(3);
                    if (methodTo.getName().equals("set" + parameterName)
                            && methodTo.getParameterCount() == 1
                            && methodTo.getReturnType() == void.class) {
                        try {

                            Object resultget = methodFrom.invoke(from);
                            Type[] typesofsetter =  methodTo.getParameterTypes();
                            if (typesofsetter[0].getClass().isAssignableFrom(methodFrom.getReturnType().getClass())) {
                                methodTo.invoke(to, resultget);
                            }

                        } catch (IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }


    }
}
