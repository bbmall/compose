package pl.malinowski.cpuinfo.services;

import pl.malinowski.cpuinfo.db.entity.ProcessEntity;
import pl.malinowski.cpuinfo.dto.ProcessDto;

import java.util.List;
import java.util.Set;

public interface CpuCommand {

    List<ProcessEntity> save(Set<ProcessDto> dtoSet);
}
