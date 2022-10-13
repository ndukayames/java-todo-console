package Datatypes;

import java.util.*;

public class AdvancedTodo {
    static int id = 0;
    static boolean isEmpty (ArrayList<HashMap<String, Object>> todoList){
        if(todoList.size() == 0) {
            System.out.println("Your todo list is empty \n \n");
            return true;
        }

        return false;
    }
    static void viewTodoList ( ArrayList<HashMap<String, Object>> todoList) {
        // view the list of todo group
        int i = 1;
        if(isEmpty(todoList)) return;
        for(HashMap<String, Object> list : todoList) {
            System.out.println(list.get("id") + ". " + list.get("Group Name"));
            i++;
        }
    }
    static HashMap<String, Object> selectList (ArrayList<HashMap<String, Object>> todoList) {
        // select one of the todo groups
        int i = 1;
        if(isEmpty(todoList)) return null;
        System.out.println("Select from the list below");
        // list group names
        for(HashMap<String, Object> list : todoList) {
            System.out.println(list.get("id") + ". " + list.get("Group Name"));
            i++;
        }
        Scanner input = new Scanner(System.in);
        short selection = input.nextShort();
        HashMap<String, Object> selectedList = null;
        // loop through tasks in th egroup
        for(HashMap<String, Object> list : todoList) {
            if(list.get("id").equals(selection)); {
               selectedList = list;
            }
        }
        System.out.println(selectedList.get("Group Name") + " selected" );
        return selectedList;
    }
    static void editLabel (HashMap<String, Object> selectedList) {
        System.out.println("Enter new label name");
        Scanner input = new Scanner(System.in);
        String newLabel = input.nextLine();
        selectedList.put("Group Name", newLabel);
    }
    static void editListTasks (HashMap<String, Object> selectedList) {
        System.out.println("Select which task to edit");
        System.out.println(selectedList.get("Todo List"));
        ArrayList<String> taskList = (ArrayList<String>) selectedList.get("Todo List");
        int i = 1;
        for(String task : taskList) {
            System.out.println(i + ". " + task);
            if(i < taskList.size()) i++;
        }
        Scanner input = new Scanner(System.in);
        int selection = input.nextInt();
        System.out.println("Selected: " + taskList.get(i-1));
        System.out.println("Enter new task");
        input.nextLine();
        String newTask = input.nextLine();
        taskList.set(i-1, newTask);
        selectedList.put("Todo List", taskList);
    }
    static void editTodoList (ArrayList<HashMap<String, Object>> todoList) {

        HashMap<String, Object> selectedList = selectList(todoList);


        Scanner input = new Scanner(System.in);

            System.out.println(
                    " 1. Edit todo list label \n 2. Edit todo list tasks 3. Add new task to todo list. \n Enter '0' to exit."
            );
            int selection = input.nextInt();
            input.nextLine();
            switch (selection) {
                case 1:
                    editLabel(selectedList);
                    break;
                case 2:
                    editListTasks(selectedList);
                    break;
                case 3:
                    addTaskToList(selectedList);
                    break;
                default:
                    return;
            }
    }
    static void addNewTodoListGroup (ArrayList<HashMap<String, Object>> todoList) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Group name");
        String groupName = input.nextLine();
        HashMap<String, Object> newTodoList = new HashMap<String, Object>();
        ArrayList<String> newTodoListItem = new ArrayList<String>();
        newTodoListItem.add("My first task");
        newTodoList.put("Group Name", groupName);
        newTodoList.put("id", ++id);
        newTodoList.put("Todo List", newTodoListItem);

        todoList.add(newTodoList);
        viewTodoList(todoList);
    }
    static void addTaskToList (HashMap<String, Object> selectedList) {
        ArrayList<String> taskList = (ArrayList<String>) selectedList.get("Todo List");
        System.out.println("Enter todo task:");
        Scanner input = new Scanner(System.in);
        String task = input.nextLine();
        taskList.add( task);
        selectedList.put("Todo List", taskList);
        System.out.println("Todo list updated \n");
    }

    public static void main(String[] args) {
        System.out.println("Welcome to your todoList");
        ArrayList<HashMap<String, Object>> globalTodoList = new ArrayList<HashMap<String, Object>>();
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println(
                    " 1. View Todo List Group \n 2. Edit Todo List Group \n 3. Delete Todo Group \n 4. Add new group \n 5. Enter '0' to exit."
            );
            int selection = input.nextInt();

            switch (selection) {
                case 1:
                    viewTodoList(globalTodoList);
                    break;
                case 2:
                    editTodoList(globalTodoList);
                    break;
                case 4:
                    addNewTodoListGroup(globalTodoList);
                    break;
                default:
                    return;
            }
        }
    }
}
