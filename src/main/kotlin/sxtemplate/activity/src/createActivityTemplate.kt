package sxtemplate.activity.src

import com.android.tools.idea.wizard.template.Category
import com.android.tools.idea.wizard.template.Constraint
import com.android.tools.idea.wizard.template.FormFactor
import com.android.tools.idea.wizard.template.LanguageWidget
import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.TemplateData
import com.android.tools.idea.wizard.template.TextFieldWidget
import com.android.tools.idea.wizard.template.WizardUiContext
import com.android.tools.idea.wizard.template.activityToLayout
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import com.android.tools.idea.wizard.template.stringParameter
import com.android.tools.idea.wizard.template.template

/**
 * @ClassName SxTemplate.activity.src
 * @author zhengxiaoke
 * @Description
 * @Date： 2024-02-21 10:17
 */
val createActivityTemplate
    get() = template {
        name="SxBaseTitleActivity"
        description=""
        minApi= MIN_API
        category= Category.Other
        formFactor=FormFactor.Mobile
        screens= listOf(WizardUiContext.ActivityGallery,WizardUiContext.MenuEntry,WizardUiContext.NewProject,WizardUiContext.NewModule)

        val activityClass= stringParameter {
            name="Activity Name"
            default="Main"
            help="名字不需要包含Activity"
            constraints= listOf(Constraint.NONEMPTY)
        }

        val layoutName= stringParameter {
            name="Layout Name"
            default="activity_main"
            help="请输入布局名称"
            constraints= listOf(Constraint.LAYOUT,Constraint.UNIQUE,Constraint.NONEMPTY)
            suggest={
                val activityName=activityClass.value
                var layoutName=""
                activityName.forEachIndexed { index, c ->
                    if(index!=0&&(c in 'A'..'Z')){
                        layoutName+="_"
                    }
                    layoutName+=c
                }
                activityToLayout(layoutName.lowercase())
            }
        }

        widgets(
            TextFieldWidget(activityClass),
            TextFieldWidget(layoutName)
        )

        recipe={data:TemplateData->
            createActivityRecipe(
                data as ModuleTemplateData,
                packageName = data.packageName,
                activityClass=activityClass.value,
                layoutName=layoutName.value
            )
        }

    }