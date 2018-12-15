package pl.malinowski.cpuinfo.services.impl;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.malinowski.cpuinfo.dto.CpuInfoDto;
import pl.malinowski.cpuinfo.services.CpuHarvester;

import java.util.Set;

@Service
@Profile("linux")
class LinuxCpuHarvester implements CpuHarvester {

    @Override
    public Set<CpuInfoDto> collectData() {
        return null;
    }
}
