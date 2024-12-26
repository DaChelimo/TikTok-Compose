package da.chelimo.tiktok.presentation.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import da.chelimo.tiktokclone.presentation.screens.discover.BottomNavOptions
import da.chelimo.tiktokclone.presentation.screens.discover.navIcons


@Composable
fun BottomNav(modifier: Modifier = Modifier, selectedNavOption: BottomNavOptions, onNavigate: (BottomNavOptions) -> Unit) {
    Row(
        modifier = modifier.fillMaxWidth().background(Color.Black).padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        navIcons.forEach { navIcon ->
            Column(modifier = Modifier.clickable { onNavigate(navIcon.name) }) {
                Image(
                    painter = painterResource(navIcon.icon),
                    modifier = Modifier.width(30.dp),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(
                        if (navIcon.name == selectedNavOption) Color.White else Color.White.copy(
                            alpha = 0.8f
                        )
                    )
                )
                Spacer(modifier = Modifier.padding(top = 2.dp))
                Text(
                    navIcon.name.toString(),
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 14.sp,
                    color = if (navIcon.name == selectedNavOption) Color.White else Color.White.copy(alpha = 0.8f)
                )
            }
        }
    }
}
