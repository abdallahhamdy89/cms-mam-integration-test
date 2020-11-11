package core.configUtils;

import com.plutotv.test.lib.LogUtils;
import com.plutotv.test.lib.security.CryptoSecrets;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

public class PropertiesHolder {

    private Properties properties;
    private static PropertiesHolder instance;
    private static String resourceName = "properties/config.properties";
    private static String env = System.getProperty("environment");

    private PropertiesHolder() {

    }

    public static synchronized PropertiesHolder getInstance() {
        if (instance == null) {
            instance = new PropertiesHolder();

            try {
                instance.properties = PropertiesLoaderUtils.loadAllProperties(resourceName);
            } catch (IOException e) {
                LogUtils.logSevereMessageThenFail("Cannot load property file: " + resourceName);
            }
        }

        return instance;
    }

    public String getEnv() {
        return env;
    }

    private String getEnvProperty(String name) {
        return properties.getProperty(env + "." + name);
    }

    public String getClientUrl() {
        return getEnvProperty("client.url");

    }

    private String getProperty(String name) {
        return properties.getProperty(name);
    }

    public String getAdminLoginEmail() {
        return getProperty("login.admin.email");
    }

    public String getAdminLoginPassword() {
        return CryptoSecrets.decryptString(getProperty("login.admin.password"));
    }

    public String getMamUserLoginEmail(String userName) {
        return getProperty("login." + userName + ".email");
    }

    public String getRestUrl() {
        return getEnvProperty("rest.url");
    }

    public String getRestToken() {
        return CryptoSecrets.decryptString(getEnvProperty("rest.token"));
    }

    public String getS3Url() {
        return getEnvProperty("s3.url");
    }

    public String getDbConnection() {
        return getEnvProperty("DB.conn");
    }

    public String getDbUser() {
        return getEnvProperty("DB.user");
    }

    public String getDbPassword() {
        return CryptoSecrets.decryptString(getEnvProperty("DB.password"));
    }

    public boolean getConsoleReportFlag() {
        return Boolean.valueOf(getProperty("report.console"));
    }

    public String getAdminName() {
        return getProperty("login.admin.name");
    }

    public String getMockServerUrl() {
        return getEnvProperty("mockServer.url");
    }
}
