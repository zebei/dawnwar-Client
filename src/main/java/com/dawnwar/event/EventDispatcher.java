package com.dawnwar.event;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

@Component
@Slf4j
public class EventDispatcher {
	@Autowired
	private ApplicationContext ctx;
	protected final EventBus eventBus;

	public EventDispatcher() {
		this(Integer.valueOf(Runtime.getRuntime().availableProcessors() + 1));
	}

	public EventDispatcher(Integer threadCount) {
		this.eventBus = new AsyncEventBus(Executors.newFixedThreadPool(threadCount.intValue()));
	}

	@SuppressWarnings("rawtypes")
	@PostConstruct
	public void registerListeners() {
		Map listeners = ctx.getBeansOfType(EventListener.class);
		Iterator i$ = listeners.values().iterator();

		while (i$.hasNext()) {
			EventListener eventListener = (EventListener) i$.next();
			this.eventBus.register(eventListener);
		}

	}

	public void publish(BaseEvent event) {
		log.info("publish an event({})", event);
		this.eventBus.post(event);
	}
}
