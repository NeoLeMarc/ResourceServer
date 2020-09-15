FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY target/ca.crt /etc/ssl/certs/kubemaster01.kubernetes.ka.xcore.net
COPY target/prod.properties /prod.properties
RUN $JAVA_HOME/bin/keytool -keystore $JAVA_HOME/lib/security/cacerts -trustcacerts -storepass changeit -noprompt -importcert -alias kubemaster01 -file /etc/ssl/certs/kubemaster01.kubernetes.ka.xcore.net 
ENTRYPOINT ["java", "-jar", "/app.jar","-Xmx3G","-Xms512m", "/prod.properties"]
