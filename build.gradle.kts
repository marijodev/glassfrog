2import com.google.cloud.tools.gradle.appengine.standard.AppEngineStandardExtension
import com.google.cloud.tools.gradle.appengine.appyaml.AppEngineAppYamlExtension

        buildscript({
            repositories {
                jcenter()
                mavenCentral()
                maven {
                    url = uri("https://plugins.gradle.org/m2/")
                }
            }
            dependencies {
                classpath("com.google.cloud.tools:appengine-gradle-plugin:+")
                classpath("gradle.plugin.org.gretty:gretty:2.3.1'")
                classpath("com.google.cloud.tools:appengine-gradle-plugin:2.0.0-rc5")
            }
        })

plugins {
    war
	id("org.jetbrains.kotlin.jvm") version "1.3.41"
    java
	id("org.gretty") version "2.3.1"
	// id("com.google.cloud.tools.appengine") version "1.3.4"
}

apply {
    plugin("com.google.cloud.tools.appengine")
}


repositories {
    jcenter()
    mavenCentral()
    maven {
        url = uri("https://plugins.gradle.org/m2/")
    }
}



dependencies {
    compile("com.google.appengine:appengine:+")
    compile("com.google.appengine:appengine-api-1.0-sdk:+")
    providedCompile("javax.servlet:javax.servlet-api:3.1.0") 
    testCompile("junit:junit:4.12")
    testCompile("org.mockito:mockito-core:2.7.19") 
	testCompile("org.seleniumhq.selenium:selenium-chrome-driver:2.3.1")
    testCompile ("com.google.appengine:appengine-testing:+")
    testCompile ("com.google.appengine:appengine-api-stubs:+")
    testCompile ("com.google.appengine:appengine-tools-sdk:+")
	 
}


gretty {
    integrationTestTask = "test"  
}

java({
    // (4)
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
})

configure<AppEngineStandardExtension> {
    deploy {
        projectId = "glassfrog"
        version = "1"
        stopPreviousVersion = true // etc
    }
}
