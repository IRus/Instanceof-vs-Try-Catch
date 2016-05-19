package by.ibragimov;

import by.ibragimov.exceptions.SampleExceptionOne;
import by.ibragimov.exceptions.SampleExceptionTwo;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * My results:
 * <p>
 * # Run complete. Total time: 00:13:24
 * <p>
 * Benchmark                 Mode  Cnt     Score   Error  Units
 * Main.instanceOfException  avgt  200  1008.356 ± 5.139  ns/op
 * Main.throwException       avgt  200   996.364 ± 5.110  ns/op
 *
 * @author Ruslan Ibragimov
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class Main {

    private static Random rand = new Random();

    private static Exception getException() {
        if (rand.nextBoolean()) {
            return new SampleExceptionOne(rand.nextInt());
        } else {
            return new SampleExceptionTwo(rand.nextInt());
        }
    }

    @Benchmark
    public int instanceOfException() {
        Exception exception = getException();

        try {
            throw exception;
        } catch (SampleExceptionOne e) {
            return e.getInfo();
        } catch (SampleExceptionTwo e) {
            return e.getInfo();
        } catch (Exception e) {
            return 3;
        }
    }

    @Benchmark
    public int throwException() {
        Exception exception = getException();

        if (exception instanceof SampleExceptionOne) {
            return 1;
        } else if (exception instanceof SampleExceptionTwo) {
            return 2;
        } else {
            return 3;
        }
    }
}
