package by.ibragimov.exceptions;

/**
 * Sample exception class for tests.
 * @author Ruslan Ibragimov
 */
public class SampleExceptionTwo extends Exception implements SampleException {

    @Override
    public int getInfo() {
        return 2;
    }
}
