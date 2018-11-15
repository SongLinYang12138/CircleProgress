package com.bondex.ysl.mykotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bondex.ysl.mykotlin.R.layout.activity_main
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BaseView {

    val list:ArrayList<String> = ArrayList()



    private val TAG: String = ""
    private var reourceId: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_main.text = "ads"
        tv_main.setOnClickListener({ v ->
            Toast.makeText(this, "211112", Toast.LENGTH_LONG).show()
        })

        list.add("2222")

    }
    override fun getKind(): Int {
        return 0
    }

    override fun setType(kind: String) {
    }


}
