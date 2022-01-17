
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Itay Dukarker
 */
public class MineSweeper {

    int count = 48;
    boolean gameover = false;
    private int numBombs;
    private int lengh;
    private int width;
    private char Array[][];
    Random rnd = new Random();

    public MineSweeper(int lengh, int width, int numBombs) {
        this.lengh = lengh;
        this.width = width;
        this.Array = new char[lengh][width];
        this.numBombs = numBombs;

        for (int i = 0; i < this.lengh; i++) {
            for (int j = 0; j < this.width; j++) {
                this.Array[i][j] = '0';
            }

        }
        for (int i = 0; i < this.numBombs; i++) {
            this.Array[rnd.nextInt(this.lengh)][rnd.nextInt(this.width)] = '9';
        }
    }

    public void printArray() {
        for (int i = 0; i < this.lengh; i++) {
            for (int j = 0; j < this.width; j++) {
//                if (this.Array[i][j] == 9) {
//                    System.out.print("0"+" ");
//                } else {
                System.out.print((char) this.Array[i][j] + " ");
//                }
            }
            System.out.println(" ");
        }
    }

    public void check_num_of_mine(int i, int j) {
        int row;
        int column;
        int tempi;
        int tempj;

        tempi = i - 1;
        tempj = j - 1;
        count = 48;
        row = i + 1;
        column = j + 1;
        if (this.Array[i][j] == '9') {
            System.out.println("Game over!! You died");
            gameover = true;
            return;
        }

        for (int k = tempi; k <= row; k++) {
            for (int l = tempj; l <= column; l++) {
                if (k >= 0 && k <= this.lengh && l >= 0 && l <= this.width) {
                    if (this.Array[k][l] == '9') {
                        count++;

                    }

                }
            }
        }
        this.Array[i][j] = (char) count;
    }

    public void open_empty_fields(int locali, int localj) {
        check_num_of_mine(locali, localj);
        if (gameover == true) {
            return;
        }
        if (count != 48) {
            printArray();
            return;
        }
        this.Array[locali][localj] = '-';
        int row;
        int column;
        int tempi;
        int tempj;

        tempi = locali - 1;
        tempj = localj - 1;
        row = locali + 1;
        column = localj + 1;
        for (int k = tempi; k <= row; k++) {
            for (int l = tempj; l <= column; l++) {
                if (k >= 0 && k <= this.lengh && l >= 0 && l <= this.width) {
                    if ((k == locali) && (l == localj)) {
                        continue;
                    } else {
                        check_num_of_mine(k, l);
                        if (count == 48) 
                            this.Array[k][l] = '-';

                    }
                }
            }
        }
        printArray();
    }

}
