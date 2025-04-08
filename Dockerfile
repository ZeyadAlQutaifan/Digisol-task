# Stage 1: Build with Maven
FROM maven:3.9.6-eclipse-temurin-17-alpine AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the app
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar", "--package.base-url=https://offersvc.expedia.com/offers/v2/getOffers", "--package.scenario=deal-finder", "--package.uid=test", "--package.product-type=Package", "--package.client-id=test", "--package.page=foo"]
