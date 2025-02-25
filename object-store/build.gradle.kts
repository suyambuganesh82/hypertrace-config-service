plugins {
  `java-library`
  jacoco
  id("org.hypertrace.jacoco-report-plugin")
}

dependencies {
  api(projects.configServiceApi)
  api(projects.configServiceChangeEventApi)
  api(libs.hypertrace.grpcutils.context)

  implementation(projects.configServiceChangeEventGenerator)
  implementation(libs.slf4j.api)

  annotationProcessor(libs.lombok)
  compileOnly(libs.lombok)

  testImplementation(libs.junit.jupiter)
  testImplementation(libs.mockito.core)
  testImplementation(libs.mockito.junit)
  testImplementation(libs.mockito.inline)
  testImplementation(libs.protobuf.javautil)

  testAnnotationProcessor(libs.lombok)
  testCompileOnly(libs.lombok)
}

tasks.test {
  useJUnitPlatform()
}
