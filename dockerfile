# Use uma imagem base do Maven para compilar o projeto
FROM maven:3.8.6-openjdk-17 AS build

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o arquivo pom.xml e outros arquivos necessários para o diretório de trabalho
COPY pom.xml .

# Baixe as dependências do Maven (sem construir o projeto ainda)
RUN mvn dependency:go-offline

# Agora copie o restante do código para o contêiner
COPY src ./src

# Execute o Maven para construir a aplicação
RUN mvn clean package -DskipTests

# Etapa final: use uma imagem menor do OpenJDK para rodar a aplicação
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho no contêiner final
WORKDIR /app

# Copie o arquivo JAR gerado da etapa de build
COPY --from=build /app/target/LandingPageCoracaoAlgodao-0.0.1-SNAPSHOT.jar /app/app.jar

# Exponha a porta que a aplicação Spring Boot irá rodar
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
