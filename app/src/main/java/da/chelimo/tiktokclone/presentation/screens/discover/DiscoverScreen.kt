package da.chelimo.tiktokclone.presentation.screens.discover

import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import coil3.compose.SubcomposeAsyncImage
import da.chelimo.tiktok.presentation.screens.DiscoverViewModel
import da.chelimo.tiktok.presentation.screens.components.BottomNav
import da.chelimo.tiktokclone.R
import da.chelimo.tiktokclone.presentation.theme.AppTheme
import da.chelimo.tiktokclone.presentation.theme.QuickSand
import da.chelimo.tiktokclone.presentation.theme.TikColors

val navIcons = listOf(
    NavIcon(BottomNavOptions.Discover, R.drawable.discover),
    NavIcon(BottomNavOptions.Search, R.drawable.search),
    NavIcon(BottomNavOptions.Profile, R.drawable.profile)
)

@Composable
fun DiscoverScreen() {
    val viewModel: DiscoverViewModel = viewModel { DiscoverViewModel() }
    val isLiked by viewModel.isLiked.collectAsState()


    Column {
        Box(
            modifier = Modifier.weight(1f)
        ) {
            Image(
                painter = painterResource(R.drawable.background),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillWidth
            )

            Column(
                Modifier
                    .fillMaxSize()
                    .padding(12.dp)
            ) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp), horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Following",
                        color = Color.White.copy(alpha = 0.6f),
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(
                        text = "For You",
                        color = Color.White,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "@da_chelimo",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    fontSize = 17.sp
                )
                Text(
                    text = buildAnnotatedString {
                        append("The most satisfying Job ")
                        withStyle(SpanStyle(fontWeight = FontWeight.SemiBold)) {
                            append("#fyp #satisfying #roadmarking")
                        }
                    },
                    modifier = Modifier.padding(top = 4.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White,
                    fontSize = 15.sp
                )


                Card(
                    Modifier
                        .padding(horizontal = 8.dp)
                        .padding(bottom = 4.dp),
//                    backgroundColor = Color.Black.copy(alpha = 0.7f),
//                    contentColor = Color.White,
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Black.copy(alpha = 0.7f),
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(6.dp)
                ) {
                    Row(
                        Modifier.fillMaxWidth(0.8f),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                    }
                }
            }

            Column(
                Modifier.align(Alignment.BottomEnd),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(Modifier.size(60.dp), contentAlignment = Alignment.Center) {
                    AsyncImage(
                        model = "https://media.licdn.com/dms/image/v2/D4D03AQEyPcixDX2FYA/profile-displayphoto-shrink_800_800/profile-displayphoto-shrink_800_800/0/1710750570093?e=1736380800&v=beta&t=qO6Jwb504_xYMcXhTQR0dCfKBm8fFoGsAAhgofEGbtI",
                        contentDescription = null,
                        error = painterResource(R.drawable.mirror_self),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .border(2.dp, Color.White.copy(alpha = 0.6f), CircleShape)
                    )

                    Icon(
                        imageVector = Icons.Rounded.Add,
                        contentDescription = "Follow Creator",
                        tint = Color.White,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .size(22.dp)
                            .clip(
                                CircleShape
                            )
                            .background(TikColors.Pink)
                            .padding(2.dp)
                    )
                }

                AnimatedContent(targetState = isLiked, label = "Like Video") { liked ->
                    PostMiniDetail(
                        icon = if (liked) R.drawable.filled_heart else R.drawable.heart,
                        tint = if (liked) TikColors.Pink else Color.White,
                        title = "23.6K"
                    )
                }
                PostMiniDetail(icon = R.drawable.comment, title = "978")
                PostMiniDetail(icon = R.drawable.share, title = stringResource(R.string.share))
                Spacer(modifier = Modifier.height(16.dp))
            }
        }

        var selectedNavOption by remember { mutableStateOf(BottomNavOptions.Discover) }
        BottomNav(
            selectedNavOption = selectedNavOption,
            onNavigate = { dest -> selectedNavOption = dest }
        )
    }
}

@Preview
@Composable
private fun PreviewDiscoverScreen() = AppTheme {
    DiscoverScreen()
}

@Composable
fun PostMiniDetail(
    @DrawableRes icon: Int,
    title: String,
    modifier: Modifier = Modifier,
    tint: Color = Color.White
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            painter = painterResource(icon),
            contentDescription = null,
            tint = tint,
            modifier = Modifier
                .padding(top = 12.dp)
                .size(32.dp),
        )
        Text(
            text = title,
            modifier = Modifier.padding(top = 2.dp),
            style = MaterialTheme.typography.bodyMedium,
            fontFamily = QuickSand,
            fontSize = 13.sp,
            color = Color.White,
            fontWeight = FontWeight.Medium
        )
    }
}


enum class BottomNavOptions { Discover, Search, Profile }

data class NavIcon(
    val name: BottomNavOptions,
    @DrawableRes val icon: Int
)


