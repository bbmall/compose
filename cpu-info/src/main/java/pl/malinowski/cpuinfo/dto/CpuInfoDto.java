package pl.malinowski.cpuinfo.dto;

import java.util.Objects;
import java.util.UUID;

public class CpuInfoDto {

    private UUID id;

    public UUID getId() {
        return id;
    }

    public CpuInfoDto setId(final UUID id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(final Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        final CpuInfoDto that = (CpuInfoDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
