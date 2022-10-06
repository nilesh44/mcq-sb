# this branch of mcq-sb is created for deploying on external tomcat server with extenalized application.yml and file-logging on tomcat server.

changes required for deploying spring boot application as war file.

### step 1 :
* Add plugin id 'war'
![image](https://user-images.githubusercontent.com/44174633/194354189-a52e55cc-0660-4dbf-a12e-a874f31a98d3.png)

### step 2 :
* Extend extends SpringBootServletInitializer with mainApplication class and overrRide configure method
![image](https://user-images.githubusercontent.com/44174633/194355147-4c873e48-77c6-4d7d-8dc1-75dc19b96f6b.png)

### step 3 : add context path 
* Note: make sure that context-path and name of war file should be same
![image](https://user-images.githubusercontent.com/44174633/194355573-b6969055-bc11-4364-a688-64d54d3b96e1.png)

![image](https://user-images.githubusercontent.com/44174633/194355833-d8b9525b-b605-47c0-94ab-e2b90d23e8f7.png)

### step 4 : externalized application.yml
* Override method configure of main CLass
* Note provide correct path , ${catalina.base} is working directory of tomcat which refer tomcat folder
![image](https://user-images.githubusercontent.com/44174633/194356344-6a8dc18e-8ca2-4f04-85c9-6daa470d2e6a.png)

![image](https://user-images.githubusercontent.com/44174633/194356764-de318acd-3595-4c02-8b74-3d4d6d98d58b.png)

### step 5 : file-logging 
* Add logback-spring.xml in resource folder
![image](https://user-images.githubusercontent.com/44174633/194357170-91a35dbd-bfa6-4a9f-ad3b-fd5b56c1e31b.png)

* Provide correct path for logs
![image](https://user-images.githubusercontent.com/44174633/194357372-854b2f2e-68b8-42bb-9dea-7816adef31f8.png)

### step 6 : before creating war file please remove application.yml from the project source folder.

### step 7 : if buid support gradle then create build with ./gradlew clean build  and rename .war file to similar to contextpath
    . add .war file in tomcat webapps.
    
    ![image](https://user-images.githubusercontent.com/44174633/194358394-4ec30a16-8e17-4424-9ab0-437877d86ff9.png)
    
    ![image](https://user-images.githubusercontent.com/44174633/194358636-b4a7acc5-9c7c-413f-a179-22044a19c7c4.png)
    
    copy this build to webapps folder of tomcat.
    ![image](https://user-images.githubusercontent.com/44174633/194358828-8b1737c0-d38a-44a7-88b9-dffec6a8e42a.png)
    
   ### step 8 : test application 
   ![image](https://user-images.githubusercontent.com/44174633/194359318-ccaa7e74-f174-496a-9be2-73d51b7f9d19.png)
   
   ### step 9 : check logs.
   ![image](https://user-images.githubusercontent.com/44174633/194359551-8c53efa8-88dd-4f07-812e-6afafc43f731.png)





