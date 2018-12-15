package pl.malinowski.cpuinfo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.malinowski.cpuinfo.dto.CpuInfoDto;
import pl.malinowski.cpuinfo.services.CpuCommand;
import pl.malinowski.cpuinfo.services.CpuHarvester;

import java.util.Set;

@Component
class CpuInfoManager {

    private final CpuHarvester cpuHarvester;
    private final CpuCommand cpuCommand;

    CpuInfoManager(final CpuHarvester cpuHarvester, final CpuCommand cpuCommand) {
        this.cpuHarvester = cpuHarvester;
        this.cpuCommand = cpuCommand;
    }

    @Scheduled(fixedDelay = 1000)
    public void readProcInfo() {
        final Set<CpuInfoDto> cpuInfoDtos = cpuHarvester.collectData();
        cpuCommand.save(cpuInfoDtos);
    }
}
