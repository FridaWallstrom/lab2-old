import javax.swing.*;
import java.awt.*;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching its controller in its state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of its components.
 **/

public class CarView extends JFrame {
    private static final int X = 800;
    private static final int Y = 800;

    ControlPanel controlPanel = new ControlPanel(X,Y);

    DrawPanel drawPanel = new DrawPanel(X, Y - 240);

    // Constructor
    public CarView(String framename) {
        initComponents(framename);
    }

    // Sets everything in place and fits everything
    private void initComponents(String title) {

        //
        this.setTitle(title);
        this.setPreferredSize(new Dimension(X, Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);
        controlPanel.initComponents();
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

    @Override
    public void repaint() {
        drawPanel.repaint();
    }
}