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

include(":app")

include(":core:network")
include(":core:model")
include(":core:storage")
include(":core:ui")
include(":core:nav")
include(":core:common")

include(":domain:model")
include(":domain:repository")
include(":domain:usecase")

include(":data:movie")

include(":feature:movie-list")
include(":feature:movie-detail")
