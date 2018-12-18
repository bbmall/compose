package pl.malinowski.cpuinfo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProcessDto {

    private UUID id;
    private String name;
    private Double cpu;
    private Double memory;
    private Long created;

}
