package dev.wendyyanto.uitestsexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import dev.wendyyanto.uitestsexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        private const val PROCESSING = "PROCESSING"
    }

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
                else -> PROCESSING
            }

            showMessage(message)

            if (message == PROCESSING) {
                onSuccess()
            }
        }
    }

    private fun showMessage(message: String) {
        val snackBar = Snackbar.make(viewBinding.root, message, Snackbar.LENGTH_SHORT)
        if (message == PROCESSING) {
            snackBar.setBackgroundTint(ContextCompat.getColor(this, R.color.teal_200))
        } else {
            snackBar.setBackgroundTint(ContextCompat.getColor(this, R.color.dark_red))
        }
        snackBar.setActionTextColor(ContextCompat.getColor(this, R.color.white))
        snackBar.show()
    }

    private fun onSuccess() {
        with(viewBinding) {
            etName.visibility = View.GONE
            etPassword.visibility = View.GONE

            tvSuccessMessage.visibility = View.VISIBLE

            bSubmit.isEnabled = false
            bSubmit.text = "Data submitted"
        }
    }
}