# Usa uma imagem oficial com JDK 17
FROM eclipse-temurin:17-jdk

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o JAR gerado para dentro da imagem
COPY target/coopera-rs-1.0.0.jar app.jar

# Expõe a porta da aplicação (padrão do Spring Boot)
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
