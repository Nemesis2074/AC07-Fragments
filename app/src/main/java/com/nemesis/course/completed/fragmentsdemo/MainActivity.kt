package com.nemesis.course.completed.fragmentsdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        transformFreezerTo(FreezerFragment.Transformation.Fase0)

        val frame = findViewById<FrameLayout>(R.id.frame_goku)
        if(frame != null) {
            transformGokuTo(GokuFragment.SuperSaiyajin.Fase0)
        }
    }

    fun transformFreezerTo(fase:FreezerFragment.Transformation){
        val params = Bundle()
        params.putSerializable("fase", fase)

        val fragmentNextFase = FreezerFragment()
        fragmentNextFase.arguments = params

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_freezer, fragmentNextFase)
        transaction.commit()
    }

    fun transformGokuTo(fase:GokuFragment.SuperSaiyajin){
        val params = Bundle()
        params.putSerializable("fase", fase)

        val fragmentNextFase = GokuFragment()
        fragmentNextFase.arguments = params

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_goku, fragmentNextFase)
        transaction.commit()
    }
}


