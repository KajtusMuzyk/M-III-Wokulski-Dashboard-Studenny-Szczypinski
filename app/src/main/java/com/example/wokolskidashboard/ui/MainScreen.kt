package com.example.wokolskidashboard.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.wokolskidashboard.model.Transaction
import com.example.wokolskidashboard.ui.components.ExpenseForm
import com.example.wokolskidashboard.ui.components.IncomeForm

@Composable
fun MainScreen() {
    val transactions = remember { mutableStateListOf<Transaction>() }

    val balance = transactions.sumOf { if (it.isExpense) -it.amount else it.amount }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(text = "Dashboard Wokulskiego", style = MaterialTheme.typography.headlineMedium)

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Stan konta:")
                Text(text = "$balance rubli", style = MaterialTheme.typography.headlineLarge)
            }
        }

        Text(text = "Dodaj nowe:", style = MaterialTheme.typography.titleMedium)

        ExpenseForm(onTransactionAdded = { t -> transactions.add(t) })

        Spacer(modifier = Modifier.height(8.dp))

        IncomeForm(onAddIncome = { t -> transactions.add(t) })

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "Historia:", style = MaterialTheme.typography.titleMedium)

        transactions.forEach { t ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(text = t.name, modifier = Modifier.weight(1f))
                Text(
                    text = if (t.isExpense) "-${t.amount}" else "+${t.amount}",
                    color = if (t.isExpense) Color.Red else Color.Green
                )
            }
            HorizontalDivider()
        }
    }
}