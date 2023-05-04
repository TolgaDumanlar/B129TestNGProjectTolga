package techproed.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ListenersRetry implements IRetryAnalyzer {
//Bu class fail olan classlari tekrar calistirir
    private int retryCount = 0;
    private static final int maxRetryCount = 1;//Fail sonrasi tekrar sayisi
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}
