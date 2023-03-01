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