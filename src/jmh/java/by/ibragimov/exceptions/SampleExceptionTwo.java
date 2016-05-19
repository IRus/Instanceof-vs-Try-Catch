package by.ibragimov.exceptions;

/**
 * Sample exception class for tests.
 * @author Ruslan Ibragimov
 */
public class SampleExceptionTwo extends SampleException {

    private final Integer info;

    public SampleExceptionTwo(Integer info) {
        this.info = info;
    }

    @Override
    public int getInfo() {
        return info;
    }
}
