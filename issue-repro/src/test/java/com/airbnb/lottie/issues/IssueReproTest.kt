package com.airbnb.lottie.issues

import app.cash.paparazzi.Paparazzi
import com.airbnb.lottie.Lottie
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieConfig
import com.airbnb.lottie.LottieTask
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import java.util.concurrent.Executor

class IssueReproTest {

    @get:Rule
    val temporaryFolder = TemporaryFolder()

    @get:Rule
    val paparazzi = Paparazzi(
        theme = "Theme.AppCompat",
        maxPercentDifference = 0.0,
    )

    @Before
    fun initialize() {
        LottieTask.EXECUTOR = Executor(Runnable::run)
        val lottieConfig = LottieConfig.Builder()
            .setNetworkCacheDir(temporaryFolder.root)
            .build()
        Lottie.initialize(lottieConfig)
    }

    @Test
    fun heartUrl() {
        val view = LottieAnimationView(paparazzi.context).apply {
            setAnimationFromUrl(
                "https://raw.githubusercontent.com/drewhamilton/lottie-android/b3488622a7606354e514c2741935831012cd53b2/issue-repro/src/main/res/raw/heart.json"
            )
        }
        paparazzi.snapshot(view)
    }

    @Test
    fun heartUrl2() {
        val view = LottieAnimationView(paparazzi.context).apply {
            setAnimationFromUrl(
                "https://raw.githubusercontent.com/drewhamilton/lottie-android/48e6678489e399ed0f8d4b41ac63556c12c1ba3c/issue-repro/src/main/res/raw/heart.json"
            )
        }
        paparazzi.snapshot(view)
    }
}
