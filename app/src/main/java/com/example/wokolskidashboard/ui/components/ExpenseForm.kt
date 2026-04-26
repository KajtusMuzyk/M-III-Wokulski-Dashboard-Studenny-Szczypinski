package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wokolskidashboard.model.Transaction

@Composable
fun ExpenseForm(onTransactionAdded: (Transaction) -> Unit) {
    var name by remember { mutableStateOf("") }
    var amountStr by remember { mutableStateOf("") }
    var isNecessary by remember { mutableStateOf(true) }

    val isFormValid = name.isNotBlank() && (amountStr.toDoubleOrNull() ?: 0.0) > 0.0

    Card(
        modifier = Modifier.padding(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.errorContainer)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text("Nowy Koszt", style = MaterialTheme.typography.titleLarge)

            WokulskiTextField(value = name, onValueChange = { name = it }, label = "Nazwa")
            WokulskiTextField(value = amountStr, onValueChange = { amountStr = it }, label = "Kwota")

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Wydatek konieczny?", modifier = Modifier.weight(1f))
                Switch(checked = isNecessary, onCheckedChange = { isNecessary = it })
            }

            WokulskiButton(
                text = "Zapisz koszt",
                enabled = isFormValid,
                onClick = {
                    val doubleAmount = amountStr.toDoubleOrNull() ?: 0.0
                    val cat = if (isNecessary) "Wydatek Konieczny" else "Wydatek Osobisty"

                    onTransactionAdded(
                        Transaction(
                            name = name,
                            amount = doubleAmount,
                            isExpense = true,
                            category = cat
                        )
                    )

                    name = ""
                    amountStr = ""
                }
            )
        }
    }
}