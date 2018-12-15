package pl.malinowski.cpuinfo.services;


import pl.malinowski.cpuinfo.dto.CpuInfoDto;

import java.util.Set;

public interface CpuCommand {
    void save(Set<CpuInfoDto> dtoSet);
}
