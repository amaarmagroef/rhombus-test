package evermos.rhombus

import android.os.Bundle
import android.text.Html
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hitung.setOnClickListener {
            val s= input.text.toString()
            if(s.isBlank()){
                output.text=""
            } else {
                var angka = s.toInt()
                if(angka>100){
                    angka = 100
                    input.setText(angka)
                }
                if(angka<3) {
                    Toast.makeText(
                        applicationContext,
                        "Masukkan Angka diatas 3",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                belahketupat(angka)
            }
        }
    }

    private fun belahketupat(jumlah : Int){
        output.setText("\n")
        var jumlahString = 1
        val mid = jumlah/2
        if(jumlah%2==1){
            /**
             * top section
             */
            for(coloumn in 0 until mid){
                for(line in mid downTo coloumn ){
                    output.append(" ")
                }

                for (line in 1..jumlahString){
                    if(line==1 || line==jumlahString)
                        output.append("*")
                    else {

                        output.append("  ")
                    }
                }
                jumlahString+=2
                output.append("\n")
            }

            /**
             * bottom section
             */
            for(coloumn in 0 until jumlah-mid) {
                for(line in 0..coloumn){

                    output.append(" ")
                }
                for(line in jumlahString downTo 1){
                    if(line==1 || line==jumlahString){
                        output.append("*")
                    } else {

                        output.append("  ")
                    }
                }
                jumlahString-=2
                output.append("\n")
            }
        } else {
            for(coloumn in 0 until mid){
                for(line in mid downTo coloumn+1){
                    output.append(" ")
                }
                for(line in 1..jumlahString){
                    if(line==1 || line==jumlahString){
                        if(coloumn==0){
                            output.append("**")
                        } else
                            output.append("*")
                    } else {
                        output.append("  ")
                    }
                }
                jumlahString+=2
                output.append("\n")
            }
            jumlahString-=2
            for(coloumn in 0 until mid){
                for(line in 0..coloumn){
                    output.append(" ")
                }
                for(line in jumlahString downTo 1){
                    if(line==1 || line == jumlahString){
                        if(coloumn==mid-1){
                            output.append("**")
                        } else
                        output.append("*")
                    } else {

                        output.append("  ")
                    }
                }
                jumlahString-=2
                output.append("\n")
            }
        }
    }
}
