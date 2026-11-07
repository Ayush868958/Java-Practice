# JDBC – Day 1 Notes
## Java Database Connectivity (JDBC)

### 1. JDBC kya hai?

JDBC ka full form **Java Database Connectivity** hai.

JDBC Java API hai jiska use Java application ko database ke saath connect karne aur database operations perform karne ke liye hota hai.

Example:

Hum Java application se MySQL database mein:
- Data insert kar sakte hain.
- Data retrieve kar sakte hain.
- Data update kar sakte hain.
- Data delete kar sakte hain.

### 2. JDBC ki zarurat kyu hoti hai?

Suppose hum ek Student Management System bana rahe hain.

Java application mein student ki information available hai:

- Student ID
- Student Name
- Student City

Humein ye information permanently database mein store karni hai.

JDBC Java application aur MySQL database ke beech communication establish karta hai.

### 3. JDBC Architecture

Java Application → JDBC API → JDBC Driver → MySQL Database

**JDBC Driver:** Ye Java application aur database ke beech communication karne mein help karta hai.

Hum MySQL ke liye MySQL Connector/J driver use kar rahe hain.

### 4. MySQL Connector/J

MySQL Connector/J MySQL ka official JDBC driver hai.

Humne iska JAR file IntelliJ project mein add kiya:

`mysql-connector-j-26.10.0.jar`

Driver class:

```java
com.mysql.cj.jdbc.Driver
```

### 5. Database Setup

MySQL Workbench mein humne database create kiya:

```sql
CREATE DATABASE jdbclearning;
```

Database select karne ke liye:

```sql
USE jdbclearning;
```

Table create ki:

```sql
CREATE TABLE student_info (
    sid INT PRIMARY KEY,
    sname VARCHAR(50) NOT NULL,
    scity VARCHAR(50) NOT NULL
);
```

Table structure:

| Column | Data Type |
|---|---|
| sid | INT PRIMARY KEY |
| sname | VARCHAR(50) |
| scity | VARCHAR(50) |

### 6. JDBC ke 7 Basic Steps

**Step 1: Import SQL Package**

```java
import java.sql.*;
```

Java ke SQL-related classes aur interfaces access karne ke liye.

**Step 2: Load and Register Driver**

```java
Class.forName("com.mysql.cj.jdbc.Driver");
```

MySQL JDBC driver ko load karta hai.

Note: Modern JDBC drivers automatically register ho jaate hain. Isliye modern applications mein ye step generally optional hai.

**Step 3: Establish Connection**

```java
String url = "jdbc:mysql://localhost:3306/jdbclearning";
String username = "root";
String password = "YOUR_MYSQL_PASSWORD";

Connection connect =
    DriverManager.getConnection(url, username, password);
```

Important terms:

- `jdbc:mysql`: JDBC protocol aur MySQL database.
- `localhost`: Database local machine par hai.
- `3306`: MySQL ka default port.
- `jdbclearning`: Database name.
- `Connection`: Database connection represent karta hai.
- `DriverManager`: Database connection establish karne mein help karta hai.

**Step 4: Create Statement**

```java
Statement statement = connect.createStatement();
```

SQL queries execute karne ke liye Statement object create hota hai.

**Step 5: Execute Query**

SELECT query execute karne ke liye:

```java
ResultSet result =
    statement.executeQuery("SELECT * FROM student_info");
```

**Step 6: Process the Result**

```java
while (result.next()) {
    System.out.println(result.getInt("sid"));
    System.out.println(result.getString("sname"));
    System.out.println(result.getString("scity"));
}
```

- `ResultSet`: Database se returned records store karta hai.
- `next()`: Cursor ko next row par move karta hai.
- `getInt()`: Integer value retrieve karta hai.
- `getString()`: String value retrieve karta hai.

**Step 7: Close Resources**

```java
result.close();
statement.close();
connect.close();
```

Database resources ko properly close karna important hai.

### 7. Important JDBC Classes and Interfaces

| Name | Purpose |
|---|---|
| DriverManager | Connection establish karta hai |
| Connection | Database connection represent karta hai |
| Statement | SQL queries execute karta hai |
| ResultSet | SELECT query ka result represent karta hai |
| Driver | Database driver functionality |

### 8. JDBC Connection Program

```java
package com.ayush.jdbc;

import java.sql.*;

public class LaunchApp1 {

    public static void main(String[] args) throws Exception {

        // Load and register driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Database details
        String url = "jdbc:mysql://localhost:3306/jdbclearning";
        String username = "root";
        String password = "YOUR_MYSQL_PASSWORD";

        // Establish connection
        Connection connect =
            DriverManager.getConnection(url, username, password);

        // Create statement
        Statement statement = connect.createStatement();

        // Execute query
        ResultSet result =
            statement.executeQuery("SELECT * FROM student_info");

        // Process result
        while (result.next()) {
            System.out.println(result.getInt("sid"));
            System.out.println(result.getString("sname"));
            System.out.println(result.getString("scity"));
        }

        // Close resources
        result.close();
        statement.close();
        connect.close();
    }
}
```

### 9. executeQuery() vs executeUpdate()

| Method | Use |
|---|---|
| `executeQuery()` | SELECT queries |
| `executeUpdate()` | INSERT, UPDATE, DELETE |

`executeQuery()` returns a ResultSet.

`executeUpdate()` returns an integer representing affected rows.

### 10. JDBC Learning – Today's Practical Work

Aaj humne:

1. MySQL Workbench mein local instance connect kiya.
2. `jdbclearning` database create kiya.
3. `student_info` table create ki.
4. MySQL Connector/J JAR IntelliJ mein add ki.
5. JDBC driver load karna seekha.
6. Java application se MySQL connection establish kiya.
7. Connection-related authentication error solve kiya.
8. Successful database connection verify kiya.

**Project:** FirstjdbcApp

**Package:** `com.ayush.jdbc`

**Class:** `LaunchApp1`

**Database:** `jdbclearning`

**Table:** `student_info`

---

### Today's Learning Outcome

JDBC ka basic purpose samajhna aur Java application ko MySQL database ke saath connect karna.

**Next Topics:**
- ResultSet in detail
- executeQuery()
- executeUpdate()
- INSERT operation
- PreparedStatement
