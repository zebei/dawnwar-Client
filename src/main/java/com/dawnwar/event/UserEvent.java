package com.dawnwar.event;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class UserEvent extends BaseEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8185483712469082567L;

	List<String> ids;

	public UserEvent(String id) {
		super.id = id;
	}

	public UserEvent(List<String> ids) {
		super();
		this.ids = ids;
	}

	public UserEvent(String id, Map<String, Object> context) {
		super.id = id;
		super.context = context;
	}

}
