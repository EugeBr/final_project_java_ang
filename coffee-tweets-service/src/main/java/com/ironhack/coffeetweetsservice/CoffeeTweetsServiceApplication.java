package com.ironhack.coffeetweetsservice;

import com.ironhack.coffeetweetsservice.model.Tweet;
import com.ironhack.coffeetweetsservice.repository.TweetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CoffeeTweetsServiceApplication {

	@Bean
	public WebMvcConfigurer corsConfigurer(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry){
				registry.addMapping("/**").allowedMethods("*").allowedOrigins("*");
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(CoffeeTweetsServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner run(TweetRepository tweetRepository) {
		return args -> {

			tweetRepository.save(new Tweet(null, "https://res.cloudinary.com/drrxks8d9/image/upload/v1686128712/Tweets/7_t7b1c6.png"));
			tweetRepository.save(new Tweet(null, "https://res.cloudinary.com/drrxks8d9/image/upload/v1686128712/Tweets/6_yushj2.png"));
			tweetRepository.save(new Tweet(null, "https://res.cloudinary.com/drrxks8d9/image/upload/v1686128711/Tweets/10_utrasc.png"));
			tweetRepository.save(new Tweet(null, "https://res.cloudinary.com/drrxks8d9/image/upload/v1686128711/Tweets/8_t2clzh.png"));
			tweetRepository.save(new Tweet(null, "https://res.cloudinary.com/drrxks8d9/image/upload/v1686128711/Tweets/11_hdgyun.png"));
			tweetRepository.save(new Tweet(null, "https://res.cloudinary.com/drrxks8d9/image/upload/v1686128711/Tweets/9_rxh15i.png"));
			tweetRepository.save(new Tweet(null, "https://res.cloudinary.com/drrxks8d9/image/upload/v1686128711/Tweets/5_n7zolr.png"));
			tweetRepository.save(new Tweet(null, "https://res.cloudinary.com/drrxks8d9/image/upload/v1686128711/Tweets/1_tcm1tk.png"));
			tweetRepository.save(new Tweet(null, "https://res.cloudinary.com/drrxks8d9/image/upload/v1686128711/Tweets/4_eqskmn.png"));
			tweetRepository.save(new Tweet(null, "https://res.cloudinary.com/drrxks8d9/image/upload/v1686128711/Tweets/13_k5j4eb.png"));
			tweetRepository.save(new Tweet(null, "https://res.cloudinary.com/drrxks8d9/image/upload/v1686128710/Tweets/14_ljyzjh.png"));
			tweetRepository.save(new Tweet(null, "https://res.cloudinary.com/drrxks8d9/image/upload/v1686128710/Tweets/3_u2rv6f.png"));
			tweetRepository.save(new Tweet(null, "https://res.cloudinary.com/drrxks8d9/image/upload/v1686128710/Tweets/12_qq3b6x.png"));
			tweetRepository.save(new Tweet(null, "https://res.cloudinary.com/drrxks8d9/image/upload/v1686128710/Tweets/2_ciznoh.png"));

		};
	}
}
