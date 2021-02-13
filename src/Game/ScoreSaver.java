package Game;

import java.io.*;

public class ScoreSaver {

    private static final String FILE = "classpath:score.txt";
    private int currentScore;
    private int highScore;

    public ScoreSaver(int currentScore) {
        this.currentScore = currentScore;
        readHighScore();
    }

    private void readHighScore() {
        try {
        FileReader reader = new FileReader(FILE);
        BufferedReader bReader = new BufferedReader(reader);
        highScore = Integer.parseInt(bReader.readLine());
        bReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (highScore >= currentScore) {
                return;
            } else if (highScore < currentScore) {
                writeNewScore();
            }
        }
    }

    private void writeNewScore(){

        try {
        FileWriter writer = new FileWriter(FILE);
        BufferedWriter bWriter = new BufferedWriter(writer);
        bWriter.write(String.valueOf(currentScore));
        bWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getHighScore(){
        return highScore;
    }

}
