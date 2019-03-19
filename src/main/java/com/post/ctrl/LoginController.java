package com.post.ctrl;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.post.dm.Incident;
import com.post.dm.MaritalStatus;
import com.post.dm.Person;
import com.post.dm.User;
import com.post.serv.MyService;


@Controller
public class LoginController {

	@Autowired
	private MyService myService;
	
	private Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	public void checkAutowiring() {
		System.out.println("CHECKING AUTOWIRING for services and dao:  " + myService.checkAutowiring());
	}
	
	
	// TODO  effectively the welcome page, 
	@GetMapping("/")
	public String welcomeToApp(HttpServletRequest request, Model model) {
		return greetingForm(request, model);
	}
    
	
	@GetMapping("/login")
    public String greetingForm(HttpServletRequest request, Model model) {
		String currLocation = System.getProperty("user.dir");    	
		logger.info("LOGGING FROM TOMCAT WITH SLF - and currentl location is ==> " + currLocation);
		
		
		logger.info("in the get request for login");
    	checkAutowiring();
    	model.addAttribute("user", new User());
    	
    	// Session tests [start] ------------------------------------
    	//ShoppingCart cart = (ShoppingCart)request.getSession().setAttribute("cart",value);
    	Incident mockInc = new Incident();
    	mockInc.setReporter(new Person("authFirstName", "auth2ndName", "authAddress"));
    	mockInc.setId(104);
    	
    	
    	request.getSession().setAttribute("mockInc", mockInc);
    	// Session tests [end] ------------------------------------    	
    	
    	
    	
    	// testing accessing a configuration file which can be done from any java class
    	ResourceBundle rb = ResourceBundle.getBundle("config.sysprops");
    	String value = rb.getString("database.name");
    	logger.info("TEST CONFIG PROP VALUE HERE:  " + value);
    	
        return "login";
    }


    
    @PostMapping("/login")
    public ModelAndView greetingSubmit(HttpServletRequest request, ModelMap model, @Valid @ModelAttribute User login, BindingResult errors) {

    	
    	System.out.println("IN THE POST MAPPING");
    	
    	// TODO:  not great, but use this whilst @NotNull is not working
    	if (errors.hasErrors() || pageHasBlankMandatoryFields(login)) {
    		System.out.println("ERRORS ON LOGIN FORM!!!!!!!");
    		return new ModelAndView("login");
    	}    	
    	
    	//model.addAttribute("mStatusList", MaritalStatus.getMaritalStatusStrList());
    	model.addAttribute("mStatusList", MaritalStatus.values());
    	
    	Person author = getPersonFromDb(login);
    	ModelAndView mv = new ModelAndView("person");
    	mv.addObject("person", author);
    	return mv;
    }

    

  private static boolean pageHasBlankMandatoryFields(User login) {
	  return login.getUsername().isEmpty() || login.getPass().isEmpty() ? true : false; 
  }
   
  
  private Person getPersonFromDb(User login) {
	  String userName = login.getUsername();
  	  String userPass = login.getPass();
  	  System.out.println("TODO  Get person object from storage: user/pass = " + userName + "/" + userPass);
  	  
	  Person p = new Person();
	  p.setFirstName("[UserPlaceholder]  username");
  	  p.setLastName("[UserPlaceholder] pass");
  	  
  	  LocalDate dateOfBirth = LocalDate.of(1950, 4, 14);
  	  p.setDateOfBirth(dateOfBirth);
  	  
  	  
  	  return p;
  }
}