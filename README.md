# Spring Boot Starter K8S Template

## What is this?

This is a template repository for kicking off a cloud native spring boot java microservice.

## What makes this cloud native?

It's solely focused on deployment to kubernetes, the primary build artifacts of the repository are a OCI image and a helm chart. The helm chart is dynamically generated using jkube and it's associated gradle plugin.

## What opinions have been added to this?

- Gradle
- Spring Boot
- Spring MVC
- Spring JPA and JDBC
- Tomcat
- JKube (Kubernetes Deployment and Development Tools)
- Liquibase

## How do I deploy?

Use `make deploy`, if the namespace does not exist already run `make create-namespace`

## How do I run locally?

Use `make run`.

## How do I run locally outside of a container?

If you wish to run directly in your IDE:

1. Run `docker-compose up -d` to start the postgres database server.
2. Run `./gradlew update bootRun`, `update` runs the migrations and `bootRun` launches the spring boot application

## Available Make Targets

| Target             | Description                                                  |
| ------------------ | ------------------------------------------------------------ |
| jar                | Builds the standalone jar                                    |
| image              | Builds the OCI image                                         |
| run                | Runs the OCI image using docker locally                      |
| create             | Creates the kubernetes namespace a deploy will go to         |
| build              | Runs the gradle tasks to build the helm chart                |
| build-dependencies | Runs the helm tasks to pull in sub chart dependencies        |
| deploy             | Deploys the chart to your current kubernetes context         |
| template           | Renders the chart templates to standard kubernetes manifests |
| kics               | Scan the chart resources with KICS                           |

# Post Template Use Checklist

- [ ] Find and replace all references to `io.github.bryopsida` with appropriate values for your project
- [ ] Find and replace all references to `spring-boot-starter` with appropriate values for your project
- [ ] Find and replace all references to `spring-boot-starter-tomcat` with appropriate values for your poject
- [ ] Find and replace all references to `bryopsida` with appropriate values for your project
- [ ] Adjust renovate.json (or remove) settings to meet your needs
- [ ] After a successful image build, create your first release to trigger a helm publish, this is needed for the upgrade tests to pass
