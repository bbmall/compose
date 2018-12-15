package pl.malinowski.cpuinfo.db.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class CpuInfoEntity {

    @Id
    private UUID id;

    public UUID getId() {
        return id;
    }

    public CpuInfoEntity setId(final UUID id) {
        this.id = id;
        return this;
    }
}
