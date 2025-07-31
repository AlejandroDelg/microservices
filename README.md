# Currency Microservice App
App created using Java with SpringBoot and Maven

### spring-cloud-config-server
Application for global configuration of all APIs
### naming-server
Discovers and monitor all microservices. It uses netflix Eureka
### Currency-exchange-microservice
Compare two currencys. It uses H2 as a memmory database
### currency-conversion-service
Calls currency-exchange-microservice for getting the currency comparison and adds quantity parameter as the mapping
### limits-service
Gets default values from spring-cloud-config-server
