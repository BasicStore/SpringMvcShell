package com.post;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.post.ctrl.LandingController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {

	@Autowired
    private LandingController loginController;
	
	@Autowired
    private LandingController incidentController;
	
	@Autowired
    private LandingController personController;
	
	@Autowired
    private LandingController statementController;
	

    @Test
    public void contexLoads() throws Exception {
        assertThat(loginController).isNotNull();
        assertThat(incidentController).isNotNull();
        assertThat(personController).isNotNull();
        assertThat(statementController).isNotNull();
    }
    
    
}

