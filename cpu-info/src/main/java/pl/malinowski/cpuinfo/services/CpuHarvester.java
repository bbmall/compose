package pl.malinowski.cpuinfo.services;

import pl.malinowski.cpuinfo.dto.ProcessDto;

import java.util.Set;

public interface CpuHarvester {

    Set<ProcessDto> collectData();
}
