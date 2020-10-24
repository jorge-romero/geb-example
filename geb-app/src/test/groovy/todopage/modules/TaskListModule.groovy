package todopage.modules

import geb.Module

class TaskListModule extends Module {
    static content = {
        list { $("#ToDoList > ul") }
        listElements { list.$('li') }
        item { index -> $("li:nth-child($index)", dynamic: true).module(ListItem) }
    }

    def removeElement(index) {
        item(index).delete()
    }
}
