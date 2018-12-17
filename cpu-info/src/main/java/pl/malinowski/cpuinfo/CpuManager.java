package pl.malinowski.cpuinfo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.malinowski.cpuinfo.dto.ProcessDto;
import pl.malinowski.cpuinfo.services.CpuCommand;
import pl.malinowski.cpuinfo.services.CpuHarvester;

import java.util.Set;

@Component
class CpuManager {

    private final CpuHarvester cpuHarvester;
    private final CpuCommand cpuCommand;

    CpuManager(final CpuHarvester cpuHarvester, final CpuCommand cpuCommand) {
        this.cpuHarvester = cpuHarvester;
        this.cpuCommand = cpuCommand;
    }

    @Scheduled(fixedDelay = 1000)
    public void readProcInfo() {
        final Set<ProcessDto> processDtos = cpuHarvester.collectData();
        cpuCommand.save(processDtos);
    }
}
