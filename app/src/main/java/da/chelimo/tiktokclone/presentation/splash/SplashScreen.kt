package da.chelimo.tiktokclone.presentation.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import da.chelimo.tiktokclone.main_activity.Screens
import da.chelimo.tiktokclone.presentation.theme.LocalAppColors

@Composable
fun SplashScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LocalAppColors.current.background),
        contentAlignment = Alignment.Center
    ) {
        LaunchedEffect(key1 = Unit) {
//            val location = locationRepo.location.firstOrNull()
//            navController.navigate(if (location != null) Screens.Current else Screens.SelectLocation)
            navController.navigate(Screens.Discover)
        }
    }
}