package com.example.通讯录

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.second.*

class second : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)

        var telnum=intent.getStringExtra("telnum")
        var name=intent.getStringExtra("name")
        textView1.text=name+"\n"+telnum
        textView1.setTextSize(1, 50.0F)
        button1.setOnClickListener {
            var intent = Intent()
            intent.action = Intent.ACTION_DIAL//dial是拨号的意思
            intent.data = Uri.parse("tel:" + telnum)//这个tel不能改，后面的数字可以随便改
            startActivity(intent)
        }

        button2.setOnClickListener {
            var intent = Intent()
            intent.action = Intent.ACTION_SENDTO//发短信的action
            intent.data = Uri.parse("smsto:" + name)//smsto:后面的是收信人，可以随便改
            intent.putExtra("sms_body", "Welcome to Android!")//这里的第二个参数是短信内容
            startActivity(intent)

        }
    }
}
