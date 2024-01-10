plugins {
	java
	id("org.springframework.boot") version "3.2.1"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "shin.com"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-web-services")
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	implementation("org.mariadb.jdbc:mariadb-java-client")
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.3")

	implementation("org.apache.commons:commons-lang3:3.14.0")
	implementation("com.fasterxml.uuid:java-uuid-generator:4.3.0")


	implementation("com.navercorp.lucy:lucy-xss:1.6.3")


}

tasks.withType<Test> {
	useJUnitPlatform()
}
