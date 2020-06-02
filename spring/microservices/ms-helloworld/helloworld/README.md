# Spring Helloworld

This example presents the simplest example of a web service.

## Implementation

There is only [one class](src/main/java/com/bluesky/technologies/springboot/helloworld/HelloworldSpringBootApplication.java) used, that implements a
 Springboot app with the tag `@SpringBootApplication` for providing
 the Springboot functionality and uses the tag `@RestController` that provides the functionalities for REST services.
 
## Configuration

### Gradle settings

These configurations are performed on the [setting gradle](settings.gradle) file. The configuration is:

 * Gradle project name.
 ```
 rootProject.name = 'helloworld'
 ```

### Property applications

Only one property has been set, in order to redefine the default port server (`8080`):

 * Service port.
 ```
 server.port = 9900
 ```

## Testing

The testing is performed with Mockito, based on [this guide](https://spring.io/guides/gs/testing-web/).
The following tests have been created:
 * [HelloworldSpringBootSmokeTest](src/test/java/com/bluesky/technologies/springboot/helloworld
 /HelloworldSpringBootSmokeTest.java), which perform a smoking test on the only controller, so to ensure the
  controller is properly injected.
 * [HelloworldSpringBootApplicationTests](src/test/java/com/bluesky/technologies/springboot/helloworld
 /HelloworldSpringBootApplicationTests.java) 