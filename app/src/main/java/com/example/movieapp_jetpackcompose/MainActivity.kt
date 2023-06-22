package com.example.movieapp_jetpackcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieapp_jetpackcompose.navigation.MovieNavigation
import com.example.movieapp_jetpackcompose.ui.theme.MovieApp_jetpackComposeTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MovieNavigation()
            }

        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun MyApp(content: @Composable () -> Unit){  //content:@Composable() -> Unit

    MovieApp_jetpackComposeTheme {
       content()

    }

}







@Composable
fun MovieRow(movie:String,
             onItemClicked:(String)-> Unit={}){

    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        .height(130.dp)
        .clickable {
            onItemClicked(movie)

        },
         shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start){
            Surface(modifier = Modifier
                .padding(12.dp)
                .size(100.dp),
                shape = RectangleShape,
            shadowElevation = 4.dp){
                Icon(imageVector = Icons.Default.AccountBox,
                    contentDescription = "Movie Image")

            }
            Text(text = movie)

        }


    }

}


@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultPreview() {
    MyApp {

        MovieNavigation()
    }
}