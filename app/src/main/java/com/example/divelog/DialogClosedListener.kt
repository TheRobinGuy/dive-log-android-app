package com.example.divelog

import android.content.DialogInterface

interface DialogClosedListener {
    abstract fun handleDialogClose(dialog: DialogInterface)
}