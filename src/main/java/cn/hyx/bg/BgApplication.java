package cn.hyx.bg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"cn.hyx.bg.mapper"})
public class BgApplication {

	public static void main(String[] args) {
		SpringApplication.run(BgApplication.class, args);
	}

}
