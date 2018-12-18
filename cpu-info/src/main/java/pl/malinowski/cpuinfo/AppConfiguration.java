package pl.malinowski.cpuinfo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Configuration
class AppConfiguration {

    @Bean(destroyMethod = "shutdown", name = "cpuScheduleExecutor")
    ScheduledExecutorService scheduledExecutorService() {
        return Executors.newScheduledThreadPool(1);
    }
}
