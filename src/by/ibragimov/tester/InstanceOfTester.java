package by.ibragimov.tester;

import by.ibragimov.exceptions.SampleExceptionOne;
import by.ibragimov.exceptions.SampleExceptionTwo;

/**
 * @author Ruslan Ibragimov
 */
public class InstanceOfTester implements Tester {

    @Override
    public int test() {
        Exception exception = ExceptionProducer.getException();
        if (exception instanceof SampleExceptionOne) {
            return 1;
        } else if (exception instanceof SampleExceptionTwo) {
            return 2;
        } else {
            return 3;
        }
    }
}
