package com.post.dm;

import java.util.ArrayList;
import java.util.List;

public enum MaritalStatus {

	SINGLE(1, "single"),
	MARRIED(2, "married"),
	CIVIL_PARTNERSHIP(3, "civil_p"),
	OTHER(4, "other");
	
	private final int id;
	private final String lit;
	
	
	private MaritalStatus(int id, String lit) {
		this.id = id;
		this.lit = lit;
	}
		
	public static MaritalStatus getMaritalStatus(int id) {
		for (MaritalStatus ms : MaritalStatus.values()) {
			if (ms.getId() == id) {
				return ms;
			}
		}
		
		return MaritalStatus.OTHER; 
	}

	
//	public static String getMaritalStatusStr(MaritalStatus msObj) {
//		for (MaritalStatus ms : MaritalStatus.values()) {
//			if (ms.getId() == msObj.getId()) {
//				return ms.getLit();
//			}
//		}
//		
//		return MaritalStatus.OTHER.getLit(); 
//	}
//	
//	
//	public static List<String> getMaritalStatusStrList() {
//		List<String> msList = new ArrayList<String>();
//		for (MaritalStatus ms : MaritalStatus.values()) {
//			msList.add(ms.getLit());
//		}
//		
//		return msList; 
//	}
	
	
	public int getId() {
		return id;
	}
	

	public String getLit() {
		return lit;
	}

	
}
