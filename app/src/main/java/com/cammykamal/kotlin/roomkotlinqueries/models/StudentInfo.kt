package com.cammykamal.kotlin.roomkotlinqueries.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "studentInfo")
class StudentInfo(@ColumnInfo(name = "name")
                  var name: String = "",
                  @ColumnInfo(name = "rollno")
                  var rollno: Int=0,
                  @ColumnInfo(name = "section")
                  var section: String="") {
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null;



}
