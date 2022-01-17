import java.util.Scanner;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Itay Dukarker
 */
public class Main_MIneSweeper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter lengh,width and bombs: ");
      MineSweeper board1 = new MineSweeper(sc.nextInt(),sc.nextInt(),sc.nextInt());
      board1.printArray();
      System.out.println("Enter location: ");
     // board1.check_num_of_mine(sc.nextInt(), sc.nextInt());
     board1.open_empty_fields(sc.nextInt(), sc.nextInt());
    }
    
}
