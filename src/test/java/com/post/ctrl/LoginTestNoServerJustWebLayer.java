package com.post.ctrl;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.post.serv.MyService;

// just test running the web layer, without the whole context and without the server


@RunWith(SpringRunner.class)
@WebMvcTest(LandingController.class) // this could be a different class from this class
public class LoginTestNoServerJustWebLayer {  

	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private MyService myService;

    @Test
    public void greetingShouldReturnMessageFromService() throws Exception {
        when(myService.checkAutowiring()).thenReturn("Mock something here used by the controller if need be");
        this.mockMvc.perform(get("/login")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Incident Report App")));
        
        // remember if plugging in a POST method, the full content has to be prepared or it will throw error 
        // and redirect to the wrong page 
        
    }
// 
	
}
