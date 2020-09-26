# Startup-Valley - Demo Application

[![Build Status](https://travis-ci.org/pcp11/startup-valley.svg?branch=master)](https://travis-ci.org/github/pcp11/startup-valley)
[![GitHub](https://img.shields.io/github/license/pcp11/startup-valley)](https://github.com/pcp11/startup-valley/blob/master/LICENSE)
[![Deployed on Heroku](https://img.shields.io/badge/heroku-deployed-blueviolet.svg?logo=heroku)](https://startup-valley.herokuapp.com/)
[![versionkotlin](https://img.shields.io/badge/kotlin-1.3.71-brightgreen?logo=kotlin)](https://kotlinlang.org/)
[![versionspringboot](https://img.shields.io/badge/dynamic/xml?logo=spring&color=brightgreen&url=https://raw.githubusercontent.com/pcp11/startup-valley/master/pom.xml&query=%2F%2A%5Blocal-name%28%29%3D%27project%27%5D%2F%2A%5Blocal-name%28%29%3D%27parent%27%5D%2F%2A%5Blocal-name%28%29%3D%27version%27%5D&label=springboot)](https://github.com/spring-projects/spring-boot)
[![versionvuejs](https://img.shields.io/badge/dynamic/json?color=brightgreen&url=https://raw.githubusercontent.com/pcp11/startup-valley/master/frontend/package.json&query=$.dependencies.vue&label=vue&logo=vue.js)](https://vuejs.org/)
[![versionaxios](https://img.shields.io/badge/dynamic/json?color=brightgreen&url=https://raw.githubusercontent.com/pcp11/startup-valley/master/frontend/package.json&query=$.dependencies.axios&label=axios)](https://github.com/axios/axios)

A live deployment is available on Heroku: https://startup-valley.herokuapp.com/

## How to run locally

### 1. Backend

```
mvn clean install
java -jar backend/target/backend-0.0.1-SNAPSHOT.jar backend/src/main/resources/investments_VC.csv
```

### 2. Frontend

```
cd frontend/
yarn install
yarn serve
```