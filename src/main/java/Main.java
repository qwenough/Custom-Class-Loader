import loaders.CustomLoaderExample;

import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        String absoluteClassPath = new File("src/classes").getAbsolutePath();
        System.out.println("Loading classes from: " + absoluteClassPath);

        CustomLoaderExample loader = new CustomLoaderExample(absoluteClassPath);

        Class<?> loadedClass = loader.loadClass("external_classes.Hello");

        Object instance = loadedClass.getDeclaredConstructor().newInstance();
        loadedClass.getMethod("print").invoke(instance);
    }
}