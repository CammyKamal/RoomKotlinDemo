package com.cammykamal.kotlin.roomkotlinqueries

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.cammykamal.kotlin.roomkotlinqueries.database.AppDatabase
import com.cammykamal.kotlin.roomkotlinqueries.models.StudentInfo

class MainActivity : AppCompatActivity() {
    lateinit var mHandler: Handler;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var insertBtn = findViewById<Button>(R.id.insertbtn)
        insertBtn.setOnClickListener(clickListener)
        var selectBtn = findViewById<Button>(R.id.fetchbtn)
        selectBtn.setOnClickListener(clickListener)

        var updateBtn = findViewById<Button>(R.id.updatebtn)
        updateBtn.setOnClickListener(clickListener)

        var deleteBtn = findViewById<Button>(R.id.deletebtn)
        deleteBtn.setOnClickListener(clickListener)

        var deleteAll = findViewById<Button>(R.id.deleteallbtn)
        deleteAll.setOnClickListener(clickListener)
        mHandler = Handler()


    }


    private val clickListener: View.OnClickListener = View.OnClickListener { view ->
        when (view.id) {
            R.id.insertbtn -> {
                val studentInfo = StudentInfo("kamal", 1, "")

                AppDatabase.getInstance(applicationContext)?.studentDao()?.insertStudentInfo(studentInfo)

                /*   mHandler.post(object : Runnable {
                       override fun run() {
                           val studentInfo = StudentInfo("kamal", 0.0, "")


                           AppDatabase.getInstance(applicationContext)?.studentDao()?.insertStudentInfo(studentInfo)
                       }
                   })*/

                Toast.makeText(this, "Clicked 1", Toast.LENGTH_SHORT).show()
            }
            R.id.fetchbtn -> {
                val studentInfo = AppDatabase.getInstance(applicationContext)?.studentDao()?.getStudents()
                if (studentInfo!!.isNotEmpty())
                    Toast.makeText(this, studentInfo.get(0).name, Toast.LENGTH_SHORT).show()
            }

            R.id.updatebtn -> {
                val studentInfo = AppDatabase.getInstance(applicationContext)?.studentDao()?.getStudents()

                AppDatabase.getInstance(applicationContext)?.studentDao()?.updateStudentRecord("kamal vaid", 2, "A",studentInfo!!.get(0).id)
                val studentInfo1 = AppDatabase.getInstance(applicationContext)?.studentDao()?.getStudents()
                if (studentInfo1!!.isNotEmpty())
                    Toast.makeText(this, studentInfo1.get(0).name, Toast.LENGTH_SHORT).show()
            }

            R.id.deletebtn -> {
              AppDatabase.getInstance(applicationContext)?.studentDao()?.deleteStudent()

            }

            R.id.deleteallbtn -> {
                AppDatabase.getInstance(applicationContext)?.studentDao()?.deleteStudentsData()

            }
        }
    }
}
