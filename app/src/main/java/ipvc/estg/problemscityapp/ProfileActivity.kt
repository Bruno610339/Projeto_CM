package ipvc.estg.problemscityapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)

        //Change the title of Activity on Bar
        val actionBar = supportActionBar
        actionBar!!.title = getString(R.string.profile)
        actionBar.setDisplayHomeAsUpEnabled(true)

    }
}