import geb.spock.GebReportingSpec
import pages.TodoPage

class TodoSpec extends GebReportingSpec {

    def setup() {
        baseUrl = 'http://localhost:3000'
    }

    def "Visit page"() {
        given:
        to TodoPage

        expect:
        at TodoPage
    }

    def "Add task to list"() {
        given:
        to TodoPage

        when:
        addTaskForm.addTask('New Task')

        then:
        assert taskList.listElements.size() == 1
        assert taskList.listElements.first().$('span').text() == 'New Task'
    }

    def "Remove tasks from list"() {
        given:
        to TodoPage
        addTasks(['Task 1', 'Task 2', 'Task 3', 'Task 4'])

        expect:
        assert taskList.listElements.size() == 4

        when:
        taskList.removeElement(2)

        then:
        assert taskList.listElements.size() == 3
    }
}