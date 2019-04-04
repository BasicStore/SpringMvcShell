package com.post.db;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.post.serv.MyService;


@RunWith(MockitoJUnitRunner.class)
public class TestTmpStorage {
	
	@Autowired
	protected TmpStorage storage;
	
	@Test
	public void testCheckAutowiring2() {

	}
		
	
	@Test
	public void testCheckAutowiring() {
		MyService myServ = new MyService();
		assertEquals("some text goes here", myServ.checkText());
		//assertTrue(storage != null);
	}

	
	
	// test how to expect exception
	@Test(expected = MyException.class)
	public void givenNull_whenThrowsErrorOnCreate_thenCorrect() {
	    try
	    {
	    	throwException();
	    	fail("MyException was not thrown!!!!");
	    }
	    catch(MyException re)
	    {
	       String message = "Employee ID is null";
	       assertEquals(message, re.getMessage());
	       System.out.println("My exception was caught");
	    }
	}

	
	
	private void throwException() throws MyException {
		throw new MyException("My excpetion msg goes here");
	}
	
	
	
	private class MyException extends Exception {
		public MyException(String msg) {
			super(msg);
		}
	}
	
	
	
	
	
}
