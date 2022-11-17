package annotations;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ParametersOfTestAnnotations {
    @Test(groups={"smoke","P1"})
    public void A(){
        System.out.println("Method A");
        //Assert.assertFalse(true);

    }
    @Test(groups = {"P0"})
    public void C(){
        System.out.println("Method C");
    }

    @Test(dependsOnGroups = {"P0","P1"})
    public void D(){
        System.out.println("Method D");
    }

    @Test(dependsOnMethods = {"A","C"})
    public void B()
    {
        System.out.println("Method B");
    }
}
