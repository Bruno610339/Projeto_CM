package ipvc.estg.problemscityapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class HelpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.help)

        //Change the title of Activity on Bar
        val actionBar = supportActionBar
        actionBar!!.title = getString(R.string.help)
        actionBar.setDisplayHomeAsUpEnabled(true)

    }
}