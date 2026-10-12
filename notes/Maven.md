# Maven in Java

## 1. What is Maven?

Apache Maven is a **build automation and project management tool** used mainly for Java projects.

It helps developers to:
- Manage project dependencies (external libraries).
- Compile Java source code.
- Run tests.
- Package applications into JAR or WAR files.
- Maintain a standard project structure.
- Automate the build process.

## 2. Why Do We Use Maven?

Without Maven, developers may need to download external JAR files manually and configure them in their projects.

Maven simplifies this process by downloading required dependencies and their related dependencies automatically.

**Example:** If a project needs a library, we can declare it in `pom.xml`, and Maven can download it from a configured repository.

## 3. What Is `pom.xml`?

`pom.xml` stands for **Project Object Model**.

It is the main configuration file of a Maven project. It contains project information, dependencies, properties, and build configuration.

Example:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
         https://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>maven-learning</artifactId>
    <version>1.0-SNAPSHOT</version>

</project>
```

### Important Elements

- `modelVersion`: Specifies the POM model version.
- `groupId`: Identifies the organization or project group.
- `artifactId`: Identifies the project or artifact.
- `version`: Specifies the project's version.

## 4. What Are Dependencies?

Dependencies are external libraries required by a project.

For example, a Java project may need a library for JSON processing or database connectivity.

Dependencies are declared inside the `<dependencies>` section of `pom.xml`.

Example:

```xml
<dependencies>
    <dependency>
        <groupId>org.example</groupId>
        <artifactId>example-library</artifactId>
        <version>1.0.0</version>
    </dependency>
</dependencies>
```

*Note: This is an illustrative example. The library coordinates and version must correspond to a real published library before use.*

## 5. Maven Project Structure

A standard Maven project follows this structure:

```text
MavenLearning/
├── pom.xml
└── src/
    ├── main/
    │   └── java/
    │       └── Main.java
    └── test/
        └── java/
```

- `src/main/java`: Contains application source code.
- `src/test/java`: Contains test source code.
- `pom.xml`: Contains Maven configuration.

## 6. Important Maven Commands

| Command | Purpose |
|---|---|
| `mvn -v` | Displays Maven and Java version information. |
| `mvn compile` | Compiles the main source code. |
| `mvn test` | Runs tests after the required build steps. |
| `mvn package` | Builds the project package, such as a JAR. |
| `mvn clean` | Removes generated build output, usually the `target` directory. |
| `mvn clean compile` | Cleans previous build output and compiles the source code. |
| `mvn install` | Builds and installs the artifact into the local Maven repository. |

Run these commands from the project directory containing `pom.xml`.

## 7. What Is the Maven Build Lifecycle?

The Maven build lifecycle defines the sequence of steps used to build and test a project.

Some important phases are:

1. `validate` — Checks whether the project configuration is valid.
2. `compile` — Compiles the main source code.
3. `test` — Runs tests.
4. `package` — Packages the compiled application.
5. `verify` — Performs additional verification checks.
6. `install` — Installs the package in the local repository.
7. `deploy` — Publishes the package to a configured remote repository.

Running a later phase generally executes the earlier phases in that lifecycle first.

For example, `mvn package` runs the required earlier phases before packaging.

## 8. What Is the `target` Directory?

Maven generates build output inside the `target` directory by default.

It may contain:
- Compiled `.class` files.
- Test reports.
- Packaged JAR or WAR files.

The `mvn clean` command removes this generated output so the next build starts with a clean build directory.

## 9. What Is a Maven Repository?

A Maven repository stores project artifacts and dependencies.

There are three common repository types:

- **Local repository:** Stored on your computer, commonly under `.m2/repository`.
- **Central repository:** A public repository Maven can use to download many published libraries.
- **Remote repository:** A repository hosted on a server, such as a company's internal artifact repository.

Maven checks configured repositories to resolve dependencies.

## 10. Maven vs Manual JAR Management

| Manual approach | Maven approach |
|---|---|
| Download JAR files manually. | Declare dependencies in `pom.xml`. |
| Configure libraries manually. | Maven resolves dependencies. |
| Run build steps manually. | Maven automates build phases. |
| Maintain library versions manually. | Specify and manage versions through project configuration. |

## Conclusion

Maven makes Java project development easier by managing dependencies, compiling code, running tests, and packaging applications.

Understanding `pom.xml`, dependencies, repositories, and the build lifecycle is useful before working with Spring Boot projects.
