# NinjaOne Backend Interview Project

The project is configured to use an in-memory H2 database that is volatile. 

## Starting the Application

Run the `BackendInterviewProjectApplication` class

You will find all REST services in NinjaOneBackend.postman_collection

## H2 Console 

In order to see and interact with your db, access the h2 console in your browser.
After running the application, go to:

http://localhost:8080/h2-console

Enter the information for the url, username, and password in the application.yml:

```yml
url: jdbc:h2:mem:localdb
username: sa 
password: password
```

## Future Work

* Implementation of unit testing.
* Implementation of authentication.
* Response wrapping to a standard object.  
* Error logging.
* Customer entity and services.