
package com.movie.compose.feature.movie.list.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.movie.compose.core.ui.R

data class MovieUi(
    val id: Int,
    val title: String,
    val imageRes: Int,
    val desc: String = ""
)

@Composable
fun HomeScreen() {
    val sliderMovies = listOf(
        MovieUi(1, "The Toxic Avenger", R.drawable.ic_setting, "When a downtrodden janitor..."),
        MovieUi(2, "The Conjuring", R.drawable.ic_setting),
        MovieUi(3, "The Lost Princess", R.drawable.ic_setting)
    )

    val popularMovies = listOf(
        MovieUi(4, "The Conjuring", R.drawable.ic_setting),
        MovieUi(5, "The Toxic Avenger", R.drawable.ic_setting),
        MovieUi(6, "The Lost Princess", R.drawable.ic_setting)
    )

    val topRatedMovies = listOf(
        MovieUi(7, "The Shawshank Redemption", R.drawable.ic_setting),
        MovieUi(8, "The Godfather", R.drawable.ic_setting),
        MovieUi(9, "The Godfather Part II", R.drawable.ic_setting)
    )

    Scaffold(
        bottomBar = { BottomNavigationBar() },
        containerColor = Color.White
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp)
        ) {
            HeaderSection()
            Spacer(Modifier.height(8.dp))
            SliderSection(sliderMovies)
            Spacer(Modifier.height(16.dp))
            MovieSection("Popular", popularMovies)
            Spacer(Modifier.height(16.dp))
            MovieSection("Top Rated", topRatedMovies)
        }
    }
}

@Composable
fun HeaderSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Movies", fontSize = 22.sp, fontWeight = FontWeight.Bold)
        IconButton(onClick = {}) {
            Icon(
                painter = painterResource(R.drawable.ic_setting),
                contentDescription = null,
                tint = Color.Black
            )
        }
    }
}

@Composable
fun SliderSection(movies: List<MovieUi>) {
    val pagerState = rememberPagerState(pageCount = { movies.size })
    HorizontalPager(state = pagerState, modifier = Modifier.height(200.dp)) { page ->
        val movie = movies[page]
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.medium)
        ) {
            Image(
                painter = painterResource(movie.imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            listOf(Color.Transparent, Color.Black.copy(alpha = 0.6f))
                        )
                    ),
                contentAlignment = Alignment.BottomStart
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(movie.title, color = Color.White, fontWeight = FontWeight.Bold)
                    Text(
                        movie.desc,
                        color = Color.White,
                        fontSize = 12.sp,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(Modifier.height(8.dp))
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF004D40)),
                        shape = MaterialTheme.shapes.small
                    ) {
                        Text("click here", color = Color.White, fontSize = 12.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun MovieSection(title: String, movies: List<MovieUi>) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(title, fontWeight = FontWeight.Bold)
            TextButton(onClick = {}) { Text("See all", color = Color(0xFF03A9F4)) }
        }
        LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            items(movies.size) { index ->
                val movie = movies[index]
                Image(
                    painter = painterResource(movie.imageRes),
                    contentDescription = movie.title,
                    modifier = Modifier
                        .size(width = 120.dp, height = 180.dp)
                        .clip(MaterialTheme.shapes.small),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@Composable
fun BottomNavigationBar() {
    NavigationBar(containerColor = Color.White) {
        val items = listOf(
            R.drawable.ic_home,
            R.drawable.ic_search,
            R.drawable.ic_menu,
            R.drawable.ic_favorite,
            R.drawable.ic_profile
        )
        items.forEachIndexed { index, icon ->
            NavigationBarItem(
                selected = index == 0,
                onClick = {},
                icon = {
                    Icon(
                        painter = painterResource(icon),
                        contentDescription = null,
                        tint = if (index == 0) Color(0xFF03A9F4) else Color.Gray
                    )
                }
            )
        }
    }
}
