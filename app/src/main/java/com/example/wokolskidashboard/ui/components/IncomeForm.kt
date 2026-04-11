package com.example.wokolskidashboard.ui.components

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