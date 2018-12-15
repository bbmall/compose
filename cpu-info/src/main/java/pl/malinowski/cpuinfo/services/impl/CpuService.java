package pl.malinowski.cpuinfo.services.impl;

import org.springframework.stereotype.Service;
import pl.malinowski.cpuinfo.db.CpuInfoRepository;
import pl.malinowski.cpuinfo.dto.CpuInfoDto;
import pl.malinowski.cpuinfo.services.CpuCommand;

import java.util.Set;

@Service
class CpuService implements CpuCommand {

    private final CpuInfoRepository cpuInfoRepository;
    private final CpuInfoMapper cpuInfoMapper;

    CpuService(final CpuInfoRepository cpuInfoRepository) {
        this.cpuInfoRepository = cpuInfoRepository;
        this.cpuInfoMapper = new CpuInfoMapper();
    }

    @Override
    public void save(final Set<CpuInfoDto> dtoSet) {
        cpuInfoRepository.saveAll(cpuInfoMapper.mapToEntity(dtoSet));
    }
}
