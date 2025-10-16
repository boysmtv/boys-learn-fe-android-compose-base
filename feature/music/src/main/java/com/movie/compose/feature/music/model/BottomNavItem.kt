package com.movie.compose.feature.music.model

import com.movie.compose.core.ui.R
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


sealed class BottomNavItem(val route: String, val title: String, val icon: Int) {
    data object Home : BottomNavItem(HOME_SCREEN, MUSIC, R.drawable.ic_home)
    data object Search : BottomNavItem(SEARCH_SCREEN, SEARCH, R.drawable.ic_search)
    data object Settings : BottomNavItem(SETTING_SCREEN, SETTING, R.drawable.ic_setting)
    data object Explore : BottomNavItem(EXPLORE_SCREEN, EXPLORE, R.drawable.ic_explore)
    data object Sample : BottomNavItem(SAMPLE_SCREEN, SAMPLE, R.drawable.ic_sample)
    data object Library : BottomNavItem(LIBRARY_SCREEN, LIBRARY, R.drawable.ic_library)
}
