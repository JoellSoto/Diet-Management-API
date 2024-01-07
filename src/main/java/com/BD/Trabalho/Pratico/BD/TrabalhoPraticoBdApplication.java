package com.BD.Trabalho.Pratico.BD;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrabalhoPraticoBdApplication {

	public static void main(String[] args) {
		TimeZone tz=TimeZone.getTimeZone("GMT");
		TimeZone.setDefault(tz);
		SpringApplication.run(TrabalhoPraticoBdApplication.class, args);
	}

}
