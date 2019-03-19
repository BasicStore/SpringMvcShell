package com.post.serv;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.post.db.TmpStorage;


@RunWith(MockitoJUnitRunner.class)  // tells mockito to set up the automatic mocking before the tests are run 
public class MyServiceTest {
	
	@Mock  // mocks into myService
	private TmpStorage mockStorage;
	
	@InjectMocks    // class is instantaited and has all mock objects injected automatically!!!
	private MyService myService;
	
	
	@Before  // before each test
	public void before() {
		System.out.println("Before");
	}

	@After  // after each test
	public void after() {
		System.out.println("After");
	}

	@BeforeClass    // before any tests in class are run
	public static void beforeClass() {
		System.out.println("Before Class");
	}

	@AfterClass     // after any tests in class are run
	public static void afterClass() {
		System.out.println("After Class");
	}
	
	
	public MyServiceTest() {   // NOTE: these lines are unnecessary with @Mock + @InjectMocks + @RunWith annotations
		//myService = new MyService();
//		mockStorage = Mockito.mock(TmpStorage.class);
//		myService.storage = mockStorage;
	}
	
	
	
	@Test
	public void testCheckAutowiring() {
		Mockito.when(mockStorage.getTestMsg()).thenReturn("test msg goes here....");
		String expected = "test msg goes here.... some text goes here";
		String actual = myService.checkText();
		assertEquals(expected, actual);
		assertTrue(true);
	}

	
}
