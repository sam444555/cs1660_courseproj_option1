import java.net.*;
import java.util.Scanner;
import java.io.IOException;

class driver
{
 public static void main(String[] args) throws IOException
 {
    // wait_for_connection();
    print_intro(); 
    Scanner user_input = new Scanner(System.in);
    String selection; 
    print_options();                        //print the options 
    while(true)
    {
        selection = user_input.nextLine();       //get the user input 
        process_input(selection);               //process selection 
         
    }
}

 //wait for user to connect with port # 8080 
 public static void wait_for_connection()
 {
     try
     {
         //server shit 
         ServerSocket serverSocket = new ServerSocket(8080);
         Socket socket = serverSocket.accept();

         System.out.println("Connection detected -- starting program");
     }
        
     catch(IOException e)
     {
         System.out.println(e);
     }

 }
 //print intro 
 public static void print_intro()
 {
    System.out.print("\n\n");
    System.out.println("\t<<<<<<<Welcome to the Big Data Processing Application>>>>>>>");
    System.out.println("\n\tWhen you make your selection, please refer back to the\n" +
        "\tterminal application if the service requires further information\n");
    
 }
 //print options 
 public static void print_options()
 {
    System.out.println("Enter the number that corresponds to the application which you want to run:");
    System.out.println("1. Apache Hadoop");
    System.out.println("2. Apache Spark");
    System.out.println("3. Jupyter Notebook");
    System.out.println("4. SonarQube and SonarScanner");
    System.out.println("5. Print Options Again");
    System.out.println("6. Exit");
 }
 //process input 
 public static void process_input(String selection) throws IOException
 {
    
    if(selection.equals("1"))
    {
        System.out.println("Enter 146.148.48.94:9870 into your url");
        return;
    }
    if(selection.equals("2"))
    {
        System.out.println("Enter 34.70.141.209:80 into your url for web interface");
        System.out.println("To launch the terminal application:");
        System.out.println("1.  Run >> kubectl get pods");
        System.out.println("2.  Run >> kubectl exec -it <pod name> /bin/bash");
        System.out.println("3   Run >>  /spark/bin/spark-shell");
        System.out.println("After a minute or so, you'll have a spark shell running!");
        return;
  }
    if(selection.equals("3"))
    {
        // 34.67.180.254:80 
        System.out.println("Enter 34.67.180.254:80 into your url");
        return;

    }
    if(selection.equals("4"))
    {
        System.out.println("Enter 34.134.103.155:80 into your url");
        return;

    }
    if(selection.equals("5"))
    {
       print_options();
       return;
    }
    if(selection.equals("6"))
    {
        System.out.println("Exiting...");
        System.exit(1);
    }

    System.out.println("invalid input");
}



}










