//JASUM MAHARAJ
//ST10479847
package vcmsa.ci.imadpracticum_musicplaylistapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    //arrays to store singer,song,ratings and comments
    private val Song = arrayOf("song1", "song2", "song3", "song4")
    private val Artist = arrayOf("singer1","singer2","singer3","singer4")
    private val rating = arrayOf(0, 0, 0, 0)
    private val comments = arrayOf("com1", "com2", "com3", "com4")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val btnNextScreen = findViewById<Button>(R.id.btnNextScreen)
        btnNextScreen.setOnClickListener {
            //go to the next screen
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
        val btnExit = findViewById<Button>(R.id.btnExit)
        btnExit.setOnClickListener {
            //exit the app
            finishAffinity()
        }
        var index = 0
        val edtEnterSongTitle = findViewById<TextView>(R.id.edtEnterSongTitle)
        val edtArtistName = findViewById<TextView>(R.id.edtArtistName)
        val edtComment = findViewById<TextView>(R.id.edtComment)
        val txtDisplaySongInfo = findViewById<TextView>(R.id.txtDisplaySongInfo)
        val edtRating = findViewById<TextView>(R.id.edtRating)

        fun DisplaySongInfo() {
            //display the song information
         txtDisplaySongInfo.text = ""
        }

        edtComment.setOnClickListener {
            //check if the comment is not empty
            if (edtComment.text.toString()== "") {
                Toast.makeText(this, "Comment cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }

        edtEnterSongTitle.setOnClickListener {
            //check if the song title is not empty
            if (edtEnterSongTitle.text.toString()== "") {
                Toast.makeText(this, "Song title cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }

        edtArtistName.setOnClickListener {
            //check if the artist name is not empty

            if (edtArtistName.text.toString() == "") {
                Toast.makeText(this, "Artist name cannot be empty", Toast.LENGTH_SHORT).show()
            }

            edtRating.setOnClickListener {
                //check if the rating is between 1 and 5
                if (edtRating.text.toString().toInt() < 1 || edtRating.text.toString()
                        .toInt() > 5
                ) {
                    Toast.makeText(this, "Rating must be between 1 and 5", Toast.LENGTH_SHORT)
                        .show()
                }

            }

            val btnAddToPlaylist = findViewById<Button>(R.id.btnAddToPlaylist)

            btnAddToPlaylist.setOnClickListener {
                if (edtEnterSongTitle.text.toString() ==  ""
                    && edtArtistName.text.toString() == ""
                    && edtRating.text.toString().toInt().toString() == ""
                    && edtComment.text.toString() == "") {
                    //display the song information
                    txtDisplaySongInfo.text = "Song unsuccessfully added to playlist"
                } else {
                 txtDisplaySongInfo.text = "Song successfully added to playlist"
                    index++
                }
            }
        }
    }
}