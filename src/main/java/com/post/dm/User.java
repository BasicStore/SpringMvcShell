package com.post.dm;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User extends AbstractData {

    @NotNull
    private String username;
    
    @NotNull
    @Size(max=20)
    private String pass;
    
    private List<String> roleList;
    
    
    private String content;
    private String insult;
       
    
    public User() {
    	
    }
    
    public User(String username, @NotNull @Size(max = 20) String pass, List<String> roleList) {
		this.username = username;
		this.pass = pass;
		this.roleList = roleList;
		this.content = content;
		this.insult = insult;
	}
	
    
    public User(long id, String username, @NotNull @Size(max = 20) String pass, List<String> roleList) {
		this(username, pass, roleList);
		this.id = id;
	}
    
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

	public String getInsult() {
		return insult;
	}

	public void setInsult(String insult) {
		this.insult = insult;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public List<String> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<String> roleList) {
		this.roleList = roleList;
	}
	
	
}