import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * SpringBootApplication:程序入口
 * ComponentScan：指明要扫描的包
 *
 * @author chenpi
 * @create 2022-04-05 10:06
 */

@SpringBootApplication
@ComponentScan("com.course.server")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
