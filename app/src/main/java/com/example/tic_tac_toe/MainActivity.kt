package com.example.tic_tac_toe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }


    var playerTurn = 1
    var winner = ""


    private fun checkWinner(boxes: Array<Array<TextView>>) {

        for (row in boxes) {
            if (row[0].tag == row[1].tag && row[0].tag == row[2].tag && row[0].tag != "") {
                winner = row[0].tag.toString()
                return
            }
        }
        for (i in 0..2) {
            if (boxes[0][i].tag == boxes[1][i].tag && boxes[0][i].tag == boxes[2][i].tag && boxes[0][i].tag != "") {
                winner = boxes[0][i].tag.toString()
                return
            }
            if (boxes[0][0].tag == boxes[1][1].tag && boxes[0][0].tag == boxes[2][2].tag && boxes[0][0].tag != "") {
                winner = boxes[0][0].tag.toString()
                return
            }
            if (boxes[0][2].tag == boxes[1][1].tag && boxes[0][2].tag == boxes[2][0].tag && boxes[0][2].tag != "") {
                winner = boxes[0][2].tag.toString()
                return
            }
        }
        return
    }

    private fun changeBoxBg(view: View, array: Array<Array<TextView>>) {

        if (playerTurn == 1 && view.tag != "x" && view.tag != "o") {
            view.setBackgroundResource(R.drawable.cross2)
            view.tag = "x"
            checkWinner(array)
            if (winner == "x") {
                Toast.makeText(applicationContext, "Winner player X", Toast.LENGTH_SHORT).show()
            }

            playerTurn = 2
        } else if (playerTurn == 2 && view.tag != "x" && view.tag != "o") {
            view.setBackgroundResource(R.drawable.circle2)
            view.tag = "o"
            playerTurn = 1
            checkWinner(array)
            if (winner == "o") {
                Toast.makeText(applicationContext, "Winner player O", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun newGame(boxes: List<View>) {
        for (box in boxes) {
            box.setBackgroundColor(Color.WHITE)
        }
        box11.tag = 11
        box12.tag = 12
        box13.tag = 13
        box21.tag = 21
        box22.tag = 22
        box23.tag = 23
        box31.tag = 31
        box32.tag = 32
        box33.tag = 33

        playerTurn = 1
        winner = ""


    }

    private fun setListeners() {
        val box11 = findViewById<TextView>(R.id.box11)
        val box12 = findViewById<TextView>(R.id.box12)
        val box13 = findViewById<TextView>(R.id.box13)
        val box21 = findViewById<TextView>(R.id.box21)
        val box22 = findViewById<TextView>(R.id.box22)
        val box23 = findViewById<TextView>(R.id.box23)
        val box31 = findViewById<TextView>(R.id.box31)
        val box32 = findViewById<TextView>(R.id.box32)
        val box33 = findViewById<TextView>(R.id.box33)

        val newGameButton = findViewById<Button>(R.id.new_game_button)

        val listOfBoxes: List<View> = listOf(
            box11, box12, box13, box21, box22, box23, box31, box32, box33
        )
        val boxes = arrayOf(
            arrayOf(box11, box12, box13),
            arrayOf(box21, box22, box23),
            arrayOf(box31, box32, box33)
        )
        println("paska")
        for (box in listOfBoxes) {
            box.setOnClickListener { changeBoxBg(it, boxes) }
        }
        newGameButton.setOnClickListener { newGame(listOfBoxes) }

    }


}