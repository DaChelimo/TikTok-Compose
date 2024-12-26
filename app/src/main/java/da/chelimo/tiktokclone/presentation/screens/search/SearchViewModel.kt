package da.chelimo.tiktokclone.presentation.screens.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchViewModel: ViewModel() {
    private val _searchQuery = MutableLiveData<String>()
    val searchQuery: LiveData<String> = _searchQuery

    /**
     * Suggestions of accounts that start with the given query
     */
    private val _accountSuggestions = MutableLiveData<List<String>>()
    val accountSuggestions: LiveData<List<String>> = _accountSuggestions

    fun updateQuery(newValue: String) {
        _searchQuery.value = newValue
    }

}