import java.util.InputMismatchException;
import java.util.Scanner;
public class driver
{
    public static Scanner in = new Scanner(System.in);
    static int max=0;
    public static void main(String[] args)
    {
        System.out.print("Enter a seed: ");
        int seed = in.nextInt();
        System.out.print("Enter an upper limit of loops or -1 for a full pattern: ");
        int limit = in.nextInt();
        if (limit != -1){ max = limit;}
        else{ max = Integer.MAX_VALUE;}

        System.out.println("Seed entered was: "+seed);
        System.out.println("Middle Squares string is: "+MiddleSquares(seed));
        System.out.println("Lehmer string is: "+Lehmer(seed));
        System.out.println("Linear Congruential string is: "+LinearCongruential(seed));
        System.out.println("Inversive Congruential Generator string is: "+InversiveCongruentialGenerator(seed));
        //System.out.println("xxxx string is: "+xxxx(seed));
    }

    public static String MiddleSquares(int seed)
    {   //low quality PRNG; is mostly of historical merit. Developed by VonNeumann
        String out="", temp="";
        int current = seed*seed, loops = 0;

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
    public static String Lehmer(int seed)
    {   //another very early PRNG algorithm
        String out="", temp="";
        int current = seed, loops = 0, m=0, a=0;
        System.out.print("Please enter a large prime integer: "); //debugging just uses 13
        m = in.nextInt();
        System.out.print("Please enter an integer: ");
        a = in.nextInt();

        while ((current!=seed || loops==0) && loops < max)
        {
            temp=current+"";
            out=out+temp;
            current=(a*current)%m;
            loops++;
        }
        return out;
    }
    public static String LinearCongruential(int seed)
    {   //Schrage's method of linear congruential generator. This is a generalization of Lehmer
        String out = "", temp = "";
        int current = seed, loops = 0, a=0, mod=0,r=0, q=0;
        System.out.print("Please enter a non-prime integer: ");
        mod = in.nextInt();
        System.out.print("Please enter an integer less than or equal to "+(int)Math.sqrt(mod)+" :");
        a = in.nextInt();
        r=mod%a;
        q=(mod-r)/a;
        while ((current!=seed || loops==0) && loops < max)
        {
            current = a*(current%q)-r%mod;
            temp = Math.abs(current) + "";
            out = out + temp;
            loops++;
        }
        return out;
    }
    public static String InversiveCongruentialGenerator(int seed)
    {
        String out="", temp="";
        int current = seed, loops = 0, mod=0, i=1, j=2, base=0;
        System.out.print("Please enter an integer to modulus: ");
        mod = in.nextInt();
        System.out.print("Please enter an integer for a base case: ");
        base = in.nextInt();
        while (j<=mod && loops<max)
        {
            if(current==0)
                current = base;
            else
                current = (int) (Math.pow(current, i)+ Math.pow(current,j)) % mod;
            temp=current+"";
            out=out+temp;
            loops++;
        }
        return out;
    }
    public static String xxxx(int seed)
    {
        String out="", temp="";
        int current = seed, loops = 0;

        while ((current!=seed || loops==0) && loops < max)
        {
            temp=current+"";
            out=out+temp;
            //next step
            loops++;
        }
        return out;
    }
}
