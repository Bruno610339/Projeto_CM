package ipvc.estg.problemscityapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.icu.util.Output
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
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate

class AddReportActivity : AppCompatActivity() {

    private lateinit var title: EditText
    private lateinit var description: EditText
    private lateinit var type: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_report)

        // Change the title of Activity on bar
        val actionBar = supportActionBar
        actionBar!!.title = getString(R.string.addReport)
        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun insertReport(view: View) {
        title = findViewById(R.id.title)
        description = findViewById(R.id.description)
        type = findViewById(R.id.type)

        // Actual Date
        val date_creation = LocalDate.now().toString()

        // Shared Preferences variables
        val sharedPref: SharedPreferences = getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE)
        val user_id = sharedPref.getInt(getString(R.string.idSharedPref), 0)
        val lat = sharedPref.getFloat(getString(R.string.latSharedPref), 0.0f)
        val lng = sharedPref.getFloat(getString(R.string.lngSharedPref), 0.0f)

        // ********************** Test of the variables **************************
        //Toast.makeText(this, "id: $idUser + date: $realDate + location: " +
        //        "$latSharedPref / $lngSharedPref", Toast.LENGTH_SHORT).show()
        // ***********************************************************************

        val request = ServiceBuilder.buildService(EndPoints::class.java)
        val call = request.addReport(title.text.toString(), description.text.toString(), lat, lng,
                date_creation, type.text.toString(), user_id)
        val intent = Intent(this, MapsActivity::class.java)

        //If All the fields are filled
        if(title.text.toString().isNotEmpty() && description.text.toString().isNotEmpty() &&
                type.text.toString().isNotEmpty()) {

            call.enqueue(object : Callback<Report> {
                override fun onResponse(call: Call<Report>, response: Response<Report>) {
                    if(response.isSuccessful) {
                        val r: Report = response.body()!!
                        Toast.makeText(this@AddReportActivity, getString(R.string.toast_11), Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    }
                }
                override fun onFailure(call: Call<Report>, t: Throwable) {
                    Toast.makeText(this@AddReportActivity, "${t.message}", Toast.LENGTH_SHORT).show()
                    startActivity(intent)
                }
            })
        }
        else {
            Toast.makeText(applicationContext, getString(R.string.toast_10), Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
    }
}