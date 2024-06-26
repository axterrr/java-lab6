plugins {
    id("java")
}

group = "java-automatization"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit.platform:junit-platform-suite")
    testImplementation("org.assertj:assertj-core:3.11.1")
    testImplementation("org.seleniumhq.selenium:selenium-java:4.22.0")
    testImplementation("io.github.bonigarcia:webdrivermanager:5.9.1")
    testImplementation("io.cucumber:cucumber-java:7.14.1")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.14.1")
}

tasks.test {
    useJUnitPlatform()
}
