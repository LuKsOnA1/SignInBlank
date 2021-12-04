package com.example.signin
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity(){

    private lateinit var emaili : EditText
    private lateinit var paroli1 : EditText
    private lateinit var paroli2 : EditText
    private lateinit var gilaki : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        paroli1 = findViewById(R.id.paroli1)
        paroli2 = findViewById(R.id.paroli2)
        gilaki = findViewById(R.id.gilaki)
        emaili = findViewById(R.id.emaili)

        gilaki.setOnClickListener() {

            val pasword2 = paroli2.text.toString().trim()
            val pasword1 = paroli1.text.toString().trim()
            val emaili1 = emaili.text.toString().trim()

            if (pasword1.isEmpty()or pasword2.isEmpty()) {
                paroli1.error = "შეიყვანეთ პაროლი"
                paroli2.error = "შეიყვანეთ პაროლი"
                return@setOnClickListener
            }else
                if (emaili1.isEmpty()){
                    emaili.error = "შეიყვანეთ მეილი"
                    return@setOnClickListener
                }


            if (pasword1.length < 9) {
                paroli1.error = "პაროლში უნდა იყოს მინიმუმ 9 სიმბოლო"

            }else
                if (!pasword1.equals(pasword2)){

                 paroli2.error = "პაროლები უნდა ემთხვეოდეს ერთმანეთს"
                }else
                    if (!emaili1.contains("@")) {
                emaili.error = "მეილში აუცილებლდა უნდა იყოს @ ნიშანი"

                    } else {
                        Toast.makeText(
                            this,
                            "თქვენ წარმატებით გაიარეთ რეგისტრაცია",
                            Toast.LENGTH_SHORT
                        ).show()

                        emaili.text.clear()
                        paroli1.text.clear()
                        paroli2.text.clear()
                      }




         FirebaseAuth.getInstance().createUserWithEmailAndPassword(emaili1, pasword1).addOnCompleteListener { }




        }
    }

}


