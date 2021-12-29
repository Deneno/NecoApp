package ya.deneno.necoapp3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ya.deneno.necoapp3.databinding.ActivityMain2Binding
import ya.deneno.necoapp3.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var bindingClass: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        val message = intent.getStringExtra("key")
        bindingClass.textView2.text = message

        bindingClass.button2.setOnClickListener {
            val intent = Intent()
            intent.putExtra("keyBack", "Who is it?")
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}