package todopage.modules

import geb.Module

class ListItem extends Module {
    static content = {
        textElement { $("span") }
        deleteButton { $("button") }
    }

    void delete() {
        deleteButton.click()
    }

    @Override
    String text() {
        textElement.text()
    }
}