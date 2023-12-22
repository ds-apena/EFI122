package verschiebespiel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int[][] board;
    static int boardSize;
    static int[] emptyFieldIndex;
    static int moves;
    static Scanner sc;

    // File path
    static String filePath = "game_currentState.txt";

    public static void main(String[] args) {
        start();
    }

    private static void start() {

        // Init
        sc = new Scanner(System.in);
        moves = 0;

        System.out.println(" --- Welcome to the 15 Puzzle ---");

        // Ask if user would like to resume the previous game session or start a new one
        System.out.print("Board size (min. 3): ");

        boardSize = Integer.parseInt(sc.next());

        System.out.print("Would you like to resume the previous game session? (y/n) ");
        char previousGame = sc.next().charAt(0);
        if (previousGame == 'Y' || previousGame == 'y') {
            board = readFromFile();
            printBoard(board);
            play();
        }

        // Create Board
        board = new int[boardSize][boardSize];
        boardSelection();
        play();

    }

    static void boardSelection(){
        List<int[][]> boards = new ArrayList<>();

        // Create Boards
        for (int i = 0; i < 4; i++){
            boards.add(createRandomBoard());
        }

        // Print Boards
        System.out.println();
        for (int j=0; j< boards.size(); j++){
            System.out.println("Board " + j + ": ");
            printBoard(boards.get(j));
            System.out.println();
        }
        System.out.println("Board 4: Random\n");

        // Board Selection
        System.out.print("Which board do you like to choose: ");
        int selection = Integer.parseInt(sc.next());
        board = boards.get(selection);

        System.out.println();
        printBoard(board);
    }

    private static void play(){
        while (!isGameOver()) {
            System.out.print("Enter the number that you'd like to swap: ");
            int numberToSwap = Integer.parseInt(sc.next());
            if (getAdjacentsFields(numberToSwap).contains(0)){
                swapFields(numberToSwap);
                moves++;
            } else {
                System.out.println("Invalid move");
            }

            System.out.println("Total moves: " + moves);
            printBoard(board);

            // Create a BufferedWriter and FileWriter
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
                writeToFile(writer);
                // Close the writer
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private static int[][] createRandomBoard() {
        int[][] boardRandom = new int[boardSize][boardSize];
        List<Integer> assignedNumbers = new ArrayList<>();

        for (int i=0; i < boardRandom.length; i++) {
            for (int j=0; j < boardRandom[i].length; j++) {
                int ranNum;
                boolean noValidNumber = true;
                while (noValidNumber) {
                    ranNum = generateRandomNumber();
                    if (!assignedNumbers.contains(ranNum)){
                        assignedNumbers.add(ranNum);
                        boardRandom[i][j] = ranNum;
                        noValidNumber = false;
                    }
                }
            }
        }

        return boardRandom;
    }

    private static int generateRandomNumber() {
        int min = 0;
        int max = (boardSize * boardSize - 1);
        return (int) Math.floor((Math.random() * ((max - min + 1) + min)));
    }

    private static void printBoard(int[][] boardToPrint) {
        for (int i=0; i < boardToPrint.length; i++) {
            for (int j=0; j < boardToPrint[i].length; j++) {
                int num = boardToPrint[i][j];
                if (num == 0) {
                    System.out.print("\t");
                } else {
                    System.out.print(boardToPrint[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    private static void swapFields(int number) {
        int[] fieldPosition = getFieldIndex(number);

        int fieldPositionX = fieldPosition[0];
        int fieldPositionY = fieldPosition[1];

        emptyFieldIndex = getFieldIndex(0);

        board[fieldPositionX][fieldPositionY] = 0;
        board[emptyFieldIndex[0]][emptyFieldIndex[1]] = number;

        emptyFieldIndex[0] = fieldPositionX;
        emptyFieldIndex[1] = fieldPositionY;
    }

    private static List<Integer> getAdjacentsFields(int numberToSwap) {
        List<Integer> adjacentFields = new ArrayList<>();

        int[] fieldPosition = getFieldIndex(numberToSwap);

        int positionX = fieldPosition[0];
        int positionY = fieldPosition[1];

        if (positionY - 1 >= 0) {
            adjacentFields.add(board[positionX][positionY - 1]);
        }
        if (positionY + 1 < boardSize) {
            adjacentFields.add(board[positionX][positionY + 1]);
        }
        if (positionX - 1 >= 0) {
            adjacentFields.add(board[positionX -1][positionY]);
        }
        if (positionX + 1 < boardSize) {
            adjacentFields.add(board[positionX + 1][positionY]);
        }

        return adjacentFields;
    }

    private static int[] getFieldIndex(int number) {
        for (int i=0; i < boardSize; i++) {
            for (int j=0; j < boardSize; j++) {
                if (number == board[i][j]) {
                    return new int[]{i,j};
                }
            }
        }

        return null;
    }

    private static boolean isGameOver() {
        int[][] finalBoard = new int[boardSize][boardSize];

        int num = 1;

        for (int i=0; i < board.length; i++) {
            for (int j=0; j < board[i].length; j++) {
                finalBoard[i][j] = num++;
            }
        }

        for (int i=0; i < board.length; i++) {
            if (board[i].length != finalBoard[i].length) {
                return false;
            }

            for (int j=0; j < board[i].length; j++) {
                if (board[i][j] != finalBoard[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    // Optional feature: Save current state and read from file

    private static void writeToFile(BufferedWriter writer) throws IOException {
        for (int[] row : board) {
            for (int element : row ) {
                writer.write(Integer.toString(element));
                writer.write(" ");
            }
            writer.newLine();
        }
    }

    private static int[][] readFromFile() {
        try {
            Scanner fileReader  = new Scanner(new File(filePath));
            int[][] gameBoard = new int[boardSize][boardSize];

            for (int i=0; i < boardSize; i++) {
                for (int j=0; j < boardSize; j++) {
                    if(fileReader.hasNextInt()) {
                        gameBoard[i][j] = fileReader.nextInt();
                    } else {
                        break;
                    }
                }
            }

            return gameBoard;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
 }
