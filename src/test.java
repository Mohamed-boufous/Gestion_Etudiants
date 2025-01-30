import java.util.*;

public class test {



    public static void main(String args[])
    {
        LinkedList<Integer> lang = new LinkedList<Integer>();
        lang.add(8);
        lang.add(2);
        lang.add(1);
        lang.add(6);
        Iterator it = lang.iterator();
        Collections.reverse(lang);

        while(it.hasNext())
            System.out.print(it.next() + " ");
    }
    }