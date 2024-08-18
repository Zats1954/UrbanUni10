package ru.zatsoft.lifecycle

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.forEach
import ru.zatsoft.lifecycle.databinding.ActivityIndexBodyBinding

class IndexBody : AppCompatActivity() {
    private lateinit var binding: ActivityIndexBodyBinding
    private val infoText = Questions()
    private var score = 0
    private lateinit var intent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        intent = Intent()
        binding = ActivityIndexBodyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val questions = infoText.questionsArray
        var count = 0
        fillQuestion(questions[count])
        binding.btnReset.setOnClickListener {
            if(++count < 5){
              binding.radioGroup.clearCheck()
              binding.imageView.visibility = GONE
              fillQuestion(questions[count])
            } else {
                intent.putExtra("score", score)
                setResult(RESULT_OK, intent)
                finish()
            }
        }

        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val answer = questions[count].answers
            var mark = false
            when (checkedId){
                R.id.rButton1 -> {val key = answer.keys.elementAt(0)
                                    mark = answer.getValue(key) }
                R.id.rButton2 -> {val key = answer.keys.elementAt(1)
                                    mark = answer.getValue(key) }
                R.id.rButton3 -> {val key = answer.keys.elementAt(2)
                                    mark = answer.getValue(key) }
            }
            group.forEach { it.isEnabled = false

            }
            if(mark) {
                binding.imageView.setImageResource(R.drawable.ic_good)
                score += 100
            }
            else
                binding.imageView.setImageResource(R.drawable.ic_bad)
            binding.imageView.visibility = VISIBLE
        }
    }

    private fun fillQuestion(question: Question) {
        binding.radioGroup.forEach { it.isEnabled = true }
        binding.tvQuestion.text = question.title
        val answerkeys = question.answers.keys
        binding.rButton1.text =answerkeys.elementAt(0)
        binding.rButton2.text =answerkeys.elementAt(1)
        binding.rButton3.text =answerkeys.elementAt(2)
    }

    fun onClickButton(view: View) {
        finish()
    }
}