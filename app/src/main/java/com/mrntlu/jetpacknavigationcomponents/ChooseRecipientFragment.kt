package com.mrntlu.jetpacknavigationcomponents

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_choose_recipient.*
import kotlinx.android.synthetic.main.fragment_main.*

class ChooseRecipientFragment : Fragment(),View.OnClickListener {

    private lateinit var navController:NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_recipient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController= Navigation.findNavController(view)
        next_btn.setOnClickListener(this)
        cancel_btn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.next_btn -> {
                if(!TextUtils.isEmpty(input_recipient.text.toString())){
                    val bundle= bundleOf("recipient" to input_recipient.text.toString())
                    navController.navigate(R.id.action_chooseRecipientFragment_to_specifyAmountFragment,bundle)
                }
            }
            R.id.cancel_btn -> activity!!.onBackPressed()
        }
    }
}
