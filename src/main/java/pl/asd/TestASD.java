package pl.asd;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestASD {

	@Autowired
	private ResourceLoader resourceLoader;

	@RequestMapping("/asd")
	public String getTest() {

		ClassLoader cl = getClass().getClassLoader();
		String outcome = "";

		Resource fileResource = resourceLoader.getResource("classpath:asd.html");
		InputStream stream = null;
		try {
			stream = fileResource.getInputStream();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		Scanner scanner = new Scanner(stream, StandardCharsets.UTF_8.name());
		outcome = scanner.useDelimiter("\\A").next();

		return outcome;
	}

}
