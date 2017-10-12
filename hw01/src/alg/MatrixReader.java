package alg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Lukas Forst
 * @date 10/10/17
 */
public class MatrixReader {

    private static int flipNumber(int number) {
        return number == 2 ? -2 : number;
    }

    public Triplet[][] read() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Pair<Integer, Integer> size = readSize(reader);
            int rows = size.getLeft();
            int columns = size.getRight();

            Triplet[][] data = new Triplet[rows][columns];

            for (int i = 0; i < rows; i++) {
                int[] lineNumbers = Arrays.stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .map(MatrixReader::flipNumber)
                        .toArray();
                for (int j = 0; j < columns; j++) {
                    int realValue = lineNumbers[j];
                    int computedValue = realValue;
                    int numberOfPositiveFields = realValue == 1 ? 1 : 0;
                    Triplet currentTriplet = new Triplet(realValue, computedValue, numberOfPositiveFields);

                    if (i - 1 >= 0 && j - 1 >= 0) {
                        currentTriplet.subtract(data[i - 1][j - 1]);
                        currentTriplet.add(data[i - 1][j]);
                        currentTriplet.add(data[i][j - 1]);

                    } else {
                        if (i - 1 >= 0) {
                            currentTriplet.add(data[i - 1][j]);
                        }

                        if (j - 1 >= 0) {
                            currentTriplet.add(data[i][j - 1]);
                        }
                    }
                    data[i][j] = currentTriplet;
                }
            }

            return data;
        } catch (Exception e) {
            Logger.getGlobal().log(Level.WARNING, e.toString());
            return new Triplet[0][0];
        }
    }

    private Pair<Integer, Integer> readSize(BufferedReader reader) throws IOException {
        String[] line = reader.readLine().split(" ");
        int rows = Integer.parseInt(line[0]);
        int columns = Integer.parseInt(line[1]);
        return new Pair<>(rows, columns);
    }
}
