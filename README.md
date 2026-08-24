# EmployeeDemo

A simple Java application demonstrating **Hibernate ORM with MySQL** using Maven.

This project connects a Java application to a MySQL database using Hibernate and performs basic employee data persistence.

---

## 🛠️ Tech Stack

- Java 17
- Maven
- Hibernate ORM 6.4.4
- MySQL 8
- MySQL Connector/J
- Git

---

# 🚀 Setup & Installation

Follow the steps below if you are cloning this project for the first time.

---

## 1. Install Java

Check if Java is already installed:

```bash
java --version
```

If Java is not installed:

```bash
sudo apt update
sudo apt install openjdk-17-jdk -y
```

Verify the installation:

```bash
java --version
javac --version
```

---

## 2. Install Git

Check if Git is installed:

```bash
git --version
```

If Git is not installed:

```bash
sudo apt install git -y
```

---

## 3. Install Maven

Check if Maven is installed:

```bash
mvn --version
```

If Maven is not installed:

```bash
sudo apt install maven -y
```

Verify:

```bash
mvn --version
```

---

# 📥 Clone the Repository

Clone the repository:

```bash
git clone <YOUR_REPOSITORY_URL>
```

Example:

```bash
git clone https://github.com/Prajwal-SM-2005/EmployeeDemo.git
```

Move into the project directory:

```bash
cd EmployeeDemo
```

Check the project files:

```bash
ls
```

You should see files/folders such as:

```text
pom.xml
src
README.md
```

---

# 🗄️ MySQL Setup

## 4. Install MySQL Server

Update the package list:

```bash
sudo apt update
```

Install MySQL:

```bash
sudo apt install mysql-server -y
```

---

## 5. Start MySQL

Start the MySQL server:

```bash
sudo service mysql start
```

Check the MySQL status:

```bash
sudo service mysql status
```

MySQL should be running.

---

## 6. Create the Database

Enter MySQL:

```bash
sudo mysql
```

Create the database:

```sql
CREATE DATABASE employeedb;
```

Verify that the database was created:

```sql
SHOW DATABASES;
```

You should see:

```text
employeedb
```

Exit MySQL:

```sql
exit;
```

---

# 🔐 MySQL Password Configuration

The application uses the following MySQL configuration:

```text
Host:     127.0.0.1
Port:     3306
Database: employeedb
Username: root
```

You need to set a password for the MySQL root user.

Enter MySQL:

```bash
sudo mysql
```

Run:

```sql
ALTER USER 'root'@'localhost'
IDENTIFIED WITH mysql_native_password BY 'YOUR_PASSWORD';

FLUSH PRIVILEGES;
```

Replace `YOUR_PASSWORD` with your own password.

For example:

```sql
ALTER USER 'root'@'localhost'
IDENTIFIED WITH mysql_native_password BY 'mypassword123';
```

Then exit:

```sql
exit;
```

---

# ⚙️ Configure Hibernate

Open the Hibernate configuration file:

```text
src/main/resources/hibernate.cfg.xml
```

Make sure the MySQL connection settings contain your own password.

Example:

```xml
<property name="hibernate.connection.url">
    jdbc:mysql://127.0.0.1:3306/employeedb
</property>

<property name="hibernate.connection.username">
    root
</property>

<property name="hibernate.connection.password">
    YOUR_PASSWORD
</property>
```

Replace:

```text
YOUR_PASSWORD
```

with the MySQL password you created.

> ⚠️ **Important:** Never commit your real database password to GitHub.

---

# 🔍 Test MySQL Connection

Test the MySQL connection manually:

```bash
mysql -u root -p -h 127.0.0.1 -P 3306
```

Enter your password when prompted.

Check the databases:

```sql
SHOW DATABASES;
```

You should see:

```text
employeedb
```

Select the database:

```sql
USE employeedb;
```

Exit:

```sql
exit;
```

---

# 📦 Install Project Dependencies

