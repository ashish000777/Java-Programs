import java.util.Scanner;
public class Main{
    public static String reversedString(String str)
    {
        if(str == null || str.isEmpty())
        {
            return str;
        }
        
        StringBuilder reversed = new StringBuilder();
        for(int i = str.length() - 1; i>=0; i--)
        {
            reversed.append(str.charAt(i));
        }
        
        return reversed.toString();
    }
    
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to reverse: ");
        String userInput = scanner.nextLine();
        String reversedString = reversedString(userInput);
        System.out.println("Reverse string: "+ reversedString);
    }
}
