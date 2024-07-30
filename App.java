import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.net.URLClassLoader;



class Dexer {
  public void main() {

  }
}

class NetworkClassLoader extends ClassLoader {
  String host;
  int port;

  public Class findClass(String name) {
    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    try {
      FileInputStream fis = new FileInputStream(name);
      int data = fis.read();
      while (data != -1) {
        buffer.write(data);
        data = fis.read();
      }

      fis.close();

    } catch (Exception e) {

    }
    byte[] classData = buffer.toByteArray();
    System.out.println("asdlkaskdkjasd");
    return defineClass(classData, 0, classData.length);
  }

}

class A {
  public void B() {
    try {
      ClassLoader loader = URLClassLoader.newInstance(
        new URL[] { new File("./Dex.jar").toURI().toURL() },
        getClass().getClassLoader());
        Class<?> clazz = Class.forName("Dex", true, loader);
        Class<? extends Dexer> runClass = clazz.asSubclass(Dexer.class);
        runClass.newInstance().main();

    } catch(Exception e) {
      System.err.println("ASDASDASD");
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