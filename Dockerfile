FROM maven:3.9.6-amazoncorretto-17 AS demo-spring-boot-api-simple-build

ENV LANG=C.UTF-8 \
  APP_HOME=/usr/src/app \
  MAVEN_CONFIG=/root/.m2 \
  MAVEN_BUILD_REPO=/usr/share/maven/ref/repository

WORKDIR $APP_HOME

COPY pom.xml ./

RUN mvn \
  -Dmaven.main.skip \
  -Dmaven.test.skip=true \
  -Dmaven.repo.local=${MAVEN_BUILD_REPO} \
  clean \
  dependency:resolve-plugins

RUN mvn \
  -Dmaven.main.skip \
  -Dmaven.test.skip=true \
  -Dmaven.repo.local=${MAVEN_BUILD_REPO} \
  -Dspring-boot.repackage.skip \
  dependency:go-offline


FROM maven:3.9.6-amazoncorretto-17 AS demo-spring-boot-api-simple-development

ENV LANG=C.UTF-8 \
  APP_HOME=/usr/src/app \
  MAVEN_CONFIG=/root/.m2 \
  MAVEN_BUILD_REPO=/usr/share/maven/ref/repository

WORKDIR $APP_HOME

COPY --from=demo-spring-boot-api-simple-build ${MAVEN_BUILD_REPO} ${MAVEN_BUILD_REPO}
# COPY --from=demo-spring-boot-api-simple-build ${MAVEN_CONFIG} ${MAVEN_CONFIG}

# COPY --from=demo-spring-boot-api-simple-build /root/.m2/repository /usr/src/app

COPY . .

CMD mvn spring-boot:run
