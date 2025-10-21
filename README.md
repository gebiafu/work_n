# Monorepo: Backend (Spring Boot) + Frontend (Vue 3 + Vite) + Docker Compose

This repository bootstraps a monorepo for a typical web application stack:

- backend/: Spring Boot 2.7.6 (Java 8), Maven
- frontend/: Vue 3 + Vite with Vue Router, Pinia, Axios, and Element Plus
- docker-compose.yml: Local Postgres for development

## Prerequisites

- Java 8 (JDK 1.8)
- Maven 3.6+
- Node.js 16+ (recommended 18+)
- Docker & Docker Compose

## Quick Start

1) Start the development database

```bash
docker compose up -d
```

This starts a Postgres instance on localhost:5432 with database `app_db` (user: `app_user`, password: `app_password`).

2) Run the backend

```bash
cd backend
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

The backend will run on http://localhost:8080 and exposes a simple health endpoint at `GET /api/health`.

3) Run the frontend

```bash
cd frontend
npm install
npm run dev
```

The frontend dev server runs on http://localhost:5173. It proxies API requests starting with `/api` to the backend at http://localhost:8080 for local development.

## Configuration

- Backend configuration (multi-environment) lives under `backend/src/main/resources/`:
  - `application.yml` (base)
  - `application-dev.yml` (development)
  - `application-prod.yml` (production placeholder)
  - `application-test.yml` (test placeholder)
- CORS is enabled for development so the frontend can access the backend.
- Flyway migrations are under `backend/src/main/resources/db/migration/` with a baseline migration (`V1__baseline.sql`) and a reserved placeholder for Quartz tables (`V2__quartz_tables_placeholder.sql`).

## Project Structure

```
.
├── backend/              # Spring Boot (Maven) project
├── frontend/             # Vue 3 + Vite app
├── docker-compose.yml    # Local Postgres
├── .editorconfig
├── .gitignore
└── README.md
```

## Notes

- The repository is intended as a starting point. Add modules, features, and CI as needed.
- The default CORS setup is permissive for ease of local development. Harden this before production.
