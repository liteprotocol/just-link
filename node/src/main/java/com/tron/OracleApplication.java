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
		// 1. start the oracle client.
		// the client should record the position that it consumes on the trongrid,
		// when restart, this client can continuely subscribe the events that higer than the position.

		// 2. start the job runner.
		// - job runner contains multiple jobs that can provide multiple exchange-pair
		// - exchange-pair can be add or remove from web and do not need restart the node(?)
		// - job runner get new events from db and send it to the corresponding job task.
		// - task query the exchange-pair through adapter and put the result into db.

		SpringApplication.run(OracleApplication.class, args);
		log.info("==================TRON oracle start success================");
	}
}
