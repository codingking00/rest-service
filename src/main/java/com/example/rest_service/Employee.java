package com.example.rest_service;


public class Employee {
     private Integer employeeId;
  
     private String firstName;
  
     private String last_name; 

     private String email;

     private String title;

    public Employee() {}

    public Employee( Integer employee_id, String first_name, String last_name, String email, String title) 
    { 
  
  
        this.employeeId = employee_id;
  
        this.firstName = first_name;
  
        this.last_name = last_name; 
  
        this.email = email; 

        this.title = title;
  
            
    }


    public Integer getId()
    { 
     return employeeId;
    }
    public void setId(Integer id) {
          this.employeeId = id;
    }

    public String getFirstName() 
    { 
      return firstName;
    }
    public void setFirstName(String firstName) {
     this.firstName=firstName;
    }

    public String getLastName() 
    { 
  
         return last_name; 
    }
    
    public void setLastName(String lastName) {
     this.last_name=lastName;
    }

    public String getEmail() 
    { 
  
         return email; 
    }

    public void setEmail(String email) {
     this.email=email;
    }
    

    public String getTitle() 
    { 
     return title; 
    }

    public void setTitle(String title) {
     this.title=title;
    }

}
