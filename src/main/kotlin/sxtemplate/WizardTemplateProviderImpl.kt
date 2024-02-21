package sxtemplate

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import sxtemplate.activity.src.createActivityTemplate

/**
 * @ClassName SxTemplate
 * @author zhengxiaoke
 * @Description
 * @Date： 2024-02-21 10:16
 */
class WizardTemplateProviderImpl:WizardTemplateProvider() {
    override fun getTemplates(): List<Template> = listOf(
        createActivityTemplate
    )
}