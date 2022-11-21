package config;

import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class AllureFeatures {
    private static final Logger logger = LoggerFactory.getLogger(AllureFeatures.class);

    public static void generateEnvironmentVariablesForAllure() {
        allureEnvironmentWriter(ImmutableMap.<String, String>builder()
                .put("OPERATING_SYSTEM", System.getProperty("os.name"))
                .build(), System.getProperty("user.dir")
                + "/allure-results/");
        logger.info("XML generated at {}", System.getProperty("user.dir") + "/allure-results/");
    }

}