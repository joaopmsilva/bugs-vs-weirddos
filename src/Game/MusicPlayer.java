package Game;
import sun.audio.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class MusicPlayer {
    public class Project1
    {
        public static void main(String[] args)
        {
            JFrame frame = new JFrame();
            frame.setSize(200,200);
            frame.setLocationRelativeTo(null);
            JButton button = new JButton("Click me");
            frame.add(button);
            button.addActionListener(new AL());
            frame.setVisible(true);
        }
        public static class AL implements ActionListener{
            public final void actionPerformed(ActionEvent e){
                music();
            }
        }
        public static void music()
        {
            AudioPlayer MGP = AudioPlayer.player;
            AudioStream BGM;
            AudioData MD;
            ContinuousAudioDataStream loop = null;
            try
            {
                InputStream test = new FileInputStream("C:\\Music1.wmv");
                BGM = new AudioStream(test);

}
