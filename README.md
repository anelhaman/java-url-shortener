# Java URL Shortener
A lightweight URL shortener service built with Spring Boot and PostgreSQL.

### Features
- Shorten long URLs
- Redirect short URLs to their original destinations
- Persistent storage with PostgreSQL

### Prerequisites
- Java 17+
- Docker & Docker Compose
- Maven 3.9+

## Getting Started
### Clone the Repository
```
git clone https://github.com/anelhaman/java-url-shortener.git
cd java-url-shortener
```

#### Build and Run
1. Build the application:

```
mvn clean package
```

2. Start services using Docker Compose:

```
docker-compose up --build
```

3. The application runs at http://localhost:8080.

## API Endpoints
1. Shorten URL: `POST /api/shorten`

- Request:

```
{
    "url": "https://example.com"
}
```

- Response:

```
{
    "short_url": "abc123"
}
```

Redirect: `GET /{shortUrl}`
- Redirects to the original URL.

## Configuration
- Database: PostgreSQL credentials are defined in docker-compose.yml and application.properties.

## License
This project is licensed under the MIT License.