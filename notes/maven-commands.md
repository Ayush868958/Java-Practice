# Maven Commands and Goals

## 1. Introduction

Apache Maven is a build automation tool used to compile code, run tests, manage dependencies, and package Java applications.

Maven commands allow developers to perform these tasks from the terminal.

Run Maven commands from the project directory containing `pom.xml`.

## 2. What Is a Maven Goal?

A Maven goal is a specific task performed by a Maven plugin.

Examples:
- `compiler:compile` compiles the main source code.
- `surefire:test` runs tests using the Maven Surefire Plugin.
- `dependency:tree` displays the dependency hierarchy.

The general syntax for running a plugin goal is:

```bash
mvn plugin-prefix:goal
```

For example:

```bash
mvn dependency:tree
```

Maven resolves the required plugin and executes its goal.

## 3. What Is a Maven Phase?

A phase is a step in Maven's build lifecycle.

Important phases include:

- `validate`
- `compile`
- `test`
- `package`
- `verify`
- `install`
- `deploy`

A phase can execute multiple goals from different plugins.

When we run a later phase, Maven executes the earlier phases in that lifecycle first.

For example, running `mvn package` executes the required earlier phases before packaging the application.

## 4. Important Maven Commands

### A. mvn -v

```bash
mvn -v
```

Displays the installed Maven version, Java version, Maven home, and environment information.

### B. mvn clean

```bash
mvn clean
```

Removes generated build output, usually from the `target` directory.

It does not delete the project's source code.

### C. mvn compile

```bash
mvn compile
```

Compiles the main Java source code.

Compiled `.class` files are generally placed inside `target/classes`.

### D. mvn test

```bash
mvn test
```

Runs the project's tests after the necessary earlier lifecycle phases.

Test reports are commonly generated inside `target/surefire-reports`.

### E. mvn package

```bash
mvn package
```

Builds the project package, such as a JAR file.

The resulting artifact is usually created inside the `target` directory.

### F. mvn install

```bash
mvn install
```

Builds the project and installs its artifact into the local Maven repository, usually under `.m2/repository`.

This can make the artifact available to other local Maven projects.

### G. mvn clean package

```bash
mvn clean package
```

First cleans previous build output and then builds and packages the project.

This is a common command for creating a fresh build.

## 5. Difference Between a Goal and a Phase

| Maven Goal | Maven Phase |
|---|---|
| Performs a specific plugin task. | Represents a stage in the build lifecycle. |
| Example: `compiler:compile` | Example: `compile` |
| Usually belongs to a plugin. | Can invoke multiple goals. |
| Can be called directly. | Executes the lifecycle up to that phase. |

A phase is not the same as a goal, although phases can have goals bound to them.

## 6. Understanding the Build Lifecycle

Consider this simplified lifecycle:

```text
validate
   |
compile
   |
test
   |
package
   |
verify
   |
install
   |
deploy
```

This illustrates the order of common phases in Maven's default lifecycle.

For example, when we execute:

```bash
mvn install
```

Maven runs the required earlier phases before installing the built artifact.

## 7. Practical Example

Suppose a Maven project contains:

```text
MavenLearning/
├── pom.xml
└── src/
    └── main/
        └── java/
            └── Main.java
```

If `Main.java` contains valid Java code and the POM has the necessary build configuration, we can run:

```bash
mvn clean compile
```

This cleans previous output and compiles the main source code.

Next, run:

```bash
mvn package
```

Maven executes the required lifecycle phases and attempts to package the project.

If the project is configured to produce a JAR, the JAR will generally be available in `target`.

## 8. Common Errors

### Error 1: Maven command not recognized

Possible cause: Maven is not installed correctly or its `bin` directory is not in the PATH environment variable.

Solution: Check the installation and restart the terminal after changing PATH.

```bash
mvn -v
```

### Error 2: No POM found

Possible cause: The command was executed from the wrong directory.

Solution: Navigate to the project directory containing `pom.xml`.

### Error 3: Compilation failure

Possible causes include syntax errors, missing classes, or incompatible Java settings.

Solution: Read the error message, correct the code or configuration, and run the build again.

## 9. Key Takeaways

- A Maven goal performs a specific task.
- A Maven phase represents a stage in the build lifecycle.
- `mvn compile` compiles main source code.
- `mvn test` runs tests.
- `mvn package` packages the application.
- `mvn install` installs the artifact into the local repository.
- `mvn clean` removes generated build output.
- Maven commands should normally be executed from the project directory containing `pom.xml`.

Understanding Maven commands and goals is essential for working efficiently with Java and Spring Boot projects.