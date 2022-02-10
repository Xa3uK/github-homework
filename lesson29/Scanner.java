package lesson29;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Scanner {

    static Comparator<Class> comparator = new Comparator<>() {
        @Override
        public int compare(Class o1, Class o2) {
            try {
                Class<?> c1 = Class.forName(o1.getName());
                Class<?> c2 = Class.forName(o2.getName());
                int p1 = c1.getAnnotation(Start.class).priority();
                int p2 = c2.getAnnotation(Start.class).priority();
                if (p1 > p2) {
                    return -1;
                } else {
                    return 1;
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return 0;
        }
    };

    public static List<Class> findAllClassesUsingClassLoader(String packageName) {
        InputStream stream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream(packageName.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(line -> getClass(line, packageName))
                .filter(x -> x.isAnnotationPresent(Start.class))
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    private static Class getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "."
                    + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

