package ipvc.estg.problemscityapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        //Variables for Shared Preferences
        val sharedPref: SharedPreferences = getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE)
        val loginSharedPref = sharedPref.getBoolean(getString(R.string.loginSharedPref), false)
        val nameSharedPref = sharedPref.getString(getString(R.string.nameSharedPref), "")
        val idSharedPref = sharedPref.getInt(getString(R.string.idSharedPref), 0)

        //Disable title bar
        val actionBar = supportActionBar
        actionBar!!.hide()

        //Button to go for NotesActivity for check Personal Notes
        btn_notas.setOnClickListener {
            val intent = Intent (this, NotesActivity::class.java)
            startActivity(intent)
        }

        //Check if login is already have login and redirect to MainActivity
        if(loginSharedPref) {
            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun loginSharedPref(view: View) {
        //To do
    }
}