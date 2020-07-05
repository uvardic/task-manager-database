package taskmanager.database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class TaskManagerDatabaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskManagerDatabaseApplication.class, args);
    }

}
