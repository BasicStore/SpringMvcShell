package com.post.db;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.post.serv.MyService;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class TestTmpStorage {
	
	@Autowired
	protected TmpStorage storage;
	
	@Test
	public void testCheckAutowiring() {
		MyService myServ = new MyService();
		assertEquals("some text goes here", myServ.checkText());
		assertTrue(storage != null);
	}

	
	
	
	
}
