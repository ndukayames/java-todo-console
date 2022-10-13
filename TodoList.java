package Datatypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class TodoList {

    static boolean isEmpty (ArrayList<String> todoList){
        if(todoList.size() == 0) {
            System.out.println("Your todo list is empty \n \n");
            return true;
        }

        return false;
    }
    static void viewTodoList (ArrayList<String> todoList) {
        Iterator<String> it = todoList.iterator();
        int i = 1;
        if(isEmpty(todoList)) return;
        while(it.hasNext()) {
            System.out.println(i + ". " + it.next());
            i++;
        }
    }

    static void selectTodoList (ArrayList<String> todoList) {
        if(isEmpty(todoList)) return;
        Scanner input = new Scanner(System.in);
        System.out.println("Select todo list (enter the number of the item you want to edit): ");
        viewTodoList(todoList);
        int selection = input.nextInt();
        String selectedList = todoList.get(selection - 1);
        System.out.println("Selected: " + selectedList);
        System.out.print("Edit: ");
        input.nextLine(); // clear the new line
        String newTodo = input.nextLine();
        todoList.set(selection - 1, newTodo);
        System.out.println("Todo updated. \n");
        viewTodoList(todoList);
    }
    static void deleteTodoList (ArrayList<String> todoList) {
        if(isEmpty(todoList)) return;
        Scanner input = new Scanner(System.in);
        System.out.println("Select todo list (enter the number of the item you want to delete): ");
        viewTodoList(todoList);
        int selection = input.nextInt();
        String selectedList = todoList.get(selection - 1);
        System.out.println("Selected: " + selectedList);
        System.out.println("confirm delete! (true/false ");
        while(true) {
            input.nextLine();
            String doubleCheck = input.nextLine();
            if (doubleCheck.equalsIgnoreCase("true")) {
                todoList.remove(selection - 1);
                System.out.println("task deleted successfully");
                break;
            } else {
                System.out.println("task deletion failed");
                viewTodoList(todoList);
                break;
            }
        }
    }

    static void addToList (ArrayList<String> todoList) {
        System.out.println("Enter todo task:");
        Scanner input = new Scanner(System.in);
        String task = input.nextLine();
        todoList.add(task);
        System.out.println("Todo list updated \n");
    }

    public static void main(String[] args) {
        System.out.println("Welcome to your todoList");
        ArrayList<String> todoList = new ArrayList<String>();
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println(
                    " 1. View Todo List \n 2. Edit Todo List \n 3. Delete Todo \n 4. Add item to list \n 5. Enter '0' to exit."
            );
            int selection = input.nextInt();

            switch (selection) {
                case 1:
                    viewTodoList(todoList);
                    break;
                case 2:
                    selectTodoList(todoList);
                    break;
                case 3:
                    deleteTodoList(todoList);
                    break;
                case 4:
                    addToList(todoList);
                    break;
                default:
                    return;
            }
        }
    }
}
