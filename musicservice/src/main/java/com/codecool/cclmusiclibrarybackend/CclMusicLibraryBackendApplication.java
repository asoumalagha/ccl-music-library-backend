package com.codecool.cclmusiclibrarybackend;

import com.codecool.cclmusiclibrarybackend.model.Song;
import com.codecool.cclmusiclibrarybackend.service.SongHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class CclMusicLibraryBackendApplication {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private SongHandler songHandler;

    private static final Logger LOGGER = LoggerFactory.getLogger(CclMusicLibraryBackendApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CclMusicLibraryBackendApplication.class, args);
    }

    @PostConstruct
    public void afterInit() {
        songHandler.addSong("example", "example", "example", 6);
        try {
            Song song = songHandler.getSong("example", "example", "example", 6);
            LOGGER.info(song.toString());
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
    };

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/musiclibrary/**"))
                .build();
    }
}
