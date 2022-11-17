package annotations;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestParameters {
    @Test(invocationCount = 5,invocationTimeOut = 2,expectedExceptions = {ArithmeticException.class})
    public void A(){
        System.out.println("First Test A");
        //System.out.println(10/0);
        System.out.println("Hi..");
        Assert.assertFalse(true);

    }

    @Test(dependsOnMethods = "A")
    public void B(){
        System.out.println("Second Test B");
    }

    @Test(dependsOnMethods = "A",alwaysRun = true)
    public void C(){
        System.out.println("Third Test C");
    }

    @Test(enabled = false)
    public void D(){
        System.out.println("Fourth Test D");
    }

    @Test(description="validate normal scenarios ")
    public void E(){
        System.out.println("Fifth Test E");

    }
}
