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

rootProject.name = "movie-compose"
include(
    ":app",
    ":core:common",
    ":core:model",
    ":core:nav",
    ":core:network",
    ":core:storage",
    ":core:ui",
    ":data:movie",
    ":domain:model",
    ":domain:repository",
    ":domain:usecase",
    ":feature:movie-list",
    ":feature:movie-detail"
)
include(":feature:menu")
include(":feature:music")
