package test.java;

import main.java.HelloWorld;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HelloWorldTest {
    @Test
    public void testSayHello() {
        assertEquals("Hello, Jenkins!", HelloWorld.sayHello());
    }
}
