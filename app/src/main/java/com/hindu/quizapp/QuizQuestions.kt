package com.hindu.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizQuestions : AppCompatActivity() , View.OnClickListener {

    private var mcurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mUsername:String?=null
    private var mCorrectAnswers :Int =0

    private var progressBar: ProgressBar? = null
    private var tvprogress: TextView? = null
    private var tvquestion: TextView? = null
    private var tvimage: ImageView? = null

    private var tvOptionOne: TextView? = null
    private var tvOptionTwo: TextView? = null
    private var tvOptionThree: TextView? = null
    private var tvOptionFour: TextView? = null
    private var btnsubmit: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUsername = intent.getStringExtra(Constants.USER_NAME)

        tvprogress = findViewById(R.id.tv_progress)
        progressBar = findViewById(R.id.progressbar)
        tvquestion = findViewById(R.id.tv_question)
        tvimage = findViewById(R.id.iv_image)
        tvOptionOne = findViewById(R.id.tv_optionOne)
        tvOptionTwo = findViewById(R.id.tv_optionTwo)
        tvOptionThree = findViewById(R.id.tv_optionThree)
        tvOptionFour = findViewById(R.id.tv_optionFour)
        btnsubmit = findViewById(R.id.btn_submit)

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnsubmit?.setOnClickListener(this)

        mQuestionList = Constants.getQuestions()

        setQuestions()

    }

    private fun setQuestions() {

        defaulOptionView( )
        val question: Question = mQuestionList!![mcurrentPosition - 1]
        progressBar?.progress = mcurrentPosition
        tvimage?.setImageResource(question.image)
        tvprogress?.text = "$mcurrentPosition/ ${progressBar?.max}"
        tvquestion?.text = question.question
        tvOptionOne?.text = question.OptionOne
        tvOptionTwo?.text = question.OptionTwo
        tvOptionThree?.text = question.OptionThree
        tvOptionFour?.text = question.OptionFour

        if (mcurrentPosition == mQuestionList!!.size) {
            btnsubmit?.text = "FINISH"
        } else {
            btnsubmit?.text = "SUBMIT"
        }
    }

    private fun defaulOptionView() {
        val option = ArrayList<TextView>()
        tvOptionOne?.let {
            option.add(0, it)
        }

        tvOptionTwo?.let {
            option.add(1, it)
        }

        tvOptionThree?.let {
            option.add(2, it)
        }

        tvOptionFour?.let {
            option.add(3, it)
        }

        for (option in option) {
            option.setTextColor(Color.parseColor("#FF000000"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaulOptionView()

        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tv_optionOne -> {
                tvOptionOne?.let {
                    selectedOptionView(it, 1)
                }
            }

            R.id.tv_optionTwo -> {
                tvOptionTwo?.let {
                    selectedOptionView(it, 2)
                }
            }

            R.id.tv_optionThree -> {
                tvOptionThree?.let {
                    selectedOptionView(it, 3)
                }
            }

            R.id.tv_optionFour -> {
                tvOptionFour?.let {
                    selectedOptionView(it, 4)
                }
            }

            R.id.btn_submit -> {
                if (mSelectedOptionPosition == 0) {
                    mcurrentPosition++

                    when {
                        mcurrentPosition <= mQuestionList!!.size -> {
                            setQuestions()
                        }
                        else->{
                            val intent = Intent(this, result::class.java)
                            intent.putExtra(Constants.USER_NAME,mUsername)
                            intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionList?.size )
                            startActivity(intent)
                            finish()
                    }

                    }

                } else {
                    val question = mQuestionList?.get(mcurrentPosition - 1)
                    if (question!!.correctAns != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_bg)
                    }else
                    {
                        mCorrectAnswers++
                    }

                    answerView(question.correctAns , R.drawable.correct_option_bg)

                    if (mcurrentPosition == mQuestionList!!.size) {
                        btnsubmit?.text = "FINISH"
                    } else {
                        btnsubmit?.text = "NEXT"
                    }

                    mSelectedOptionPosition=0

                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                tvOptionOne?.background = ContextCompat.getDrawable(
                    this@QuizQuestions,
                    drawableView
                )
            }

            2 -> {
                tvOptionTwo?.background = ContextCompat.getDrawable(
                    this@QuizQuestions,
                    drawableView
                )
            }

            3 -> {
                tvOptionThree?.background = ContextCompat.getDrawable(
                    this@QuizQuestions,
                    drawableView
                )
            }

            4 -> {
                tvOptionFour?.background = ContextCompat.getDrawable(
                    this@QuizQuestions,
                    drawableView
                )
            }
        }
    }
}