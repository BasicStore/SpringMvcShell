package com.post;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.post.ctrl.LoginController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {

	@Autowired
    private LoginController loginController;
	
	@Autowired
    private LoginController incidentController;
	
	@Autowired
    private LoginController personController;
	
	@Autowired
    private LoginController statementController;
	

    @Test
    public void contexLoads() throws Exception {
        assertThat(loginController).isNotNull();
        assertThat(incidentController).isNotNull();
        assertThat(personController).isNotNull();
        assertThat(statementController).isNotNull();
    }
    
    
}

