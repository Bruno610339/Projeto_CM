package ipvc.estg.problemscityapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddNoteActivity: AppCompatActivity() {

    private lateinit var editText01: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_notes)

        editText01 = findViewById(R.id.editText01)

        val button = findViewById<Button>(R.id.button01)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editText01.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val word = editText01.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, word)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }
}