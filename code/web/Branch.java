package web;

import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Indexed;
import org.springframework.stereotype.Repository;

@Table(name="branch")
class Branch {
    
    @Id 
    public int id;          //If three of this are the exact same result, it can be used instantly.
    
    public String name;
    
    @Column("area")         //if different variable can use Column
    public double space;

}

//CrudRepository เอาไว้เขียนอ่านฐานข้อมูลโดยไม่ต้องเขียน Method = Create Read Update Delete; Basic operation 4 times.
@Repository @Indexed //จะดึงไป Main 
interface myConnector extends CrudRepository<Branch, Integer> {  //require 2 type parameter 1. class name and then 2. @Id integer or any type.

    Iterable findBySpaceGreaterThanEqual(double x); //Generic Name can be read by Spring
    Iterable findByName(String s);                  //Generic Name
    
    @Query("SELECT * FROM branch WHERE area <= :limit")                                          //Custom Method = @Query("SELECT * FROM branch WHERE area <= 75.00") 
    Iterable read(double limit);                                                                 //Custom Method with query    

    
}


//@Component
//@Repository
//@Service
