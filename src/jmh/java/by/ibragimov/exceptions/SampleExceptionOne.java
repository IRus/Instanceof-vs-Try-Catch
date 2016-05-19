package by.ibragimov.exceptions;

/**
 * Sample exception class for tests.
 * @author Ruslan Ibragimov
 */
public class SampleExceptionOne extends SampleException {

    private final Integer info;

    public SampleExceptionOne(Integer info) {
        this.info = info;
    }

    @Override
    public int getInfo() {
        return info;
    }
}
