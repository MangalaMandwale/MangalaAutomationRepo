package itlisteners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ITListenersExample.class)
public class DemoListener extends ITListenersExample {
    @Test
    public void m1(){
        System.out.println("m1 method");
    }

    @Test
    public void m2(){
        System.out.println("m2 method");
        Assert.assertTrue(false);
    }

    @Test
    public void m3(){
        System.out.println("m3 method");
    }


}
