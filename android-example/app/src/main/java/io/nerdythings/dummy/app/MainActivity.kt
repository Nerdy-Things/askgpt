package io.nerdythings.dummy.app

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {

    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            val state by viewModel.uiState.collectAsState()
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color(0xFFFFFFFF)
            ) {
                MainScreen(state, viewModel::loadState, ::openNerdyThings)
            }
        }
        viewModel.prepareText(this)
    }

    private fun openNerdyThings() {
        val url = "https://www.youtube.com/@Nerdy.Things"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse(url))
        startActivity(intent)
    }
}