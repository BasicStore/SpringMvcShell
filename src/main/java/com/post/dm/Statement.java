package com.post.dm;

public class Statement extends AbstractData {
	
	private Person author;
	
	private String comments;
	
	private String summary;
	
	
	public Statement() {
		
	}
	
	public Statement(Person author, String comments, String summary) {
		this.author = author;
		this.comments = comments;
		this.summary = summary;
	}
	
	public Statement(long id, Person author, String comments, String summary) {
		this(author, comments, summary);
		this.id = id;
	}
	
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Person getAuthor() {
		return author;
	}

	public void setAuthor(Person author) {
		this.author = author;
	}
	
}
