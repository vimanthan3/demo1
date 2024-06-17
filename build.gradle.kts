plugins {
    id("java")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(8))
    }
}

tasks.register<Jar>("jar") {
    manifest {
        attributes(
            "Main-Class" to "fully.qualified.MainClass"
        )
    }
}
