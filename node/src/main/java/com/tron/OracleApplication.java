package com.tron;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@MapperScan("com.tron.web.mapper")
public class OracleApplication {

	public static void main(String[] args) {
		SpringApplication.run(OracleApplication.class, args);
		log.info("==================TRON oracle start success================");
	}
}
