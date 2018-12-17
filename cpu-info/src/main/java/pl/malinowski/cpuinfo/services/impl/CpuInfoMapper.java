package pl.malinowski.cpuinfo.services.impl;

import pl.malinowski.cpuinfo.db.entity.ProcessEntity;
import pl.malinowski.cpuinfo.dto.ProcessDto;

import java.util.Set;
import java.util.stream.Collectors;

class CpuInfoMapper {

    Set<ProcessEntity> mapToEntity(final Set<ProcessDto> dtoSet) {
        return dtoSet.stream()
            .map(this::getEntity)
            .collect(Collectors.toSet());
    }

    private ProcessEntity getEntity(final ProcessDto processDto) {
        return ProcessEntity.builder()
            .name(processDto.getName())
            .cpu(processDto.getCpu())
            .memory(processDto.getMemory())
            .created(processDto.getCreated())
            .build();
    }
}
