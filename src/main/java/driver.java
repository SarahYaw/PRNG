import java.util.InputMismatchException;
import java.util.Scanner;
public class driver
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a seed: ");
        int seed = in.nextInt();
        System.out.print("Enter an upper limit of loops or -1 for a full pattern: ");
        String limit = in.next();
        System.out.println("Seed entered was: "+seed);
        System.out.println("Middle Squares string is: "+MiddleSquares(seed, limit));
        System.out.println("xxxx string is: "+xxxx(seed, limit));
    }

    public static String MiddleSquares(int seed, String limit)
    {
        //low quality PRNG; is mostly of historical merit. Developed by VonNeumann
        String out="", temp="";
        int current = seed*seed, loops = 0, max=0;
        if (Integer.parseInt(limit)!= -1)
            max=Integer.parseInt(limit);
        else
            max = Integer.MAX_VALUE;
        while (current!=seed && loops < max)
        {
            temp=current+"";
            int l = temp.length()-3;
            temp = temp.substring(l/2,temp.length()-(l/2));
            out=out+temp;
            current = Integer.parseInt(temp);
            current=current*current;
            loops++;
        }
        return out;
    }
    public static String xxxx(int seed, String limit)
    {
        String out="", temp="";
        int current = seed*seed, loops = 0, max=0;
        if (Integer.parseInt(limit)!= -1)
            max=Integer.parseInt(limit);
        else
            max = Integer.MAX_VALUE;
        while (current!=seed && loops < max)
        {
            //do work
            loops++;
        }
        return out;
    }
}
