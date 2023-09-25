package fr.eseo.e5e.smi.firststeps

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.eseo.e5e.smi.firststeps.databinding.ActivityVerificationBinding

class VerificationActivity : AppCompatActivity() {

    lateinit var binding: ActivityVerificationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtVerificationQuestion.text = String.format(
            resources.getString(R.string.verification_text),
            intent.getStringExtra(NAME)
        )

        binding.btnYes.setOnClickListener { v ->
            val resultIntent = Intent()
            resultIntent.putExtra(NAME, intent.getStringExtra(NAME))
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}