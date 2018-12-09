package mobileSession;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URL;
import java.util.List;

public class Caps {

    private Env env;
    private Android android;
    private Ios ios;
    private String autoGrantPermissions = "true";
    private String autoAcceptAlerts = "true";
    private Boolean waitForQuiesence = false;
    private int newCommandTimeout = 120;

    public Android getAndroid() {
        return android;
    }

    public void setAndroid(Android android) {
        this.android = android;
    }

    public Ios getIos() {
        return ios;
    }

    public void setIos(Ios ios) {
        this.ios = ios;
    }

    public String getAutoGrantPermissions() {
        return autoGrantPermissions;
    }

    public void setAutoGrantPermissions(String autoGrantPermissions) {
        this.autoGrantPermissions = autoGrantPermissions;
    }

    public String getAutoAcceptAlerts() {
        return autoAcceptAlerts;
    }

    public void setAutoAcceptAlerts(String autoAcceptAlerts) {
        this.autoAcceptAlerts = autoAcceptAlerts;
    }

    public Boolean getWaitForQuiesence() {
        return waitForQuiesence;
    }

    public void setWaitForQuiesence(Boolean waitForQuiesence) {
        this.waitForQuiesence = waitForQuiesence;
    }

    public int getNewCommandTimeout() {
        return newCommandTimeout;
    }

    public void setNewCommandTimeout(int newCommandTimeout) {
        this.newCommandTimeout = newCommandTimeout;
    }

    public Env getEnv() {
        return env;
    }

    public void setEnv(Env env) {
        this.env = env;
    }

    public class Env{
        @JsonProperty("env")
       private Local local;
       private bitBar bitBar;
       private browserStack browserStack;

       public URL getEnvUrl(String env){
           if (env.equals("local")){
               return local.getHubUrl();
           }
           if (env.equals("bitbar")){
               return bitBar.getHubUrl();
           }
           if (env.equals("browserstack")){
               return browserStack.getHubUrl();
           }
           return null;
       }

        public Env.bitBar getBitBar() {
            return bitBar;
        }

        public Local getLocal() {
            return local;
        }

        public Env.browserStack getBrowserStack() {
            return browserStack;
        }

        public class Local{
            private URL hubUrl;

            public URL getHubUrl() {
                return hubUrl;
            }

            public void setHubUrl(URL hubUrl) {
                this.hubUrl = hubUrl;
            }
        }
        public class bitBar{
            private URL hubUrl;

            public URL getHubUrl() {
                return hubUrl;
            }

            public void setHubUrl(URL hubUrl) {
                this.hubUrl = hubUrl;
            }
        }

        public class browserStack{
            private URL hubUrl;
            private String device;
            private String browserstackappium_version;
            private String os;
            private String os_version;
            private String browserstackdebug;

            public URL getHubUrl() {
                return hubUrl;
            }

            public void setHubUrl(URL hubUrl) {
                this.hubUrl = hubUrl;
            }

            public String getDevice() {
                return device;
            }

            public void setDevice(String device) {
                this.device = device;
            }

            public String getBrowserstackappium_version() {
                return browserstackappium_version;
            }

            public void setBrowserstackappium_version(String browserstackappium_version) {
                this.browserstackappium_version = browserstackappium_version;
            }

            public String getOs() {
                return os;
            }

            public void setOs(String os) {
                this.os = os;
            }

            public String getOs_version() {
                return os_version;
            }

            public void setOs_version(String os_version) {
                this.os_version = os_version;
            }

            public String getBrowserstackdebug() {
                return browserstackdebug;
            }

            public void setBrowserstackdebug(String browserstackdebug) {
                this.browserstackdebug = browserstackdebug;
            }
        }
    }

    public class Android {
        private String platform;
        private String platformVersion;
        private String deviceName;
        private String udid;
        private List<app> app;
        private String automationName;
        private String chromedriverExecutableDir;


        public app getApp(String appName){
            for (app ap : app){
                if (ap.getName().toLowerCase().equals(appName.toLowerCase())){
                    return ap;
                }
            }
            return null;
        }

        public class app{
            private String name;
            private String url;
            private String appPackage;
            private String appActivity;
            private String bundleId;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getAppPackage() {
                return appPackage;
            }

            public void setAppPackage(String appPackage) {
                this.appPackage = appPackage;
            }

            public String getAppActivity() {
                return appActivity;
            }

            public void setAppActivity(String appActivity) {
                this.appActivity = appActivity;
            }

            public String getBundleId() {
                return bundleId;
            }

            public void setBundleId(String bundleId) {
                this.bundleId = bundleId;
            }

            public void setName(String name) {
                this.name = name;
            }
            public String getName() {
                return name;
            }
        }

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }

        public String getPlatformVersion() {
            return platformVersion;
        }

        public void setPlatformVersion(String platformVersion) {
            this.platformVersion = platformVersion;
        }

        public String getDeviceName() {
            return deviceName;
        }

        public void setDeviceName(String deviceName) {
            this.deviceName = deviceName;
        }

        public String getUdid() {
            return udid;
        }

        public void setUdid(String udid) {
            this.udid = udid;
        }

        public String getAutomationName() {
            return automationName;
        }

        public void setAutomationName(String automationName) {
            this.automationName = automationName;
        }

        public String getChromedriverExecutableDir() {
            return chromedriverExecutableDir;
        }

        public void setChromedriverExecutableDir(String chromedriverExecutableDir) {
            this.chromedriverExecutableDir = chromedriverExecutableDir;
        }
    }

    public class Ios {
        private String platform;
        private String platformVersion;
        private String deviceName;
        private String udid;
        private List<app> app;
        private String automationName;


        public app getApp(String appName){
            for (app ap : app){
                if (ap.getName().toLowerCase().equals(appName.toLowerCase())){
                    return ap;
                }
            }
            return null;
        }

        public class app{
            private String name;
            private String url;
            private String bundleId;


            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getBundleId() {
                return bundleId;
            }

            public void setBundleId(String bundleId) {
                this.bundleId = bundleId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }

        public String getPlatformVersion() {
            return platformVersion;
        }

        public void setPlatformVersion(String platformVersion) {
            this.platformVersion = platformVersion;
        }

        public String getDeviceName() {
            return deviceName;
        }

        public void setDeviceName(String deviceName) {
            this.deviceName = deviceName;
        }

        public String getUdid() {
            return udid;
        }

        public void setUdid(String udid) {
            this.udid = udid;
        }

        public String getAutomationName() {
            return automationName;
        }

        public void setAutomationName(String automationName) {
            this.automationName = automationName;
        }
    }
}
