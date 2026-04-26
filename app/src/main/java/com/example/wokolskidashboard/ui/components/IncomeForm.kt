package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wokolskidashboard.model.Transaction

@Composable
fun IncomeForm(onAddIncome: (Transaction) -> Unit) {
    var name by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }

    val isFormValid = name.isNotBlank() && (amount.toDoubleOrNull() ?: 0.0) > 0.0

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("Nowy Przychód (Sklep)", style = MaterialTheme.typography.titleLarge)

        WokulskiTextField(
            value = name,
            onValueChange = { name = it },
            label = "Nazwa towaru / usługi"
        )

        WokulskiTextField(
            value = amount,
            onValueChange = { amount = it },
            label = "Kwota (ruble)"
        )

        WokulskiButton(
            text = "Zapisz przychód",
            enabled = isFormValid,
            onClick = {
                val parsedAmount = amount.toDoubleOrNull() ?: 0.0
                onAddIncome(
                    Transaction(
                        name = name,
                        amount = parsedAmount,
                        isExpense = false,
                        category = "Sklep"
                    )
                )
                name = ""
                amount = ""
            }
        )
    }
}