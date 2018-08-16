import org.apache.commons.lang3.ArrayUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Game {
    static int turn;
    static boolean gameOn=true;
    static int turnNum = 0;
    private static final Scanner scanner = new Scanner(System.in);
    private static int[] chose = new int[9];
    private static int select = scanner.nextInt();
    private static List<Integer> list = new ArrayList<>();
    static void craftChose(){
        int j=1;
        for(int i = 0; i< chose.length; i++){
            chose[i]=j;
            j++;
        }

    }

    static String symbol;

    static void showChose(int i, int i1){
        if(turn == 1){
            symbol ="Х";
        }
        if (turn ==2){
            symbol ="0";
        }
        System.out.println("Where to place "+ symbol +" ?");
        for (int aChose : chose) {
            System.out.println(aChose);
        }
    }
    static void showNewChose(int i, int i1){
        if(turn == 1){
            symbol ="Х";
        }
        if (turn ==2){
            symbol ="0";
        }
        System.out.println("Where to place "+ symbol +" ?");
        for (int aChose : chose) {

            System.out.println(aChose);

        }
    }
    static boolean notBig=false;
    static boolean notAlreadySelected=false;
    static void turning() {
        if (select==0){
            select=100;
        }
        chekIfBig();
        notBig=true;
        chekIfAlreadySelected();
        notAlreadySelected =true;
        if (notAlreadySelected && notBig) {
            list.add(select);
            chose = ArrayUtils.removeElement(chose, select);

            if (select == 1) {
                Matrix.i = 0;
                Matrix.j = 0;

            }
            if (select == 2) {
                Matrix.i = 0;
                Matrix.j = 1;
            }
            if (select == 3) {
                Matrix.i = 0;
                Matrix.j = 2;
            }
            if (select == 4) {
                Matrix.i = 1;
                Matrix.j = 0;
            }
            if (select == 5) {
                Matrix.i = 1;
                Matrix.j = 1;
            }
            if (select == 6) {
                Matrix.i = 1;
                Matrix.j = 2;
            }
            if (select == 7) {
                Matrix.i = 2;
                Matrix.j = 0;
            }
            if (select == 8) {
                Matrix.i = 2;
                Matrix.j = 1;
            }
            if (select == 9) {
                Matrix.i = 2;
                Matrix.j = 2;
            }
            Matrix.changeMatrix(Matrix.i, Matrix.j);

        }
    }
    static void checkWin(){
        boolean xWon = Matrix.s[0][0].equals("Х") && Matrix.s[0][1].equals("Х") && Matrix.s[0][2].equals("Х") || Matrix.s[0][1].equals("X") && Matrix.s[1][1].equals("X") && Matrix.s[2][1].equals("X") ||
                Matrix.s[1][0].equals("Х") && Matrix.s[1][1].equals("Х") && Matrix.s[1][2].equals("Х") || Matrix.s[2][0].equals("Х") && Matrix.s[2][1].equals("Х") && Matrix.s[2][2].equals("Х") ||
                Matrix.s[0][0].equals("Х") && Matrix.s[1][1].equals("Х") && Matrix.s[2][2].equals("Х") || Matrix.s[0][2].equals("Х") && Matrix.s[1][1].equals("Х") && Matrix.s[2][0].equals("Х") ||
                Matrix.s[0][0].equals("Х") && Matrix.s[1][0].equals("Х") && Matrix.s[2][0].equals("Х") || Matrix.s[0][2].equals("Х") && Matrix.s[1][2].equals("Х") && Matrix.s[2][2].equals("Х");
        boolean zeroWon = Matrix.s[0][0].equals("0") && Matrix.s[0][1].equals("0") && Matrix.s[0][2].equals("0") || Matrix.s[0][1].equals("0") && Matrix.s[1][1].equals("0") && Matrix.s[2][1].equals("0") ||
                Matrix.s[1][0].equals("0") && Matrix.s[1][1].equals("0") && Matrix.s[1][2].equals("0") || Matrix.s[2][0].equals("0") && Matrix.s[2][1].equals("0") && Matrix.s[2][2].equals("0") ||
                Matrix.s[0][0].equals("0") && Matrix.s[1][1].equals("0") && Matrix.s[2][2].equals("0") || Matrix.s[0][2].equals("0") && Matrix.s[1][1].equals("0") && Matrix.s[2][0].equals("0") ||
                Matrix.s[0][0].equals("0") && Matrix.s[1][0].equals("0") && Matrix.s[2][0].equals("0") || Matrix.s[0][2].equals("0") && Matrix.s[1][2].equals("0") && Matrix.s[2][2].equals("0");
        if (turnNum == 9&& !xWon && !zeroWon){
            gameOn = false;
            System.out.println("Nobody won !");

        }
        if(xWon) {
            gameOn = false;
            System.out.println("eX won !");

        }
        if(zeroWon) {
            gameOn = false;
            System.out.println("Zero won !");

        }
    }
    public static void chekIfBig() {
        while (select>9) {
            System.out.println("Select correct value");
            select = scanner.nextInt();

            int chek;
            for (Integer aList : list) {
                chek = aList;
                do {

                    chekIfAlreadySelected();
                } while (select == chek);
            }

        }
    }
    public static void chekIfAlreadySelected(){
        int chek;
        for (Integer aList : list) {
            chek = aList;
            do {
                System.out.println("Select another value");
                select = scanner.nextInt();
                if (select>9) {

                    chekIfBig();
                }
            } while (select == chek);

        }


    }

}
