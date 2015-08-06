package metrics.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	private Logger log = LoggerFactory.getLogger(TestController.class);

	public TestController() {
		log.info("=============================");
	}

	@RequestMapping("/test")
	public String test() {
		log.info("=============TEST================");
		return "Hello World123";
	}

}
