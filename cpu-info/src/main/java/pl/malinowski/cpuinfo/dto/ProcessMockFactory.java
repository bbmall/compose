package pl.malinowski.cpuinfo.dto;

import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

public final class ProcessMockFactory {

    private static final double MULTIPLIER_100 = 100.0;
    private static final double MULTIPLIER_10 = 10.0;

    private ProcessMockFactory() {
    }

    public static ProcessDto createFakeProcess(final Integer nb) {
        final ThreadLocalRandom randGen = ThreadLocalRandom.current();
        return new ProcessDto()
            .setName("Process_" + nb)
            .setCpu(roundDouble(randGen.nextDouble() * MULTIPLIER_100, 1))
            .setMemory(roundDouble(randGen.nextDouble() * MULTIPLIER_100, 2))
            .setCreated(Instant.now().toEpochMilli());
    }

    private static double roundDouble(final double v, final int precision) {
        return ((int) (v * Math.pow(MULTIPLIER_10, precision))) / Math.pow(MULTIPLIER_10, precision);
    }
}
