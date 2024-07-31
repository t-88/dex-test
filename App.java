import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;



class Dexer {
  public void main() {

  }
}

class A {
  public void B() {
    try {
      ClassLoader loader = URLClassLoader.newInstance(
        // new URL[] { new File("./Dex.jar").toURI().toURL() },
        new URL[] { new URL("https://github.com/t-88/dex-test/raw/master/Dex.class") },
        getClass().getClassLoader());

        String a[] = {};
        Class<?> clazz = Class.forName("Dex", true, loader);
        Method m = clazz.getMethod("main",  new Class[] { a.getClass()  });
        m.setAccessible(true);
        m.invoke(null, new Object[] { a });
        // Class<? extends Dexer> runClass = clazz.asSubclass(Dexer.class);
        // runClass.newInstance().main();

    } catch(Exception e) {
      System.out.println("ASDASDASD");
      System.out.println(e.getMessage());
    }
  }
}

public class App extends ClassLoader {

  public static void main(String[] args) {
    A a = new A();
    a.B();
    // NetworkClassLoader loader = new NetworkClassLoader();
    // Object obj = loader.findClass("Dex.class");
    // ((Dexer) obj).main() ;

  }
}