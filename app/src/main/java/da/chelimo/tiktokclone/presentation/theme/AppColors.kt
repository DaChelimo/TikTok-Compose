package da.chelimo.tiktokclone.presentation.theme

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val lightAppColors = AppColors(
    background = LightBlue,
    backgroundVariant = LighterBlue,
    onBackground = Color.White,
    distinctBackground = LightBlue,

    surface = Color.White,
    surfaceSmallerVariant = AlmostWhite,
    surfaceVariant = LightWhite,
    distinctSurface = Color.White,

    onSurface = DarkBlack,
    onSurfaceLighter = LightBlack
)

val darkAppColors = AppColors(
    background = DarkBlue,
    backgroundVariant = LessDarkBlue,
    onBackground = Color.White,
    distinctBackground = DarkBlue,

    surface = DarkBlack,
    surfaceSmallerVariant = AlmostDarkBlack,
    surfaceVariant = LightBlack,
    distinctSurface = VeryDarkBlack,

    onSurface = Color.White,
    onSurfaceLighter = LightWhite
)

val blackAppColors = AppColors(
    background = VeryDarkBlack,
    backgroundVariant = AlmostDarkBlack,
    onBackground = Color.White,
    distinctBackground = Color.Black,

    surface = Black,
    surfaceSmallerVariant = DarkBlack,
    surfaceVariant = LightBlack,
    distinctSurface = Black,

    onSurface = Color.White,
    onSurfaceLighter = LightWhite
)

val LocalAppColors: ProvidableCompositionLocal<AppColors> = staticCompositionLocalOf { lightAppColors }

data class AppColors (
    val background: Color,
    val backgroundVariant: Color,
    val onBackground: Color,
    val distinctBackground: Color,


    val surface: Color,
    val surfaceSmallerVariant: Color,
    val surfaceVariant: Color,
    val distinctSurface: Color,

    // Text Color to be used on a black/white background (main)
    val onSurface: Color,

    // Lighter Text Color to be used on a black/white background (description text)
    val onSurfaceLighter: Color
)