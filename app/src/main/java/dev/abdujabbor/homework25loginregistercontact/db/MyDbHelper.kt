package dev.abdujabbor.homework25loginregistercontact.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import dev.abdujabbor.homework25loginregistercontact.models.User
import dev.abdujabbor.homework25loginregistercontact.models.Usercha

class MyDbHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION, null) {
    companion object {
        var DB_NAME = "mydbs"
        var DB_VERSION = 1
        var TABLE_NAME = "mytable"
        var USER_ID = "id"
        var USER_NAME = "name"
        var USER_PASSWORD = "password"
        var USER_IMAGE = "image"
        var USER_NUMBER = "number"

        var TABLE_USERCHA = "usercha"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val query =
            "create table $TABLE_NAME($USER_ID integer not null primary key autoincrement not null,$USER_NAME text not null,$USER_PASSWORD text,$USER_NUMBER text not null,$USER_IMAGE text not null)"
        db?.execSQL(query)
        val querycha =
            "create table $TABLE_USERCHA($USER_NAME text not null,$USER_PASSWORD text)"
        db?.execSQL(querycha)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun getAllUsers(): ArrayList<User> {
        val list = ArrayList<User>()
        val query = "select * from $TABLE_NAME"
        val database = readableDatabase
        val cursor = database.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            do {
                list.add(
                    User(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)
                    )
                )
            } while (cursor.moveToNext())
        }
        return list
    }



    fun addUser(user: User) {
        val database = writableDatabase
        val contentValues = ContentValues()
        contentValues.put(USER_NAME, user.name)
        contentValues.put(USER_PASSWORD, user.password)
        contentValues.put(USER_NUMBER, user.number)

        contentValues.put(USER_IMAGE, user.image)
        database.insert(TABLE_NAME, null, contentValues)
        database.close()
    }


}