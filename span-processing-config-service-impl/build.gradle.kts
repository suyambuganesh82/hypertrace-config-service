plugins {
  `java-library`
  jacoco
  id("org.hypertrace.jacoco-report-plugin")
}

dependencies {
  api(projects.spanProcessingConfigServiceApi)
  implementation(projects.configServiceApi)
  implementation(projects.objectStore)
  implementation(projects.validationUtils)
  implementation(projects.configProtoConverter)
  implementation(projects.configServiceChangeEventGenerator)

  implementation(libs.protobuf.javautil)
  implementation(libs.google.re2j)
  implementation(libs.hypertrace.grpcutils.context)
  implementation(libs.hypertrace.grpcutils.client)

  implementation(libs.guice)
  implementation(libs.guava)
  implementation(libs.slf4j.api)
  implementation(libs.typesafe.config)

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
