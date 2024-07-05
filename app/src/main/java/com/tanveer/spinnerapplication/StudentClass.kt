package com.tanveer.spinnerapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class StudentClass(var studentList: ArrayList<StudentDataClass>) : BaseAdapter() {
    override fun getCount(): Int {
        return studentList.size
    }

    override fun getItem(p0: Int): Any {
        return studentList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return studentList[p0].rollNo?.toLong() ?: 0L
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view = LayoutInflater.from(p2?.context).inflate(
            R.layout.item_base_adapter,
            p2, false
        )
        val tvRollNo = view.findViewById<TextView>(R.id.tvRollNo)
        val tvName = view.findViewById<TextView>(R.id.tvName)
        val tvCourse = view.findViewById<TextView>(R.id.tvCourse)
        tvRollNo.setText(studentList[p0].rollNo.toString())
        tvName.setText(studentList[p0].name)
        tvCourse.setText(studentList[p0].course)
        return view
    }
}
