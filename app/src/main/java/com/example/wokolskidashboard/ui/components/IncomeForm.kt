package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import com.example.wokolskidashboard.model.Transaction
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun IncomeForm(onAddIncome: (Transaction) -> Unit) {
    var name by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Przychody", style = MaterialTheme.typography.titleMedium)

    WokulskiTextField(
        value = name,
        onValueChange = { name = it },
        label =  "Nazwa towaru"
    )

    WokulskiTextField(
        value = amount,
        onValueChange = { amount = it },
        label = "Kwota (ruble)"
    )

        WokulskiButton(
            text = "Zapisz",
            onClick = {
                val parsedAmount = amount.toDoubleOrNull()
                if (name.isNotBlank() && parsedAmount != null && parsedAmount > 0) {
                    onAddIncome(Transaction(
                        name = name,
                        amount = parsedAmount,
                        isExpense = false,
                        category = "Sklep"
                    ))
                }
            }
        )

}
}