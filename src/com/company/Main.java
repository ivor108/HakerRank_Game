package com.company;
import java.util.*;

public class Main {

    //Моя первая реализация
    /*
    public static boolean canWin(int leap, int[] game, int pos) {

        if(pos == game.length-1 || pos + leap >= game.length)
            return true;

        if (leap != 0 && pos + leap < game.length && game[pos + leap] == 0)
        {
            pos+=leap;
            //System.out.println("Leap to " + pos);
            return canWin(leap, game, pos);
        }
        else if (pos + 1 < game.length && game[pos + 1] == 0)
        {
            pos++;
            //System.out.println("Step to " + pos);
            return canWin(leap, game, pos);
        }
        else if (pos != 0 && leap != 0 && leap != 1 && game[pos - 1] == 0)
        {
            pos--;
            //System.out.println("Back to " + pos);
            int c = leap;
            while(game[pos] == 0 && pos > 0 && c > 1)
            {
                if(game[pos + leap] == 0)
                {
                    pos+=leap;
                    //System.out.println("Leap "+ leap +" to " + pos);
                    return canWin(leap, game, pos);
                }
                pos--;
                c--;
            }
        }
        else
            return false;

        return false;
    }
     */

    public static boolean canWin(int leap, int[] game) {
        return isSolvable(leap, game, 0);
    }

    private static boolean isSolvable(int leap, int[] game, int i) {

        if (i >= game.length) {
            return true;
        } else if (i < 0 || game[i] == 1) {
            return false;
        }

        game[i] = 1;


        return isSolvable(leap, game, i + leap) ||
                isSolvable(leap, game, i + 1) ||
                isSolvable(leap, game, i - 1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
