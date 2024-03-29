package io.nerdythings.action

import com.intellij.openapi.actionSystem.ActionUpdateThread
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import io.nerdythings.dialog.SettingsDialog
import io.nerdythings.utils.IdeaUtil
import org.jetbrains.annotations.NotNull

class PluginSettingsAction : AnAction() {

    override fun actionPerformed(@NotNull event: AnActionEvent) {
        SettingsDialog().show()
    }

    override fun update(e: AnActionEvent) {
        IdeaUtil.setActionIcon(e)
        e.presentation.isEnabledAndVisible = true
    }

    override fun getActionUpdateThread(): ActionUpdateThread {
        return ActionUpdateThread.BGT
    }
}
