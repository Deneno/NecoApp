package ya.deneno.necoapp4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import ya.deneno.necoapp.constance.Constance
import ya.deneno.necoapp4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bc: ActivityMainBinding
    private lateinit var launcherSignActivity: ActivityResultLauncher<Intent>

    private var login = "empty"
    private var password = "empty"
    private var firstName = "empty"
    private var secondName = "empty"
    private var lastName = "empty"
    private var avatarImageId = R.drawable.noname

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bc = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bc.root)

        launcherSignActivity = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
                if (result.data?.getStringExtra(Constance.SIGN_STATE) == Constance.SIGN_IN_STATE) {
                    val resultLogin = result.data?.getStringExtra(Constance.LOGIN).toString()
                    val resultPassword = result.data?.getStringExtra(Constance.PASSWORD).toString()
                    if (resultLogin == login && resultPassword == password) {
                        bc.imageView.visibility = View.VISIBLE
                        bc.imageView.setImageResource(avatarImageId)

                        val fullName = "$firstName $secondName $lastName"
                        bc.fullNameTextView.visibility = View.VISIBLE
                        bc.fullNameTextView.text = fullName

                        bc.buttonSignUp.visibility = View.GONE
                        bc.buttonSignIn.text = getString(R.string.exit)
                    } else {
                        bc.fullNameTextView.visibility = View.VISIBLE
                        bc.fullNameTextView.text = "Такого аккаунта не существует"

                        bc.imageView.visibility = View.VISIBLE
                        bc.imageView.setImageResource(R.drawable.figa)

                    }
                } else if (result.data?.getStringExtra(Constance.SIGN_STATE) == Constance.SIGN_UP_STATE) {
                    login = result.data?.getStringExtra(Constance.LOGIN)!!
                    password = result.data?.getStringExtra(Constance.PASSWORD)!!
                    firstName = result.data?.getStringExtra(Constance.FNAME)!!
                    secondName = result.data?.getStringExtra(Constance.SNAME)!!
                    lastName = result.data?.getStringExtra(Constance.LNAME)!!
                    avatarImageId = result.data?.getIntExtra(Constance.AVATAR_ID, 0)!!
                    bc.imageView.visibility = View.VISIBLE
                    bc.imageView.setImageResource(avatarImageId)
                    val fullName = "$firstName $secondName $lastName"
                    bc.fullNameTextView.visibility = View.VISIBLE
                    bc.fullNameTextView.text = fullName
                    bc.buttonSignUp.visibility = View.GONE
                    bc.buttonSignIn.text = getString(R.string.exit)
                }
            }
        }

        bc.buttonSignIn.setOnClickListener {
            if (bc.buttonSignIn.text.toString() == getString(R.string.exit)) {
                bc.imageView.visibility = View.INVISIBLE
                bc.imageView.setImageResource(R.drawable.noname)

                bc.fullNameTextView.visibility = View.INVISIBLE
                bc.fullNameTextView.text = ""

                bc.buttonSignUp.visibility = View.VISIBLE
                bc.buttonSignIn.text = getString(R.string.sign_in)

            } else {
                val intent = Intent(this, SignInUpActivity::class.java)
                intent.putExtra(Constance.SIGN_STATE, Constance.SIGN_IN_STATE)
                launcherSignActivity.launch(intent)
            }
        }

        bc.buttonSignUp.setOnClickListener {
            val intent = Intent(this, SignInUpActivity::class.java)
            intent.putExtra(Constance.SIGN_STATE, Constance.SIGN_UP_STATE)
            launcherSignActivity.launch(intent)
        }
    }
}
