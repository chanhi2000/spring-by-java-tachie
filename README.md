# `batch-processing-demo`

## What's Used?

![shield-springboot][shield-springboot]
![shield-java][shield-java]
![shield-kotlin][shield-kotlin]
![shield-gradle][shield-gradle]
![shield-mysql][shield-mysql]
![shield-docker][shield-docker]

## Prerequisite(s)
- Intellij Idea CE
- MySQL Database (`mysql:8.0.29-oracle`)
- Postman
 
### Setup Databse
- Docker is very convenient for prepping
- Run the following commands

#### 1. Download Docker Image
```sh
docker pull mysql:8.0.29-oracle
```
#### 2. Run the Docker Image
```sh
docker run -d -it
--name mysql-test
-p 3306:3306
-e MYSQL_ROOT_PASSWORD=Password
-e MYSQL_DATABASE=javatechie 
mysql:8.0.29-oracle
```

#### 3. Troubleshooting
For MySQL 8.x or later, you may encounter the following error when attempting to connect
> public key retrieval is not allowed

Modify JDBC Url as followed
```
jdbc:mysql://localhost:3306/javatechie?allowPublicKeyRetrieval=true
```

### To Test API
If you don't have Postman to send POST request, use the following `curl`

```sh
curl -X POST http://localhost:9191/jobs/importCustomers
```

## Task(s) Completed
- [x] ~~initialize project~~
- [x] ~~Configure necessary components~~
- [x] ~~Setup Basic Batch Operation(s)~~
- [x] ~~Setup Concurrent Batch Operation(s)~~
- [x] ~~Setup CustomerProcessor (add users from United States)~~

## References

- [IQ | Spring Batch for Beginners | Process Million of Record Faster Using Spring Batch | JavaTechie][youtube-tut]


[youtube-tut]: https://www.youtube.com/watch?v=hr2XTbKSdAQ

[shield-springboot]: https://img.shields.io/badge/springboot-2.6.7-6DB33F?logo=springboot&logoColor=6DB33F&style=flat-square
[shield-java]: https://img.shields.io/badge/Java-11-f3812a?logo=java&logoColor=f3812a&style=flat-square
[shield-kotlin]: https://img.shields.io/badge/Kotlin-1.6.21-0095D5?logo=kotlin&logoColor=0095D5&style=flat-square
[shield-gradle]: https://img.shields.io/badge/Gradle-7.1-abd759?logo=gradle&logoColor=abd759&style=flat-square
[shield-mysql]: https://img.shields.io/badge/MySQL-8.0.29-4479A1?logo=mysql&logoColor=4479A1&style=flat-square
[shield-docker]: https://img.shields.io/badge/Docker-8.0.29-2496ED?logo=docker&logoColor=2496ED&style=flat-square