import javax.swing.*;
import java.awt.*;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching its controller in its state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of its components.
 **/

public class CarView extends JFrame implements UpdateObserver {
    public static final int X = 800;
    public static final int Y = 800;
    private JPanel controlPanel;
    private JPanel drawPanel;


    // Constructor
    public CarView(String framename, JPanel controlPanel, JPanel drawPanel) {
        this.controlPanel = controlPanel;
        this.drawPanel = drawPanel;
        initComponents(framename);
    }

    // Sets everything in place and fits everything
    private void initComponents(String title) {

        //
        this.setTitle(title);
        this.setPreferredSize(new Dimension(X, Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);
        this.add(controlPanel);

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actOnTickUpdate(){
        drawPanel.repaint();
    }
}