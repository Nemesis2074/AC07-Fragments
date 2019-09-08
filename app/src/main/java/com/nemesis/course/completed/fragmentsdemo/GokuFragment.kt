package com.nemesis.course.completed.fragmentsdemo

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import java.io.Serializable

class GokuFragment: Fragment() {

    enum class SuperSaiyajin: Serializable {
        Fase0,
        Fase1,
        Fase2,
        Fase3,
        Fase4,
        Fase5,
        Fase6;

        fun nextFase(): SuperSaiyajin?{
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

    private lateinit var mainActivity: MainActivity
    private lateinit var goku: ImageView

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_goku, container, false)

        goku = view.findViewById(R.id.goku)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupFrament()
    }

    private fun setupFrament(){

        val fase = arguments?.getSerializable("fase") as? SuperSaiyajin ?: SuperSaiyajin.Fase0
        showFase(fase)

        goku.setOnClickListener {
            val nextFase = fase.nextFase()
            if(nextFase != null){
                mainActivity.transformGokuTo(nextFase)
            }

        }
    }

    private fun showFase(fase: SuperSaiyajin){
        when(fase){
            SuperSaiyajin.Fase0 -> {
                goku.setImageResource(R.drawable.img_goku)
            }
            SuperSaiyajin.Fase1 -> {
                goku.setImageResource(R.drawable.img_goku_ss1)
            }
            SuperSaiyajin.Fase2 -> {
                goku.setImageResource(R.drawable.img_goku_ss2)
            }
            SuperSaiyajin.Fase3 -> {
                goku.setImageResource(R.drawable.img_goku_ss3)
            }
            SuperSaiyajin.Fase4 -> {
                goku.setImageResource(R.drawable.img_goku_ss4)
            }
            SuperSaiyajin.Fase5 -> {
                goku.setImageResource(R.drawable.img_goku_ss5)
            }
            SuperSaiyajin.Fase6 -> {
                goku.setImageResource(R.drawable.img_goku_ss6)
            }
        }
    }

}