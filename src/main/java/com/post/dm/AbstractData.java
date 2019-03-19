package com.post.dm;

public abstract class AbstractData {

	protected long id;
	
	protected AbstractData() {
	}
	
	protected AbstractData(long id) {
		this.id = id;
	}	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
