# Dynatrace and Micrometer sample
Sample project about how to setup Micrometer in a Spring Boot application to push metrics into Dynatrace using Metrics API v1.

When running the application it will push random values of metric called `custom:temperature` every 30 seconds in the configured Dynatrace tenant. The metric has the following dimensions: city, country and continent.
 
Note that all the preconfigured metrics by Micrometer (jvm, process, logging, etc.) have been disabled through configuration.

Metric data can be seen in Dynatrace using custom charting feature.

# Getting Started

1. Log in into your Dynatrace tenant and generate an `apiToken` with `DataExport` rights. See [this article](https://www.dynatrace.com/support/help/shortlink/api-authentication#generate-a-token) for help. 
2. Rename `application.properties.example` to `application.properties`
3. Edit the property file filling `apiToken`, `uri` and `deviceId`
    ```properties
    management.metrics.export.dynatrace.apiToken=my-token
    management.metrics.export.dynatrace.uri=https://my-tnenat.live.dynatrace.com
    management.metrics.export.dynatrace.deviceId=my-device-id
    ```  
4. Run the application to start pushing metrics
```shell script
$ ./gradlew bootRun
```
