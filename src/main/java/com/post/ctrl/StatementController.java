package com.post.ctrl;
import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.post.dm.Incident;
import com.post.dm.ActionType;
import com.post.dm.Person;
import com.post.dm.Severity;
import com.post.dm.Statement;


@Controller
@RequestMapping("/entry")
public class StatementController {
	
	private Logger logger = LoggerFactory.getLogger(StatementController.class);
	
	@PostMapping("/statement")
    public ModelAndView greetingSubmit(HttpSession session, ModelAndView mv, ModelMap map, @Valid @ModelAttribute Statement statement, BindingResult errors) {
    	
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    	// SESSION experiment [start]
		Incident incidentX = (Incident)session.getAttribute("mockInc");
    	logger.info("Session incident test val in the statement controller: \n"
    			+ "Firstname = " + incidentX.getReporter().getFirstName() 
    			+ "  Last name = " + incidentX.getReporter().getLastName()
    			+ "  Address = " + incidentX.getReporter().getAddress());
    	// SESSION experiment [end]
    	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
    	System.out.println("Statement holder's firstname = " + statement.getAuthor().getFirstName());
    	System.out.println("comments = " + statement.getComments());
    	System.out.println(errors.getErrorCount() + "ERRORS ON one of the statement FORMs!");
    	System.out.println("summary = " + statement.getSummary());
    	
    	if (errors.hasErrors()) {
    		return new ModelAndView("statement");
    	}
    	
    	mv.setViewName("submitted");
    	
    	
    	//map.addAttribute("incTypeList", IncidentType.ROBBERY);
    	
    	
    	
    	
    	Incident incident = new Incident();
    	Person reporter = new Person();
    	reporter.setFirstName("reporter firstname");
    	reporter.setLastName("reporter lastname");
    	incident.setReporter(reporter);
    	// TODO why can enums not be initiated here??? 
    	incident.setType(ActionType.TYPE2);
    	incident.setSeverity(Severity.SUPERSERIOUS);
    	
    	incident.setStartDate(LocalDateTime.of(2017, 2, 13, 15, 56));
    	incident.setEndDate(LocalDateTime.of(2017, 2, 13, 16, 56));
    	incident.setDateSubmitted(LocalDateTime.now());
    	mv.addObject("incident", incident);
    	return mv;
    }


}
