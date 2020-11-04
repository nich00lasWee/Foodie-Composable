package com.example.composablefoodie

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

@Composable
fun foodCard (food: Food) {
    Card(
        // creates a round-cornered card with elevation
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp
    ) {
        // get drawable resources
        val image = imageResource(food.imageResource)
        val icon = vectorResource(R.drawable.ic_schedule_black_24dp)
        
        // apply Material Design principles to the components
        MaterialTheme {
            val typography = MaterialTheme.typography

            // stack elements vertically
            Column(
                // modifier determines how the elements should be styled
                modifier = Modifier.fillMaxSize()
            ) {
                val imageModifier = Modifier
                    .height(144.dp)
                    .fillMaxWidth()

                Image(image,
                    modifier = imageModifier,
                    contentScale = ContentScale.Crop)

                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = food.title,
                        style = typography.h5
                    )
                    Text(
                        text = food.description,
                        style = typography.body1
                    )

                    // specifies spacing between Text and Row
                    Spacer(Modifier.preferredHeight(4.dp))

                    // display elements horizontally
                    Row {
                        Text(
                            text = "Servings: ${food.servings}",
                            modifier = Modifier.padding(end = 24.dp),
                            style = typography.caption
                        )
                        Icon(icon, modifier = Modifier.preferredSize(16.dp))
                        Text(
                            text = "${food.duration} mins",
                            modifier = Modifier.padding(start = 8.dp),
                            style = typography.caption
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun foodCardPreview() {
    foodCard(food = foods[0])
}