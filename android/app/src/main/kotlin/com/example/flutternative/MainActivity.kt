package com.example.flutternative

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log

import io.flutter.app.FlutterActivity
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant
import io.flutter.plugin.common.MethodCall



class MainActivity: FlutterActivity() {
  private val CHANNEL = "flutter.native/helper"
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    MethodChannel(flutterView, CHANNEL).setMethodCallHandler { call, result ->
      if (call.method == "helloFromNativeCode") {
          helloFromNativeCode()
        Log.e("native","hai native")
      }
    }
  }

  private fun helloFromNativeCode(){
    val builder = AlertDialog.Builder(this@MainActivity)
    builder.setTitle("Alert from native")
    builder.setMessage("This alert from native")

    // Set a positive button and its click listener on alert dialog
    builder.setPositiveButton("YES"){dialog, which ->

    }


    // Display a negative button on alert dialog
    builder.setNegativeButton("No"){dialog,which ->

    }


    // Display a neutral button on alert dialog
    builder.setNeutralButton("Cancel"){_,_ ->
    }
    val dialog: AlertDialog = builder.create()
    dialog.show()
  }
}
