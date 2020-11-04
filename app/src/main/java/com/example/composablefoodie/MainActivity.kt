package com.example.composablefoodie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.composablefoodie.ui.ComposableFoodieTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            mainContent()
        }
    }
}

@Composable
fun mainContent () {
    // Scaffold implements the UI with the basic Material Design layout structure
    Scaffold(
        // top AppBar
        topBar = {
            TopAppBar(
                title = { Text("Composable Foodie") }
            )
        }
    ) {
        // body content
        foodList(foods)
    }
}

@Composable
fun foodList (foodList : List<Food>) {
    ScrollableColumn(Modifier.fillMaxSize()) {
        Column(Modifier.padding(16.dp)) {
            // creates a card for each Food in foodList
            foodList.forEach {
                Spacer(Modifier.preferredHeight(16.dp))
                foodCard(it)
                Spacer(Modifier.preferredHeight(16.dp))
            }
        }
    }
}

val foods = listOf(
    Food(R.drawable.pizza,"Pizza","Cheesy Family-style Pepperoni Pizza", 2, 45),
    Food(R.drawable.carbonara, "Carbonara", "Tasty Carbonara Pasta Topped with Mozarella Cheese", 1, 30),
    Food(R.drawable.fish_and_chips, "Fish & Chips", "Classic British-style Fish and Chips", 1, 45),
    Food(R.drawable.dumplings, "Dumplings", "Steaming-hot Shrimp Dumplings", 1, 15)
)

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposableFoodieTheme {
        mainContent()
    }
}