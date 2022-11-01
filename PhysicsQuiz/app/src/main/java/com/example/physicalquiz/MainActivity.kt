package com.example.physicalquiz

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private var currentPosition = 1 //numer aktualnego pytania

    private val questions = listOf(
        Question(0,"Czy V = S / T to wzór na prędkość?", 1, "https://leszekbober.pl/wp-content/uploads/2020/05/Wz%C3%B3r-na-pr%C4%99dko%C5%9B%C4%87.jpg.webp"),
        Question(1,"Sublimacja to zmiana stanu skupienia z gazowego w ciekły", 2, "https://pl.wikipedia.org/wiki/Sublimacja"),
        Question(2,"Energia kinetyczna to energia, którą posiada ciało będące w ruchu", 1, "https://leszekbober.pl/fizyka/praca-moc-energia/energia-kinetyczna/"),
        Question(3,"Dżul (J) jest jednostką siły", 1, "https://leszekbober.pl/jednostki/jednostka-pracy-dzul/"),
        Question(4,"Dalekowzroczność to wada wzroku powodująca rozmycie obiektów znajdujących się blisko", 1, "https://leszekbober.pl/fizyka/optyka/wady-wzroku/"),
        Question(5,"Napięcie elektryczne oznaczamy dużą literą I", 2, "https://leszekbober.pl/fizyka/prad-elektryczny/napiecie-elektryczne/"),
        Question(6,"Amplituda to czas trwania jednego pełnego drgania", 2, "https://leszekbober.pl/fizyka/ruch-drgajacy-i-falowy/ruch-drgajacy/"),
        Question(7,"Opór elektryczny inaczej nazywamy rezystancją", 1, "https://leszekbober.pl/fizyka/ruch-drgajacy-i-falowy/ruch-drgajacy/"),
        Question(8,"Protony są naładowane ujemnie", 2, "https://pl.wikipedia.org/wiki/Proton"),
        Question(9,"Punktami odniesienia z skali Celsjusza jest topnienie lodu i wrzenie wody", 1, "https://leszekbober.pl/fizyka/przemiany-energii/skale-temperatur/"),
    )

    private var currentResult = 0
    private var correctAnswers = 0
    private var cheats = 0

    private val questionText: TextView by lazy { findViewById(R.id.text_view_question)} //zaciagam tresc pytan do wygladu
    private val trueButton: Button by lazy { findViewById(R.id.button)}
    private val falseButton: Button by lazy { findViewById(R.id.button2)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setQuestion()

        questionText.setOnClickListener {
            Toast.makeText(
                this, "kliknieto w pytanie",
                Toast.LENGTH_SHORT
            ).show()
        }

        trueButton.setOnClickListener {

            val question = questions[currentPosition - 1]
            if (question.correctAnswer == 1) {
                currentResult += 10
                correctAnswers++
            }

            currentPosition++

            if (currentPosition <= questions.size)
                setQuestion()

            else{
                Toast.makeText(
                    this, "Quiz zakończony, zdobyłeś $currentResult points, $correctAnswers poprawnych odpowiedzi i $cheats oszustw",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        falseButton.setOnClickListener {

            val question = questions[currentPosition - 1]
            if (question.correctAnswer == 2) {
                currentResult += 10
                correctAnswers++
            }

            currentPosition++

            if (currentPosition <= questions.size)
                setQuestion()
            else {
                Toast.makeText(
                    this, "Quiz zakończony, zdobyłeś $currentResult points, $correctAnswers poprawnych odpowiedzi i $cheats oszustw",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun setQuestion() {
        val question = questions[currentPosition - 1]

        questionText.text = question.question
    }

    fun startCheat(view: View) {
        val message = questionText.text.toString()
        val id = currentPosition.toString()
        val currentURL = questions[currentPosition-1].url

        val intent = Intent(this, Cheat::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
            putExtra(EXTRA_ID, id)
            putExtra(EXTRA_URL, currentURL)
        }
        secondActivityResultLauncher.launch(intent)
    }

    private val secondActivityResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){
            result ->
        if (result.resultCode == Activity.RESULT_OK)
            questionText.text = result.data!!.getStringExtra(EXTRA_MESSAGE_REPLY)
//            currentPosition = result.data!!.getStringExtra(EXTRA_ID_REPLY)
    }

}