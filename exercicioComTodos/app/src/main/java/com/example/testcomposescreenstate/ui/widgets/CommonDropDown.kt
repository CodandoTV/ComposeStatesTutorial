package com.example.testcomposescreenstate.ui.widgets

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

typealias OnDropDownValueChanged <T> = (T) -> Unit

@Composable
fun <T> CommonDropDown(
    // data
    options: List<T>,
    currentValue: T,
    // action
    onDropDownValueChanged: OnDropDownValueChanged<T>,
    // modifier - general purpose
    modifier: Modifier = Modifier,
) {
    val expanded = remember { mutableStateOf(false) }

    Box(modifier) {
        OutlinedButton(
            modifier = modifier
                .align(alignment = Alignment.CenterStart)
                .padding(vertical = 12.dp),
            onClick = {
                expanded.value = true
            }
        ) {
            Text(
                text = currentValue.toString(),
                fontSize = 12.sp
            )
        }

        DropdownMenu(
            expanded = expanded.value,
            onDismissRequest = { expanded.value = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    onClick = {
                        onDropDownValueChanged(option)
                        expanded.value = false
                    }
                ) {
                    Text(
                        option.toString(),
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun CommonDropDownPreview() {
    CommonDropDown(
        options = emptyList(),
        currentValue = "test",
        onDropDownValueChanged = { }
    )
}