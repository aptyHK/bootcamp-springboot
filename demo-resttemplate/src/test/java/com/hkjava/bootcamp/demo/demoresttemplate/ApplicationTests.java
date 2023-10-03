package com.hkjava.bootcamp.demo.demoresttemplate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// Hamcrest -> Matchers
// Junit5 -> jupiter -> @Mock, @InjectMock, Mokito (when)
// Spring Test Framework -> @WebMockMvc
// What is @SpringBootTest?

// I am goiing to test ther server start process, with dependency checking
@SpringBootTest
// mvn test -> Simulate App server Start & Bean Injection on Context
// mvn clean test would test start server (error find caused by) (no need to type springboot run)
class ApplicationTests {

	@Test
	void contextLoads() {
	}

}
