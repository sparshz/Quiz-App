package com.hindu.quizapp

object Constants {

    const val USER_NAME :String = "user_name"
    const val TOTAL_QUESTIONS :String = "total_question"
    const val CORRECT_ANSWERS :String = "correct_answers"



    fun getQuestions ():ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val que1 = Question(
            1,
            "What Country the Flag belong to?",
            R.drawable.arrr,
             "Argentina",
            "Australia",
            "Russia",
            "Armenia",
            1
        )
        questionList.add(que1)

        val que2 = Question(
            2,
            "What Country the Flag belong to?",
            R.drawable.fiii,
            "Argentina",
            "Fiji",
            "China",
            "Jordan",
            2
        )
        questionList.add(que2)

        val que3 = Question(
            3,
            "What Country the Flag belong to?",
            R.drawable.geerr,
            "Germany",
            "Australia",
            "Japan",
            "India",
            1
        )
        questionList.add(que3)

        val que4 = Question(
            4,
            "What Country the Flag belong to?",
            R.drawable.indiaa,
            "India",
            "Iran",
            "Mongolia",
            "Sweden",
            1
        )
        questionList.add(que4)

        val que5 = Question(
            5,
            "What Country the Flag belong to?",
            R.drawable.kuwaitt,
            "Argentina",
            "Australia",
            "Kuwait",
            "Armenia",
            3
        )
        questionList.add(que5)

        val que6 = Question(
            6,
            "What Country the Flag belong to?",
            R.drawable.belgium,
            "Jordan",
            "Australia",
            "Russia",
            "belgium",
            4
        )
        questionList.add(que6)

        val que7 = Question(
            7,
            "What Country the Flag belong to?",
            R.drawable.brazil,
            "Argentina",
            "Brazil",
            "china",
            "Armenia",
            2
        )
        questionList.add(que7)

        val que8 = Question(
            8,
            "What Country the Flag belong to?",
            R.drawable.denmark,
            "Sweden",
            "Australia",
            "Denmark",
            "Malaysia",
            3
        )
        questionList.add(que8)


        return questionList

    }
}