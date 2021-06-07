package com.example.projectfoodpedia

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.example.projectfoodpedia.utils.FirebaseUtils
import com.example.projectfoodpedia.utils.FirebaseUtils.firebaseAuth
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_welcome_page.*

class Login : Fragment() {
    private lateinit var auth: FirebaseAuth
    lateinit var signInInputsArray: Array<EditText>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth= FirebaseAuth.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_login.setOnClickListener {
            checkCredentials(view)
        }
    }

    private fun checkCredentials(view: View){
        signInInputsArray = arrayOf(tf_emailLogin, tf_passwordLogin)
        val email = tf_emailLogin.text.toString().trim()
        val password = tf_passwordLogin.text.toString().trim()

        if (email.isNotEmpty() && password.isNotEmpty()) {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { signIn ->
                        if (signIn.isSuccessful) {
                            val action=LoginDirections.actionLoginToHomeFragment()
                            Navigation.findNavController(view).navigate(action)
                        }
                        else {
                            Toast.makeText(requireContext(), "Sign in failed!", Toast.LENGTH_LONG)
                                .show()
                        }
                    }
                    .addOnFailureListener {
                        Log.d("Error", it.localizedMessage)
                    }
            }
            else{
                signInInputsArray.forEach { input ->
                    if (input.text.toString().trim().isEmpty()) {
                        input.error = "${input.hint}"
                    }
                }
            }
        }

    }
