package com.company.recursion;

public class pow {
    public static int pow(int b, int p)
    {
        if (p == 0)
        {
            return 1     ;
        }
        int ptemp = pow(b, p-1);
        System.out.println("ptemp : "+ptemp+"  "+b);
        return (b*ptemp);

    }

    public static void main(String args[])
    {
        System.out.print(pow(2,5));
    }
}
