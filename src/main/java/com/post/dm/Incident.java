package com.post.dm;

import java.time.LocalDateTime;
import java.util.List;

public class Incident extends AbstractData {
	
	private Person reporter;
	private ActionType type = ActionType.TYPE1;
	private Severity severity = Severity.NOT_KNOWN;
	private LocalDateTime startDate; 
	private LocalDateTime endDate; 
	private String periodInQuestion;  
	private List<Statement> statementList;
	private LocalDateTime dateSubmitted;
	
	public Incident() {
		
	}
	
	
	public Incident(Person reporter, ActionType type, Severity severity, LocalDateTime startDate, LocalDateTime endDate,
			String periodInQuestion, LocalDateTime dateSubmitted, List<Statement> statementList) {
		this.reporter = reporter;
		this.type = type;
		this.severity = severity;
		this.startDate = startDate;
		this.endDate = endDate;
		this.periodInQuestion = periodInQuestion;
		this.statementList = statementList;
		this.dateSubmitted = dateSubmitted;
	}

	
	public Incident(long id, Person reporter, ActionType type, Severity severity, LocalDateTime startDate, LocalDateTime endDate,
			String periodInQuestion, LocalDateTime dateSubmitted, List<Statement> statementList, LocalDateTime submissionDate) {
		this(reporter, type, severity, startDate, endDate, periodInQuestion, dateSubmitted, statementList);
		this.id = id;
	}
	
	
	public ActionType getType() {
		return type;
	}


	public void setType(ActionType type) {
		this.type = type;
	}


	public Severity getSeverity() {
		return severity;
	}


	public void setSeverity(Severity severity) {
		this.severity = severity;
	}

	public String getPeriodInQuestion() {
		return periodInQuestion;
	}
	
	public void setPeriodInQuestion(String periodInQuestion) {
		this.periodInQuestion = periodInQuestion;
	}
	
	public Person getReporter() {
		return reporter;
	}

	public void setReporter(Person reporter) {
		this.reporter = reporter;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public List<Statement> getStatementList() {
		return statementList;
	}

	public void setStatementList(List<Statement> statementList) {
		this.statementList = statementList;
	}

	public LocalDateTime getDateSubmitted() {
		return dateSubmitted;
	}

	public void setDateSubmitted(LocalDateTime dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}
	
}
