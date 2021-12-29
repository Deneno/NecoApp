package ya.deneno.necoapp4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import ya.deneno.necoapp.constance.Constance
import ya.deneno.necoapp4.databinding.ActivitySignInUpBinding

class SignInUpActivity : AppCompatActivity() {
    private lateinit var bc: ActivitySignInUpBinding
    private var signState = "empty"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bc = ActivitySignInUpBinding.inflate(layoutInflater)
        setContentView(bc.root)
        signState = intent.getStringExtra(Constance.SIGN_STATE)!!
        if (signState == Constance.SIGN_IN_STATE) {
            bc.editTextFName.visibility = View.GONE
            bc.editTextSName.visibility = View.GONE
            bc.editTextLName.visibility = View.GONE
            bc.buttonAvatar.visibility = View.INVISIBLE

        }

        bc.buttonAvatar.setOnClickListener {
            bc.imageViewAvatar.visibility = View.VISIBLE
        }

        bc.buttonDone.setOnClickListener {
            if (signState == Constance.SIGN_UP_STATE) {
                val intentBack = Intent()
                intentBack.putExtra(Constance.SIGN_STATE, signState)
                intentBack.putExtra(Constance.LOGIN, bc.editTextLogin.text.toString())
                intentBack.putExtra(Constance.PASSWORD, bc.editTextPassword.text.toString())
                intentBack.putExtra(Constance.FNAME, bc.editTextFName.text.toString())
                intentBack.putExtra(Constance.SNAME, bc.editTextSName.text.toString())
                intentBack.putExtra(Constance.LNAME, bc.editTextLName.text.toString())
                if (bc.imageViewAvatar.isVisible) intentBack.putExtra(Constance.AVATAR_ID, R.drawable.avatar_new)
                setResult(RESULT_OK, intentBack)
                finish()
            } else if (signState == Constance.SIGN_IN_STATE) {
                val intentBack = Intent()
                intentBack.putExtra(Constance.SIGN_STATE, signState)
                intentBack.putExtra(Constance.LOGIN, bc.editTextLogin.text.toString())
                intentBack.putExtra(Constance.PASSWORD, bc.editTextPassword.text.toString())
                setResult(RESULT_OK, intentBack)
                finish()
            }

        }



    }
}