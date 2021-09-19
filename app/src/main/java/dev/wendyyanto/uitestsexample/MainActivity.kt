package dev.wendyyanto.uitestsexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dev.wendyyanto.uitestsexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        setupSubmitButton()
    }

    private fun setupSubmitButton() {
        viewBinding.bSubmit.setOnClickListener {
            val name = viewBinding.etName.text
            val password = viewBinding.etPassword.text

            val message = when {
                name.isNullOrBlank() -> "Name should not empty"
                password.isNullOrBlank() -> "Password should not empty"
                else -> "Processing"
            }

            showMessage(message)
        }
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}