package ipvc.estg.problemscityapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        //Disable title bar
        val actionBar = supportActionBar
        actionBar!!.hide()

        //Button to go for MainActivity after Login
        btn_login.setOnClickListener {
            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)
        }

        //Button to go for NotesActivity for check Personal Notes
        btn_notas.setOnClickListener {
            val intent = Intent (this, NotesActivity::class.java)
            startActivity(intent)
        }
    }
}