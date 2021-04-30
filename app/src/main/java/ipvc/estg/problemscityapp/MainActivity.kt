package ipvc.estg.problemscityapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
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
            R.id.profile -> {
                val intent = Intent (this, ProfileActivity::class.java)
                startActivity(intent)
            }
            R.id.notes -> {
                val intent = Intent (this, NotesActivity::class.java)
                startActivity(intent)
            }
            R.id.help -> {
                val intent = Intent (this, HelpActivity::class.java)
                startActivity(intent)
            }
            R.id.logout -> {
                val sharedPref: SharedPreferences = getSharedPreferences(
                        getString(R.string.preference_file_key), Context.MODE_PRIVATE)
                with(sharedPref.edit()){
                    putBoolean(getString(R.string.loginSharedPref), false)
                    putString(getString(R.string.nameSharedPref), "")
                    putInt(getString(R.string.idSharedPref), 0)
                    commit()
                }

                val intent = Intent (this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        return true
    }


}