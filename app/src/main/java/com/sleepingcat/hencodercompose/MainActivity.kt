package com.sleepingcat.hencodercompose

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.TextView
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
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import com.sleepingcat.hencodercompose.ext.switchTab
import com.sleepingcat.hencodercompose.http.ApiService
import com.sleepingcat.hencodercompose.nav.NavGraphBuilder
import com.sleepingcat.hencodercompose.utils.AppConfig
import com.sleepingcat.hencodercompose.view.AppBottomBar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread

//import androidx.compose.ui.tooling.preview.Preview
//import com.sleepingcat.hencodercompose.ui.theme.HencoderComposeTheme

class MainActivity : AppCompatActivity() {
    private val navController by lazy {
        (supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment).navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navGraph = NavGraphBuilder.build(navController, this)
        navController.setGraph(navGraph,null)
        findViewById<AppBottomBar>(R.id.bottom_bar).setOnItemSelectedListener {
            val tab = AppConfig.getBottomBarConfig().tabs[it.order]
            navController.switchTab(tab.route)
            !TextUtils.isEmpty(it.title)
        }

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
