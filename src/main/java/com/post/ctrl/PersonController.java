package com.post.ctrl;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.post.dm.Incident;
import com.post.dm.ActionType;
import com.post.dm.Person;
import com.post.dm.Severity;
import com.post.dm.Statement;
import com.post.serv.MyService;


@Controller
public class PersonController {
   
	private Logger logger = LoggerFactory.getLogger(PersonController.class);	
	
	
    @PostMapping("/person")
    public ModelAndView greetingSubmit(HttpSession session, ModelAndView mv, ModelMap model, @Valid @ModelAttribute Person person, BindingResult errors) {
    	
    	logger.info("should be in the personal post method **********************************************8");
    	
    	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    	// SESSION experiment [start]
    	Incident incidentX = (Incident)session.getAttribute("mockInc");
    	logger.info("Session incident test val: \n"
    			+ "Firstname = " + incidentX.getReporter().getFirstName() 
    			+ "  Last name = " + incidentX.getReporter().getLastName()
    			+ "  Address = " + incidentX.getReporter().getAddress());
    	// SESSION experiment [end]
    	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    	
    	System.out.println("name = " + person.getFirstName() + " " + person.getLastName());
    	System.out.println("address = " + person.getAddress());
    	System.out.println("dob = " + person.getDateOfBirth());
    	System.out.println("marital status = " + person.getMaritalStatus().getLit() + " WORKING");
    	System.out.println("occupation = " + person.getOccupation());    
    	
    	if (errors.hasErrors()) {
    		System.out.println(errors.getErrorCount() + "ERRORS ON personal details FORM!");
    		
    		model.addAttribute("status", "error status blar blar");
    		model.addAttribute("error", "???? some error message");
    		
    		return new ModelAndView("error");
    	}
    	
    	System.out.println("No errors on the personal form, so go to the incident form");
    	
    	mv.setViewName("incident");
    	Incident incident = new Incident();
    	
    	Person reporter = new Person();
    	reporter.setFirstName("reporter firstname");
    	reporter.setLastName("reporter lastname");
    	incident.setReporter(reporter);
    	   	
    	// LocalDate dateOfBirth = LocalDate.of(1950, 4, 14);
    	incident.setStartDate(LocalDateTime.of(2017, 2, 13, 15, 56));
    	incident.setEndDate(LocalDateTime.of(2017, 2, 13, 16, 56));
    	
    	Person p2 = new Person();
    	p2.setFirstName("Statement Author 1");
    	
    	// TODO XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXx
    	List<Statement> statementList = new ArrayList<Statement>();
    	Statement statement1 = new Statement(1, p2, "full comments description here", "summary details here");
    	statement1.setAuthor(p2);
    	statementList.add(statement1);
    	// TODO better practice ==> incident.setStatementList(statementList);
    	
    	model.addAttribute("severityList", Severity.values());
    	model.addAttribute("incTypeList", ActionType.values());
    	
    	// NOT GREAT TO UND THIS WAY........
    	model.addAttribute("statementList", statementList);
    	
    	
    	
    	mv.addObject("incident", incident);
    	Person p = new Person();
    	p.setFirstName(person.getFirstName());
    	p.setLastName(person.getLastName());
    	mv.addObject("person", p);
    	return mv;
    }
	
	
}
