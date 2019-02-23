import java.io.*;
import java.util.Scanner;

public class Invert {

    public static float[][] copyMatrixToArray(File matrixFile) {
        try (FileReader reader = new FileReader(matrixFile)) {
            int order = getMatrixOrder(matrixFile);
            if (order != 3) {
                System.out.println("Your matrix should has order 3");
                System.exit(1);
            }
            BufferedReader bufferedReader = new BufferedReader(reader);
            float[][] matrix = new float[order][order];
            for (int i = 0; i < order; ++i) {
                Scanner scanner = new Scanner(bufferedReader.readLine());
                for (int j = 0; j < order; ++j) {
                    matrix[i][j] = scanner.nextFloat();
                }
            }
            return matrix;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("FileNotFoundException");
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException");
            System.exit(1);
        }
        return null;
    }

    public static int getMatrixOrder(File matrixFile) {
        int lineCounter = 0;
        int elemCounter;
        int counter = 0;
        try (FileReader reader = new FileReader(matrixFile)) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            while (bufferedReader.ready()) {
                elemCounter = 0;
                Scanner scanner = new Scanner(bufferedReader.readLine());
                while (scanner.hasNextFloat()) {
                    scanner.nextFloat();
                    ++elemCounter;
                }
                if (counter == 0) {
                    counter = elemCounter;
                } else if (counter != elemCounter) {
                    System.out.println("Your matrix has mistakes");
                    System.exit(1);
                }
                ++lineCounter;
            }
            if (counter != lineCounter) {
                System.out.println("Your matrix has mistakes");
                System.exit(1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineCounter;
    }

    public static float getDeterminant(float[][] matrix) {
        float determinant = 0;
        for (int i = 0; i < 3; i++) {
            determinant = -(matrix[0][i]*getMinor(matrix, 0, i) + determinant);
        }
        return -determinant;
    }

    public static float getMinor(float[][] matrix, int a, int b) {
        float minor;
        int counter = 0;
        float[] minorMatrix = new float[4];
        for (int k = 0; k < 3; k++) {
            for (int j = 0; j < 3; j++) {
                if (k != a && j != b) {
                    minorMatrix[counter] = matrix[k][j];
                    counter++;
                }
            }
        }
        minor = minorMatrix[0]*minorMatrix[3] - minorMatrix[1]*minorMatrix[2];
        return minor;
    }

    public static float[][] getExtraMatrix(float[][] matrix) {
        float[][] extraMatrix = new float[3][3];
        int k = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                extraMatrix[j][i] = getMinor(matrix, i, j)*k;
                if (k == 1) {
                    k = -1;
                } else {
                    k = 1;
                }
            }
        }
        return extraMatrix;
    }

    public static float[][] invertMatrix(float[][] matrix) {
        float[][] invertMatrix = new float[3][3];
        float[][] extraMatrix = getExtraMatrix(matrix);
        float det = getDeterminant(matrix);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                invertMatrix[i][j] = extraMatrix[i][j]/det;
            }
        }
        return invertMatrix;
    }

    public static void printMatrix(float[][] matrix) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        if (args.length != 1) {
            System.out.println("Usage: Invert <matrix file>");
            System.exit(1);
        }
        File matrixFile = new File(System.getProperty("user.dir"), args[0]);
        if (!matrixFile.exists()) {
            System.out.println("Input file does not exists");
            System.exit(1);
        }
        float[][] matrix = copyMatrixToArray(matrixFile);
        if (getDeterminant(matrix) == 0) {
            System.out.println("Determinant equals 0, invert matrix does not exist");
            System.exit(0);
        }
        float[][] invertMatrix = invertMatrix(matrix);
        printMatrix(invertMatrix);
        System.exit(0);
    }
}