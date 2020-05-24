package kr.tjoeun.androidbasic01_intent_20200524

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        goToFirstBtn.setOnClickListener {

            val myIntent = Intent(this, FirstActivity::class.java)
            startActivity(myIntent)

        }

//        두번째 액티비티(SecondActivity)로 버튼을 누르면 이동, 돌아가기 누르면
//        다시 메인으로 돌아오도록
        goToSecondBtn.setOnClickListener {

            val myIntent = Intent(this, SecondActivity::class.java)
            startActivity(myIntent)
        }

        goToThirdBtn.setOnClickListener {

            val inputCotent = contentEdt.text.toString()

            val myIntent = Intent( this , ThirdActivity::class.java)
            myIntent.putExtra("content", inputCotent)
            myIntent.putExtra("number", 10)
            startActivity(myIntent)
        }

//        폰번을 입력받어서, 네번째 액티비티 (FourthActivity)에서 출력

        goToFourthBtn.setOnClickListener {

            val inputContent = contentFourthEdt.text.toString()

            val myIntent = Intent(this, FourthActivity::class.java)
            myIntent.putExtra("content", inputContent)
            startActivity(myIntent)
        }

        editNickNameBtn.setOnClickListener {

            val myIntent = Intent(this, EditNickNameActivity::class.java)
            startActivityForResult(myIntent,1000)

        }



        }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1000 ) {
            if (resultCode == Activity.RESULT_OK) {

                val newNickName = data?.getStringExtra("nick")

                nickNameTxt.text = newNickName
            }
        }
    }
}