Move to the project root:

```bash
cd EmployeeDemo
```

Run:

```bash
mvn clean install
```

Maven will automatically download the required dependencies from `pom.xml`.

---

# ▶️ Run the Application

Run the application using:

```bash
mvn org.codehaus.mojo:exec-maven-plugin:3.5.0:java -Dexec.mainClass=com.employeedemo.Main
```

If everything is configured correctly, you should see output similar to:

```text
Employee saved successfully!
Generated ID: 1

BUILD SUCCESS
```

---

# 🧪 Verify the Database

Connect to MySQL:

```bash
mysql -u root -p -h 127.0.0.1 -P 3306
```

Select the database:

```sql
USE employeedb;
```

Check the tables:

```sql
SHOW TABLES;
```

You should see:

```text
employee
```

Check the employee records:

```sql
SELECT * FROM employee;
```

Example output:

```text
+----+------------+-----------+--------+
| id | first_name | last_name | salary |
+----+------------+-----------+--------+
|  1 | Prajwal    | SM        |  50000 |
+----+------------+-----------+--------+
```

---

# 📁 Project Structure

```text
EmployeeDemo/
│
├── pom.xml
├── README.md
│
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── employeedemo/
        │           ├── Main.java
        │           └── Employee.java
        │
        └── resources/
            └── hibernate.cfg.xml
```

---

# 🧩 How It Works

The application follows this flow:

```text
Java Application
       ↓
Hibernate ORM
       ↓
MySQL JDBC Driver
       ↓
MySQL Server
       ↓
employeedb
       ↓
employee table
```

Hibernate handles the communication between the Java application and MySQL database.

The `Employee` class represents the employee entity, and Hibernate maps it to the `employee` table.

---

# 🐛 Troubleshooting

## MySQL command not found

If you see:

```text
mysql: command not found
```

Install MySQL:

```bash
sudo apt update
sudo apt install mysql-server -y
```

Then start it:

```bash
sudo service mysql start
```

---

## MySQL server is not running

Start MySQL:

```bash
sudo service mysql start
```

Check its status:

```bash
sudo service mysql status
```

---

## Cannot connect through MySQL socket

If you see:

```text
ERROR 2002 (HY000):
Can't connect to local MySQL server through socket
```

Try connecting through TCP:

```bash
mysql -u root -p -h 127.0.0.1 -P 3306
```

---

## Database does not exist

Enter MySQL:

```bash
sudo mysql
```

Create the database:

```sql
CREATE DATABASE employeedb;
```

Then:

```sql
exit;
```

---

## Access denied for MySQL root user

Make sure the password is configured correctly:

```bash
sudo mysql
```

Then:

```sql
ALTER USER 'root'@'localhost'
IDENTIFIED WITH mysql_native_password BY 'YOUR_PASSWORD';

FLUSH PRIVILEGES;
```

---

## Maven dependencies are missing

Run:

```bash
mvn clean install
```

Then run the application again:

```bash
mvn org.codehaus.mojo:exec-maven-plugin:3.5.0:java -Dexec.mainClass=com.employeedemo.Main
```

---

## Hibernate cannot connect to MySQL

Check that:

1. MySQL is running.
2. The database `employeedb` exists.
3. The username is `root`.
4. The password in `hibernate.cfg.xml` is correct.
5. The port is `3306`.
6. The JDBC URL is correct.

Expected JDBC URL:

```text
jdbc:mysql://127.0.0.1:3306/employeedb
```

---

# 🔒 Security

Do **not** commit passwords, API keys, or other secrets to GitHub.

Before pushing the project, make sure your real MySQL password is not present in:

```text
hibernate.cfg.xml
```

For a production application, credentials should be stored using environment variables or a secure secrets manager.

---

# 👨‍💻 Author

**Prajwal S M**

GitHub:

https://github.com/Prajwal-SM-2005

---

# 📄 License

This project is intended for educational and demonstration purposes.
