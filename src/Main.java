public class Main {
    public static void main(String args[]) {

        Matrix.doMatrix();
        Matrix.showMatrix();
        Game.craftChose();
        Game.showChose(Game.turn = 1 , Game.turnNum++);
        Game.turning();
        Matrix.clearOutput();
        Matrix.showMatrix();
        Game.checkWin();
        do {
            Game.showNewChose(Game.turn = 2, Game.turnNum++);
            Game.turning();
            Matrix.clearOutput();
            Matrix.showMatrix();
            Game.checkWin();
            if(Game.gameOn) {
                Game.showNewChose(Game.turn = 1 , Game.turnNum++);
                Game.turning();
                Matrix.clearOutput();
                Matrix.showMatrix();
                Game.checkWin();
            }
        }while(Game.gameOn);
    }
}
