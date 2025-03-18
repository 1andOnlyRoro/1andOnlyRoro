package vcmsa.ci.icetask2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val height : EditText = findViewById(R.id.bodyH)
        val weight : EditText = findViewById(R.id.bodyW)
        val btnE : Button = findViewById(R.id.btnE)
        val bmi : TextView = findViewById(R.id.bmi)
        var bmiAnswer : Double = 0.0




        //tell the app what we want to happen when the enter button is clicked
        btnE.setOnClickListener {
            val weight = weight.text.toString().toDouble()
            val height = height.text.toString().toDouble()

             bmiAnswer = weight/(height * height)
             when(bmiAnswer){
                 in 0.0 .. 18.5 ->bmi.text = "UnderWeight"
                 in 18.6 .. 24.9 ->bmi.text = "Healthy Weight"
                 in 25.0 .. 29.9 ->bmi.text = "OverWeight"
                 in 30.0 .. 70.9 ->bmi.text = "Obses"
             }



        }
    }
}