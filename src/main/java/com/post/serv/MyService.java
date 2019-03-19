package com.post.serv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.post.db.TmpStorage;



@Service
public class MyService {

	@Autowired
	protected TmpStorage storage;
	
	private Logger logger = LoggerFactory.getLogger(MyService.class);
	
	public MyService() {
		
		
		
	}
	
	
	
	public String checkAutowiring() {
		
		logger.info("loggin in checkAutowiring()");
		
		
		return storage.getTestMsg();
	}
	
	
	public String checkText() {
		logger.info("loggin in checkText()");
		return checkAutowiring() + " some text goes here";
	}
	

}
