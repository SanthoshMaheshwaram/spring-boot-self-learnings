package org.jangaon.familyfriendsservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FamilyFriendsServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}

/*
The above code implements two annotation by default: @SpringBootTest, and @Test.

@SpringBootTest: It applies on a Test Class that runs Spring Boot based tests. It provides the following features over and above the regular Spring TestContext Framework:
It uses SpringBootContextLoader as the default ContextLoader if no specific @ContextConfiguration(loader=...) is defined.
It automatically searches for a @SpringBootConfiguration when nested @Configuartion is not used, and no explicit classes are specified.
It provides support for different WebEnvironment modes.
It registers a TestRestTemplate or WebTestClient bean for use in web tests that are using the webserver.
It allows application arguments to be defined using the args attribute.

 */