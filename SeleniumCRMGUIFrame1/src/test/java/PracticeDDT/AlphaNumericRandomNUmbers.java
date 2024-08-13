package PracticeDDT;

import java.util.Random;

public class AlphaNumericRandomNUmbers
{
public static void main(String[] args) 
{
	int n=20;
	
	Random random=new Random();
	
//choose character from this string
	  String Alphastring="ABCDEFGHIJKLMNOPQRSTUV0123456789abcdefghijklmnopqrstuvwxyz";
	
//create stringbuffer size of alphanumericstring
	  StringBuilder sb=new StringBuilder(n);
	  for(int i=0;i<n;i++)  //concate 20 length
	{
//generate a random number between 0 to 9 and alphanumeric string variable length
		int index=(int)(Alphastring.length()*Math.random());
		sb.append(Alphastring.charAt(index));
	}
	System.out.println(sb);	
	}
}
