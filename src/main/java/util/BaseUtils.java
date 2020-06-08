package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BaseUtils {

    private static String userName;
    private static Stack<String> userPool = new Stack<>();
    private static List<String> list = new ArrayList<>(Arrays.asList(TypeLoader.getAppUsername().split(",")));

    static {

            System.out.println("\nDEBUG: inside BaseUtils");
                // adding the current user to the stack
                printArray((ArrayList<String>) list);
                    userPool.addAll(list);
                System.out.println("\n =============== ADDED LIST TO THE STACK (file doesn't exist) ================");
                printStack(userPool);
            // set current user
            userPool.removeIf(element -> element.equalsIgnoreCase("END"));
            printStack(userPool);
            while(userPool.isEmpty()){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        System.out.println();
            userName = userPool.pop();
            System.out.println("\n =============== CURRENT USER IS: " + userName + " ================");
            printStack(userPool);
    }

    public static String getUserName() {
        System.out.println("...getting the user: " );
        return userName;
    }

    public static void addCurrentUserBackToUserPool(){
        System.out.println("\n =============== CURRENT USER: " + userName + " IS RETURNED TO THE POOL ================");
        if(!userPool.contains(userName)) {
            userPool.push(userName);
            printStack(userPool);
        }
        else{
            System.out.println("User " + userName + " is already in the pool");
        }
    }

    public static void printStack(Stack<String> pool){
        System.out.println("\n userPool is: ");
        for (String user:pool) {
            System.out.println("\n user no: " + pool.indexOf(user) + " is: " + user);
        }
        System.out.println("\n end of userPool");
    }

    public static void printArray(ArrayList<String> list){
        System.out.println("\n list of users is: ");
        for (String user:list) {
            System.out.println("\n user no: " + list.indexOf(user) + " is: " + user);
        }
        System.out.println("\n end of list");
    }
}
