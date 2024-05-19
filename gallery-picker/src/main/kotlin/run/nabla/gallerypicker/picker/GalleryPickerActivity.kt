package run.nabla.gallerypicker.picker

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.core.view.WindowCompat
import run.nabla.gallerypicker.picker.result.GalleryRequest
import run.nabla.gallerypicker.picker.result.RESULT_URI
import run.nabla.gallerypicker.picker.result.updateFromBundle

class GalleryPickerActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                setResult(Activity.RESULT_CANCELED)
                finish()
            }
        }
        onBackPressedDispatcher.addCallback(
            this,
            callback
        )

        val request = GalleryRequest().apply {
            this.updateFromBundle(intent.extras)
        }

        setContent {
            val onImageSelected: (Uri) -> Unit = {
                val resultIntent = Intent()
                resultIntent.putExtra(RESULT_URI, it.toString())
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }

            val typography = if (request.fontFamily > 0) {
                Typography(
                    defaultFontFamily = FontFamily(
                        Font(request.fontFamily),
                    ),
                )
            } else {
                MaterialTheme.typography
            }

            MaterialTheme(typography = typography) {
                GalleryPicker(
                    modifier = Modifier.statusBarsPadding(),
                    onImageSelected = onImageSelected,
                    backgroundColor = Color(request.backgroundColor.toULong()),
                    state = rememberGalleryPickerState(
                        horizontalPadding = request.horizontalPadding,
                        roundedCornerSize = request.itemsRoundedCornerSize,
                        gridColumns = request.gridColumns,
                        itemMinHeight = request.itemMinHeight,
                        itemMaxHeight = request.itemMaxHeight,
                    )
                )
            }
        }
    }
}