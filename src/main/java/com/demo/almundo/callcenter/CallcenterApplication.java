package com.demo.almundo.callcenter;

import com.demo.almundo.callcenter.messaging.consumer.events.impl.DispatchCallEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * The main of callcenter project
 *
 * @author Miguel Angel Suevis Pacheco (miguelangelsuevis@gmail.com)
 * @since 1.0
 */
@SpringBootApplication
public class CallcenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CallcenterApplication.class, args);
	}
}
