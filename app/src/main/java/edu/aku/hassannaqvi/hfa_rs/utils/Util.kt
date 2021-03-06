package edu.aku.hassannaqvi.hfa_rs.utils

import android.Manifest
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.core.content.ContextCompat
import edu.aku.hassannaqvi.hfa_rs.CONSTANTS
import edu.aku.hassannaqvi.hfa_rs.R
import edu.aku.hassannaqvi.hfa_rs.core.MainApp
import edu.aku.hassannaqvi.hfa_rs.core.MainApp._EMPTY_
import edu.aku.hassannaqvi.hfa_rs.ui.other.EndingActivity
import edu.aku.hassannaqvi.hfa_rs.ui.other.SectionMainActivity
import java.util.*

private fun checkPermission(context: Context): IntArray {
    return intArrayOf(
        ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.READ_CONTACTS
        ), ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.GET_ACCOUNTS
        ), ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.READ_PHONE_STATE
        ), ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ), ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ), ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        ), ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.CAMERA
        )
    )
}

fun getPermissionsList(context: Context): List<String> {
    val permissions = arrayOf(
        Manifest.permission.READ_CONTACTS, Manifest.permission.GET_ACCOUNTS,
        Manifest.permission.READ_PHONE_STATE, Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.CAMERA
    )
    val listPermissionsNeeded: MutableList<String> = ArrayList()
    for (i in checkPermission(context).indices) {
        if (checkPermission(context)[i] != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(permissions[i])
        }
    }
    return listPermissionsNeeded
}

@JvmOverloads
fun openEndActivity(activity: Activity, childEndingActivity: Boolean = false) {
    val dialog = Dialog(activity)
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog.setContentView(R.layout.item_dialog_2)
    dialog.setCancelable(false)
    val params = WindowManager.LayoutParams()
    params.copyFrom(dialog.window!!.attributes)
    params.width = WindowManager.LayoutParams.WRAP_CONTENT
    params.height = WindowManager.LayoutParams.WRAP_CONTENT
    dialog.show()
    dialog.window!!.attributes = params
    dialog.findViewById<View>(R.id.btnOk).setOnClickListener { view: View? ->
        activity.finish()
        val intent = Intent(activity, EndingActivity::class.java).putExtra("complete", false)
            .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        if (childEndingActivity) intent.putExtra(CONSTANTS.SECTION_MAIN_CHECK_FOR_END, true)
        activity.startActivity(intent)
    }
    dialog.findViewById<View>(R.id.btnNo).setOnClickListener { view: View? -> dialog.dismiss() }
}

fun openSectionMainActivity(activity: Activity, item: String) {
    val dialog = Dialog(activity)
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog.setContentView(R.layout.item_dialog_2)
    dialog.setCancelable(false)
    val params = WindowManager.LayoutParams()
    params.copyFrom(dialog.window!!.attributes)
    params.width = WindowManager.LayoutParams.WRAP_CONTENT
    params.height = WindowManager.LayoutParams.WRAP_CONTENT
    dialog.show()
    dialog.window!!.attributes = params
    dialog.findViewById<View>(R.id.btnOk).setOnClickListener { view: View? ->

        when (item) {
            "B" -> MainApp.fc.setsB("")
            "C" -> MainApp.fc.setsC("")
            "D" -> MainApp.fc.setsD("")
            "E" -> MainApp.fc.setsE("")
            "F" -> MainApp.fc.setsF("")
            "G" -> MainApp.fc.setsG("")
            "H" -> MainApp.fc.setsH("")
            "I" -> MainApp.fc.setsI("")
            "J" -> MainApp.fc.setsJ("")
            "K" -> MainApp.fc.setsK("")
        }

        activity.finish()
        val intent = Intent(activity, SectionMainActivity::class.java)
            .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        activity.startActivity(intent)
    }
    dialog.findViewById<View>(R.id.btnNo).setOnClickListener { view: View? -> dialog.dismiss() }
}

fun openSectionMainActivityI(activity: Activity) {
    val dialog = Dialog(activity)
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog.setContentView(R.layout.item_dialog_2)
    dialog.setCancelable(false)
    val params = WindowManager.LayoutParams()
    params.copyFrom(dialog.window!!.attributes)
    params.width = WindowManager.LayoutParams.WRAP_CONTENT
    params.height = WindowManager.LayoutParams.WRAP_CONTENT
    dialog.show()
    dialog.window!!.attributes = params
    dialog.findViewById<View>(R.id.btnOk).setOnClickListener { view: View? ->

        if (MainApp.fc.getsI().isNotEmpty()) MainApp.fc.setsI(_EMPTY_)
        if (MainApp.psc.getsI1().isNotEmpty()) MainApp.psc.setsI1(_EMPTY_)
        if (MainApp.psc.getsI2().isNotEmpty()) MainApp.psc.setsI2(_EMPTY_)
        if (MainApp.psc.getsI3().isNotEmpty()) MainApp.psc.setsI3(_EMPTY_)
        if (MainApp.psc.getsI4().isNotEmpty()) MainApp.psc.setsI4(_EMPTY_)

        activity.finish()
        val intent = Intent(activity, SectionMainActivity::class.java)
            .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        activity.startActivity(intent)
    }
    dialog.findViewById<View>(R.id.btnNo).setOnClickListener { view: View? -> dialog.dismiss() }
}

fun openChildEndActivity(activity: Activity) {
    val dialog = Dialog(activity)
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog.setContentView(R.layout.item_dialog)
    dialog.setCancelable(false)
    val params = WindowManager.LayoutParams()
    params.copyFrom(dialog.window!!.attributes)
    params.width = WindowManager.LayoutParams.WRAP_CONTENT
    params.height = WindowManager.LayoutParams.WRAP_CONTENT
    dialog.show()
    dialog.window!!.attributes = params
    dialog.findViewById<View>(R.id.btnOk).setOnClickListener { view: View? ->
        activity.finish()
        //activity.startActivity(Intent(activity, ChildEndingActivity::class.java).putExtra("complete", false))
        activity.startActivity(Intent(activity, SectionMainActivity::class.java))
    }
    dialog.findViewById<View>(R.id.btnNo).setOnClickListener { view: View? -> dialog.dismiss() }
}

fun contextEndActivity(activity: Activity) {
    val dialog = Dialog(activity)
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog.setContentView(R.layout.item_dialog_2)
    dialog.setCancelable(false)
    val params = WindowManager.LayoutParams()
    params.copyFrom(dialog.window!!.attributes)
    params.width = WindowManager.LayoutParams.WRAP_CONTENT
    params.height = WindowManager.LayoutParams.WRAP_CONTENT
    dialog.show()
    dialog.window!!.attributes = params
    val endSecAActivity = activity as EndSectionActivity
    dialog.findViewById<View>(R.id.btnOk)
        .setOnClickListener { view: View? -> endSecAActivity.endSecActivity(true) }
    dialog.findViewById<View>(R.id.btnNo).setOnClickListener { view: View? -> dialog.dismiss() }
}

fun getMemberIcon(gender: Int, age: String): Int {
    val memAge = age.toInt()
    return if (memAge == -1) R.drawable.boy else if (memAge > 10) if (gender == 1) R.drawable.ctr_male else R.drawable.ctr_female else if (gender == 1) R.drawable.ctr_childboy else R.drawable.ctr_childgirl
}

interface EndSectionActivity {
    fun endSecActivity(flag: Boolean)
}
