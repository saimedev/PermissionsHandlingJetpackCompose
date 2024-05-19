package com.saimedevs.compose.permissionshandlingjetpackcompose

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import com.saimedevs.compose.permissionshandlingjetpackcompose.picker.GalleryPicker
import com.saimedevs.compose.permissionshandlingjetpackcompose.ui.theme.PermissionsHandlingJetpackComposeTheme

class MainActivity : ComponentActivity() {


    @OptIn(ExperimentalPermissionsApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val context = LocalContext.current
            val showRationalDialog = remember { mutableStateOf(false) }
            val isPermission = remember { mutableStateOf(false) }

            PermissionsHandlingJetpackComposeTheme {
                val permissionState = rememberPermissionState(
                    permission = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
                        Manifest.permission.READ_MEDIA_IMAGES
                    else
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                    onPermissionResult = { isGranted ->
                        if (isGranted) {
                          isPermission.value = isGranted
                        } else {
                            Toast.makeText(this, "Denial", Toast.LENGTH_SHORT).show()
                        }
                    }
                )

                LaunchedEffect(permissionState) {
                    if (!permissionState.status.isGranted && permissionState.status.shouldShowRationale) {
                        showRationalDialog.value = true
                    } else {
                        permissionState.launchPermissionRequest()
                    }
                }

                if (isPermission.value){
                    GalleryPicker(
                        modifier = Modifier.safeContentPadding(),
                       // state = rememberGalleryPickerState(),
                        backgroundColor = Color.Black,
                        onImageSelected = {
                            Toast.makeText(this, it.path, Toast.LENGTH_SHORT).show()
                        }
                    )
                }

                if (showRationalDialog.value) {
                    AlertDialog(
                        onDismissRequest = { showRationalDialog.value = false },
                        title = {
                            Text(
                                text = "Permission",
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                        },
                        text = {
                            Text(
                                "The Photo is important for this app. Please grant the permission.",
                                fontSize = 16.sp
                            )
                        },
                        confirmButton = {
                            TextButton(
                                onClick = {
                                    showRationalDialog.value = false
                                    val intent = Intent(
                                        Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                                        Uri.fromParts("package", context.packageName, null)
                                    ).apply {
                                        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                    }
                                    ContextCompat.startActivity(context, intent, null)
                                }
                            ) {
                                Text("OK", style = TextStyle(color = Color.Black))
                            }
                        },
                        dismissButton = {
                            TextButton(onClick = { showRationalDialog.value = false }) {
                                Text("Cancel", style = TextStyle(color = Color.Black))
                            }
                        },
                    )
                }
            }
        }
    }
}