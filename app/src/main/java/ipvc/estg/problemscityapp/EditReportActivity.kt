package ipvc.estg.problemscityapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import ipvc.estg.problemscityapp.api.EndPoints
import ipvc.estg.problemscityapp.api.Report
import ipvc.estg.problemscityapp.api.ServiceBuilder
import kotlinx.android.synthetic.main.edit_report.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate

class EditReportActivity : AppCompatActivity() {

    private lateinit var title: EditText
    private lateinit var description: EditText
    private lateinit var type: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_report)
    }

    fun updateReport(view: View) {}
    fun deleteReport(view: View) {}
}