/** UPLOAD TO GITHUB */

package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

public class Start {
    
    
    public static void main(String[] data) {
        //Initialization
        ApplicationContext context;
        context = SpringApplication.run(Setup.class); 
        //If the system is ok, print
        System.out.println("Spring Framework Load Successfully");
        myConnector connector = context.getBean(myConnector.class);
        
        //==== EXAMPLE WRITING TO DATABASE ====//
        Branch b = new Branch();
        b.name = "Example";
        b.space = 150.00;
        //connector.save(b);
        
        //==== EXAMPLE READING FROM DATABASE ====//       
        Iterable<Branch> all = connector.read(999.00);       //findBySpaceGreaterThanEqual Spring will generate code for us. It will print 2 branch that has greater than 75.00
        
        for (Branch x : all) {                                    //By using for enhance for (Branch b : all)
            System.out.println(x.name + " " + x.space);           //System.out.println(b.name);
        }
        //connector.delete(b.name);
        //SpringApplication.exit(context);
    }
    
}

@SpringBootApplication
class Setup {
    @Bean
     DriverManagerDataSource connect() {
        return new DriverManagerDataSource(connectionString);
     }
    String dbname = "random"; //database which we will connect
    String username = "jeff"; //username of the user
    String password = "bezos"; //password of the user
    String connectionString = "jdbc:mysql://127.0.0.1/" + dbname + "?user="+ username +"&password="+password;
}

@Controller
class Control {
    @RequestMapping("/") //Instead of index.html go to 
    String show() {      //  |
                         //  v
        return "sample"; //"sample" = "sample.html"
    }
    
    //and then go to http://localhost:3000/
@Component
class Example {
    @Autowired myConnector connect;
    
}
    
}

/* 
Spring Boot Data JDBC

+----------+              +-------+
|  Java    | <----------> | MySQL |
+----------+              +-------+

1. Print to standard output @Component
2. Create Web Service       @RestController
                            @Controller @ResponseBody
ไม่ว่าจะเชื่อมต่อตัวไหนต้องใช้ Connection String

connectionString = "jdbc:mysql://127.0.0.1/random?user=jeff&password=bezos";

//Database name = random

+------+
|UBUNTU|----> Terminal
+------+

sudo mysql <enter>
password
show databases;                                                         //Show all databases.
create database <database-name> default charset 'UTF8';                 //Create database and set default charset to allow UTF-8.
use <database-name>;                                                    //Use database.
create table <tablename>(col1, col2, col3);                             //Create table.
insert into <database-name>(col1, col2, col3) values(..., ..., ...);    //Insert data into database.
grant all on <database-name>.* to <user>;                               //Allow grant access.

KEYWORDS:

SQL              
int     
bigint
float
double
char
varchar(80)
date
unique
not null 
autoincrement (or identity in SQL Server)
+--------+
|Example:|
+--------+
create table staff(id int unique not null auto_increment, email varchar(200) unique not null, password varchar(200) not null, first_name varchar(200) not null, last_name varchar(200), gender char, salary float);

create table branch(id int unique not null auto_increment, name varchar(200) not null, area float);

insert into branch(name, area) values('New York', 75.00);   //go over auto increment and add name and area and values set to New York and area to 75.00
insert into branch(name, area) values('London', 60.0);      
insert into branch(name, area) values('Paris', 80.0);
insert into branch(name, area) values('Tokyo', 70.0);


*/