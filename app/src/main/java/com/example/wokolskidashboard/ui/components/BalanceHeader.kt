package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun BalanceHeader(balance: Double) {
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
}