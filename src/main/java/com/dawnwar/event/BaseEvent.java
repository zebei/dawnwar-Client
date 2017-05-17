package com.dawnwar.event;

import java.io.Serializable;
import java.util.Map;

import lombok.Data;

@Data
public class BaseEvent implements Serializable {

	private static final long serialVersionUID = 6950844257169553509L;
	// 事件表示，用于追踪
	protected String id;
	// 存储上下文信息
	protected Map<String, Object> context;
}