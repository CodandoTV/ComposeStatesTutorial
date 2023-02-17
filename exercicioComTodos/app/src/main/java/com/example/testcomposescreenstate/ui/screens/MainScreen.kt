package com.example.testcomposescreenstate.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.testcomposescreenstate.MainUIState
import com.example.testcomposescreenstate.MainViewModel
import com.example.testcomposescreenstate.ui.widgets.BaseInputText
import com.example.testcomposescreenstate.ui.widgets.CommonDropDown
import com.example.testcomposescreenstate.ui.widgets.Loader

@Composable
fun MainScreen(viewModel: MainViewModel) {
    val uiState = remember {
        // TODO: 5 - Substituir essa linha pelo uiState do viewModel
        MainUIState(false,"", emptyList(), currentCountry = "")
    }

    // TODO: 6 - Substituir o isLoading pelo uiState.isLoading
    val isLoading = false
    // TODO: 7 - Substituir o countries pelo uiState.availableCountries
    val countries = listOf("País 1", "País 2")
    // TODO: 10 - Substituir o currentCountry pelo uiState.currentCountry
    val currentCountry = "País"
    // TODO: 11 - Substituir o userName pelo uiState.userNameValue
    val userName = "Nome"

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        if (isLoading) {
            Loader()
        } else {
            Text("CodandoTV - Compose & State", style = MaterialTheme.typography.h3)

            Spacer(modifier = Modifier.height(12.dp))

            CommonDropDown(
                options = countries,
                currentValue = currentCountry,
                onDropDownValueChanged = { country ->
                    viewModel.onCountryChange(
                        country = country,
                    )
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            BaseInputText(
                currentText = userName,
                onTextChange = { userName ->
                    viewModel.onNameChange(userName)
                },
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = {
                    Toast.makeText(
                        context,
                        "Salvo que: $userName vive em $currentCountry",
                        Toast.LENGTH_SHORT
                    ).show()
                }) {
                Text("Salvar")
            }
        }
    }
}