# 📝 Simple Task Management System

A full-stack Task Management System using:

- 🔧 **Backend**: Spring Boot Microservices (Auth, Employee, Task)
- 🛡️ JWT Authentication
- 🌐 **Frontend**: React (Vite) + Tailwind CSS
- 🐘 **Database**: PostgreSQL
- 🐳 Docker & Docker Compose

---

## 📁 Project Folder Structure

```
task-management/
├── back/
│   ├── auth-service/
│   ├── employee-service/
│   └── task-service/
├── front/                     # React Vite App
├── docker-compose.yml
└── postgres-init.sql          # DB init script
```

---

## 🚀 How to Run the Project

### 🔹 Prerequisites

- Docker Desktop installed and running
- Node.js 18+ and npm
- Java 17+
- PostgreSQL (if not using Docker)

- hint : No `.env` files are used in this project.
  
---



## 🧩 Backend Setup (2 Options)

### ✅ Option 1: Using Docker (Recommended)

1. Open terminal and run:
   ```bash
   cd task-management
   docker-compose up --build
   ```

2. Docker will spin up:
   - Auth Service (port `8081`)
   - Employee Service (port `8082`)
   - Task Service (port `8083`)
   - PostgreSQL with DB init using `postgres-init.sql`

---

### 🛠️ Option 2: Manual (Without Docker)

> Open 3 terminals — one for each service.

#### 🔸 1. Auth Service
```bash
cd task-management/back/auth-service
.\mvnw.cmd clean install
.\mvnw.cmd spring-boot:run
```

#### 🔸 2. Employee Service
```bash
cd task-management/back/employee-service
.\mvnw.cmd clean install
.\mvnw.cmd spring-boot:run
```

#### 🔸 3. Task Service
```bash
cd task-management/back/task-service
.\mvnw.cmd clean install
.\mvnw.cmd spring-boot:run
```

🛑 Make sure PostgreSQL is running and the databases are created manually or with the `postgres-init.sql`.

---

## 🌐 Frontend Setup

```bash
cd task-management/front
npm install
npm run dev
```

📍 App runs on: [http://localhost:5173](http://localhost:5173)

---

## 🔐 Sample Credentials

Use this login:

```
Username: admin
Password: password
```

These are pre-seeded in the Auth service.

---

## ✅ Features

- JWT-based authentication
- CRUD for tasks
- Assign task to employee
- View employee list
- Task status: TODO / IN_PROGRESS / DONE
- Route protection for authenticated users
- Axios with JWT token header
- Logout feature
- Search by task title or status

---

## ✨ Bonus Features

- ✅ Docker + Docker Compose
- ✅ React Route Guards
- ✅ Error Redirect (401, 403, 404)
- ✅ Token Interceptor (Axios)
- ✅ Logout Button
- ✅ Title Search and status filter
- ✅ PostgreSQL auto-init with SQL script

---

## ⚠️ Known Issues

- No refresh token yet
- No backend-side pagination or sorting
- Employee name resolved in frontend (can improve by enriching backend response)

---

## 🛠 Technologies Used

- **Frontend**: React (Vite), Tailwind CSS, Axios
- **Backend**: Spring Boot, Spring Security, Spring Data JPA
- **Database**: PostgreSQL
- **Auth**: JWT-based login
- **DevOps**: Docker, Docker Compose

---

## 👨‍💻 Author

**Hashara Sankalpa**  
📧 hasharamsankalpam@gmail.com  
🔗 [GitHub](https://github.com/hasharas)  
🔗 [Portfolio](https://hasharaportfolio.netlify.app)  
🔗 [LinkedIn](https://linkedin.com/in/hashara-sankalpa)

---
