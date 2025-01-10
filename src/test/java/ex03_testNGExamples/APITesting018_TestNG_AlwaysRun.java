package ex03_testNGExamples;


import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting018_TestNG_AlwaysRun {
    @Test(enabled = false)
    public void test01() {
        Assert.assertTrue(true);
    }

    @Test(alwaysRun = true)
    public void test02() {
        Assert.assertTrue(false);
    }

    @Test
    public void test03() {
        Assert.assertTrue(true);
    }
}
