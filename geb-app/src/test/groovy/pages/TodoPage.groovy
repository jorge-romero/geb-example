package pages

import geb.Page
import todopage.modules.FormModule
import todopage.modules.TaskListModule

class TodoPage extends Page {
    static url = '/'

    static at = { title == 'ToDo App' }

    static content = {
        addTaskForm(required: true, wait: true) { module(FormModule) }
        taskList { module(TaskListModule) }
    }

    def addTasks(tasks) {
        tasks.each {
            task -> addTaskForm.addTask(task)
        }
    }
}
