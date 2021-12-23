package ya.deneno.necoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ya.deneno.necoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bindingClass: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        bindingClass.button4.setOnClickListener {
            var count = bindingClass.editText.text.toString().toIntOrNull()
            bindingClass.textViewResult.visibility = View.VISIBLE
            when(count) {
                null -> bindingClass.textViewResult.visibility = View.GONE
                in 0..1000 -> bindingClass.textViewResult.text = "Вы начинающий блогер"
                in 1000..10000 -> bindingClass.textViewResult.text = "Вы обычный блогер"
                in 10000..100000 -> bindingClass.textViewResult.text = "Вы крутой блогер"
                in 100000..1000000 -> bindingClass.textViewResult.text = "Вы супер блогер"
                in 1000000..10000000 -> bindingClass.textViewResult.text = "Вы епичный блогер"
            }

        }
    }
}