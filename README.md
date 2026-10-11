# DevBoard

A full-stack project management dashboard built with **React, TypeScript, Spring Boot microservices, and Docker Compose**.

DevBoard is a learning project focused on backend development, REST APIs, service-to-service communication, and containerization. The goal is to build a complete application while understanding the architectural decisions behind each component.

## Overview

DevBoard allows users to manage development projects and track their progress through a simple dashboard.

### Planned features

- Create and list projects.
- Update project status.
- Delete projects.
- View project statistics.
- Run the application using Docker Compose.

## Architecture

The application follows a microservices-based architecture with a separate frontend.

```text
                  ┌──────────────────────┐
                  │       Frontend       │
                  │  React + TypeScript  │
                  └──────────┬───────────┘
                             │ HTTP / REST
                  ┌──────────▼───────────┐
                  │    Project Service   │
                  │      Spring Boot     │
                  │      Spring Data JPA │
                  └──────────┬───────────┘
                             │
                  ┌──────────▼───────────┐
                  │      H2 Database     │
                  └──────────────────────┘

                  ┌──────────────────────┐
                  │    Stats Service     │
                  │      Spring Boot     │
                  └──────────┬───────────┘
                             │ HTTP / REST
                             └── Project Service
```

### Services

**Project Service**
- Manages project data and status.
- Exposes REST endpoints.
- Uses Spring Data JPA and an H2 in-memory database.

**Stats Service**
- Retrieves project data from the Project Service.
- Calculates project statistics.
- Exposes a REST endpoint for the dashboard.

**Frontend**
- Provides the user interface.
- Built with React, TypeScript, and Vite.
- Communicates with the backend through HTTP APIs.

## Tech Stack

| Technology | Purpose |
|---|---|
| Java | Backend development |
| Spring Boot | REST APIs and microservices |
| Spring Data JPA | Data persistence |
| H2 Database | In-memory database |
| React | User interface |
| TypeScript | Frontend type safety |
| Vite | Frontend development server |
| Docker | Application containerization |
| Docker Compose | Local multi-service orchestration |
| Maven | Java dependency management and builds |

## Project Structure

```text
devboard/
├── project-service/
│   └── src/
├── stats-service/
│   └── src/
├── frontend/
│   └── src/
├── compose.yaml
├── .gitignore
└── README.md
```

## Project Status

**In development.**

The project is being built incrementally, starting with the Project Service and its REST API, followed by service-to-service communication, the frontend, and containerization.

Features and setup instructions will be updated as development progresses.

## Getting Started

### Prerequisites

- Git
- Java JDK compatible with the project configuration
- Maven, or the included Maven Wrapper
- Node.js and npm
- Docker Desktop with Docker Compose

### Clone the repository

```bash
git clone https://github.com/antonioromdel/devboard.git
cd devboard
```

### Run with Docker Compose

Once the Docker configuration is complete:

```bash
docker compose up --build
```

To stop the containers:

```bash
docker compose down
```

Detailed instructions will be added as the application becomes runnable end to end.

## API Endpoints

The following endpoints are planned for the Project Service:

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/projects` | Retrieve all projects |
| POST | `/api/projects` | Create a project |
| PATCH | `/api/projects/{id}/status` | Update project status |
| DELETE | `/api/projects/{id}` | Delete a project |

The Stats Service will expose:

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/stats` | Retrieve project statistics |

The default local ports are planned as `8081` for the Project Service and `8082` for the Stats Service.

## Learning Objectives

This project is designed to explore:

- REST API design and HTTP methods.
- Separation of controller, service, and repository layers.
- Dependency injection in Spring Boot.
- Persistence with Spring Data JPA.
- Communication between independent services.
- React and TypeScript integration with backend APIs.
- Docker images and multi-container development environments.
- Git version control and project documentation.

## Future Improvements

Potential improvements include:

- Input validation and consistent error handling.
- Persistent database storage.
- Automated backend and frontend tests.
- API documentation with OpenAPI.
- Improved configuration and environment management.
- Production-ready deployment.

## License

This project is open source. 