package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizquestionActivity : AppCompatActivity(),View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionlist: ArrayList<Qustion>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCurrectAnswer: Int =0

    private var mUserName :String? =null

    private var progressBar: ProgressBar? = null
    private var tvprogress: TextView? = null
    private var tvquestion: TextView? = null
    private var ivimage: ImageView? = null

    private var optionOne: TextView? = null
    private var optionTwo: TextView? = null
    private var optionThree: TextView? = null
    private var optionFour: TextView? = null
    private var btnsubmit: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizquestion)

        mUserName =intent.getStringExtra(Constants.USER_NAME)

        progressBar = findViewById(R.id.progressBar)
        tvprogress = findViewById(R.id.tvprogress)
        tvquestion = findViewById(R.id.tvquestion)
        ivimage = findViewById(R.id.ivimage)

        optionOne = findViewById(R.id.optionOne)
        optionTwo = findViewById(R.id.optionTwo)
        optionThree = findViewById(R.id.optionThree)
        optionFour = findViewById(R.id.optionFour)

        btnsubmit = findViewById(R.id.btnsubmit)


        optionOne?.setOnClickListener(this)
        optionTwo?.setOnClickListener(this)
        optionThree?.setOnClickListener(this)
        optionFour?.setOnClickListener(this)
        btnsubmit?.setOnClickListener(this)

        mQuestionlist = Constants.getQuestions()

        setQuestion()

    }

    private fun setQuestion() {

        val question: Qustion = mQuestionlist!![mCurrentPosition - 1]

        progressBar?.progress = mCurrentPosition
        tvprogress?.text = "$mCurrentPosition/${progressBar?.max}"
        ivimage?.setImageResource(question.image)
        tvquestion?.text = question.Question
        optionOne?.text = question.optionOne
        optionTwo?.text = question.optionTwo
        optionThree?.text = question.optionThree
        optionFour?.text = question.optionFour


        if (mCurrentPosition == mQuestionlist!!.size) {
            btnsubmit?.text = "FINISH"
        } else {
            btnsubmit?.text = "SUBMIT"
        }
    }

    private fun defaultOptionView() {
        val options = ArrayList<TextView>()
        optionOne?.let {
            options.add(0, it)
        }
        optionTwo?.let {
            options.add(1, it)
        }
        optionThree?.let {
            options.add(2, it)
        }
        optionFour?.let {
            options.add(3, it)
        }
        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background =
                ContextCompat.getDrawable(this, R.drawable.defailt_option_background_bg)
        }

    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363a43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.optionOne -> {
                optionOne?.let {
                    selectedOptionView(it, 1)
                }
            }
            R.id.optionTwo -> {
                optionTwo?.let {
                    selectedOptionView(it, 2)
                }
            }
            R.id.optionThree -> {
                optionThree?.let {
                    selectedOptionView(it, 3)
                }
            }
            R.id.optionFour -> {
                optionFour?.let {
                    selectedOptionView(it, 4)
                }
            }
            R.id.btnsubmit -> {
                if(mSelectedOptionPosition==0) {
                    mCurrentPosition++
                    defaultOptionView()

                    when {
                        mCurrentPosition <= mQuestionlist!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent =Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.CORRECT_ANSWERS,mCurrectAnswer)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionlist?.size)
                            intent.putExtra(Constants.USER_NAME,mUserName)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
                else{
                   val question = mQuestionlist?.get(mCurrentPosition-1)
                  if( question!!.correctAnswer != mSelectedOptionPosition){
                      answerView(question.correctAnswer,R.drawable.wrong_option_background_bg)
                  }else{
                      mCurrectAnswer++
                  }
                    answerView(question.correctAnswer, R.drawable.correct_option_background_bg)

                    if(mCurrentPosition == mQuestionlist!!.size){
                        btnsubmit?.text ="FINISH"
                    }else{
                        btnsubmit?.text= "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }

        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                optionOne?.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                optionTwo?.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                optionThree?.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                optionFour?.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }
}