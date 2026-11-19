# Temperature API

## Prerequisites

- Docker 

## Getting Started

### Start
```bash
docker build -t simple-temperature-app . 
docker run --name simple-temperature-app_container -p 8081:8080 simple-temperature-app
```

### Restart
```bash
docker rm simple-temperature-app_container && docker run --name simple-temperature-app_container -p 8081:8080 simple-temperature-app
```

### Stop
```bash
docker stop simple-temperature-app_container
```

## API Endpoints

- `GET /temperature/:id` - получение случайной температуры по локации
- `GET /temperature?location={location}` - получение случайной температуры по локации
