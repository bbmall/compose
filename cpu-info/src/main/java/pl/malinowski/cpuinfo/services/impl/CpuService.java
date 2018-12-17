package pl.malinowski.cpuinfo.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.malinowski.cpuinfo.db.ProcessRepository;
import pl.malinowski.cpuinfo.db.entity.ProcessEntity;
import pl.malinowski.cpuinfo.dto.ProcessDto;
import pl.malinowski.cpuinfo.services.CpuCommand;

import java.util.List;
import java.util.Set;

@Service
class CpuService implements CpuCommand {

    private final ProcessRepository processRepository;
    private final CpuInfoMapper cpuInfoMapper;

    CpuService(final ProcessRepository processRepository) {
        this.processRepository = processRepository;
        this.cpuInfoMapper = new CpuInfoMapper();
    }

    @Override
    @Transactional
    public List<ProcessEntity> save(final Set<ProcessDto> dtoSet) {
        return processRepository.saveAll(cpuInfoMapper.mapToEntity(dtoSet));
    }
}
