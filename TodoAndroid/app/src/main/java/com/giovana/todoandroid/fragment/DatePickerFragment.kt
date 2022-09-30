package com.giovana.todoandroid.fragment

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.time.LocalDate
import java.time.ZoneId
import java.util.Calendar

class DatePickerFragment (
    val timerPickerListener: TimerPickerListener
        ): DialogFragment(), DatePickerDialog.OnDateSetListener{
        //DialogFragment() -> abre uma telinha, no caso abre o calendario

    //Cria o que é necessario para retornar o calendario e selecionar a data atual
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        //recupera o ano atual
        val year = c.get(Calendar.YEAR)
        //recupera o mes atual
        val month = c.get(Calendar.MONTH)
        //recupera o dia atual
        val day = c.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(requireContext(), this, year,month,day)
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        val calendar = Calendar.getInstance()
        //seleciona e recupera o ano
        calendar.set(Calendar.YEAR,p1)
        //seleciona e recupera o mes
        calendar.set(Calendar.MONTH,p2)
        //seleciona e recupera o dia
        calendar.set(Calendar.DAY_OF_MONTH,p3)

        //retorna no formato de LocalDate
        timerPickerListener.onDateSelected(calendar.time.toInstant().atZone(
            ZoneId.systemDefault()).toLocalDate())

    }

}

//Criando interface para retornar data em formato LocalDate
interface TimerPickerListener{
    fun onDateSelected(date: LocalDate)
}