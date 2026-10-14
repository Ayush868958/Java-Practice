# Maven Dependencies in Java

## 1. What Is a Dependency?

A dependency is an external library or component that a Java project needs to perform certain tasks.

For example:
- A JSON library helps process JSON data.
- A database driver helps a Java application communicate with a database.
- Spring Web provides tools for building web applications and REST APIs.

Instead of manually downloading every library, we can declare dependencies in Maven's `pom.xml` file.

## 2. How to Add a Dependency in Maven

Dependencies are declared inside the `<dependencies>` element of `pom.xml`.

Example:

```xml
<dependencies>
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.13.2</version>
    </dependency>
</dependencies>
```

This example adds Gson, a Java library used to convert Java objects to JSON and JSON to Java objects.

The version shown is an example; use a compatible version for your project.

## 3. Understanding Dependency Fields

Every dependency commonly contains three important fields.

### A. groupId

Identifies the group or organization that publishes the library.

Example:

```xml
<groupId>com.google.code.gson</groupId>
```

### B. artifactId

Identifies the particular library.

Example:

```xml
<artifactId>gson</artifactId>
```

### C. version

Specifies the version of the library.

Example:

```xml
<version>2.13.2</version>
```

These coordinates help Maven identify which library to resolve.

## 4. How Does Maven Download Dependencies?

When we add a dependency to `pom.xml` and run a Maven command, Maven attempts to resolve that dependency.

The process is generally:

1. Maven reads the project's `pom.xml`.
2. It checks the local Maven repository for the required artifact.
3. If the artifact is missing, Maven checks configured remote repositories.
4. Maven downloads the required files when available.
5. Maven makes the resolved dependency available to the build.

The default local repository is commonly located at:

```text
C:\Users\YOUR_USERNAME\.m2\repository
```

The exact location can be changed through Maven configuration.

## 5. What Is Maven Central?

Maven Central is a public repository containing many Java libraries and other build artifacts.

Maven can download dependencies from configured repositories, including Maven Central.

Developers can find library coordinates through the Maven Central website:

https://central.sonatype.com/

Always choose a suitable, maintained library version for your project.

## 6. What Is Transitive Dependency?

A transitive dependency is a dependency required by another dependency.

For example:

- Your project uses Library A.
- Library A requires Library B.
- Maven can resolve Library B automatically as a transitive dependency.

This reduces the need to declare every required library manually.

However, dependency conflicts or exclusions may sometimes require additional configuration.

## 7. Dependency Scope

Dependency scope controls when a dependency is available during the build.

Common Maven scopes include:

| Scope | Purpose |
|---|---|
| `compile` | Available during compilation and runtime; this is the default scope. |
| `provided` | Available for compilation and testing but expected to be supplied by the runtime environment. |
| `runtime` | Needed at runtime but not for compiling the main source code. |
| `test` | Used for compiling and running tests, not the main application at runtime. |

Example of a test dependency:

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>YOUR_COMPATIBLE_VERSION</version>
    <scope>test</scope>
</dependency>
```

Replace `YOUR_COMPATIBLE_VERSION` with a real compatible version before using this example.

## 8. What Happens When We Change a Dependency Version?

Suppose a project uses version `1.0` of a library and later changes to version `2.0`.

Maven attempts to resolve the newly specified version when the project is built.

A newer version may contain bug fixes or new features, but it can also introduce incompatible changes. Therefore, dependency versions should be updated carefully.

## 9. Useful Maven Commands

Run these commands from the directory containing `pom.xml`.

| Command | Purpose |
|---|---|
| `mvn compile` | Compiles the main source code. |
| `mvn test` | Runs the project's tests. |
| `mvn package` | Builds the project package. |
| `mvn dependency:tree` | Displays the dependency hierarchy, including transitive dependencies. |
| `mvn dependency:resolve` | Attempts to resolve the project's dependencies. |

The dependency commands require Maven to resolve the relevant plugin and repository artifacts.

## 10. Maven Dependencies in Spring Boot

Spring Boot projects often use starter dependencies.

For example, `spring-boot-starter-web` provides a convenient set of dependencies for building web applications and REST APIs.

Spring Boot dependency management can control compatible dependency versions, so developers often do not need to specify each managed dependency version individually.

The exact dependency name and configuration depend on the Spring Boot version and project setup.

## Conclusion

Maven dependencies make Java development easier by automating library management.

Important concepts to remember:

- Dependency coordinates: `groupId`, `artifactId`, and `version`.
- Maven Central and the local repository.
- Transitive dependencies.
- Dependency scopes.
- Dependency management in Spring Boot.

Understanding these concepts helps developers manage libraries and build reliable Java applications.