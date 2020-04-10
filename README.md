#Hexagonal Architecture

Hexagonal Architecture is a software architecture that allows an application to be equally driven by users, programs, automated tests, or batch scripts and to be developed in isolation from its run-time target system. The intent is to create an application to work without either a User Interface or a database so that we can run an automated regression test against the application, work with an application when a run-time system, such as a database is not available, or integrate applications without user interface.

Have a look at these tests belows. Then you can easily see that if want to create a listener for any queue, for example, you just need to create an another adapter and use the same business logic.
* ConsoleAnagramAdaptorTest
* AnagramsControllerTest

### Reference 
https://dzone.com/articles/hexagonal-architecture-in-java-2