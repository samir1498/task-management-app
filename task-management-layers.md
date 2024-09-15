# Task Management System Layer Breakdown

## 1. Domain Layer

### Entities

- Task
- User
- Project (if we want to group tasks)

### Value Objects

- TaskId
- UserId
- ProjectId
- TaskStatus (e.g., ToDo, InProgress, Done)
- Priority (e.g., Low, Medium, High)
- DateRange (for start and due dates)

### Domain Services

- TaskAssignmentService
- TaskPriorityService

### Domain Events

- TaskCreated
- TaskAssigned
- TaskStatusChanged
- TaskPriorityChanged

### Repository Interfaces

- ITaskRepository
- IUserRepository
- IProjectRepository

## 2. Application Layer

### Use Cases / Application Services

- CreateTaskUseCase
- AssignTaskUseCase
- UpdateTaskStatusUseCase
- UpdateTaskPriorityUseCase
- ListTasksUseCase
- CreateProjectUseCase
- AddUserToProjectUseCase

### DTOs (Data Transfer Objects)

- TaskDto
- UserDto
- ProjectDto

### Input Models

- CreateTaskInputModel
- AssignTaskInputModel
- UpdateTaskStatusInputModel
- UpdateTaskPriorityInputModel

### Interfaces for External Services

- INotificationService
- IEmailService

## 3. Infrastructure Layer

### Repository Implementations

- CosmosDbTaskRepository
- CosmosDbUserRepository
- CosmosDbProjectRepository

### External Services Implementations

- AzureSignalRNotificationService
- AzureNotificationHubService
- SendGridEmailService

### Data Access

- CosmosDbContext

### Authentication/Authorization

- AzureAdB2CAuthenticationService

### Logging

- ApplicationInsightsLogger

## 4. Presentation Layer

### API Controllers

- TasksController
- UsersController
- ProjectsController

### ViewModels (if needed)

- TaskViewModel
- UserViewModel
- ProjectViewModel

### Middleware

- ExceptionHandlingMiddleware
- LoggingMiddleware
- AuthenticationMiddleware

### Angular Components

- TaskListComponent
- TaskDetailComponent
- CreateTaskComponent
- ProjectListComponent
- UserProfileComponent

### Angular Services

- TaskService
- ProjectService
- AuthService
- NotificationService

### Angular Models

- Task
- User
- Project

## Additional context and explanations for each layer

1. Domain Layer:
   This is the core of your application, containing business logic and rules. It should be independent of other layers and frameworks.

   - Entities are objects with an identity that persists over time.
   - Value Objects are objects defined by their attributes, without a distinct identity.
   - Domain Services contain business logic that doesn't naturally fit within an entity or value object.
   - Domain Events represent something significant that has happened in the domain.
   - Repository Interfaces define how to access and persist entities.

2. Application Layer:
   This layer orchestrates the flow of data to and from the domain layer and provides a separation between the domain layer and the outside world.

   - Use Cases represent the actions a user can perform in your system.
   - DTOs are used to transfer data between processes, helping to decouple layers.
   - Input Models represent the data coming into your application.
   - Interfaces for External Services define how your application interacts with external systems.

3. Infrastructure Layer:
   This layer implements interfaces defined in the domain and application layers, dealing with databases, external services, and frameworks.

   - Repository Implementations provide concrete implementations of the repository interfaces.
   - External Services Implementations handle interaction with external systems like Azure services.
   - Data Access handles database-specific logic.
   - Authentication/Authorization implements security-related functionality.

4. Presentation Layer:
   This layer is responsible for presenting information to the user and interpreting user commands.

   - API Controllers handle HTTP requests and responses.
   - ViewModels represent the data and operations available for the user interface.
   - Middleware handles cross-cutting concerns like logging and error handling.
   - Angular Components and Services handle the user interface and interaction with the backend.
