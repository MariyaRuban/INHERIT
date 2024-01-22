import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    ///

    @Test
    public void shouldSearchSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Todos todos = new Todos();

        todos.add(simpleTask);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Позвонить родителям");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchEpic() {
        String[] subtasks = {"Позвонить родителям", "Прочитать книгу", "Съесть суп"};
        Epic epic = new Epic(2, subtasks);

        Todos todos = new Todos();

        todos.add(epic);

        Task[] expected = {epic};
        Task[] actual = todos.search("Съесть суп");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchMeeting() {
        Meeting meeting = new Meeting(3, "Сходить погулять", "Объект", "утро первого");

        Todos todos = new Todos();

        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Сходить погулять");
        Assertions.assertArrayEquals(expected, actual);

    }

}
