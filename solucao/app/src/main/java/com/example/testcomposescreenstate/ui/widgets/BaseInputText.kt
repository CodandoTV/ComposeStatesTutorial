package com.example.testcomposescreenstate.ui.widgets

import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

typealias OnTextChanged = (String) -> Unit

@Composable
fun BaseInputText(
    // data
    currentText: String,
    // callback
    onTextChange: OnTextChanged,
    // general purpose
    modifier: Modifier = Modifier
) {
    TextField(
        maxLines = 1,
        value = currentText,
        modifier = modifier,
        onValueChange = {
            onTextChange(it)
        }
    )
}