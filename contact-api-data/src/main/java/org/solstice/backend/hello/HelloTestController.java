package org.solstice.backend.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloTestController {

	@RequestMapping("/hello")
	public String sayHello()
	{
		return "Hello! API App!";
	}
}
