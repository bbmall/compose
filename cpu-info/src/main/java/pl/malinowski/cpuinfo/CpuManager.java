package pl.malinowski.cpuinfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.malinowski.cpuinfo.dto.ProcessDto;
import pl.malinowski.cpuinfo.services.CpuCommand;
import pl.malinowski.cpuinfo.services.CpuHarvester;

import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
class CpuManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(CpuManager.class);

    private final CpuHarvester cpuHarvester;
    private final CpuCommand cpuCommand;

    CpuManager(final CpuHarvester cpuHarvester, final CpuCommand cpuCommand,
               @Qualifier("cpuScheduleExecutor") final ScheduledExecutorService scheduledExecutorService,
               @Value("${manager.scheduleSeconds}") final Long delaySec) {
        this.cpuHarvester = cpuHarvester;
        this.cpuCommand = cpuCommand;

        scheduledExecutorService.scheduleAtFixedRate(this::readProcInfo, 0, delaySec, TimeUnit.SECONDS);
    }

    private void readProcInfo() {
        LOGGER.info("Executing scheduled process");
        final Set<ProcessDto> processDtos = cpuHarvester.collectData();
        cpuCommand.save(processDtos);
    }

}
