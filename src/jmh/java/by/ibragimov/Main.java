package by.ibragimov;

import by.ibragimov.exceptions.SampleExceptionOne;
import by.ibragimov.exceptions.SampleExceptionTwo;
import org.openjdk.jmh.annotations.Benchmark;

import java.util.Random;

/**
 *  My results:
 *  # Run complete. Total time: 00:13:25
 *  Benchmark                  Mode  Cnt       Score       Error  Units
 *  Main.instanceOfException  thrpt  200  991684.998 ± 11215.602  ops/s
 *  Main.throwException       thrpt  200  968521.586 ± 11313.841  ops/s
 *
 *  @author Ruslan Ibragimov
 */
public class Main {

    private static Random rand = new Random();

    private static Exception getException() {
        if (rand.nextBoolean()) {
            return new SampleExceptionOne();
        } else {
            return new SampleExceptionTwo();
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
        } catch ( Exception e ) {
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
