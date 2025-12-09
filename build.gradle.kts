plugins {
  id("com.diffplug.spotless")
  id("com.gradleup.shadow") apply false
  id("java-library")
}

repositories {
  mavenCentral()
}

spotless {
  kotlinGradle {
    ktlint().editorConfigOverride(mapOf(
      "indent_size" to "2",
      "continuation_indent_size" to "2",
      "max_line_length" to "160",
      "insert_final_newline" to "true",
      "ktlint_standard_no-wildcard-imports" to "disabled",
      // ktlint does not break up long lines, it just fails on them
      "ktlint_standard_max-line-length" to "disabled",
      // ktlint makes it *very* hard to locate where this actually happened
      "ktlint_standard_trailing-comma-on-call-site" to "disabled",
      // depends on ktlint_standard_wrapping
      "ktlint_standard_trailing-comma-on-declaration-site" to "disabled",
      // also very hard to find out where this happens
      "ktlint_standard_wrapping" to "disabled"
    ))
    target("**/*.gradle.kts")
  }
}

subprojects {
  apply(plugin = "com.diffplug.spotless")
  apply(plugin = "java-library")
  apply(plugin = "com.gradleup.shadow")

  group = "io.opentelemetry"
  version = "0.1.0-SNAPSHOT"

  repositories {
    mavenCentral()
  }

  dependencies {
    // using the bom ensures that all of your opentelemetry dependency versions are aligned
    implementation(platform("io.opentelemetry.instrumentation:opentelemetry-instrumentation-bom-alpha:2.22.0-alpha"))
  }

  spotless {
    java {
      targetExclude("**/generated/**")
      googleJavaFormat()
    }
    kotlinGradle {
      ktlint().editorConfigOverride(mapOf(
        "indent_size" to "2",
        "continuation_indent_size" to "2",
        "max_line_length" to "160",
        "insert_final_newline" to "true",
        "ktlint_standard_no-wildcard-imports" to "disabled",
        // ktlint does not break up long lines, it just fails on them
        "ktlint_standard_max-line-length" to "disabled",
        // ktlint makes it *very* hard to locate where this actually happened
        "ktlint_standard_trailing-comma-on-call-site" to "disabled",
        // depends on ktlint_standard_wrapping
        "ktlint_standard_trailing-comma-on-declaration-site" to "disabled",
        // also very hard to find out where this happens
        "ktlint_standard_wrapping" to "disabled"
      ))
      target("**/*.gradle.kts")
    }
  }
}
