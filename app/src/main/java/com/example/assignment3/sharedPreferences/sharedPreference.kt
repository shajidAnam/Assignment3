package com.example.assignment3.sharedPreferences

interface sharedPreference {
    companion object{
        const val NAME="name"
        const val AGE="age"
        const val PHONE="phone"
        const val EMAIL="email"
        const val PASSWORD="password"
        const val WEBURL="weburl"
        const val LOGINFLAG="loginflag"
        const val GENDER="gender"
        const val WEIGHT="weight"
        const val CHECKBOXVALUE="checkboxValue"

    }
    fun getString(key:String):String?
    fun setString(key: String,value:String)
    fun getInt(key:String):Int?
    fun setInt(key: String,value:Int)
    fun getBoolean(key:String):Boolean?
    fun setBoolean(key: String,value:Boolean)
    fun getFloat(key:String):Float?
    fun setFloat(key: String,value:Float)


}