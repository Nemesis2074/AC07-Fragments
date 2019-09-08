package com.nemesis.course.completed.fragmentsdemo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import java.io.Serializable

class FreezerFragment: Fragment() {

    enum class Transformation: Serializable {
        Fase0,
        Fase1,
        Fase2,
        Fase3,
        Fase4,
        Fase5,
        Fase6;

        fun nextFase(): Transformation?{
            return when(this){
                Fase0 -> Fase1
                Fase1 -> Fase2
                Fase2 -> Fase3
                Fase3 -> Fase4
                Fase4 -> Fase5
                Fase5 -> Fase6
                Fase6 -> null
            }
        }
    }

    private lateinit var freezer: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_freezer, container, false)

        freezer = view.findViewById(R.id.freezer)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        retainInstance = true
        setupFrament()
    }

    private fun setupFrament(){

        val fase = arguments?.getSerializable("fase") as? Transformation ?: Transformation.Fase0
        showFase(fase)

        freezer.setOnClickListener {
            val nextFase = fase.nextFase()
            if(nextFase != null){

                val activity =this.activity as MainActivity
                activity.transformFreezerTo(nextFase)
            }

        }
    }

    private fun showFase(fase:Transformation){
        when(fase){
            Transformation.Fase0 -> {
                freezer.setImageResource(R.drawable.img_freezer)
            }
            Transformation.Fase1 -> {
                freezer.setImageResource(R.drawable.img_freezer_f1)
            }
            Transformation.Fase2 -> {
                freezer.setImageResource(R.drawable.img_freezer_f2)
            }
            Transformation.Fase3 -> {
                freezer.setImageResource(R.drawable.img_freezer_f3)
            }
            Transformation.Fase4 -> {
                freezer.setImageResource(R.drawable.img_freezer_f4)
            }
            Transformation.Fase5 -> {
                freezer.setImageResource(R.drawable.img_freezer_f5)
            }
            Transformation.Fase6 -> {
                freezer.setImageResource(R.drawable.img_freezer_f6)
            }
        }
    }

}