package com.post.ctrl;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.post.dm.Incident;
import com.post.dm.Person;
import com.post.dm.Statement;

@Controller
@RequestMapping("/entry")
public class IncidentController {
    
	
	@GetMapping("/incident")
    public String greetingForm(Model model) {
    	System.out.println("in the get request for incident");
    	model.addAttribute("incident", new Incident());
    	
    	Person p = new Person();
    	p.setFirstName("[PLACEHOLDER] 1st name");
    	p.setLastName("[PLACEHOLDER] last name");
    	model.addAttribute("person", p);
    	
        return "incident";
    }
	
	
	
    @PostMapping("/incident")
    public ModelAndView greetingSubmit(ModelAndView mv, ModelMap map, @Valid @ModelAttribute Incident incident, BindingResult errors) {
    	
    	
    	map.addAttribute("testModelMap", "model map property");
    	
    	System.out.println("person post method");
    	
    	System.out.println("severity = " + incident.getSeverity().getLit());
    	
    	
    	
//    	// 3) read the statement list
//    	List<Statement> statementList = incident.getStatementList();
//    	if (statementList != null && statementList.size() > 0) {
//    		System.out.println("statement 1 author/comments/summary = " 
//    		          + statementList.get(0).getAuthor() + statementList.get(0).getComments() + statementList.get(0).getSummary());
//    	} else { // TODO do in java 8
//    		System.out.println("No statements to display yet");
//    	}
    	
    	System.out.println("incident type = " + incident.getType().getLit());
    	System.out.println("incident start = " + incident.getStartDate());
    	System.out.println("incident end = " + incident.getEndDate());
    	System.out.println(errors.getErrorCount() + "ERRORS ON incident FORM!");
    	if (errors.hasErrors()) {
    		return new ModelAndView("incident");
    	}
    	
    	mv.setViewName("statement");
    	Statement statement = new Statement();
    	
    	// TODO !!!!! create a new person as author (will be selected or created by the user in the application)
    	Person author = new Person();
    	author.setFirstName("statement maker's first name");
    	author.setLastName("statement maker's last name");
    	statement.setAuthor(author);
    	
    	mv.addObject("statement", statement);
    	return mv;
        // move this on to statement page
    }
	
	
}
