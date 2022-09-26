package com.ugurrsnr.playaudiofromurl

import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var playBtn : Button
    private lateinit var pauseBtn : Button
    var mediaPlayer : MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        playBtn = findViewById(R.id.playAudioBtn)
        pauseBtn = findViewById(R.id.pauseAudioBtn)

        playBtn.setOnClickListener {
            playAudio()
        }
        pauseBtn.setOnClickListener {
            pauseAudio()
        }
    }

    private fun playAudio(){
        val audioUrl = "https://api.dictionaryapi.dev/media/pronunciations/en/english-us.mp3"
        mediaPlayer = MediaPlayer()
        mediaPlayer!!.setAudioStreamType(AudioManager.STREAM_MUSIC)



        try {
            mediaPlayer!!.apply {
                setDataSource(audioUrl)
                prepare()
                start()
                Toast.makeText(this@MainActivity,"Playing", Toast.LENGTH_SHORT).show()
            }
        }catch (e : Exception){
            e.printStackTrace()
        }



    }
    private fun pauseAudio(){
        if (mediaPlayer!!.isPlaying){
            mediaPlayer!!.apply {
                stop()
                reset()
                release()
            }
        }else{
            Toast.makeText(this, "Audio not playing", Toast.LENGTH_SHORT).show()
        }




    }
}