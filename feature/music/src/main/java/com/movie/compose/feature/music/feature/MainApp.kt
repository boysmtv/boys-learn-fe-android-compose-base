package com.movie.compose.feature.music.feature

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.movie.compose.feature.music.feature.explore.ExploreScreen
import com.movie.compose.feature.music.feature.home.HomeScreen
import com.movie.compose.feature.music.feature.library.LibraryScreen
import com.movie.compose.feature.music.feature.sample.SampleScreen
import com.movie.compose.feature.music.feature.search.SearchScreen
import com.movie.compose.feature.music.feature.setting.SettingScreen
import com.movie.compose.feature.music.model.BottomNavItem
import com.movie.compose.feature.music.toolbar.AppToolbar
import com.movie.compose.feature.music.utils.BottomBar
import com.movie.compose.feature.music.utils.Constant.EXPLORE
import com.movie.compose.feature.music.utils.Constant.EXPLORE_SCREEN
import com.movie.compose.feature.music.utils.Constant.HOME_SCREEN
import com.movie.compose.feature.music.utils.Constant.LIBRARY
import com.movie.compose.feature.music.utils.Constant.LIBRARY_SCREEN
import com.movie.compose.feature.music.utils.Constant.MUSIC
import com.movie.compose.feature.music.utils.Constant.SAMPLE
import com.movie.compose.feature.music.utils.Constant.SAMPLE_SCREEN
import com.movie.compose.feature.music.utils.Constant.SEARCH
import com.movie.compose.feature.music.utils.Constant.SEARCH_SCREEN
import com.movie.compose.feature.music.utils.Constant.SETTING
import com.movie.compose.feature.music.utils.Constant.SETTING_SCREEN

@Composable
fun MainApp() {
    val navController = rememberNavController()
    val backgroundColor = Color.Black

    val menuItems = listOf(
        BottomNavItem.Home,
        BottomNavItem.Explore,
        BottomNavItem.Sample,
        BottomNavItem.Library
    )

    val currentDestination by navController.currentBackStackEntryAsState()
    val route = currentDestination?.destination?.route

    val appBarTitle = when (route) {
        HOME_SCREEN -> MUSIC
        SEARCH_SCREEN -> SEARCH
        SETTING_SCREEN -> SETTING
        EXPLORE_SCREEN -> EXPLORE
        SAMPLE_SCREEN -> SAMPLE
        LIBRARY_SCREEN -> LIBRARY
        else -> ""
    }

    val isMenu = route !in listOf(SEARCH_SCREEN, SETTING_SCREEN)

    Scaffold(
        topBar = {
            if (isMenu) AppToolbar(
                title = appBarTitle,
                onSearchClick = {
                    if (route != SEARCH_SCREEN) {
                        navController.navigate(SEARCH_SCREEN) {
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                onSettingsClick = {
                    if (route != SETTING_SCREEN) {
                        navController.navigate(SETTING_SCREEN) {
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            )
        },
        bottomBar = {
            if (isMenu) BottomBar(navController, menuItems)
        },
        containerColor = backgroundColor
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor)
                .padding(innerPadding)
        ) {
            NavHost(
                navController = navController,
                startDestination = HOME_SCREEN
            ) {
                composable(HOME_SCREEN) { HomeScreen(navController) }
                composable(SEARCH_SCREEN) { SearchScreen(navController) }
                composable(SETTING_SCREEN) { SettingScreen(navController) }
                composable(EXPLORE_SCREEN) { ExploreScreen(navController) }
                composable(SAMPLE_SCREEN) { SampleScreen(navController) }
                composable(LIBRARY_SCREEN) { LibraryScreen(navController) }
            }
        }
    }
}

