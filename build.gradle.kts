import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {

	id("org.springframework.boot") version "2.3.4.RELEASE"
	id("io.spring.dependency-management") version "1.0.10.RELEASE"
	id("org.jetbrains.kotlin.plugin.allopen") version "1.3.72"
	kotlin("jvm") version "1.3.72"
	kotlin("plugin.spring") version "1.3.72"
	kotlin("plugin.jpa") version "1.3.72"
	id("org.jlleitschuh.gradle.ktlint") version "9.2.1"
}

group = "com.renatomateusx.clean.arch"
version = "0.0.1-SNAPSHOT"

repositories {
	mavenCentral()
}

extra["springCloudVersion"] = "Hoxton.SR8"
subprojects() {

	group = "com.renatomateusx.clean.arch"
	version = "1.3-RELEASE"

	apply(plugin = "kotlin")
	apply(plugin = "kotlin-spring")
	apply(plugin = "io.spring.dependency-management")


	repositories {
		mavenCentral()
	}



	dependencies {
		implementation("org.springframework.boot:spring-boot-starter-web:2.3.4.RELEASE")
		implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.11.0")
		implementation("org.apache.kafka:kafka-streams:2.6.0")
		implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.72")
		implementation("org.jetbrains.kotlin:kotlin-allopen:1.3.72")
		implementation("org.jetbrains.kotlin:kotlin-reflect")
		implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
		implementation("org.springframework.cloud:spring-cloud-starter")
		implementation("org.springframework.cloud:spring-cloud-stream")
		implementation("org.springframework.cloud:spring-cloud-stream-binder-kafka-streams")
		testImplementation("org.springframework.boot:spring-boot-starter-test") {
			exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
		}
		testImplementation("org.springframework.cloud:spring-cloud-stream-test-support")

	}

	allOpen {
		annotation("org.springframework.stereotype.Component")
		annotation("org.springframework.stereotype.Service")
		annotation("org.springframework.stereotype.Repository")
	}
	dependencyManagement {
		imports {
			mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
		}
	}


	tasks.withType<Test> {
		useJUnitPlatform()
	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "11"
		}
	}

}
