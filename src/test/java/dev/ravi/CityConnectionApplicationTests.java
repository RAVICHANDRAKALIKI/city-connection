package dev.ravi;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.env.Environment;
import java.net.InetAddress;
import java.net.UnknownHostException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
class CityConnectionApplicationTests {

	@Autowired
	private Connection connection;

	@Autowired
	Environment environment;

	@Autowired
	TestRestTemplate restTemplate;

	@Test
	@DisplayName("Load Spring Context")
	@Order(1)
	void contextLoads() {
		assertThat(connection).isNotNull();
	}

	@Test
	@Order(2)
	@DisplayName("Verify Rest End Point is open")
	void testEndPoint() throws UnknownHostException {
		assertThat(restTemplate.getForObject(restTemplate.getRootUri()
				+ "/connected?origin=city1&destination=city2",
				String.class)).isEqualTo("yes");
	}

}
