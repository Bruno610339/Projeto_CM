package ipvc.estg.problemscityapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.model.LatLng
import ipvc.estg.problemscityapp.api.EndPoints
import ipvc.estg.problemscityapp.api.ServiceBuilder
import ipvc.estg.problemscityapp.api.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileActivity : AppCompatActivity() {

    val nameText: TextView = findViewById<TextView>(R.id.name)
    val emailText: TextView = findViewById<TextView>(R.id.email)
    val addressText: TextView = findViewById<TextView>(R.id.address)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)

        //Change the title of Activity on Bar
        val actionBar = supportActionBar
        actionBar!!.title = getString(R.string.profile)
        actionBar.setDisplayHomeAsUpEnabled(true)

        //Variables Shared Preferences
        val sharedPref: SharedPreferences = getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE)
        val nameUser = sharedPref.getString(getString(R.string.nameSharedPref), "")

        val request = ServiceBuilder.buildService(EndPoints::class.java)
        val call = request.getUserByName(nameUser.toString())

        call.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    val u: User = response.body()!!

                    nameText.text = u.name
                    emailText.text = u.email
                    addressText.text = u.adress
                }
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(this@ProfileActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })

    }
}