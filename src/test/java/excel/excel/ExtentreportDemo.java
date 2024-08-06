package excel.excel;
import org.testng.SkipException;
import org.testng.annotations.Test;


import org.testng.Assert;

public class ExtentreportDemo {
	@Test
	public void testmethod1()
	{
		System.out.println("this is test method1 ....");
		
		Assert.assertTrue(true);
	}

	@Test
	public void testmethod2()
	{
		System.out.println("this is test method2 ....");
		
		Assert.assertTrue(false);
	}

	@Test
	public void testmethod3()
	{
		System.out.println("this is test method3 ....");
		
		Assert.assertTrue(true);
	}

	@Test
	public void testmethod4()
	{
		System.out.println("this is test method4 ....");
		
		throw new SkipException("this test method is skipped....");
	}

}
