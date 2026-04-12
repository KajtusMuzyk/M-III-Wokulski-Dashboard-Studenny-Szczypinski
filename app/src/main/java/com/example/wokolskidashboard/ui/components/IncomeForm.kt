package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import com.example.wokolskidashboard.model.Transaction

@Composable
fun IncomeForm(onAddIncome: (Transaction) -> Unit) {
    var name by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }



    TextField(
        value = name,
        onValueChange = { name = it },
        label = { Text("Nazwa towaru") }
    )

    TextField(
        value = amount,
        onValueChange = { amount = it },
        label = { Text("Kwota (ruble)") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}