## Spring Data MongoDB | MongoTemplate | Criteria Query
Dans ce repo, nous allons voir comment implémenter la requête Spring Data MongoDB dans Spring Boot avec les méthodes custom repository MongoTemplate.

### Technologies
---
- Java 11
- Spring Boot 2.7.7
- Spring Data MongoDB
- Lombok
- Maven 3+
- MongoDB
- MapStruct

### Exemples réalisés
---
- CRUD
- Toutes les requêtes de recherche de MongoTemplate
- 

### Exécuter et tester les APIs
---
- Exécuter l'application `mvn spring-boot:run`
- Importer dans Postman la collection `mongoTemplate-criteria-query.postman_collection.json` pour tester les APIs
- Vous pouver utiliser aussi l'url du Swagger ou importer l'url Swagger dans Postman. Les descriptions OpenAPI seront disponibles au chemin /v3/api-docs par défaut :
    - http://localhost:8081/v3/api-docs/
    - http://localhost:8081/swagger-ui/index.html