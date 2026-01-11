package base;

import com.microsoft.playwright.Page;
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
            Path screenshot = outDir.resolve("failure.png");
            test.page.screenshot(new Page.ScreenshotOptions().setPath(screenshot).setFullPage(true));

            // Trace
            Path trace = outDir.resolve("trace.zip");
            test.context.tracing().stop(new com.microsoft.playwright.Tracing.StopOptions().setPath(trace));

            // NOTE: video is saved automatically under target/videos by Playwright
        } catch (Exception ignored) {
            // We don't want artifact creation issues to hide the real failure
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Object instance = result.getInstance();
        if (!(instance instanceof BaseTest)) return;

        BaseTest test = (BaseTest) instance;
        try {
            // Stop trace for passed tests too (optional)
            test.context.tracing().stop();
        } catch (Exception ignored) {}
    }
}
