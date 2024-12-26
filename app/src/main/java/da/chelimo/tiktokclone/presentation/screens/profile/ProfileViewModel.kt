package da.chelimo.tiktokclone.presentation.screens.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import da.chelimo.tiktokclone.domain.video.preview.VideoPreview

class ProfileViewModel: ViewModel() {

    private val _myVideoPreviews = MutableLiveData<List<VideoPreview>>()
    val myVideoPreviews: LiveData<List<VideoPreview>> = _myVideoPreviews

    private val _repostPreviews = MutableLiveData<List<VideoPreview>>()
    val repostPreviews: LiveData<List<VideoPreview>> = _repostPreviews


    private val _likedPreviews = MutableLiveData<List<VideoPreview>>()
    val likedPreviews: LiveData<List<VideoPreview>> = _likedPreviews


}