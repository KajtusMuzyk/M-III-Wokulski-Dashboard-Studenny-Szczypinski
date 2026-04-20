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
import com.example.wokolskidashboard.ui.components.BalanceHeader
import com.example.wokolskidashboard.ui.components.ExpenseForm
import com.example.wokolskidashboard.ui.components.IncomeForm
import com.example.wokolskidashboard.ui.components.TransactionCard

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
        Text(text = "Dodaj nowe:", style = MaterialTheme.typography.titleMedium)

        BalanceHeader(balance = balance)

        ExpenseForm(onTransactionAdded = { t -> transactions.add(t) })

        Spacer(modifier = Modifier.height(8.dp))

        IncomeForm(onAddIncome = { t -> transactions.add(t) })

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "Historia:", style = MaterialTheme.typography.titleMedium)

        transactions.reversed().forEach { t ->
            TransactionCard(transaction = t)
        }
    }
}