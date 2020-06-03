# Spring Netflix Zuul

This module implements a Zuul Reverse Proxy Server and its configurations.
In order to use this software, the following steps are to follow:
 1. Configure the Zuul application, as described on the further sections.
 2. On the [application.properties](src/main/resources/application.properties) add the `url` property pointing to the
  backedn service, as explained on the *Application Property* section below.
 3. Create one or more filters

## Implementation

There is only [one class](src/main/java/com/bluesky/technologies/springboot/netflix/zuul/ZuulGatewayApplication.java
) used, that implements a Springboot app with the tag `@SpringBootApplication` for providing
 the Springboot functionality and uses the tag `@EnableZuulProxy` to add the Zuul server functionalities.
 
## Configuration

### Gradle settings

These configurations are performed on the [setting gradle](settings.gradle) file. The configuration is:

 * Gradle project name.
 ```
 rootProject.name = 'zuul'
 ```

### Application properties

Only one property has been set, in order to override the default port server (`8080`):

 * Service port.
 ```
 server.port = 9000
 ```

 * Zuul endpoints (routes and filters) are enabled. Routes can be retrieved on the `/actuator/routes` endpoint, while
  the filters can be retrieved on the `/actuator/filters`. This is enabled as it follows:
 ```
management.endpoints.web.exposure.include=*
management.endpoint.routes.enabled=true
management.endpoint.filters.enabled=true
 ```

 * Services are mapped on the proxy by their project name on the gradle.settings file. Routes to the hello world
  service are mapped to `/helloworld`, so while you send a `/helloworld` request to the backend server, you will have
   to send further request to Zuul to `http://localhost:9001/helloworld/helloworld`. This is achieved by defining the
    following configuration for that service:
 ```
 zuul.routes.helloworld.url=http://localhost:9900
 ```
 
 * Discovery with Netflix Eureka. This property allows to enable (by default) or disables the service discovering
  services on a Netflix Eureka server:
 ```
 ribbon.eureka.enabled=false
 ```


## Testing

The testing is performed with Mockito, based on [this guide](https://spring.io/guides/gs/testing-web/).
The following tests have been created:
 * [HelloworldSpringBootSmokeTest](src/test/java/com/bluesky/technologies/springboot/helloworld
 /HelloworldSpringBootSmokeTest.java), which perform a smoking test on the only controller, so to ensure the
  controller is properly injected.
 * [HelloworldSpringBootApplicationTests](src/test/java/com/bluesky/technologies/springboot/helloworld
 /HelloworldSpringBootApplicationTests.java) 