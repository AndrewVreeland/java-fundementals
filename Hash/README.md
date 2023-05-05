This app Hash is a simple app that utilizes Bcrypt in order to hash all passwords stored on the site. We are utlizing PGAdmin 4 as our database. This app allows
for users to log in and log out of.


To build and run the "Hash" project from the command line,
navigate to the project directory using the terminal and run the command
"./gradlew bootRun". This will build the project and start the Spring Boot application.

Before running the application, you need to set up a Postgres server with a database named
"Hash". You can download and install Postgres from their official website,
or use a cloud-based service like Heroku or AWS. Once you have a Postgres server running,
create a new database named "recipes".

Next, update the "src/main/resources/application.properties"
file in the project directory with your Postgres server's username and password.

place the lines below within the application.properties file
spring.datasource.username=your_username_here
spring.datasource.password=your_password_here