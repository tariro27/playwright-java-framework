package base;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Tracing;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ArtifactListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object instance = result.getInstance();
        if (!(instance instanceof BaseTest)) return;

        BaseTest test = (BaseTest) instance;

        try {
            String testName = result.getMethod().getMethodName();
            Path outDir = Paths.get("target", "artifacts", testName);
            Files.createDirectories(outDir);

            // Screenshot
            Path screenshotPath = outDir.resolve("failure.png");
            test.page.screenshot(new Page.ScreenshotOptions()
                    .setPath(screenshotPath)
                    .setFullPage(true)
            );

            // Trace
            Path tracePath = outDir.resolve("trace.zip");
            test.context.tracing().stop(new Tracing.StopOptions().setPath(tracePath));
        } catch (Exception ignored) {
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Object instance = result.getInstance();
        if (!(instance instanceof BaseTest)) return;

        BaseTest test = (BaseTest) instance;

        try {
            //Stop trace without saving for passed tests
            test.context.tracing().stop();
        } catch (Exception ignored) {}
    }
}