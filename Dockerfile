# Etapa de construção
FROM maven:3.9.4-eclipse-temurin-21 AS build

WORKDIR /app

# Copie o arquivo pom.xml e baixe as dependências
COPY pom.xml .
RUN mvn dependency:go-offline

# Copie o código-fonte
COPY src ./src

# Construa o projeto
RUN mvn clean package -DskipTests

# Etapa final: usar uma imagem menor para executar a aplicação
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

# Copie o arquivo JAR gerado na etapa de build
COPY --from=build /app/target/*.jar /app/app.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/app.jar"]