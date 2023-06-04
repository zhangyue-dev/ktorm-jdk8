import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.12"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    // Gradle没有自己的中央仓库
    // 先从本地maven仓库寻找依赖的jar包，存在则直接使用本地maven仓库的jar
    mavenLocal()
    // 本地maven仓库没有则从远程仓库下载jar包，并保存到 环境变量GRADLE_USER_HOME 配置的路径下
    // 设置maven仓库阿里镜像地址
    maven {
        setUrl("https://maven.aliyun.com/nexus/content/groups/public/")
    }
    // 配置使用Maven的中央仓库
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.ktorm:ktorm-core:3.6.0")
    implementation("org.ktorm:ktorm-jackson:3.6.0")
    implementation("org.ktorm:ktorm-support-mysql:3.6.0")
    implementation("mysql:mysql-connector-java:8.0.13")
    implementation("cn.hutool:hutool-core:5.8.19")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}