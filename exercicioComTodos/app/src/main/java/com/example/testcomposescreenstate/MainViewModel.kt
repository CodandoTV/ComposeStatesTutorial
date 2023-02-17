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
        // TODO: 1 - Atualizar loading para true antes do launch da coroutine

        viewModelScope.launch {
            // TODO: 2 - Chamar a suspend function de delay

            //  TODO: 3 - No launch, após o delay, atualizar os países disponíveis

        }.invokeOnCompletion {
            // TODO: 4 - Atualizar o loading para false

        }
    }


    fun onCountryChange(country: String) {
        // TODO: 8 - Atualizar currentCountry do uiState
    }

    fun onNameChange(name: String) {
        // TODO: 4 - Atualizar userNameValue do uiState
    }
}