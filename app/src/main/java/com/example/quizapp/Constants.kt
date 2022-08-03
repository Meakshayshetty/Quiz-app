package com.example.quizapp

object Constants {
    const val USER_NAME:String ="user_name"
    const val TOTAL_QUESTIONS:String = "total+questions"
    const val CORRECT_ANSWERS :String = "correct_answer"

    fun getQuestions():ArrayList<Qustion>{
        val QuestionsList= ArrayList<Qustion>()

        val que1= Qustion(1,"what country does this flag belong to?",
            R.drawable.india,"Pakistan","China","Russia","india",
        4)
        QuestionsList.add(que1)

        val que2= Qustion(2,"what country does this flag belong to?",
            R.drawable.china,"Pakistan","China","Russia","india",
            2)
        QuestionsList.add(que2)

        val que3= Qustion(3,"what country does this flag belong to?",
            R.drawable.russia,"Pakistan","China","Russia","india",
            3)
        QuestionsList.add(que3)

        val que4= Qustion(4,"what country does this flag belong to?",
            R.drawable.pakistan,"Pakistan","China","Russia","india",
            1)
        QuestionsList.add(que4)

        val que5= Qustion(5,"what country does this flag belong to?",
            R.drawable.srilanka,"Pakistan","srilanka","Russia","india",
            2)
        QuestionsList.add(que5)


        val que6= Qustion(6,"what country does this flag belong to?",
            R.drawable.france,"Pakistan","China","Russia","france",
            4)
        QuestionsList.add(que6)


        val que7= Qustion(7,"what country does this flag belong to?",
            R.drawable.germany,"Germany","China","Russia","india",
            1)
        QuestionsList.add(que7)

        val que8= Qustion(8,"what country does this flag belong to?",
            R.drawable.america,"Germany","China","america","india",
            3)
        QuestionsList.add(que8)
        return QuestionsList
    }
}