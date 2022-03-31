/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package time.conversions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author ahmed
 */
public class TimeConversions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
    
}
class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        //'11:10::00PM to 23:10:00
         String str1=s.toLowerCase();
        StringBuilder MyString = new StringBuilder(str1);
       
        char[] ch =str1.toCharArray();
        int digit=Integer.parseInt(String.valueOf(ch[0])+String.valueOf(ch[1])); 
        
        char time=MyString.charAt(MyString.length()-2);
        MyString.delete(MyString.length()-2,MyString.length());
        
        int hour=0;
        
        if(Character.compare(time,'p')==0||Character.compare(time,'P')==0)
         {
            if(digit<12)
           {
              hour=digit+12;
              MyString.delete(0, 2);
              MyString.insert(0,hour);
         }
       }
         else if(Character.compare(time,'A')==0||Character.compare(time,'a')==0)
         {
             if(digit==12)
             {
                 
                 MyString.delete(0, 2);
                 MyString.insert(0,"00");
             }
              
         }
        return MyString.toString();
    }
}