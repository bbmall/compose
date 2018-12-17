package pl.malinowski.cpuinfo.db.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "process")
public class ProcessEntity {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "pl.malinowski.cpuinfo.db.UuidGenerator")
    private UUID id;

    @Column(length = 60, nullable = false)
    private String name;

    @Column(nullable = false)
    private Double cpu;

    @Column(nullable = false)
    private Double memory;

    @Column(nullable = false)
    private Long created;
}
