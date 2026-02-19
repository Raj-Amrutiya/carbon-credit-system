# Docker Setup for Carbon Credit System

This project uses Docker to containerize both the backend (Django) and frontend (React + Vite).

## Prerequisites

- Docker installed on your system
- Docker Compose installed on your system

## Quick Start

1. **Build and start all services:**
   ```bash
   docker-compose up --build
   ```

2. **Access the application:**
   - Frontend: http://localhost
   - Backend API: http://localhost:8000
   - Django Admin: http://localhost:8000/admin

3. **Stop the services:**
   ```bash
   docker-compose down
   ```

## Commands

### Build containers
```bash
docker-compose build
```

### Start services in detached mode
```bash
docker-compose up -d
```

### View logs
```bash
docker-compose logs -f
```

### View logs for specific service
```bash
docker-compose logs -f backend
docker-compose logs -f frontend
```

### Stop services
```bash
docker-compose stop
```

### Remove containers and volumes
```bash
docker-compose down -v
```

### Execute commands in running containers
```bash
# Backend shell
docker-compose exec backend python manage.py shell

# Create Django superuser
docker-compose exec backend python manage.py createsuperuser

# Run migrations
docker-compose exec backend python manage.py migrate
```

## Development Mode

For development with hot-reload, you can modify the docker-compose.yml or create a docker-compose.dev.yml file:

```yaml
# docker-compose.dev.yml
version: '3.8'

services:
  backend:
    build: ./backend
    command: python manage.py runserver 0.0.0.0:8000
    volumes:
      - ./backend:/app
    ports:
      - "8000:8000"
    environment:
      - DEBUG=1

  frontend:
    build:
      context: ./frontend
      target: build
    command: npm run dev -- --host
    volumes:
      - ./frontend:/app
      - /app/node_modules
    ports:
      - "5173:5173"
```

Run development mode:
```bash
docker-compose -f docker-compose.dev.yml up
```

## Using PostgreSQL

To use PostgreSQL instead of SQLite:

1. Uncomment the `db` service in docker-compose.yml
2. Update backend environment variables to use PostgreSQL
3. Rebuild containers

## Troubleshooting

### Port already in use
If ports 80, 8000, or 5432 are already in use, modify the port mappings in docker-compose.yml:
```yaml
ports:
  - "8080:80"  # Frontend on port 8080 instead
```

### Permission issues
```bash
sudo chown -R $USER:$USER .
```

### Clear everything and start fresh
```bash
docker-compose down -v
docker system prune -a
docker-compose up --build
```
