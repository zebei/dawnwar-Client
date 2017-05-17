package com.dawnwar.event;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

import com.google.common.eventbus.Subscribe;

@Slf4j
@Component
public class UserEventListener implements EventListener {

	@Subscribe
	public void userCreateEvent(UserEvent userEvent) {

		log.info("User create event, id:{}", userEvent.id);

	}

}
