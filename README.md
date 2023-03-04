# SpringApplication
Using Java Spring framework to connect to MySQL and perform Business Logic while displaying the file back to Web Page or App.

## Requirement
1. Maven
2. MySQL
3. Springframework

### For Ubuntu 
``` sudo apt install mysql-server ```<br>

### For Windows CD into the mysql directory: 
Open the first terminal to initialize mysqld to get temporary password:<br>
``` \bin\mysqld.exe --console --initialize ```<br>
Open the second terminal to login as root with temporary password:<br>
``` \bin\mysql.exe --user root --password ```<br>
Change the password by using:<br>
``` alter user root@localhost identified by '<Yourpassword>'; ```<br>
Start the database server:<br>
```\tools\mysql\bin\mysqld --console```

### Check your SQL status by: show databases;  
``` 
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| sys                |
+--------------------+
``` 

## Pom.xml dependencies requirements
```<dependencies>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.32</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jdbc</artifactId>
            <version>3.0.2</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <version>3.0.2</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-freemarker</artifactId>
            <version>RELEASE</version>
        </dependency>
      </dependencies>
