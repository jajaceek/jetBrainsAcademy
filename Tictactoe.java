package tictactoe;


import java.io.*;
import java.util.*;

public class Tictactoe {

    public static void main(String[] args) {

        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        char[] ch = new char[9];
        boolean flagXwin = false;
        boolean flagOwin = false;
        boolean flagDraw = false;

        // fill the matrix ' '
        Arrays.fill(ch, ' ');


        char input = 'X';
        int coordinateFirst = 0;
        int coordinateSecond = 0;


        while (true) {

            try {

                while (!flagDraw && !flagXwin && !flagOwin) {


                    printStatus(ch);

                    System.out.print("Enter the coordinates: ");

                    String sc = scanner.readLine();
                    String[] pieces = sc.split(" ");
                    coordinateFirst = Integer.parseInt(pieces[0]);
                    coordinateSecond = Integer.parseInt(pieces[1]);


                    // if 1 - 3
                    while (coordinateFirst > 3 || coordinateFirst < 1 || coordinateSecond > 3 || coordinateSecond < 1) {
                        System.out.println("Coordinates should be from 1 to 3!");
                        System.out.print("Enter the coordinates: ");
                        sc = scanner.readLine();
                        pieces = sc.split(" ");
                        coordinateFirst = Integer.parseInt(pieces[0]);
                        coordinateSecond = Integer.parseInt(pieces[1]);
                    }

                    // if free
                    while (ch[getIndex(coordinateFirst, coordinateSecond)] == 'O' || ch[getIndex(coordinateFirst, coordinateSecond)] == 'X') {
                        System.out.println("This cell is occupied! Choose another one!");
                        System.out.print("Enter the coordinates: ");
                        sc = scanner.readLine();
                        pieces = sc.split(" ");
                        coordinateFirst = Integer.parseInt(pieces[0]);
                        coordinateSecond = Integer.parseInt(pieces[1]);
                    }


                    if (coordinateFirst == 1 && coordinateSecond == 1) {
                        ch[6] = input;
                    } else if (coordinateFirst == 1 && coordinateSecond == 2) {
                        ch[3] = input;
                    } else if (coordinateFirst == 1 && coordinateSecond == 3) {
                        ch[0] = input;
                    } else if (coordinateFirst == 2 && coordinateSecond == 1) {
                        ch[7] = input;
                    } else if (coordinateFirst == 2 && coordinateSecond == 2) {
                        ch[4] = input;
                    } else if (coordinateFirst == 2 && coordinateSecond == 3) {
                        ch[1] = input;
                    } else if (coordinateFirst == 3 && coordinateSecond == 1) {
                        ch[8] = input;
                    } else if (coordinateFirst == 3 && coordinateSecond == 2) {
                        ch[5] = input;
                    } else if (coordinateFirst == 3 && coordinateSecond == 3) {
                        ch[2] = input;
                    }

                    // change input
                    if (input == 'X') input = 'O';
                    else input = 'X';


                    // Xwin
                    int win = 264;
                    if (ch[0] + ch[1] + ch[2] == win || ch[3] + ch[4] + ch[5] == win || ch[6] + ch[7] + ch[8] == win ||
                            ch[0] + ch[3] + ch[6] == win || ch[1] + ch[4] + ch[7] == win || ch[2] + ch[5] + ch[8] == win ||
                            ch[0] + ch[4] + ch[8] == win || ch[2] + ch[4] + ch[6] == win)
                        flagXwin = true;

                    // Owin
                    win = 237;
                    if (ch[0] + ch[1] + ch[2] == win || ch[3] + ch[4] + ch[5] == win || ch[6] + ch[7] + ch[8] == win ||
                            ch[0] + ch[3] + ch[6] == win || ch[1] + ch[4] + ch[7] == win || ch[2] + ch[5] + ch[8] == win ||
                            ch[0] + ch[4] + ch[8] == win || ch[2] + ch[4] + ch[6] == win)
                        flagOwin = true;

                    // Draw
                    if ((ch[0] == 'O' || ch[0] == 'X') && (ch[1] == 'O' || ch[1] == 'X') && (ch[2] == 'O' || ch[2] == 'X') &&
                            (ch[3] == 'O' || ch[3] == 'X') && (ch[4] == 'O' || ch[4] == 'X') && (ch[5] == 'O' || ch[5] == 'X') &&
                            (ch[6] == 'O' || ch[6] == 'X') && (ch[7] == 'O' || ch[7] == 'X') && (ch[8] == 'O' || ch[8] == 'X') &&
                            !flagXwin && !flagOwin)
                        flagDraw = true;


                }

                // results
                printStatus(ch);
                if (isOWin(ch)) System.out.println("O wins");
                else if (isXWin(ch)) System.out.println("X wins");
                else System.out.println("Draw");

                break;

            } catch (Exception e) {
                System.out.println("You should enter numbers!");
            }
        }


    }

