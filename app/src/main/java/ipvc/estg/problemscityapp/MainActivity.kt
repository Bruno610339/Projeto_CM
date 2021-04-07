package ipvc.estg.problemscityapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //Function to call the menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.notes -> {
                val intent = Intent (this, NotesActivity::class.java)
                startActivity(intent)
            }
            R.id.help -> {
                val intent = Intent (this, HelpActivity::class.java)
                startActivity(intent)
            }
        }
        return true
    }
}