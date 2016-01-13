package mmi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

/**
 * Created by Robert on 1/5/2016.
 */
@SpringBootApplication
public class Main extends SpringBootServletInitializer
{
    public static void main(String[] args)
    {
        ApplicationContext context = SpringApplication.run(Main.class, args);
    }

}
