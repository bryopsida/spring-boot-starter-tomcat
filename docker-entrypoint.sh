#!/usr/bin/env sh
exec java -jar -Dspring.profiles.active=k8s /app/app.jar 