plugins {
  `java-library`
  jacoco
  id("org.hypertrace.jacoco-report-plugin")
  id("org.hypertrace.publish-plugin")
}

dependencies {
  api(projects.spanProcessingConfigServiceApi)
  implementation(libs.slf4j.api)
  implementation(libs.google.re2j)

  annotationProcessor(libs.lombok)
  compileOnly(libs.lombok)

  testImplementation(libs.junit.jupiter)
  testImplementation(libs.mockito.core)
  testImplementation(libs.mockito.junit)
  testImplementation(testFixtures(projects.configServiceApi))
}

tasks.test {
  useJUnitPlatform()
}
