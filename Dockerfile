# Utilisation d'une image légère avec Java 17 (version classique)
FROM openjdk:17-jdk-alpine

# On copie le fichier .jar généré par Maven depuis le dossier target vers le conteneur
COPY target/*.jar app.jar

# Commande exécutée au démarrage du conteneur
ENTRYPOINT ["java", "-jar", "/app.jar"]