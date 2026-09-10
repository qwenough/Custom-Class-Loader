package loaders;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CustomLoaderExample extends ClassLoader {
    private final String classPath;

    public CustomLoaderExample(String classPath) {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        try {
            String path = className.replace('.', File.separatorChar) + ".class";
            File classFile = new File(classPath, path);

            if (!classFile.exists()) {
                throw new ClassNotFoundException("Class file not found: " + classFile.getAbsolutePath());
            }

            byte[] byteArray;
            try (FileInputStream fis = new FileInputStream(classFile)) {
                byteArray = fis.readAllBytes();
            }

            return defineClass(className, byteArray, 0, byteArray.length);
        } catch (IOException e) {
            throw new ClassNotFoundException("Class not found: " + className, e);
        }
    }
}