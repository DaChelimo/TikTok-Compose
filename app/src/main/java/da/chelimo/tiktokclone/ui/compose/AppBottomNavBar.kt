package da.chelimo.tiktokclone.ui.compose

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import da.chelimo.tiktokclone.main_activity.Screens
import da.chelimo.tiktokclone.presentation.theme.AppTheme
import da.chelimo.tiktokclone.presentation.theme.LocalAppColors


enum class BottomNav(@StringRes val nameRes: Int, @DrawableRes val icon: Int) {
//    Current(R.string.current, R.drawable.radar),
//    Hourly(R.string.hourly, R.drawable.clock),
//    Daily(R.string.daily, R.drawable.daily_calender)
}

fun BottomNav.getScreen() = Screens.Discover
//    when(this) {
//    BottomNav.Current -> Screens.Current
//    BottomNav.Hourly -> Screens.Hourly
//    BottomNav.Daily -> Screens.Daily
//}


@Composable
fun AppBottomNavBar(
    activeBottomNav: BottomNav,
    navigateToBottomNav: (BottomNav) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp)
            .padding(bottom = 6.dp),
        shape = RoundedCornerShape(8.dp),
        color = LocalAppColors.current.backgroundVariant,
        shadowElevation = 3.dp
    ) {
        Row(
            Modifier
                .fillMaxWidth()
//                .padding(top = 6.dp, bottom = 4.dp)
                .padding(top = 10.dp, bottom = 6.dp)
        ) {
//            BottomNavItem(
//                bottomNav = BottomNav.Current,
//                isActive = activeBottomNav == BottomNav.Current,
//                onClick = { navigateToBottomNav(BottomNav.Current) }
//            )
//            BottomNavItem(
//                bottomNav = BottomNav.Hourly,
//                isActive = activeBottomNav == BottomNav.Hourly,
//                onClick = { navigateToBottomNav(BottomNav.Hourly) }
//            )
//            BottomNavItem(
//                bottomNav = BottomNav.Daily,
//                isActive = activeBottomNav == BottomNav.Daily,
//                onClick = { navigateToBottomNav(BottomNav.Daily) }
//            )
        }
    }
}

@Preview
@Composable
private fun PreviewAppBottomNavBar() = AppTheme {
    Box(
        Modifier
            .fillMaxWidth()
            .background(LocalAppColors.current.background)
            .height(150.dp)
    ) {
//        AppBottomNavBar(
//            modifier = Modifier.align(Alignment.BottomCenter),
//            activeBottomNav = BottomNav.Current,
//            navigateToBottomNav = { }
//        )
    }
}


@Composable
fun RowScope.BottomNavItem(
    bottomNav: BottomNav,
    isActive: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val onSurface = LocalAppColors.current.onBackground.copy(alpha = if (isActive) 1f else 0.55f)

    Column(
        modifier.weight(1f),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier.clickable { onClick() }.size(24.dp),
            painter = painterResource(id = bottomNav.icon),
            contentDescription = stringResource(id = bottomNav.nameRes),
            tint = onSurface
        )

        Text(
            text = stringResource(id = bottomNav.nameRes),
            fontSize = 15.sp,
            modifier = Modifier.padding(top = 2.dp),
            color = onSurface,
            fontWeight = if (isActive) FontWeight.SemiBold else FontWeight.Medium
        )
    }
}