package da.chelimo.tiktokclone.presentation.screens.auth.enter_email

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import da.chelimo.tiktokclone.R
import da.chelimo.tiktokclone.presentation.theme.AppTheme
import da.chelimo.tiktokclone.presentation.theme.QuickSand

@Composable
fun EnterEmailScreen() {
    Column(Modifier.fillMaxSize()) {
        Icon(
            imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
            contentDescription = stringResource(id = R.string.go_back),
            modifier = Modifier.size(48.dp)
        )


        Text(text = "Enter email address", fontSize = 26.sp, fontFamily = QuickSand, fontWeight = FontWeight.SemiBold)
    }
}

@Preview
@Composable
private fun PreviewEnterEmailScreen() = AppTheme {
    EnterEmailScreen()
}