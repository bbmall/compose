package pl.malinowski.cpuinfo.dto;

import java.util.Objects;
import java.util.UUID;

public class ProcessDto {

    private UUID id;
    private String name;
    private Double cpu;
    private Double memory;
    private Long created;

    public UUID getId() {
        return id;
    }

    public ProcessDto setId(final UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProcessDto setName(final String name) {
        this.name = name;
        return this;
    }

    public Double getCpu() {
        return cpu;
    }

    public ProcessDto setCpu(final Double cpu) {
        this.cpu = cpu;
        return this;
    }

    public Double getMemory() {
        return memory;
    }

    public ProcessDto setMemory(final Double memory) {
        this.memory = memory;
        return this;
    }

    public Long getCreated() {
        return created;
    }

    public ProcessDto setCreated(final Long created) {
        this.created = created;
        return this;
    }

    //checkstyle-off
    @Override
    public boolean equals(final Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        final ProcessDto that = (ProcessDto) o;
        return Objects.equals(id, that.id) &&
            Objects.equals(name, that.name) &&
            Objects.equals(cpu, that.cpu) &&
            Objects.equals(memory, that.memory) &&
            Objects.equals(created, that.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cpu, memory, created);
    }
    //checkstyle-on
}
