package com.movie.compose.feature.menu.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.movie.compose.core.ui.R
import com.movie.compose.feature.menu.favorite.FavoriteScreen
import com.movie.compose.feature.menu.home.HomeScreen
import com.movie.compose.feature.menu.profile.ProfileScreen
import com.movie.compose.feature.menu.search.SearchScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val items = listOf(
        BottomNavItem("Home", "home", R.drawable.ic_home),
        BottomNavItem("Search", "search", R.drawable.ic_search),
        BottomNavItem("Favorite", "favorite", R.drawable.ic_favorite),
        BottomNavItem("Profile", "profile", R.drawable.ic_profile)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Movies",
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                actions = {
                    IconButton(onClick = { /* search */ }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_search),
                            contentDescription = "Search"
                        )
                    }
                    IconButton(onClick = { /* settings */ }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_setting),
                            contentDescription = "Settings"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.onSurface,
                    actionIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                )
            )
        },
        bottomBar = { BottomNavBar(navController, items) },
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") { HomeScreen() }
            composable("search") { SearchScreen() }
            composable("favorite") { FavoriteScreen() }
            composable("profile") { ProfileScreen() }
        }
    }
}

data class BottomNavItem(val title: String, val route: String, val icon: Int)

@Composable
fun BottomNavBar(navController: NavHostController, items: List<BottomNavItem>) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        painterResource(item.icon),
                        contentDescription = item.title,
                        tint = if (currentRoute == item.route)
                            MaterialTheme.colorScheme.primary
                        else Color.Gray
                    )
                },
                label = { Text(item.title, fontSize = MaterialTheme.typography.labelSmall.fontSize) }
            )
        }
    }
}