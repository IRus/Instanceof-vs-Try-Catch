package by.ibragimov.runner;

import by.ibragimov.tester.InstanceOfTester;
import by.ibragimov.tester.Tester;
import by.ibragimov.tester.ThrowTester;

public class Runner {

    public static void main(String[] args) {
        long start;
        int times = 10;
        long iof = 0;
        long tca = 0;
        for (int i = 0; i < times; i++) {
            start = System.currentTimeMillis();
            test(new InstanceOfTester());
            iof += (System.currentTimeMillis() - start);

            start = System.currentTimeMillis();
            test(new ThrowTester());
            tca += (System.currentTimeMillis() - start);
        }
        System.out.println("Instance of: " + iof/times);
        System.out.println("Try / Catch: " + tca/times);
    }

    public static int test(Tester tester) {
        int tests = 100000;
        for (int i = 0; i < tests; i++) {
            tester.test();
        }
        return 0;
    }
}
