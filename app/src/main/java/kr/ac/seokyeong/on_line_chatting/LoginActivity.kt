package kr.ac.seokyeong.on_line_chatting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kr.ac.seokyeong.on_line_chatting.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding : ActivityLoginBinding
    var googleSigninInClient : GoogleSignInClient? = null
    var GoogleLoginCode = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        var gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSigninInClient = GoogleSignIn.getClient(this, gso)

        binding.loginBtn.setOnClickListener {
            var i = googleSigninInClient?.signInIntent
            if (i != null) {
                startActivityForResult(i, GoogleLoginCode)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == GoogleLoginCode) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            val account = task.getResult(ApiException::class.java)
            val credential = GoogleAuthProvider.getCredential(account!!.idToken, null)

            FirebaseAuth.getInstance().signInWithCredential(credential)
                .addOnCompleteListener { task->
                    if(task.isSuccessful) {
                        println("로그인 성공!")
                    }
                }
        }
    }
}