# REST project

## Welcome to the REST Project, a simple application for managing todos and user registration.

## Introduction
The REST Project is a Spring Boot application that provides endpoints for creating todos, completing todos, registering users, and more. It is designed to be a simple and straightforward example of a RESTful API.


## How to Run
* **Clone the repository:** git clone https://github.com/DrDmlg/rest-project.git
* Ensure you have MySQL installed and running.
* Configure the database connection in application.properties or application.yml.
* **Build and run the application:** Access the application at http://localhost:8080/users

## Usage
### Todo Endpoints

* **POST /todos?userId={userId}** :  Create Todo
* **PUT /todos?id={todoId}** : Complete Todo

### User Endpoints
* **POST /users** : Register User
* **GET /users?id={userId}** : Get User by Id
* **DELETE /users/{userId}** : Delete User by Id

## Contact
If you have any questions or suggestions, feel free to reach out to me at *dorokhov.did@gmail.com* or through my GitHub page.
