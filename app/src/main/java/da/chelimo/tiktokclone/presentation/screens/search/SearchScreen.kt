package da.chelimo.tiktokclone.presentation.screens.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel

@Composable
fun SearchScreen(modifier: Modifier = Modifier) {
    val viewModel = koinViewModel<SearchViewModel>()
    val query by viewModel.searchQuery.observeAsState("")

    Column(modifier = Modifier.fillMaxSize()) {
        TextField(value = query, leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Search,
                contentDescription = null,
                tint = Color.LightGray,
                modifier = Modifier
                    .padding(4.dp)
                    .size(26.dp)
            )
        }, onValueChange = { newQuery -> viewModel.updateQuery(newQuery) })

        Card(
            shape = RoundedCornerShape(4.dp)
        ) {

        }
    }
}


@Preview
@Composable
private fun PreviewSearchScreen() {

}