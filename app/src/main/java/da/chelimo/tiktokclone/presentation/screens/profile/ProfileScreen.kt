package da.chelimo.tiktokclone.presentation.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import da.chelimo.tiktokclone.R
import da.chelimo.tiktokclone.domain.video.preview.VideoPreview
import da.chelimo.tiktokclone.presentation.theme.AppTheme
import da.chelimo.tiktokclone.presentation.theme.DarkBlack
import da.chelimo.tiktokclone.presentation.theme.DarkBlue
import da.chelimo.tiktokclone.presentation.theme.LightBlack
import da.chelimo.tiktokclone.presentation.theme.LocalAppColors
import da.chelimo.tiktokclone.presentation.theme.ProximaNova
import da.chelimo.tiktokclone.presentation.theme.QuickSand

@Composable
fun ProfileScreen() {
//    val viewModel = koinViewModel<ProfileViewModel>()

    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        ProfileTopAppBar(true)

        AsyncImage(
            model = "https://media.licdn.com/dms/image/v2/D4D03AQEQGF0MjZQ2BQ/profile-displayphoto-shrink_200_200/profile-displayphoto-shrink_200_200/0/1731534463396?e=2147483647&v=beta&t=UvhmIgbv0wEyjRG6VOujTIEFRDIJcKM_bpgMdV1gpow",
            contentDescription = null,
            error = painterResource(id = R.drawable.andrew_chelimo),
            modifier = Modifier
                .padding(top = 28.dp)
                .align(Alignment.CenterHorizontally)
                .size(105.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Text(
            text = "@da_chelimo",
            fontFamily = QuickSand,
            fontWeight = FontWeight.SemiBold,
            color = LocalAppColors.current.onSurface,
            modifier = Modifier
                .padding(top = 4.dp)
                .align(Alignment.CenterHorizontally),
            fontSize = 15.sp,
            letterSpacing = 0.1.sp
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(fraction = 0.7f)
                .padding(top = 24.dp)
                .align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            MiniProfileDetails(actualValue = "32.2K", title = "Likes")
            Text(text = "|", color = Color.LightGray)
            MiniProfileDetails(actualValue = "120", title = "Followers")
            Text(text = "|", color = Color.LightGray)
            MiniProfileDetails(actualValue = "1020", title = "Following")
        }


        Row(
            modifier = Modifier.padding(top = 12.dp)
        ) {
            ProfileActionButton(text = "Edit Profile", onClick = {})
            Spacer(modifier = Modifier.width(6.dp))
            ProfileActionButton(text = "Share Profile", onClick = {})
        }


        Text(
            text = "I'm just a girl :)",
            modifier = Modifier.padding(top = 12.dp),
            fontFamily = QuickSand,
            fontSize = 14.sp
        )


        var selectedPageIndex by remember { mutableIntStateOf(2) }
        val pagerState = rememberPagerState { 2 }


        val tabs = listOf(
            R.drawable.grid, R.drawable.repost
        )
        TabRow(
            modifier = Modifier.padding(top = 16.dp),
            containerColor = Color.White,
            contentColor = DarkBlack,
            indicator = { tabPositions ->
                if (selectedPageIndex < tabPositions.size) {
                    TabRowDefaults.SecondaryIndicator(
                        Modifier
                            .tabIndicatorOffset(tabPositions[selectedPageIndex])
                            .padding(top = 8.dp),
                        color = DarkBlue
                    )
                }
            },
            selectedTabIndex = selectedPageIndex
        ) {
            tabs.forEachIndexed { index, tabDrawable ->
                Icon(
                    painter = painterResource(id = tabDrawable),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 12.dp)
                        .size(22.dp),
                    tint = if (index == selectedPageIndex) DarkBlack else LightBlack
                )
            }
        }


//        val repostPreviews by viewModel.repostPreviews.observeAsState()
//        val myVideoPreviews by viewModel.myVideoPreviews.observeAsState()
//        val likedPreviews by viewModel.likedPreviews.observeAsState()
        /**
         * Page 1 is Video Posts, Page 2 is Reposts and Page 3 (optional) is liked videos
         */
        LaunchedEffect(key1 = selectedPageIndex, pagerState.isScrollInProgress) {
            if (!pagerState.isScrollInProgress)
                pagerState.animateScrollToPage(selectedPageIndex)
        }
        HorizontalPager(state = pagerState) { page ->
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                verticalArrangement = Arrangement.spacedBy(2.dp),
                horizontalArrangement = Arrangement.spacedBy(2.dp),
                contentPadding = PaddingValues(horizontal = 2.dp)
            ) {
                items(VideoPreview.TEST_LIST) { preview ->
                    AsyncImage(
                        model = preview.thumbnail,
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .aspectRatio((16 / 9).toFloat())
                            .clip(RoundedCornerShape(4.dp)),
                        error = painterResource(id = R.drawable.andrew_chelimo),
                        contentDescription = null
                    )
                }
            }
        }
    }
}


@Preview
@Composable
private fun PreviewProfileScreen() = AppTheme {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        ProfileScreen()
    }
}

@Composable
fun ProfileActionButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = LocalAppColors.current.onSurface.copy(
                alpha = 0.05f
            )
        )
    ) {
        Text(
            text = text,
            fontFamily = QuickSand,
            fontWeight = FontWeight.SemiBold,
            color = LocalAppColors.current.onSurface
        )
    }
}


/**
 * The @param isCurrentUser enables us to customize the profile top bar based on whether
 * the account belongs to the current user or not.
 */
@Composable
fun ProfileTopAppBar(isCurrentUser: Boolean, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(bottomStart = 4.dp, bottomEnd = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp), contentAlignment = Alignment.Center
        ) {
            if (!isCurrentUser) {
                Icon(
                    imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                    contentDescription = stringResource(R.string.go_back),
                    tint = LocalAppColors.current.onSurface
                )
            }

            TextButton(onClick = {}, modifier = Modifier.align(Alignment.Center)) {
                Text(
                    text = "Knight Andre",
                    fontFamily = ProximaNova,
                    fontSize = 18.sp,
                    color = LocalAppColors.current.onSurface,
                    fontWeight = FontWeight.SemiBold
                )

                if (isCurrentUser)
                    Icon(
                        imageVector = Icons.Rounded.KeyboardArrowDown,
                        contentDescription = null,
                        tint = LocalAppColors.current.onSurface,
                        modifier = Modifier.padding(start = 2.dp)
                    )
            }


            Icon(
                imageVector = Icons.Rounded.MoreVert,
                contentDescription = "Open Account Settings",
                tint = LocalAppColors.current.onSurface,
                modifier = Modifier
                    .height(22.dp)
                    .align(Alignment.CenterEnd)
                    .padding(horizontal = 6.dp)
            )
        }
    }
}


