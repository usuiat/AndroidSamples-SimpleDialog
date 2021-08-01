package net.engawapg.app.simpledialog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import net.engawapg.app.simpledialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), SimpleDialog.ResultListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        SimpleDialog.Builder()
            .setTitle(R.string.dialog_title)
//            .setTitle("Title")
            .setMessage(R.string.dialog_message)
//            .setMessage("Message")
            .setPositiveText(R.string.dialog_positive_text)
//            .setPositiveText("OK")
            .setNegativeText(R.string.dialog_negative_text)
//            .setNegativeText("CANCEL")
            .create()
            .show(supportFragmentManager, "SimpleDialog")
    }

    override fun onSimpleDialogResult(tag: String?, result: SimpleDialog.Result) {
        if (tag == "SimpleDialog") {
            when (result) {
                SimpleDialog.Result.POSITIVE -> onClickOk()
                SimpleDialog.Result.NEGATIVE -> onClickCancel()
            }
        }
    }

    private fun onClickOk() {
        binding.textView.text = "OK!"
    }

    private fun onClickCancel() {
        binding.textView.text = "Canceled"
    }
}