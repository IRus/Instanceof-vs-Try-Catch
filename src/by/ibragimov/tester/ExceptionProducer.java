package by.ibragimov.tester;

import by.ibragimov.exceptions.SampleExceptionOne;
import by.ibragimov.exceptions.SampleExceptionTwo;

import java.util.Random;

/**
 * @author Ruslan Ibragimov
 */
public class ExceptionProducer {

    private static Random rand = new Random();

    public static Exception getException() {
        if (rand.nextBoolean()) {
            return new SampleExceptionOne();
        } else {
            return new SampleExceptionTwo();
        }
    }
}
