package com.post.dm;

public enum Severity {
	
	SUPERSERIOUS(1, "superserious"),
	MAJORPLUS(2, "majorplus"),
	MAJOR(3, "major"),
	MINOR(4, "minor"),
	TRIVIAL(5, "trivial"),
	NOT_KNOWN(6, "not known");
	
	private final int id;
	
	private final String lit;
	
	private Severity(int id, String lit) {
		this.id = id;
		this.lit = lit;
	}
	
	public Severity getSeverity(int id) {
		for (Severity sev : Severity.values()) {
			if (sev.getId() == id) {
				return sev;
			}
		}
		
		return Severity.NOT_KNOWN; 
	}

	public int getId() {
		return id;
	}

	public String getLit() {
		return lit;
	}
	
	
}
