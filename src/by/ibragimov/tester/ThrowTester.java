package by.ibragimov.tester;

import by.ibragimov.exceptions.SampleExceptionOne;
import by.ibragimov.exceptions.SampleExceptionTwo;

/**
 * @author Ruslan Ibragimov
 */
public class ThrowTester implements Tester {

    @Override
    public int test() {
        Exception exception = ExceptionProducer.getException();
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
}
