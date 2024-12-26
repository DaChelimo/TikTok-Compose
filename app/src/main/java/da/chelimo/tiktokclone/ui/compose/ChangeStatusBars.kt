package da.chelimo.tiktokclone.ui.compose

import android.view.View
import android.view.Window
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import da.chelimo.tiktokclone.presentation.theme.LocalAppColors
import da.chelimo.tiktokclone.utils.getActivity


@Composable
fun ChangeStatusBars(
    navigateBack: Boolean,

    // Whether to intercept navigateBack and BackHandler commands...
    // Useful on initial startup when back press (with no location) should cause app exit
    onNavigateBack: () -> Unit,
    resetNavigateBack: () -> Unit
) {
    val view = LocalView.current
    val window = (view.context.getActivity() ?: return).window

    val whiteBlackColor = LocalAppColors.current.surface
    val blueBackground = LocalAppColors.current.background

    LaunchedEffect(key1 = whiteBlackColor) {
        window.statusBarColor = whiteBlackColor.toArgb()
        window.navigationBarColor = whiteBlackColor.toArgb()

        // If in Light mode, the status bars will be white hence icons need to be black here
        if (whiteBlackColor == Color.White) {
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = true
            WindowCompat.getInsetsController(window, view).isAppearanceLightNavigationBars = true
        }
    }


    LaunchedEffect(key1 = navigateBack) {
        if (navigateBack) {
            onNavigateBack()

            window.statusBarColor = blueBackground.toArgb()
            window.navigationBarColor = blueBackground.toArgb()
            restoreIconsToWhite(window, view)

            resetNavigateBack()
        }
    }

    BackHandler {
        onNavigateBack()

        window.statusBarColor = blueBackground.toArgb()
        window.navigationBarColor = blueBackground.toArgb()

        restoreIconsToWhite(window, view)
    }
}

fun restoreIconsToWhite(window: Window, view: View) {
    WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
    WindowCompat.getInsetsController(window, view).isAppearanceLightNavigationBars = false
}