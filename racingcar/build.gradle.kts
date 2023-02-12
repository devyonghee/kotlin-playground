plugins {
    kotlin("jvm")
}

val kotestVersion = "5.5.5"

dependencies {
    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
}
