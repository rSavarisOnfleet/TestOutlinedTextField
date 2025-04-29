package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.lifecycle.viewmodel.compose.viewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainContent()
        }
    }
}

@Composable
fun MainContent(
    modifier: Modifier = Modifier,
    viewModel: MyViewmodel = viewModel()) {
    MyApplicationTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Box(Modifier.padding(innerPadding)) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier
                        .verticalScroll(rememberScrollState())
                        .padding(8.dp),
                ) {
                    TextFieldComponent(
                        modifier = Modifier.testTag("component1"),
                        label = {
                            Text(
                                text = "Component1",
                                textAlign = TextAlign.Center
                            )
                        },
                        textState = viewModel.componentState1,
                        onValueChanged = { text ->
                            println("component1 " + text)
                        }
                    )
                    TextFieldComponent(
                        modifier = Modifier.testTag("component2"),
                        label = {
                            Text(
                                text = "Component2",
                                textAlign = TextAlign.Center
                            )
                        },
                        textState = viewModel.componentState2,
                        onValueChanged = { text ->
                            println("component2 " + text)
                        }
                    )
                    TextFieldComponent(
                        modifier = Modifier.testTag("component3"),
                        label = {
                            Text(
                                text = "Component3",
                                textAlign = TextAlign.Center
                            )
                        },
                        textState = viewModel.componentState3,
                        onValueChanged = { text ->
                            println("component3 " + text)
                        }
                    )
                }
            }
        }
    }
}