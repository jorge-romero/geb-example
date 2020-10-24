import geb.report.ScreenshotReporter
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.remote.DesiredCapabilities


// Define timing to get information from a page
waiting {
    timeout = 25
    retryInterval = 0.5
    includeCauseInMessage = true
    atCheckWaiting = true

    presets {
        extremelySlow {
            timeout = 3600
            retryInterval = 5
        }
        verySlow {
            timeout = 600
            retryInterval = 5
        }
        mediumSlow {
            timeout = 300
            retryInterval = 5
        }
        slow {
            timeout = 50
            retryInterval = 1
        }
        quick {
            timeout = 10
        }
    }
}

environments {
    // TODO Add the proxy to all the drivers
    // See: http://code.google.com/p/selenium/wiki/ChromeDriver
    def env = System.getenv()

    chrome {
        // if (env.HTTP_PROXY) {
        // 	ChromeOptions options = new ChromeOptions();
        // 	options.setCapability("proxy", proxy);
        // 	driver = { new ChromeDriver(options) }
        // } else {
        //DesiredCapabilities handlSSLErr = DesiredCapabilities.chrome()
        //handlSSLErr.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true)

        driver = {
            ChromeOptions o = new ChromeOptions()
            o.addArguments('--ignore-certificate-errors')

            o.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            o.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
            new ChromeDriver(o)
        }
        // }
    }

    // run via “./gradlew chromeHeadlessTest”
    // See: http://code.google.com/p/selenium/wiki/ChromeDriver
    chromeHeadless {
        driver = {
            ChromeOptions o = new ChromeOptions()
            o.addArguments('headless', '--ignore-certificate-errors')
            o.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            o.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
            new ChromeDriver(o)
        }
    }
}

autoClearWebStorage = true
autoClearCookies = true


// Report configuration
reporter = new ScreenshotReporter()
//reportsDir = new File(properties."config.reports.dir")