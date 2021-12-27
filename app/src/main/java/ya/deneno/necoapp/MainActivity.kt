package ya.deneno.necoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ya.deneno.necoapp.constance.Constance
import ya.deneno.necoapp.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var bindingClass: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        bindingClass.button4.setOnClickListener {
            val nameValue = bindingClass.editText.text.toString().lowercase(Locale.getDefault())
            bindingClass.textViewResult.visibility = View.VISIBLE
            when(nameValue) {
                Constance.DVORNIK -> {
                    if (bindingClass.editText2.text.toString().toInt() == Constance.DVORNIK_PASSWORD) {
                        val tempText = "${Constance.DVORNIK} получил ${Constance.DVORNIK_ZP}р"
                        bindingClass.textViewResult.text = tempText
                        bindingClass.imageView.setImageResource(R.drawable.dvornik)
                    } else {
                        bindingClass.textViewResult.text = "Неверный пароль, вызываю полицию нравов!!!"
                    }
                }
                Constance.ENGINEER -> {
                    if (bindingClass.editText2.text.toString().toInt() == Constance.ENGINEER_PASSWORD) {
                        val tempText = "${Constance.ENGINEER} получил ${Constance.ENGINEER_ZP}р"
                        bindingClass.textViewResult.text = tempText
                        bindingClass.imageView.setImageResource(R.drawable.engeneer)
                    } else {
                        bindingClass.textViewResult.text = "Неверный пароль, вызываю полицию нравов!!!"
                    }
                }
                Constance.DIRECTOR -> {
                    if (bindingClass.editText2.text.toString().toInt() == Constance.DIRECTOR_PASSWORD) {
                        val tempText = "${Constance.DIRECTOR} получил ${Constance.DIRECTOR_ZP}р"
                        bindingClass.textViewResult.text = tempText
                        bindingClass.imageView.setImageResource(R.drawable.director)
                    } else {
                        bindingClass.textViewResult.text = "Неверный пароль, вызываю полицию нравов!!!"
                    }
                }
                else -> {
                    bindingClass.textViewResult.text = "Нет такого работника"
                    bindingClass.textViewResult.visibility = View.GONE
                    bindingClass.imageView.setImageResource(R.drawable.noname)
                }
            }
        }
    }
}