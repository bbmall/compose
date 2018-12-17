package pl.malinowski.cpuinfo.services.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import pl.malinowski.cpuinfo.RestTests;
import pl.malinowski.cpuinfo.db.ProcessRepository;
import pl.malinowski.cpuinfo.db.entity.ProcessEntity;
import pl.malinowski.cpuinfo.dto.ProcessDto;
import pl.malinowski.cpuinfo.services.CpuCommand;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@Category(RestTests.class)
@RunWith(SpringRunner.class)
@SpringBootTest//(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles({"test", "linux"})
public class CpuServiceTest {

    @Autowired
    private CpuCommand cpuCommand;

    @Autowired
    private ProcessRepository processRepository;


    @Before
    public void setUp() {
        processRepository.deleteAll();
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void save_thereAreNullFields_exception() {
        final ProcessDto processDto = ProcessDto.builder().build();
        cpuCommand.save(Collections.singleton(processDto));
    }

    @Test
    public void save_properDtoToSave_saved() {
        final ProcessDto processDto = ProcessDto.builder()
            .name("name2")
            .cpu(123.0)
            .memory(123456789.0)
            .created(123456L)
            .build();
        cpuCommand.save(Collections.singleton(processDto));
        final List<ProcessEntity> entities = processRepository.findAll();

        assertEquals(1, entities.size());
        final ProcessEntity processEntity = entities.get(0);
        assertEquals(processDto.getCpu(), processEntity.getCpu());
        assertEquals(processDto.getMemory(), processEntity.getMemory());
        assertEquals(processDto.getName(), processEntity.getName());
        assertEquals(processDto.getCreated(), processEntity.getCreated());

    }
}