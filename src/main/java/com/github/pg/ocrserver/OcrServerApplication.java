package com.github.pg.ocrserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class OcrServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OcrServerApplication.class, args);
	}

}
