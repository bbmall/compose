package pl.malinowski.cpuinfo.services.impl;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import pl.malinowski.cpuinfo.UnitTests;
import pl.malinowski.cpuinfo.dto.ProcessDto;
import pl.malinowski.cpuinfo.services.CpuHarvester;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@Category(UnitTests.class)
public class LinuxCpuHarvesterTest {

    @Test
    public void collectData_queryData_shouldNotBeNull() {
        final CpuHarvester cpuHarvester = new LinuxCpuHarvester();
        final Set<ProcessDto> processDtos = cpuHarvester.collectData();

        assertEquals(15, processDtos.size());
        processDtos.stream()
            .filter(p -> p.getCpu() == null)
            .filter(p -> p.getMemory() == null)
            .filter(p -> p.getName() == null)
            .filter(p -> p.getCreated() == null)
            .findAny()
            .ifPresent(p -> fail());

        //dodać lomboka do DTO
//        to samo z DTO oraz
        fail();
    }
}