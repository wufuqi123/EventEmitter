package cn.wufuqi.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import cn.wufuqi.eventemitter.EventEmitter

class MainActivity : AppCompatActivity() {
    val event by lazy { EventEmitter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        event.on("log事件"){
            Log.e("MainActivity","log事件")
        }

        event.emit("log事件")
    }
}