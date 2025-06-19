package vcmsa.ci.imadpracticum_musicplaylistapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    private val Song = arrayOf("Blue Suede Shoes", "Dancing Queen", "Unwritten", "Lover")
    private val Artist = arrayOf("Elvis Presley", "ABBA", "Natasha Bedingfield", "Taylor Swift")
    private val rating = arrayOf(5, 4, 3, 5)
    private val comments = arrayOf("Nostalgic", "Absolute classic", "Good song", "Best love song")
    var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)


        val btnExitApp = findViewById<Button>(R.id.btnExitApp)
        btnExitApp.setOnClickListener {
            //exit the app
            finishAffinity()
        }
        val btnReturnToScreen1 = findViewById<Button>(R.id.btnReturnToScreen1)
        btnReturnToScreen1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val btnDisplaySongs = findViewById<Button>(R.id.btnDisplaySongs)
        val btnAvgRating = findViewById<Button>(R.id.btnAvgRating)
        val txtDisplay = findViewById<TextView>(R.id.txtDisplay)

       btnDisplaySongs.setOnClickListener {
           while (index <= 4) {
               txtDisplay.text =
                   "song: " + Song[index] +
                           " Artist: " + Artist[index] +
                           " Rating: " + rating[index] +
                           " Comment: " + comments[index]

           }
       }
      btnAvgRating.setOnClickListener {
          rating[index] = rating[index] / 4
          txtDisplay.text = "the average rating is: " + rating[index] + "/5"
      }

    }
}