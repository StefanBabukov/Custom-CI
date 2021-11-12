package dectohex;

import java.util.Scanner;

class Dec2Hex
{
    public static int Arg1;
    public static boolean isANumber (String value){
        try {
            double d = Integer.parseInt(value);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    Dec2Hex(){
        
    }
    public static void main(String args[])
    {
	if(args.length==0){
            System.out.println("No value provided");
            return;
	}
    if(!isANumber(args[0])){
        System.out.println(args[0] + " is not a number!");
        return;
    }
	
        Arg1 = Integer.parseInt(args[0]);
        char ch[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        int rem, num;
        num = Arg1;
        String hexadecimal="";
        System.out.println("Converting the Decimal Value " + num + " to Hex...");

        while(num != 0)
        {
            rem=num%16;
            hexadecimal= ch[rem] + hexadecimal;
            num= num/16;
        }

        System.out.println("Hexadecimal representation is: " + hexadecimal);

    }
}
