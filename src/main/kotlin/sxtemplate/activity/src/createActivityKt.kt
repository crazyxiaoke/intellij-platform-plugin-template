package sxtemplate.activity.src

import org.jetbrains.kotlin.lombok.utils.capitalize

/**
 * @ClassName sxtemplate.activity.src
 * @author zhengxiaoke
 * @Description
 * @Date： 2024-02-21 10:53
 */

fun createActivityKt(
    applicationPackage:String?,
    packName:String,
    activityClassName:String,
    layoutName:String
):String{

    val layoutNames=layoutName.split("_")
    var bindingName=""
    layoutNames.forEach {
        bindingName+=it.capitalize()
    }

    val stringBuilder=StringBuilder()

    stringBuilder.append("""
    package $packName
    
    import com.sx.bridge.base.BaseTitleBarActivity
    import ${applicationPackage}.R
    import ${applicationPackage}.databinding.${bindingName}Binding
    import com.sx.bridge.base.BaseTitleBarActivity
    
    class ${activityClassName}Activity:BaseTitleBarActivity<${bindingName}Binding>{
        
       override fun getContentResId(): Int {
           return R.layout.${layoutName}
       }
       
       override fun initView() {
        
       }
    }
    """.trimIndent())

    return stringBuilder.toString()
}