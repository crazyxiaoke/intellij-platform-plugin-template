package sxtemplate.activity.src

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifestStrings
import sxtemplate.activity.res.layout.createActivityXml

/**
 * @ClassName sxtemplate.activity.src
 * @author zhengxiaoke
 * @Description
 * @Date： 2024-02-21 10:31
 */

fun RecipeExecutor.createActivityRecipe(
    moduleData:ModuleTemplateData,
    packageName:String,
    activityClass:String,
    layoutName:String
){
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension

//    generateManifest(
//        moduleData=moduleData,
//        activityClass=activityClass,
//        packageName=packageName,
//        isLauncher = false,
//        hasNoActionBar = false,
//        activityThemeName = "",
//        isNewModule = false,
//        isLibrary = false,
//        manifestOut = moduleData.manifestDir,
//        baseFeatureResOut = moduleData.baseFeature?.resDir?:moduleData.resDir,
//        generateActivityTitle = false,
//        isResizeable = false
//    )

    val createActivity = createActivityKt(projectData.applicationPackage,packageName,activityClass,layoutName)
    //保存Activity
    save(createActivity,srcOut.resolve("${activityClass}Activity.${ktOrJavaExt}"))
    //保存layout
    val createXml= createActivityXml(packageName,activityClass)
    save(createXml,resOut.resolve("layout/${layoutName}.xml"))
}