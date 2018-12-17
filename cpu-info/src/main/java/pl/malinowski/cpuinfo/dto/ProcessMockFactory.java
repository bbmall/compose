package pl.malinowski.cpuinfo.dto;

import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

public final class ProcessMockFactory {

    private static final double MULTIPLIER_1000_1000 = 1000_000.0;
    private static final double MULTIPLIER_100 = 100.0;
    private static final double MULTIPLIER_10 = 10.0;

    private ProcessMockFactory() {
    }

    public static ProcessDto createFakeProcess(final Integer nb) {
        final ThreadLocalRandom randGen = ThreadLocalRandom.current();
        return ProcessDto.builder()
            .name("Process_" + nb)
            .cpu(roundDouble(randGen.nextDouble() * MULTIPLIER_100, 1))
            .memory(roundDouble(randGen.nextDouble() * MULTIPLIER_1000_1000, 2))
            .created(Instant.now().toEpochMilli())
            .build();
    }

    private static double roundDouble(final double v, final int precision) {
        return ((int) (v * Math.pow(MULTIPLIER_10, precision))) / Math.pow(MULTIPLIER_10, precision);
    }
}
