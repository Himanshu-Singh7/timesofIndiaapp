package net.timesofindia.timesofIndiaApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TimesofIndiaApplication {
	public static void main(String[] args) {
		SpringApplication.run(TimesofIndiaApplication.class, args);
	}

}
