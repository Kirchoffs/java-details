package org.syh.classloader;

import javax.servlet.Servlet;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

public class URLClassLoaderTest {
    public static void main(String[] args) {
        loadByJar();
        loadServlet();
        loadCustomizedList();
    }

    public static void loadByJar() {
        System.out.println("Load By Jar");
        String prjDirectory = System.getProperty("user.dir");
        String libDirectory = prjDirectory + "/src/main/lib";
        String jarDirectory = libDirectory + "/app.jar";

        try {
            URL url = new URL("file:" + jarDirectory);
            URLClassLoader ucl = new URLClassLoader(new URL[]{ url });
            Class cls = ucl.loadClass("org.syh.learning.App");
            System.out.println(cls.getName());

            org.syh.learning.App app = (org.syh.learning.App) cls.getDeclaredConstructor().newInstance();
            app.say();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        System.out.println("--------");
    }

    public static void loadServlet() {
        System.out.println("Load Servlet");
        String prjDirectory = System.getProperty("user.dir");
        String libDirectory = prjDirectory + "/src/main/lib/";

        try {
            URL url = new URL("file:" + libDirectory);
            URLClassLoader ucl = new URLClassLoader(new URL[]{ url });
            Class cls = ucl.loadClass("PrimitiveServlet");
            System.out.println(cls.getName());

            Servlet servlet = (Servlet) cls.getDeclaredConstructor().newInstance();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        System.out.println("--------");
    }

    private static void loadCustomizedList() {
        System.out.println("Load Customized List");
        String prjDirectory = System.getProperty("user.dir");
        String libDirectory = prjDirectory + "/src/main/lib/";
        try {
            URL url = new URL("file:" + libDirectory);
            URLClassLoader ucl = new URLClassLoader(new URL[]{ url });
            Class cls = ucl.loadClass("CustomizedList");
            List list = (List) cls.getDeclaredConstructor().newInstance();
            System.out.println(list);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        System.out.println("--------");
    }
}
