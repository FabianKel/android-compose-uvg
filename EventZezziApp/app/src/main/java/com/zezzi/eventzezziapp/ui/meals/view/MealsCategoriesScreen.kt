package com.zezzi.eventzezziapp.ui.meals.view

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.zezzi.eventzezziapp.navigation.AppBar
import com.zezzi.eventzezziapp.data.networking.response.MealResponse

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealsCategoriesScreen(
    navController: NavController,
    viewModel: MealsCategoriesViewModel = viewModel()
) {
    LaunchedEffect(key1 = "Meals"){
        viewModel.getMeals()
    }

    Scaffold(
        topBar = {
            AppBar(title = "Categories", navController = navController)
        }
    ) {

        LazyColumn(contentPadding = it, modifier = Modifier) {
            items(viewModel.categories.value) { meal ->
                //Text(text = meal.name)
                //CARDS

                Card(modifier = Modifier
                    .padding(bottom = 8.dp, start = 8.dp, end = 8.dp)

                    .clickable(onClick = {
                        //mContext.startActivity(Intent(mContext, ShowReceta::class.java).putExtra("id",this.descripcion))
                    })
                    .width(320.dp)
                    .height(500.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)){
                    Column {
                        Column(modifier = Modifier.width(50.dp)){
                            Image(
                                painter= rememberAsyncImagePainter(model = meal.imageUrl),
                                contentDescription="Recipe Image",
                                modifier= Modifier
                                    .fillMaxWidth()
                                    .height(150.dp)
                                    .padding(bottom = 8.dp),
                                contentScale= ContentScale.Crop
                            )
                        }
                    }
                    Column {
                        Row {
                            val headModi = Modifier.padding(horizontal = 15.dp, vertical = 15.dp)
                            Column(modifier = headModi){
                                Row {
                                    Text(text = meal.name)
                                }
                                Row{
                                    Text(text = meal.description)
                                }

                            }
                        }

                    }
                }
            }
        }
    }
}