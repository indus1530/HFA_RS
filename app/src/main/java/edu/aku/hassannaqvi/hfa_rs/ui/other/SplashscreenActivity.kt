package edu.aku.hassannaqvi.hfa_rs.ui.other

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.aku.hassannaqvi.hfa_rs.R
import edu.aku.hassannaqvi.hfa_rs.utils.extension.gotoActivity
import kotlinx.coroutines.*

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class SplashscreenActivity : AppCompatActivity() {
    private lateinit var activityScope: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
        activityScope = launchSplashScope()
    }

    override fun onPause() {
        super.onPause()
        activityScope.cancel()
    }

    override fun onResume() {
        super.onResume()
        if (activityScope.isActive.not())
            launchSplashScope()
    }

    override fun onDestroy() {
        super.onDestroy()
        activityScope.cancel()
    }

    private fun launchSplashScope() =
        CoroutineScope(Dispatchers.Main).launch {
            delay(SPLASH_TIME_OUT.toLong())
            finish()
            gotoActivity(LoginActivity::class.java)
        }

    companion object {
        private const val SPLASH_TIME_OUT = 1000
    }
}