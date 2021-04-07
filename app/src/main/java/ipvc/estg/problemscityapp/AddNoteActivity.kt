package ipvc.estg.problemscityapp

import android.app.Activity
import android.app.Notification.EXTRA_TITLE
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.add_notes.*

class AddNoteActivity: AppCompatActivity() {

    private lateinit var editText01: EditText
    private lateinit var editText02: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_notes)

        editText01 = findViewById(R.id.editText01)
        editText02 = findViewById(R.id.editText02)

        val button = findViewById<Button>(R.id.button01)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editText01.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            }
            else {
                replyIntent.putExtra(EXTRA_REPLY_TITLE, editText01.text.toString())
                replyIntent.putExtra(EXTRA_REPLY_DESC, editText02.text.toString())

                setResult(Activity.RESULT_OK, replyIntent)
                Toast.makeText(applicationContext, "New note inserted!", Toast.LENGTH_SHORT).show()
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY_TITLE = "com.example.android.wordlistsql.REPLY"
        const val EXTRA_REPLY_DESC = "com.example.android.wordlistsql.REPLY"
    }
}