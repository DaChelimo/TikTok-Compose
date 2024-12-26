package da.chelimo.tiktokclone.presentation.screens.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import da.chelimo.tiktokclone.presentation.theme.AppColors
import da.chelimo.tiktokclone.presentation.theme.DarkBlack
import da.chelimo.tiktokclone.presentation.theme.LightBlack
import da.chelimo.tiktokclone.presentation.theme.Poppins
import da.chelimo.tiktokclone.presentation.theme.ProximaNova
import da.chelimo.tiktokclone.presentation.theme.QuickSand
import da.chelimo.tiktokclone.presentation.theme.Roboto

/**
 * For each segment on the profile description
 *
 * @param actualValue - The number of followers, for instance
 * @param title - The title e.g followers
 */
@Composable
fun MiniProfileDetails(actualValue: String, title: String, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        Text(
            text = actualValue,
            fontWeight = FontWeight.Bold,
            color = DarkBlack,
            fontSize = 15.sp,
            fontFamily = QuickSand
        )

        Text(text = title, fontSize = 12.sp, color = DarkBlack.copy(alpha = 0.7f), fontFamily = QuickSand)
    }
}