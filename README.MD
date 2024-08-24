# Transfer Service

## Описание
Transfer Service — это REST API для перевода денег с одной банковской карты на другую. Сервис реализован с использованием Spring Boot и предоставляет два основных эндпоинта:

1. Перевод денег с одной карты на другую.
2. Подтверждение операции с помощью кода подтверждения.

## Функциональные возможности
- **Перевод денег**: Позволяет перевести деньги с одной банковской карты на другую, учитывая сумму и валюту перевода.
- **Подтверждение операции**: Позволяет подтвердить выполненную операцию с помощью кода подтверждения.## Команды для запуска

1. **Клонируйте репозиторий**:

   ```bash
   git clone https://github.com/ваш_репозиторий.git
   cd transfer-service

2. Соберите проект: Убедитесь, что у вас установлен Gradle или Maven. Выполните команду**:
   ./gradlew build

3. **Запустите Docker Compose: Убедитесь, что Docker и Docker Compose установлены и запущены. Выполните команду**
   docker-compose up
## Эндпоинты API

### Перевод денег

- **URL**: `/transfer`
- **Метод**: `POST`
- **Описание**: Этот эндпоинт позволяет перевести деньги с одной банковской карты на другую.

- **Запрос**:

  **URL**: `http://localhost:5500/transfer`

  **Метод**: `POST`

  **Заголовки**:
  ```http
  Content-Type: application/json

### Подтверждение операции

- **URL**: `/confirmOperation`
- **Метод**: `POST`
- **Описание**: Этот эндпоинт позволяет подтвердить операцию с помощью кода подтверждения.

- **Запрос**:

  **URL**: `http://localhost:5500/confirmOperation`

  **Метод**: `POST`

  **Заголовки**:
  ```http
  Content-Type: application/json

## Диаграмма компонентов

@startuml
!define RECTANGLE class
!define DATABASE database
!define INTERFACE interface
!define ACTOR actor

' Define Actors
ACTOR User

' Define Frontend
RECTANGLE "Frontend\n(React Application)" as Frontend {
User --> Frontend : Uses Application
}

' Define Backend
RECTANGLE "Backend\n(Spring Boot Application)" as Backend {
Backend --> Frontend : Provides REST API
}

' Define External Systems
DATABASE "External Bank System" as BankSystem

' Define API Endpoints
INTERFACE "Transfer API" as TransferAPI {
+POST /transfer
+POST /confirmOperation
}

' Relation


