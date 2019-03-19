package com.post.dm;

public enum ActionType {
	
	TYPE1(1, "type1"),
	TYPE2(2, "type2"),
	TYPE3(3, "type3"),
	TYPE4(4, "type4"),
	TYPE5(5, "type5"),
	TYPE6(6, "type6");
	
	private final int id;
	
	private final String lit;
	
	private ActionType(int id, String lit) {
		this.id = id;
		this.lit = lit;
	}
	
	public ActionType getActionType(int incType) {
		for (ActionType it : ActionType.values()) {
			if (it.getId() == incType) {
				return it;
			}
		}
		
		return ActionType.TYPE1; 
	}

	public int getId() {
		return id;
	}

	public String getLit() {
		return lit;
	}
	
}
