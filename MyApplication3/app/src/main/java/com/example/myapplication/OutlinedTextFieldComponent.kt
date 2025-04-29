package com.example.myapplication

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.KeyboardActionHandler
import androidx.compose.foundation.text.input.OutputTransformation
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldLabelScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import kotlinx.coroutines.flow.collectLatest

@Composable
fun TextFieldComponent(
    modifier: Modifier = Modifier,
    textState: TextFieldState,
    label: @Composable (TextFieldLabelScope.() -> Unit)? = null,
    isError: Boolean = false,
    onValueChanged: (String) -> Unit,
    keyboardActionHandler: KeyboardActionHandler? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    placeholder: @Composable (() -> Unit)? = null,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(),
    trailingIcon: @Composable (() -> Unit)? = null,
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    outputTransformation: OutputTransformation? = null,
    lineLimits: TextFieldLineLimits = TextFieldLineLimits.Default,
    leadingIcon: @Composable (() -> Unit)? = null,
) {
    LaunchedEffect(Unit) {
        snapshotFlow { textState.text }
            .collectLatest { text ->
                onValueChanged(text.toString())
            }
    }
    OutlinedTextField(
        state = textState,
        isError = isError,
        modifier = modifier,
        keyboardOptions = keyboardOptions,
        onKeyboardAction = keyboardActionHandler,
        label = label,
        placeholder = placeholder,
        colors = colors,
        trailingIcon = trailingIcon,
        textStyle = textStyle,
        outputTransformation = outputTransformation,
        lineLimits = lineLimits,
        leadingIcon = leadingIcon,
    )
}