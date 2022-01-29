package cool.tdl.seckill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@MapperScan("cool.tdl.seckill.mapper")

public class SeckillApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeckillApplication.class, args);
    }
}
