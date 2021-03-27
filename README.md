## Spring Boot Demo application with Rest, Spring Data and Spring Specifications

Uses H2 DB

## Usage example
GET localhost:8080/employee </br>
GET localhost:8080/employee?name=Ioan </br>
GET localhost:8080/employee?name=Ioan&department=HR </br>

GET localhost:8080/department </br>
GET localhost:8080/department?size=10&page=2 </br>
GET localhost:8080/department?size=100 </br>
GET localhost:8080/department?name=Mark </br>

## Docker
docker build -t rest-data-demo . </br>
docker run -p 8080:8080 rest-data-demo
