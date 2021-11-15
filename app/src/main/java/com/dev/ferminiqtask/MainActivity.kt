package com.dev.ferminiqtask

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.dev.ferminiqtask.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        activityMainBinding.activity=this
    }
     fun onSubmit(){
        var email=activityMainBinding.etEmail.text.toString()
        var password=activityMainBinding.etPassword.text.toString()
        var cPass=activityMainBinding.etConfirmPassword.text.toString()
        if(email.isNullOrEmpty())
        {
            activityMainBinding.etEmail.error="Please enter email!"
            activityMainBinding.etEmail.requestFocus()
            return
        }
        if(password.isNullOrEmpty())
        {
            activityMainBinding.etPassword.error="Please enter password!"
            activityMainBinding.etPassword.requestFocus()
            return
        }
        if(cPass.isNullOrEmpty())
        {
            activityMainBinding.etConfirmPassword.error="Please enter confirm password!"
            activityMainBinding.etConfirmPassword.requestFocus()
            return
        }
        if(!cPass.trim().equals(password.trim()))
        {
            activityMainBinding.etConfirmPassword.error="Password should match with Confirm Password!"
            activityMainBinding.etConfirmPassword.requestFocus()
            return
        }
        openSuccessDialog(email)
    }


    private fun openSuccessDialog(email:String) {
        val builder= AlertDialog.Builder(this)
        builder.setTitle("Welcome $email")
        builder.setPositiveButton("Ok",object :DialogInterface.OnClickListener{
            override fun onClick(p0: DialogInterface?, p1: Int) {
                p0?.dismiss()
            }

        })
        val alertDialog=builder.create()
        alertDialog.setCancelable(true)
        alertDialog.show()
    }
}