    static void printStatus(char[] ch) {
        System.out.println("---------");
        System.out.println("| " + ch[0] + " " + ch[1] + " " + ch[2] + " |");
        System.out.println("| " + ch[3] + " " + ch[4] + " " + ch[5] + " |");
        System.out.println("| " + ch[6] + " " + ch[7] + " " + ch[8] + " |");
        System.out.println("---------");
    }

    static boolean isXWin(char[] ch) {
        int win = 264;
        return ch[0] + ch[1] + ch[2] == win || ch[3] + ch[4] + ch[5] == win || ch[6] + ch[7] + ch[8] == win ||
                ch[0] + ch[3] + ch[6] == win || ch[1] + ch[4] + ch[7] == win || ch[2] + ch[5] + ch[8] == win ||
                ch[0] + ch[4] + ch[8] == win || ch[2] + ch[4] + ch[6] == win;

    }

    static boolean isOWin(char[] ch) {
        int win = 237;
        return ch[0] + ch[1] + ch[2] == win || ch[3] + ch[4] + ch[5] == win || ch[6] + ch[7] + ch[8] == win ||
                ch[0] + ch[3] + ch[6] == win || ch[1] + ch[4] + ch[7] == win || ch[2] + ch[5] + ch[8] == win ||
                ch[0] + ch[4] + ch[8] == win || ch[2] + ch[4] + ch[6] == win;
    }

    static boolean isDraw(char[] ch) {

        return (int) ch[0] == 88 || (int) ch[0] == 79 ||
                (int) ch[1] == 88 || (int) ch[1] == 79 ||
                (int) ch[2] == 88 || (int) ch[2] == 79 ||
                (int) ch[3] == 88 || (int) ch[3] == 79 ||
                (int) ch[4] == 88 || (int) ch[4] == 79 ||
                (int) ch[5] == 88 || (int) ch[5] == 79 ||
                (int) ch[6] == 88 || (int) ch[6] == 79 ||
                (int) ch[7] == 88 || (int) ch[7] == 79 ||
                (int) ch[8] == 88 || (int) ch[8] == 79 && !isOWin(ch) && !isXWin(ch);
    }


    static int getIndex(int coordinateFirst, int coordinateSecond) {
        int index = 0;
        if (coordinateFirst == 1 && coordinateSecond == 1) {
            index = 6;
        } else if (coordinateFirst == 1 && coordinateSecond == 2) {
            index = 3;
        } else if (coordinateFirst == 1 && coordinateSecond == 3) {
            index = 0;
        } else if (coordinateFirst == 2 && coordinateSecond == 1) {
            index = 7;
        } else if (coordinateFirst == 2 && coordinateSecond == 2) {
            index = 4;
        } else if (coordinateFirst == 2 && coordinateSecond == 3) {
            index = 1;
        } else if (coordinateFirst == 3 && coordinateSecond == 1) {
            index = 8;
        } else if (coordinateFirst == 3 && coordinateSecond == 2) {
            index = 5;
        } else if (coordinateFirst == 3 && coordinateSecond == 3) {
            index = 2;
        }
        return index;
    }

}