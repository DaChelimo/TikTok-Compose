package da.chelimo.tiktokclone.presentation.screens.auth.sign_up

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import da.chelimo.tiktokclone.R
import da.chelimo.tiktokclone.presentation.theme.AppTheme
import da.chelimo.tiktokclone.presentation.theme.LightBlack
import da.chelimo.tiktokclone.presentation.theme.LocalAppColors
import da.chelimo.tiktokclone.presentation.theme.Poppins
import da.chelimo.tiktokclone.presentation.theme.QuickSand
import da.chelimo.tiktokclone.presentation.theme.TikColors

@Composable
fun SignUpScreen() {
    Card(
        shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
        elevation = CardDefaults.elevatedCardElevation(),
        modifier = Modifier
            .fillMaxSize()
            .background(LocalAppColors.current.background),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = LocalAppColors.current.onSurface
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Box(Modifier.fillMaxWidth()) {
                Icon(
                    imageVector = Icons.Rounded.Close,
                    contentDescription = "Exit sign up page",
                    modifier = Modifier
                        .padding(12.dp)
                        .size(24.dp)
                        .align(Alignment.TopStart),
                    tint = LocalAppColors.current.onSurface
                )

                Text(
                    text = "Sign up for TikTok",
                    fontFamily = QuickSand,
                    fontSize = 24.sp,
                    letterSpacing = 0.1.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(top = 72.dp)
                        .align(Alignment.Center)
                )

                Icon(
                    imageVector = Icons.Rounded.Refresh,
                    contentDescription = "FAQ",
                    modifier = Modifier
                        .padding(12.dp)
                        .size(24.dp)
                        .align(Alignment.TopEnd),
                    tint = LocalAppColors.current.onSurface
                )
            }

            Text(
                text = "Create your profile, follow other accounts, make your own videos",
                color = LocalAppColors.current.onSurfaceLighter.copy(alpha = 0.8f),
                fontFamily = Poppins,
                lineHeight = 16.sp,
                fontSize = (14.5).sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(top = 12.dp)
                    .align(Alignment.CenterHorizontally),
            )

            Spacer(modifier = Modifier.height(36.dp))

            AuthButton(
                modifier = Modifier.fillMaxWidth(0.9f),
                icon = painterResource(id = R.drawable.person),
                action = "Continue with email",
                onClick = { })

            AuthButton(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(top = 12.dp),
                icon = painterResource(id = R.drawable.facebook),
                action = "Continue with Facebook",
                onClick = { })

            AuthButton(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(top = 12.dp),
                icon = painterResource(id = R.drawable.google),
                action = "Continue with Google",
                onClick = { })


            Spacer(modifier = Modifier.weight(1f))

            val boldSpanStyle =
                SpanStyle(color = LocalAppColors.current.onSurface, fontWeight = FontWeight.Medium)
            Text(text = buildAnnotatedString {
                append("By continuing with an account located in")
                withStyle(boldSpanStyle) {
                    append(" KE")
                }
                append(" you agree to our")
                withStyle(boldSpanStyle) {
                    append(" Terms of Service ")
                }
                append("and acknowledge that you have read our Privacy Policy")
            }
            )

            Row(Modifier.align(Alignment.CenterHorizontally).padding(vertical = 24.dp)) {
                Text(text = buildAnnotatedString {
                    append("Already have an account?")
                    withStyle(SpanStyle(color = TikColors.Pink, fontWeight = FontWeight.SemiBold)) {
                        append("Log in")
                    }
                }, fontFamily = QuickSand, fontSize = 15.sp, fontWeight = FontWeight.Medium)
            }
        }
    }
}


/**
 * Button for each authentication method
 *
 * @param icon - The leading icon for the button
 * @param action - The action name
 */
@Composable
fun AuthButton(icon: Painter, action: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        shape = RoundedCornerShape(6.dp),
        border = BorderStroke(1.dp, LocalAppColors.current.onSurface.copy(alpha = 0.2f)),
        onClick = onClick,
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 14.dp, vertical = 14.dp)
    ) {
        Image(
            painter = icon,
            contentDescription = null,
            modifier = Modifier
                .size(24.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = action,
            fontWeight = FontWeight.SemiBold,
            fontFamily = QuickSand,
            fontSize = 16.sp,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
private fun PreviewSignUpScreen() = AppTheme {
    Column(Modifier.background(Color.White)) {
        Spacer(modifier = Modifier.padding(top = 24.dp))

        SignUpScreen()
    }
}