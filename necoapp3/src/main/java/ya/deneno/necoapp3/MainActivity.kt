package ya.deneno.necoapp3

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import ya.deneno.necoapp3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bindingClass: ActivityMainBinding

    private lateinit var launcherMainActivity2ForResult: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        launcherMainActivity2ForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
                bindingClass.textView.text = result.data?.getStringExtra("keyBack")
            }
        }

        bindingClass.button.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("key", "Hello my friend")
            launcherMainActivity2ForResult.launch(intent)
        }
    }
}