package com.example.studyapp
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DBHlpr(context: Context):SQLiteOpenHelper(context,"StudyApp.db",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        if (db!=null){
            db.execSQL("create table Kotlin(Id Integer PRIMARY KEY AUTOINCREMENT ,Title text, Descrip text ,Details text)")
            db.execSQL("create table Android(Id Integer PRIMARY KEY AUTOINCREMENT ,Title text, Descrip text ,Details text)")
        }

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}

    fun add(table:String,title:String,descrip:String,details:String): Long {
        val cv=ContentValues()
        cv.put("Title",title)
        cv.put("Descrip",descrip)
        cv.put("Details",details)

        return this.writableDatabase.insert("$table",null,cv)
    }
    fun getData(table:String):ArrayList<Lessons>{
        val data=ArrayList<Lessons>()
        val c:Cursor=this.readableDatabase.query("$table",null,null,null,null,null,null)
        if(c.moveToFirst()){
            var id=c.getInt(c.getColumnIndex("Id"))
            var title=c.getString(c.getColumnIndex("Title"))
            var descrip=c.getString(c.getColumnIndex("Descrip"))
            var details=c.getString(c.getColumnIndex("Details"))
            data.add(Lessons(id,title,descrip,details))
            while (c.moveToNext()){
                id=c.getInt(c.getColumnIndex("Id"))
                title=c.getString(c.getColumnIndex("Title"))
                descrip=c.getString(c.getColumnIndex("Descrip"))
                details=c.getString(c.getColumnIndex("Details"))
                data.add(Lessons(id,title,descrip,details))
            }
        }
        c.close()
        return data
    }
    fun delete(table:String,id:Int) {
        this.writableDatabase.delete("$table","Id=?", arrayOf(id.toString()))
    }
    fun update(table:String,id:Int,title: String,descrip: String,details: String) {
        val cv=ContentValues()
        cv.put("Title",title)
        cv.put("Descrip",descrip)
        cv.put("Details",details)
        this.writableDatabase.update("$table",cv,"Id=?", arrayOf(id.toString()))
    }
}