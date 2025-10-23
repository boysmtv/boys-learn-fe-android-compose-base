pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Music Compose"

include(
    ":app",
    ":core:common",
    ":core:model",
    ":core:nav",
    ":core:network",
    ":core:storage",
    ":core:ui",
    ":domain:model",
    ":domain:repository",
    ":domain:usecase",
    ":data:music",
    ":feature:menu",
    ":feature:music"
)
