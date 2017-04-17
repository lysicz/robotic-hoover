Application uses Spring Boot and Spring Data solutions and MongoDB database. I used Spring Tool Suite as a dev environment.

1. How to start the application.

To start the application run the robotic-hoover-0.0.1-SNAPSHOT.jar file. In the Windows environment double click the file. If you are using the command prompt type "java -jar robotic-hoover-0.0.1-SNAPSHOT.jar". 
It's possible to create a war file but requires changes in the application pom file.

2. Execution settings:

By default application runs on embeded Tomcat application server. The default port is 8080. By default application tries to connect to the MongoDB database which should be installed and started on the localhost and should accept connections using standard 27017 port.
It's possible to change application port and database location using application.properties file. The example of the application.properties file can be found in the example directory. The application.properties file should be in the /config directory inside application directory.

There is a compiled jar + config file in the GitHub repository (example folder). I know it shouldn't be there. You can use it in case of any compiling problems.

3. Possible future improvements

I was't able to test my solution on Mac and Linux.

Integration tests should be added on the REST controller level. Spring supports REST controller integration test but I wasn't able to create them. It will require some additional investigation and research on my side. 
I don't have much experiance with REST services so, probably, the request errors handling can be done different way. I need more experience to find my way or someone who will show me the best practice.

If MongoDB is not available application throws an exception on the startup (I was't able to find how to get rid of this exception or at least handle it). Application should response with valid data but request processing will take about a minute (default MongoDB connection timeout is 30 seconds).