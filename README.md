This Application uses H2 - In Memory Database
auto-ddl -set as create-drop
Efficient Data Retrieval with Cursor-Based Pagination

When working with enterprise datasets, it’s common to deal with millions of records. Fetching them in a single query is not only inefficient but also dangerous — it can overload the database, consume too much memory, and cause timeouts.

Our API is designed to safely and efficiently retrieve large datasets using a combination of:

Spring Data JPA Pageable → for limiting result size.

Offset-ID (cursor-based pagination) → for fast navigation through large tables.
pagination + offset-id (a.k.a. keyset or cursor-based pagination)





SWAGGER ENDPOINT http://localhost:8080/swagger-ui/index.html 

Actuators
http://localhost:8080/actuator/health

http://localhost:8080/actuator/info

http://localhost:8080/actuator/metrics

http://localhost:8080/actuator/env

Sample JSON for PU Request

{
    "name": "John Doe",
    "designation": "Software Engineer",
    "email": "john.doe@example.com",
    "phone": 9876543210,
    "addresses": [
      {
        "street": "123 Main Street",
        "city": "San Francisco",
        "state": "CA",
        "zip": "94105",
        "country": "USA"
      },
      {
        "street": "456 Market Street",
        "city": "San Francisco",
        "state": "CA",
        "zip": "94107",
        "country": "USA"
      }
    ],
    "assets": [
      {
        "name": "Laptop",
        "description": "Dell Latitude 5420",
        "serialNumber": "SN123456",
        "location": "HQ Office",
        "status": "ASSIGNED"
      },
      {
        "name": "Mobile Phone",
        "description": "iPhone 13",
        "serialNumber": "SN654321",
        "location": "Remote",
        "status": "ASSIGNED"
      }
    ]
  }
