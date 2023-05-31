package spring.spring;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
public class Project1ToSpringApplication {
    public static void main(String[] args) {
//		QuanLyHoSo test = new QuanLyHoSo();
        SpringApplication.run(Project1ToSpringApplication.class, args);
        log.info("Hello World!");
    }

}
