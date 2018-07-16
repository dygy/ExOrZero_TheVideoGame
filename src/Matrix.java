class Matrix {
    static String [][] s = new String[3][3];
    static void doMatrix(){

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                s[i][j] = "_";

            }
        }
    }
    static void showMatrix(){
        System.out.println(" _____");
        System.out.println("|"+s[0][0]+"|"+s[0][1]+"|"+s[0][2]+"|");
        System.out.println("|"+s[1][0]+"|"+s[1][1]+"|"+s[1][2]+"|");
        System.out.println("|"+s[2][0]+"|"+s[2][1]+"|"+s[2][2]+"|");
    }
    static int i;
    static int j;
    static void changeMatrix(int i, int j){
        s[i][j]=Game.symbol;
    }
    static void clearOutput() {
        System.out.print("\033[H\033[2J");
    }
}
