FROM eclipse-temurin:11.0.20_8-jre

ADD build/libs/opentelemetry-examples-prometheus-*-SNAPSHOT-all.jar /app.jar

ENTRYPOINT java -cp app.jar io.opentelemetry.example.prometheus.PrometheusExample 19090