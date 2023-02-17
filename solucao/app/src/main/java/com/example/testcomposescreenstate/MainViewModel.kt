package com.example.testcomposescreenstate

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

data class MainUIState(
    val isLoading: Boolean,

    val userNameValue: String,

    // region countriesSelector
    val availableCountries: List<String>,
    val currentCountry: String,
    // endregion
)

class MainViewModel : ViewModel() {

    private val _uiState = mutableStateOf(
        MainUIState(
            isLoading = false,
            userNameValue = "Digite seu nome",
            availableCountries = emptyList(),
            currentCountry = "Selecione seu país",
        )
    )
    val uiState: State<MainUIState> = _uiState

    init {
        _uiState.value = _uiState.value.copy(
            isLoading = true
        )

        viewModelScope.launch {
            delay(3000L)

            _uiState.value = _uiState.value.copy(
                availableCountries = listOf(
                    "Brazil", "Argentina", "Noruega"
                )
            )
        }.invokeOnCompletion {
            _uiState.value = _uiState.value.copy(
                isLoading = false
            )
        }
    }


    fun onCountryChange(country: String) {
        _uiState.value = _uiState.value.copy(
            currentCountry = country
        )
    }

    fun onNameChange(name: String) {
        _uiState.value = _uiState.value.copy(
            userNameValue = name
        )
    }
}