package com.android.traveltube.ui.mypage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.android.traveltube.model.db.VideoBasicModel
import com.android.traveltube.repository.YoutubeRepositoryImpl
import com.android.traveltube.ui.favorite.FavoriteViewModel
import kotlinx.coroutines.launch

class WatchHistoryViewModel(
    private val youtubeRepositoryImpl: YoutubeRepositoryImpl
) : ViewModel() {
    private val _historyVideos = MutableLiveData<List<VideoBasicModel>>()
    val historyVideos: LiveData<List<VideoBasicModel>> get() = youtubeRepositoryImpl.getSavedVideos()
    fun deleteWatchHistoryItem(videoId: String) = viewModelScope.launch {
        youtubeRepositoryImpl.updateSavedStatus(videoId, false)
    }
}


class WatchHistoryViewModelFactory(
    private val youtubeRepositoryImpl: YoutubeRepositoryImpl,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WatchHistoryViewModel::class.java)) {
            return WatchHistoryViewModel(youtubeRepositoryImpl) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}