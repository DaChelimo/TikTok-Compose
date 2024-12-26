package da.chelimo.tiktok.presentation.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import da.chelimo.tiktokclone.R
import da.chelimo.tiktokclone.presentation.theme.AppTheme
import da.chelimo.tiktokclone.presentation.theme.TikColors

@Composable
fun Comment(isLiked: Boolean, modifier: Modifier = Modifier) {
    Row(modifier = modifier.padding(vertical = 6.dp)) {
        Image(
            painter = painterResource(R.drawable.mirror_self),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 8.dp)
                .size(32.dp)
                .clip(
                    CircleShape
                )
        )

        Column(
            modifier = Modifier
                .padding(start = 12.dp)
                .weight(1f)
        ) {
            Text(
                text = "abby.shauri",
                style = MaterialTheme.typography.bodyMedium,
                color = TikColors.Grey,
                fontSize = 13.sp
            )

            Text(
                text = "My man, my man, my man",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 2.dp)
            )

            Row {
                Text(text = "12 hrs", color = TikColors.Grey, modifier = Modifier.padding(top = 4.dp), fontSize = 13.sp)

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "Reply",
                    color = TikColors.Grey,
                    fontSize = 13.sp,
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .padding(top = 4.dp, bottom = 4.dp)
                        .clickable {
//                            Timber.d("Reply to comment")
                        }
                )
            }
        }


        Column(
            Modifier.padding(horizontal = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = if (isLiked) Icons.Rounded.Favorite else Icons.Rounded.FavoriteBorder,
                tint = if (isLiked) TikColors.Pink else TikColors.Grey,
                contentDescription = "Like comment",
                modifier = Modifier.size(22.dp)
            )

            Text(
                text = "2205",
                color = TikColors.Grey,
                fontSize = 12.sp
            )
        }
    }
}


@Preview
@Composable
private fun PreviewComment() = AppTheme {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Comment(isLiked = true)
        Comment(isLiked = false)
    }
}