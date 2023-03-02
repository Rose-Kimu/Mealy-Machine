import java.util.*;
class Complement{
    static StringBuilder myOutputString = new StringBuilder();

    static int myState = 1;

     //for start state A
    static void startState(char c) {
        if (c =='0') {
            myState = 2;
            myOutputString.append("b");
        } else if (c == '1') {
            myState = 1;
            myOutputString.append("b");
        } else {
            myState = -1; //put an exception for -1 state
        }
    }
    static void  stateB(char c) {
        if (c =='0') {
            myState = 3;
            myOutputString.append("b");
        } else if (c == '1') {
            myState = 1;
            myOutputString.append("b");
        } else {
            myState = -1; //put an exception for -1 state
        }
    }
    static void stateC(char c) {
        if (c =='0') {
            myState = 3;
            myOutputString.append("b");
        } else if (c == '1') {
            myState = 4;
            myOutputString.append("a");
        } else {
            myState = -1; 
        }
    }
    static void stateD(char c) {
        if (c =='0') {
            myState = 2;
            myOutputString.append("b");
        } else if (c == '1') {
            myState = 1;
            myOutputString.append("b");
        } else {
            myState = -1; //put an exception for -1 state
        }
    }
    //logic to check the input against the states
    static boolean endsWith(char str[]) { 
        int len = str.length;
        int i;

        for (i = 0; i <= len-1; i++) {
            if (myState == 1) {
                startState(str[i]);
            } 
            else if (myState == 2) {
                stateB(str[i]);    
            }
            else if (myState == 3) {
                stateC(str[i]);    
            }
            else if (myState == 4) {
                stateD(str[i]);    
            }
            else {
                System.out.println("wrong input");
            }
        }
        System.out.println(myOutputString);

        String string = myOutputString.toString();
        int n = string.length();
        if (string.charAt(n-1) == 'a'){
            System.out.println("True");
            return true;
        }else{
            System.out.println("False");
            return false;
        }

    }
    static boolean checkValidity(String str){
        boolean isValid = true;
        for (int i=0; i < str.length(); i++){
            if (!( (str.charAt(i)=='0') || (str.charAt(i) == '1') )){
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    static String findTwoscomplement(StringBuffer str)
	{
		int n = str.length();
		// Traverse the string to get first '1' from
		// the last of string
		int i;
		for (i = n-1 ; i >= 0 ; i--)
			if (str.charAt(i) == '1')
				break;
	
		// If there exists no '1' concat 1 at the
		// starting of string
		if (i == -1)
			return "1" + str;
	
		// Continue traversal after the position of
		// first '1'
		for (int k = i-1 ; k >= 0; k--)
		{
			//Just flip the values
			if (str.charAt(k) == '1')
				str.replace(k, k+1, "0");
			else
				str.replace(k, k+1, "1");
		}
	
		// return the modified string
		return str.toString();
	}

    public static int displayOptions(){
        System.out.println("Enter number to choose the Language to process\n" +
             "1. To obtain 2's Complement\n"+
             "2. Check whether string ends with 001 " );
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        return num;
    }

    static void chooseFunction(int x){
        if (x == 1){
            System.out.println("Choice 1");
            System.out.println("Enter a binary string to find the 2's complement:");
            
            StringBuffer sbuffer = new StringBuffer();
            Scanner input = new Scanner(System.in);
            sbuffer.append(input.nextLine());
            // input.close();
            if (checkValidity(sbuffer.toString()) == true){
                System.out.println(findTwoscomplement(sbuffer));
                System.out.println("End of choice 1");
            }
            else{
                System.out.println("Invalid alphabet");
            }      
        }
        else if  (x == 2){
            System.out.println("Choice 2");
            Scanner sc= new Scanner(System.in);  
            System.out.print("Enter a string to check whether it ends with 001 : ");  
            String str= sc.nextLine();              
            char string[] = str.toCharArray();
            if (checkValidity(str) == true){
                endsWith(string);
                System.out.println("End of choice 2");
            }
            else{
                System.out.println("Invalid alphabet");
            }   
        }
        else{
            System.out.println("Invalid choice");
        }
    }

    public static void main(String[]args){
        int num = displayOptions();
        chooseFunction(num);
	    
    }



}