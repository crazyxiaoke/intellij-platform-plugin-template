package sxtemplate.activity.res.layout

/**
 * @ClassName sxtemplate.activity.res.layout
 * @author zhengxiaoke
 * @Description
 * @Date： 2024-02-21 11:20
 */
fun createActivityXml(
    packageName:String,
    activityClass:String
):String{

    val stringBuilder=StringBuilder()
    stringBuilder.append("""
        <layout xmlns:android="http://schemas.android.com/apk/res/android"
                xmlns:app="http://schemas.android.com/apk/res-auto"
                xmlns:tools="http://schemas.android.com/tools"
                tools:context="${packageName}.${activityClass}">
                <androidx.constraintlayout.widget.ConstraintLayout
                    android:layout_width="match_parent"
                    android:layout_height="match_parent">
                    
                    
                    
                </androidx.constraintlayout.widget.ConstraintLayout>    
        </layout>
    """.trimIndent())
    return stringBuilder.toString()
}