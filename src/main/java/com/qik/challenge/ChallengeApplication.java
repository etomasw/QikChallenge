package com.qik.challenge;

import com.qik.challenge.enums.PromotionType;
import com.qik.challenge.model.Promotion;
import com.qik.challenge.model.promotions.FlatPromotion;
import com.qik.challenge.model.promotions.GetFreePromotion;
import com.qik.challenge.model.promotions.QuantityPromotion;
import com.qik.challenge.repository.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@SpringBootApplication
public class ChallengeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ChallengeApplication.class, args);
		setupData(context);


	}



	@Qualifier("restTemplate")
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder
				.setConnectTimeout(Duration.ofMillis(10000))
				.setReadTimeout(Duration.ofMillis(10000))
				.messageConverters(new MappingJackson2HttpMessageConverter())
				.build();
	}

	private static void setupData(ConfigurableApplicationContext context) {
		PromotionBaseRepository flatPromotionRepository = context.getBean(FlatPromotionRepository.class);
		PromotionBaseRepository getFreePromotionRepository = context.getBean(GetFreePromotionRepository.class);
		PromotionBaseRepository quantityPromotionRepository = context.getBean(QuantityPromotionRepository.class);

		Promotion flatPromotion = new FlatPromotion(PromotionType.FLAT_PERCENT, 10);
		Promotion getFreePromotion = new GetFreePromotion(PromotionType.BUY_X_GET_Y_FREE, 2, 1);
		Promotion quantityPromotion = new QuantityPromotion(PromotionType.QTY_BASED_PRICE_OVERRIDE, 3, 1222);

		flatPromotionRepository.save(flatPromotion);
		getFreePromotionRepository.save(getFreePromotion);
	}

}
