# toDoList
This application implements a simple functionality of the to-do list

## Usage

1. Place "toDoList-1.0.1.jar" and "application.properties" on your computer. For example, on the Desktop;
2. Open terminal (console);
3. Create database on your MySQL server:
	* In the console log in to the MySQL client
	* Inter the command: "CREATE DATABASE {$database_name}"
4. Rewrite the application.properties file for your MySQL database:
	* spring.jpa.hibernate.ddl-auto=create
	* spring.datasource.url=jdbc:mysql://{$host}:{$port}/{$database_name}
	* spring.datasource.username={$username}
	* spring.datasource.password={$password}
5. Run the toDoList-1.0.1.jar file:
	* In the console go to the appropriate directory: "cd Desctop"
	* Run toDoList-1.0.1.jar: java -jar toDoList-1.0.1.jar