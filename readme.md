# Tenable.io Java SDK
Tenable.io Java SDK

### Configuration
Access key and secret key are needed to authenticate with the [Tenable Cloud API]. There are three ways to configure the `TenableIoClient` with the keys.

##### TenableIoClient Constructor Arguments
```java
TenableIoClient client = new TenableIoClient( 'YOUR_ACCESS_KEY', 'YOUR_SECRET_KEY' );
```

##### Environment Variables
TenableIoClient looks for the environment variables `TENABLEIO_ACCESS_KEY` and `TENABLEIO_SECRET_KEY`. When defined, the TenableIoClient` can be created without parameters:
```java
TenableIoClient client = new TenableIoClient();
```

##### JVM system properties
TenableIoClient looks for the JVM system properties `tenableIoAccessKey` and `tenableIoSecretKey`. They are set like any other JVM system properties, with the `-D` command line option, for isntance:
```aidl
java -DtenableIoAccessKey=<YOUR ACCESS KEY> -DtenableIoSecretKey=<YOUR SECRET KEY>
```
When defined, the TenableIoClient` can be created without parameters:
```java
TenableIoClient client = new TenableIoClient();
```
NOTE: The JVM system properties have priority over the environment variables.

### Java Version
1.7+

### Development
The Tenable IO SDK uses the Gradle build tool and has to following dependencies:
```
org.apache.httpcomponents.httpasyncclient => version:4.1.2
org.apache.httpcomponents.httpmime => version: 4.5.2
com.fasterxml.jackson.core.jackson-core => version: 2.0.0 or above
com.fasterxml.jackson.core.jackson-annotations => version: 2.0.0 or above
com.fasterxml.jackson.core.jackson-databind => version: 2.0.0 or above
```

### Run Tests
To run the tests, edit the `build.gradle` and update the `test` block with your information:
```aidl
test {
    // Access key and secret
    jvmArgs "-DtenableIoAccessKey=<ACCESS KEY>"
    jvmArgs "-DtenableIoSecretKey=<ACCESS SECRET>"
    // A valid domain name for username, for instance "tenable.com"
    jvmArgs "-DuserDomainName=<YOUR DOMAIN>"
    // Comma-separated list of host targets to create a scan with. (Warning: do not scan targets that you're not authorized to.)
    jvmArgs "-DscanTextTargets=<SCAN_TEXT_TARGETS>"
    // Comma-separated list of host alternative targets to launch a scan with. (Warning: do not scan targets that you're not authorized to.)
    jvmArgs "-DscanAltTargets=<SCAN_ALT_TARGETS>"
    // Name of template to create a scan with.
    jvmArgs "-DscanTemplateName=discovery"
    // Name of template to create a policy with.
    jvmArgs "-DpolicyTemplateName=discovery"
}
```

Note: alternatively, you can also define your Access and Secret key by setting the environment variables `TENABLEIO_ACCESS_KEY` and `TENABLEIO_SECRET_KEY`, either at the bash level (in which case they can be taken out of the test block) or directly in the test block:
```aidl
test {
    environment "TENABLEIO_ACCESS_KEY", "YOUR ACCESS KEY"
    environment "TENABLEIO_SECRET_KEY", "YOUR SECRET KEY"
    // A valid domain name for username, for instance "tenable.com"
    jvmArgs "-DuserDomainName=<YOUR DOMAIN>"
            ...
            ...
}
To run the tests, execute the following command from the project root
```sh
$ gradle test
```
### Documentation
Generate HTML documentation. Run the following command from the project root. HTML docs will get generated in `build/docs/javadoc`
```sh
$ gradle javadoc
```
