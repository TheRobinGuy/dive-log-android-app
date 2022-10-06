package com.example.divelog

import android.app.Activity
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import com.example.divelog.model.Log
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

object AddNewLog : BottomSheetDialogFragment() {
    val TAG: String = "ActionBottomDialog"
    private lateinit var newLogText: EditText
    private lateinit var newLogSaveButton: Button

    fun newInstance(): AddNewLog{
        return AddNewLog
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.NewLogDialogStyle)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
        val view: View = inflater.inflate(R.layout.new_log_layout, container, false)
        dialog?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newLogText = requireView().findViewById(R.id.newLogText)
        newLogSaveButton = requireView().findViewById(R.id.newLogButton)

        var isUpdate: Boolean = false
        var bundle: Bundle? = arguments
        if(bundle!=null){
            isUpdate = true
            val log: String? = bundle.getString("log")
            newLogText.setText(log)
            if (log!!.isNotEmpty()){
                newLogSaveButton.setTextColor(ContextCompat.getColor(requireContext(), androidx.appcompat.R.color.primary_dark_material_dark))
            }
        }
        newLogText.addTextChangedListener()

        val onclickListener = View.OnClickListener {
            val text: String = newLogText.text.toString()
            if(isUpdate){
                //send updated Log to AWS
            }else{
                Log.Builder().id(0).build()
            }
            dismiss()
        }

        newLogSaveButton.setOnClickListener(onclickListener)
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        if (activity is DialogClosedListener){
            (activity as DialogClosedListener).handleDialogClose(dialog)
        }
    }
}