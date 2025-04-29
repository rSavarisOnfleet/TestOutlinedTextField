package com.example.myapplication

import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performTextClearance
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performTextReplacement
import androidx.lifecycle.viewmodel.compose.viewModel
import org.junit.Rule
import org.junit.Test

class MyComposeTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun errorWhenReplaceTheOldField() {
        composeTestRule.setContent {
            MainContent(viewModel = MyViewmodel())
        }

        composeTestRule.onNodeWithTag("component1").assertExists()
        composeTestRule.onNodeWithTag("component2").assertExists()
        composeTestRule.onNodeWithTag("component3").assertExists()


        composeTestRule.onNodeWithTag("component1").performTextInput("test1")
        composeTestRule
            .onNodeWithTag("component1").assertTextContains("test1")

        composeTestRule.onNodeWithTag("component2").performTextInput("test2")
        composeTestRule
            .onNodeWithTag("component2").assertTextContains("test2")

        composeTestRule.onNodeWithTag("component3").performTextInput("test3")
        composeTestRule
            .onNodeWithTag("component3").assertTextContains("test3")

        composeTestRule
            .onNodeWithTag("component1").assertTextContains("test1")
        composeTestRule
            .onNodeWithTag("component2").assertTextContains("test2")
        composeTestRule
            .onNodeWithTag("component3").assertTextContains("test3")

        composeTestRule.onNodeWithTag("component1")
            .performTextReplacement("test11")
        composeTestRule
            .onNodeWithTag("component1").assertTextContains("test11")
        composeTestRule
            .onNodeWithTag("component2").assertTextContains("test2")
        composeTestRule
            .onNodeWithTag("component3").assertTextContains("test3")

        composeTestRule.onNodeWithTag("component1").performTextReplacement("")
        composeTestRule
            .onNodeWithTag("component1").assertTextContains("")
        composeTestRule
            .onNodeWithTag("component2").assertTextContains("test2")
        composeTestRule
            .onNodeWithTag("component3").assertTextContains("test3")

        composeTestRule.onNodeWithTag("component1").performTextReplacement("test1")
        composeTestRule
            .onNodeWithTag("component1").assertTextContains("test1")
        composeTestRule
            .onNodeWithTag("component2").assertTextContains("test2")
        composeTestRule
            .onNodeWithTag("component3").assertTextContains("test3")

        composeTestRule.onNodeWithTag("component1").performTextClearance()
        composeTestRule
            .onNodeWithTag("component1").assertTextContains("")
        composeTestRule
            .onNodeWithTag("component2").assertTextContains("test2")
        composeTestRule
            .onNodeWithTag("component3").assertTextContains("test3")

    }

    @Test
    fun errorWhenReplaceTheSameField() {

        composeTestRule.setContent {
            MainContent(viewModel = MyViewmodel())
        }

        composeTestRule.onNodeWithTag("component1").assertExists()
        composeTestRule.onNodeWithTag("component2").assertExists()
        composeTestRule.onNodeWithTag("component3").assertExists()

        composeTestRule.onNodeWithTag("component1").performTextReplacement("0")
        composeTestRule
            .onNodeWithTag("component1").assertTextContains("0")
        composeTestRule.onNodeWithTag("component1").performTextReplacement("3")
        composeTestRule
            .onNodeWithTag("component1").assertTextContains("3")

        /////

        composeTestRule.onNodeWithTag("component2").performTextReplacement("40")
        composeTestRule
            .onNodeWithTag("component2").assertTextContains("40")
        composeTestRule.onNodeWithTag("component2").performTextReplacement("10")
        composeTestRule
            .onNodeWithTag("component2").assertTextContains("10")

        ////

        composeTestRule.onNodeWithTag("component3").performTextReplacement("1800")
        composeTestRule
            .onNodeWithTag("component3").assertTextContains("1800")

        ////

        composeTestRule.onNodeWithTag("component1").performTextReplacement("13")
        composeTestRule
            .onNodeWithTag("component1").assertTextContains("13")

        ///

        composeTestRule.onNodeWithTag("component3").performTextReplacement("2000")
        composeTestRule
            .onNodeWithTag("component3").assertTextContains("2000")


    }

    @Test
    fun testCleaningTheFieldBetweenAddNew() {

        composeTestRule.setContent {
            MainContent(viewModel = MyViewmodel())
        }

        composeTestRule.onNodeWithTag("component1").assertExists()
        composeTestRule.onNodeWithTag("component2").assertExists()
        composeTestRule.onNodeWithTag("component3").assertExists()

        composeTestRule.onNodeWithTag("component1").performTextReplacement("0000")
        composeTestRule
            .onNodeWithTag("component1").assertTextContains("0000")

        composeTestRule.onNodeWithTag("component1").performTextClearance()
        composeTestRule
            .onNodeWithTag("component1").assertTextContains("")
        composeTestRule.onNodeWithTag("component1").performTextReplacement("3")
        composeTestRule
            .onNodeWithTag("component1").assertTextContains("3")

    }

}