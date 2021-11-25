package edu.aku.hassannaqvi.hfa_rs.ui.sections

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.validatorcrawler.aliazaz.Validator
import edu.aku.hassannaqvi.hfa_rs.CONSTANTS.Companion.TRAINED_STAFF_SERIAL
import edu.aku.hassannaqvi.hfa_rs.R
import edu.aku.hassannaqvi.hfa_rs.contracts.StaffingContract
import edu.aku.hassannaqvi.hfa_rs.core.MainApp
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionC2Binding
import edu.aku.hassannaqvi.hfa_rs.ui.other.MainActivity
import edu.aku.hassannaqvi.hfa_rs.ui.other.SectionMainActivity
import edu.aku.hassannaqvi.hfa_rs.utils.openEndActivity
import org.json.JSONObject
import ru.whalemare.sheetmenu.ActionItem
import ru.whalemare.sheetmenu.SheetMenu
import ru.whalemare.sheetmenu.layout.GridLayoutProvider

class SectionC2Activity : AppCompatActivity() {
    lateinit var bi: ActivitySectionC2Binding
    lateinit var tsc: StaffingContract
    var serial = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c2)
        bi.callback = this
        SectionMainActivity.countC2++

        serial = intent.getIntExtra(TRAINED_STAFF_SERIAL, 1)
    }


    private fun UpdateDB(): Boolean {
        val db = MainApp.appInfo.dbHelper
        val updcount = db.addTSC(tsc)
        tsc._ID = updcount.toString()
        return if (updcount > 0) {
            tsc._UID = tsc.deviceID + tsc._ID
            db.updatesTSCColumn(tsc, StaffingContract.StaffingTable.COLUMN_UID, tsc._UID)
            true
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show()
            false
        }

    }

    private fun saveDraft() {

        tsc = StaffingContract()
        tsc.sysdate = MainApp.fc.sysdate
        tsc.userName = MainApp.fc.userName
        tsc.deviceID = MainApp.appInfo.deviceID
        tsc.devicetagID = MainApp.appInfo.tagName
        tsc.appversion = MainApp.appInfo.appVersion
        tsc._UUID = MainApp.fc._UID
        tsc.districtCode = MainApp.fc.districtCode
        tsc.districtType = MainApp.fc.districtType
        tsc.tehsilCode = MainApp.fc.tehsilCode
        tsc.ucCode = MainApp.fc.ucCode
        tsc.hfCode = MainApp.fc.hfCode
        tsc.serialno = serial.toString()
        tsc.status = "1"

        val json = JSONObject()

        json.put(
            "c021a",
            if (bi.c021a.text.toString().trim().isEmpty()) "-1" else bi.c021a.text.toString()
        )

        json.put(
            "c021b", when {
                bi.c021ba.isChecked -> "1"
                bi.c021bb.isChecked -> "2"
                bi.c021bc.isChecked -> "3"
                bi.c021bd.isChecked -> "4"
                bi.c021be.isChecked -> "5"
                bi.c021bf.isChecked -> "96"
                else -> "-1"
            }
        )
        json.put(
            "c021bfx",
            if (bi.c021bfx.text.toString().trim().isEmpty()) "-1" else bi.c021bfx.text.toString()
        )

        json.put(
            "c021c",
            if (bi.c021c.text.toString().trim().isEmpty()) "-1" else bi.c021c.text.toString()
        )

        json.put(
            "c021d", when {
                bi.c021da.isChecked -> "1"
                bi.c021db.isChecked -> "2"
                bi.c021dc.isChecked -> "3"
                bi.c021dd.isChecked -> "4"
                bi.c021de.isChecked -> "5"
                bi.c021df.isChecked -> "6"
                bi.c021dg.isChecked -> "96"
                else -> "-1"
            }
        )
        json.put(
            "c021dgx",
            if (bi.c021dgx.text.toString().trim().isEmpty()) "-1" else bi.c021dgx.text.toString()
        )

        json.put(
            "c021e",
            if (bi.c021e.text.toString().trim().isEmpty()) "-1" else bi.c021e.text.toString()
        )

        tsc.setsC2(json.toString())

    }


    private fun formValidation(): Boolean {
        return Validator.emptyCheckingContainer(this, bi.GrpName)
    }


    fun btnContinue(v: View) {
        routingNextActivity(MainActivity::class.java)
    }


    private fun routingNextActivity(activity: Class<*>, flag: Boolean = true) {
        if (!formValidation()) return
        saveDraft()
        if (UpdateDB()) {
            finish()
            var intent = Intent(this, activity).putExtra(TRAINED_STAFF_SERIAL, serial + 1)
            if (!flag)
                intent = Intent(this, activity)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show()
        }
    }


    fun btnAddMore(v: View) {

        SheetMenu(
            "Select your Action",
            listOf(
                ActionItem(
                    0,
                    "Add More",
                    getDrawable(R.drawable.ic_account_circle_black_24dp)
                ),
                ActionItem(
                    1,
                    "Next Section",
                    getDrawable(R.drawable.ic_keyboard_arrow_right_black_24dp)
                )
            ),
            onClick = { item: ActionItem ->
                run {
                    when (item.id) {
                        0 -> routingNextActivity(this::class.java)
                        else -> routingNextActivity(SectionMainActivity::class.java, false)
                    }
                }

            }, layoutProvider = GridLayoutProvider()
        ).show(this)

    }

    fun btnEnd(v: View) {
        openEndActivity(this)
    }


    override fun onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show()
    }

}