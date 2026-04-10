package com.example.wokolskidashboard.model

data class Transaction(
    val id: Int = (0..1000000).random(),
    val name: String,
    val amount: Double,
    val isExpense: Boolean,
    val category: String,
    val isNecessary: Boolean = true
)