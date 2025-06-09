package zed.rainxch.rainyyy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import zed.rainxch.rainyyy.core.presentation.designsystem.theme.RainyyyTheme
import zed.rainxch.rainyyy.core.presentation.navigation.AppNavigation

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        val restoredState = savedInstanceState?.getBundle(NAV_RESTORE_KEY)
        setContent {
            val navController = rememberNavController()
            navController.restoreState(restoredState)
            RainyyyTheme {
                AppNavigation(
                    navController = navController,
                )
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (::navController.isInitialized) {
            outState.putBundle(NAV_RESTORE_KEY, navController.saveState())
        }
    }

    companion object {
        const val NAV_RESTORE_KEY = "nav_state"
    }
}