package pl.malinowski.cpuinfo.services;


import pl.malinowski.cpuinfo.dto.CpuInfoDto;

import java.util.Set;

public interface CpuHarvester {
    Set<CpuInfoDto> collectData();
}
