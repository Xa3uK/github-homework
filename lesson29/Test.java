package lesson29;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

public class Test {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, IOException, ClassNotFoundException {
        List<Class> classesWithAnnotation = Scanner.findAllClassesUsingClassLoader("lesson29");

        for (Class cls : classesWithAnnotation) {
            String className = cls.getName();
            try {
                Class<?> c = Class.forName(className);
                Start annotation = c.getAnnotation(Start.class);
                String methodInAnnotation = annotation.method();
                Constructor<?> cons = c.getConstructor();
                Object obj = cons.newInstance();
                Method method = obj.getClass().getMethod(methodInAnnotation);
                method.invoke(obj);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }
}

