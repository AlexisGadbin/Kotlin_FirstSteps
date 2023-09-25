package fr.eseo.e5e.smi.firststeps

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import fr.eseo.e5e.smi.firststeps.R.string.verification_text
import fr.eseo.e5e.smi.firststeps.databinding.ActivityMainBinding

const val NAME = "user_name"

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private var activityLauncherWithResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                binding.txtSalutation.text = String.format(
                    resources.getString(verification_text),
                    data?.getStringExtra(NAME)
                )
                binding.txtSalutation.visibility = View.VISIBLE
            } else {
                binding.txtSalutation.visibility = View.INVISIBLE
            }

        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LifeCycle", "onCreate() starter")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOk.setOnClickListener { v ->
            val switchActivityIntent = Intent(this, VerificationActivity::class.java)
            switchActivityIntent.putExtra(NAME, binding.editName.text.toString())
            //startActivity(switchActivityIntent)
            activityLauncherWithResult.launch(switchActivityIntent)
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d("LifeCycle", "onStart() starter")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LifeCycle", "onStop() starter")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LifeCycle", "onResume() starter")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LifeCycle", "onPause() starter")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("LifeCycle", "onRestart() starter")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LifeCycle", "onDestroy() starter")
    }
}