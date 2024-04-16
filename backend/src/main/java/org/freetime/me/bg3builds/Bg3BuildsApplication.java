package org.freetime.me.bg3builds;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// remove that annotation when batch tables are missing
@EnableBatchProcessing
@SpringBootApplication
public class Bg3BuildsApplication {

    public static void main(String[] args) {
        SpringApplication.run(Bg3BuildsApplication.class, args);
    }

}
