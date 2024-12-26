package da.chelimo.tiktok.presentation.screens

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class DiscoverViewModel : ViewModel() {

    val isLiked = MutableStateFlow(true)

}