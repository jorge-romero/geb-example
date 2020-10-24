package todopage.modules

import geb.Module

class FormModule extends Module {
    static content = {
        inputBox { $('#inputText') }
        addButton { $('#addButton') }
    }

    void addTask(task) {
        inputBox << task
        addButton.click()
    }
}
