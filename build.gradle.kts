buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath "org.cyclonedx:cyclonedx-gradle-plugin:1.8.1"
    }
}

apply plugin: 'java'
apply plugin: 'org.cyclonedx.bom'

repositories {
    mavenCentral()
}

cyclonedxBom {
    includeConfigs = ["runtimeClasspath"]
    projectType = "application"
    schemaVersion = "1.5"
    destination = file("build/reports")
    outputName = "bom"
    outputFormat = "xml"
    includeBomSerialNumber = false
    includeLicenseText = false
    componentVersion = "2.0.0"
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

jar {
    manifest {
        attributes(
            'Main-Class': 'com.package.app.Class'
        )
    }
}

tasks.withType(JavaCompile) {
    options.encoding = 'UTF-8'
}
