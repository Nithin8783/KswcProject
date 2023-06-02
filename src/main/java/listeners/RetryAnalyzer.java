package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import utilities.PropertyFile;

import java.io.IOException;

public class RetryAnalyzer implements IRetryAnalyzer {
    @Override
    public boolean retry(ITestResult result) {
        try {
            if(PropertyFile.getProperty("retryCount").equals(true)){
                int count = 1;
                while(count<3){
                    count++;
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
