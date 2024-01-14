### Flight Search API
This API provides endpoints for managing users, airports, flights, and searching for flights.

## Tech Stack
Java
Spring Boot
Spring Data JPA
Spring Security
MySQL

## API Endpoints

# User Management (ADMIN only)

- GET /users - Get all users
- GET /users/{id} - Get user by ID
- DELETE /users/{id} - Delete user by ID

# Authentication

- POST /login - Login
- POST /register - Register as a user
- POST /admin/register - Register as an admin

# Airport Management (ADMIN only)

- GET /airports - Get all airports
- GET /airports/find?IATA={IATA} - Get airport by IATA code
- POST /airports/create - Create an airport
- PUT /airports/update?id={id} - Update an airport
- DELETE /airports/delete?IATA={IATA} - Delete an airport

# Flight Management (ADMIN only)

- GET /flights - Get all flights
- GET /flights/find?id={id} - Get flight by ID
- POST /flights/create - Create a flight
- PUT /flights/update?id={id} - Update a flight
- DELETE /flights/delete?id={id} - Delete a flight

# Flight Search (ADMIN and USER)

- GET /search/by-departure-airport-iata?departureAirportIATA={departureAirportIATA} - Search flights by departure airport IATA code
- GET /search/by-arrival-airport-iata?arrivalAirportIATA={arrivalAirportIATA} - Search flights by arrival airport IATA code
- GET /search/by-departure-airport-iata-and-arrival-airport-iata?departureAirportIATA={departureAirportIATA}&arrivalAirportIATA={arrivalAirportIATA} - Search flights by departure and arrival airport IATA codes
- GET /search/specify?departureAirportIATA={departureAirportIATA}&arrivalAirportIATA={arrivalAirportIATA}&departureDate={departureDate} - Search flights by departure airport IATA code, arrival airport IATA code, and departure date
- GET /search/specify-with-return?departureAirportIATA={departureAirportIATA}&arrivalAirportIATA={arrivalAirportIATA}&departureDate={departureDate}&returnDate={returnDate} - Search flights by departure airport IATA code, arrival airport IATA code, departure date, and return date

## How to user?
- Compile project with mvn clean install command.
- Start project using java -jar target/flight-search-api-0.0.1-SNAPSHOT.jar command.

## Usage
http://localhost:8080/swagger-ui/index.html#
