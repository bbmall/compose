package pl.malinowski.cpuinfo.services.impl;

import org.springframework.stereotype.Service;
import pl.malinowski.cpuinfo.dto.ProcessDto;
import pl.malinowski.cpuinfo.dto.ProcessMockFactory;
import pl.malinowski.cpuinfo.services.CpuHarvester;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
class MockCpuHarvester implements CpuHarvester {

    @Override
    public Set<ProcessDto> collectData() {
        return IntStream.range(0, 15)
            .boxed()
            .map(ProcessMockFactory::createFakeProcess)
            .collect(Collectors.toSet());
    }

}
