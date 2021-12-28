package ya.deneno.necoapp4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ya.deneno.necoapp4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bc: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}