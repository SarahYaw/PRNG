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

        //use middle squares to seed lehmer
        String temp =MiddleSquares(seed);
        //System.out.println("Middle Squares string is: "+temp);
        int t = temp.length()/3;
        int s = Integer.parseInt(temp.substring(0,5));
        int m = Integer.parseInt(temp.substring(t,t+5));
        int a = Integer.parseInt(temp.substring(2*t,2*t+5));
        temp = Lehmer(s, m, a);

        //use lehmer to seed inversive congruential
        //System.out.println("Lehmer string is: "+temp);
        t = temp.length()/3;
        s = Integer.parseInt(temp.substring(0,5));
        m = Integer.parseInt(temp.substring(t,t+5));
        a = Integer.parseInt(temp.substring(2*t,2*t+5));
        temp = InversiveCongruentialGenerator(s, m, a);

        //use inversive congruential to seed linear
        //System.out.println("Inversive Congruential Generator string is: "+temp);
        t = temp.length()/3;
        s = Integer.parseInt(temp.substring(0,5));
        m = Integer.parseInt(temp.substring(t,t+5));
        a = Integer.parseInt(temp.substring(2*t,2*t+5));
        if(a<=Math.sqrt(m))
            temp = LinearCongruential(s, m, a);
        else
            temp = LinearCongruential(s, m, a%m);

        //LC gives the final output string
        //System.out.println("Linear Congruential string is: "+temp);
        System.out.println("Random string is: \n"+temp);
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
    public static String Lehmer(int seed, int m, int a)
    {   //another very early PRNG algorithm
        String out="", temp="";
        int current = seed, loops = 0;

        while ((current!=seed || loops==0) && loops < max)
        {
            temp=Math.abs(current)+"";
            out=out+temp;
            current=(a*current)%m;
            loops++;
        }
        return out;
    }
    public static String LinearCongruential(int seed, int mod, int a)
    {   //Schrage's method of linear congruential generator. This is a generalization of Lehmer
        String out = "", temp = "";
        int current = seed, loops = 0,r=0, q=0;
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
    public static String InversiveCongruentialGenerator(int seed, int mod, int base)
    {
        String out="", temp="";
        int current = seed, loops = 0, i=1, j=2;
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
}
