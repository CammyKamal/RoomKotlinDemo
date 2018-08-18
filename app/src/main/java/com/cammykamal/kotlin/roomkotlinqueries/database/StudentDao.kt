package com.cammykamal.kotlin.roomkotlinqueries.database

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.cammykamal.kotlin.roomkotlinqueries.models.StudentInfo

@Dao
interface StudentDao {

    @Query("SELECT * from studentInfo")
    fun getStudents(): List<StudentInfo>

    @Insert(onConflict = REPLACE)
    fun insertStudentInfo(studentInfo: StudentInfo)

    @Query("DELETE from studentInfo")
    fun deleteStudentsData()

    @Update
    fun updateStudentInfo(studentInfo: StudentInfo);

    @Query("DELETE From StudentInfo where id = 1")
    fun deleteStudent()

    @Query("UPDATE StudentInfo SET name = :name , rollno = :rollno , section = :section where id = :id")
    fun updateStudentRecord(name: String, rollno: Int, section: String,id : Long?)
}

