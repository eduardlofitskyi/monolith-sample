package com.lofitskyi;

import com.lofitskyi.entity.Currency;
import com.lofitskyi.entity.User;
import com.lofitskyi.repository.CurrencyRepository;
import com.lofitskyi.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

@SpringBootApplication
public class MonolithSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonolithSampleApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserRepository userRepository, CurrencyRepository currencyRepository){
		return string -> {
			java.util.stream.Stream.of(
					new User(1L, "Alex",	asList(BigDecimal.valueOf(105), BigDecimal.TEN)),
					new User(2L, "Den",		asList(BigDecimal.TEN)),
					new User(3L, "Serge",	emptyList()))
				.forEach(userRepository::save);

			java.util.stream.Stream.of(new Currency(1L, "Dollar", BigDecimal.valueOf(1)), new Currency(2L, "Yena", BigDecimal.valueOf(3.4)))
				.forEach(currencyRepository::save);
		};
	}
}
