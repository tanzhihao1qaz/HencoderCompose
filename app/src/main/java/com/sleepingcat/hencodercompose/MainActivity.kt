package com.sleepingcat.hencodercompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.material3.Button
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.fragment.NavHostFragment
import com.sleepingcat.hencodercompose.nav.NavGraphBuilder

//import androidx.compose.ui.tooling.preview.Preview
//import com.sleepingcat.hencodercompose.ui.theme.HencoderComposeTheme

class MainActivity : AppCompatActivity() {
    private val navController by lazy {
        (supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment).navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity","home = ${R.id.homeFragment}; category = ${R.id.categoryFragment}; tags = ${R.id.tagsFragment}; user = ${R.id.userFragment} ")
        val navGraph = NavGraphBuilder.build(navController, this)
        navController.graph.addAll(navGraph)
        /*setContent {
            HencoderComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }*/
    }
}

/*
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HencoderComposeTheme {
        Greeting("Android")
    }
}*/
