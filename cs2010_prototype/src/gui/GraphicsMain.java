package gui;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import com.jogamp.opengl.util.FPSAnimator;
/**
 * The main window for the Biomorph Simulation.
 * @author Charandeep Rai
 */

public class GraphicsMain{

// The main frame used for the GUI
private static JFrame mainFrame;

// private FileMenu fileFrame;
public GraphicsMain()
{
	final JLabel tempRightLabel = new JLabel("Right Panel");
	final JLabel tempLeftLabel = new JLabel("Biomorph Window");
	final int blankSpace = 1;
	// Creating the main container for the GUI
	mainFrame = new JFrame("Group 5 Biomorph Simulation");
	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	//Importing the filemenu element
	FileMenu filemenu = new FileMenu();
	
	//Importing the Biomorph selection element
	//BiomorphSelector selector = new BiomorphSelector();
	
	//Importing the Biomorph display window
	//BiomorphWindows biowindow = new BiomorphWindows();
	
	//Importing the RightPanel
	RightPanel rp = new RightPanel();
	
	//setting up the biomorph window
	GLProfile glp = GLProfile.getDefault();
	GLCapabilities caps = new GLCapabilities(glp);
	GLCanvas canvas = new GLCanvas(caps);
	Panel bioWindow = new Panel();
	int width = 400;
	int height = 400;
	bioWindow.setPreferredSize(new Dimension(width, height));
	Float aspect = 0.0f;
	aspect = (float)width / (float)height;
	canvas.setPreferredSize(new Dimension(10,10));
	bioWindow.add(canvas);
	bioWindow.setVisible(true);
	
	canvas.addGLEventListener(new OpenGLFrame());
	FPSAnimator animator = new FPSAnimator(canvas, 60);
	animator.start();
	
	// Creating the other containers for the GUI
	//JButton button = new JButton();
	
	JPanel biomorphPanel = new JPanel();
	JPanel filemenuPanel = new JPanel();
	JPanel rightPanel = new JPanel();
	JPanel selectorPanel = new JPanel();
	
	// Specifying the layout managers
	mainFrame.setLayout(new BorderLayout());
	mainFrame.setPreferredSize(new Dimension(800,800));
	((JPanel) mainFrame.getContentPane()).setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
	
	biomorphPanel.setLayout(new BorderLayout());
	biomorphPanel.setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
	
	filemenuPanel.setLayout(new BorderLayout());
	filemenuPanel.setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
	
	rightPanel.setLayout(new BorderLayout());
	rightPanel.setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
	
	selectorPanel.setLayout(new BorderLayout());
	selectorPanel.setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
	
	// Add components to containers
	filemenuPanel.add(filemenu.getContents(), BorderLayout.CENTER);
	
	//selectorPanel.add(selector.getContents(), BorderLayout.CENTER);
	
	biomorphPanel.add(bioWindow);
	System.out.println(canvas.getSize());
	
	//rightPanel.add(rp.getContents(), BorderLayout.CENTER);
	
	mainFrame.add(filemenuPanel, BorderLayout.NORTH);
	//mainFrame.add(biomorphPanel,BorderLayout.WEST);
	mainFrame.add(rightPanel, BorderLayout.EAST);
	mainFrame.add(selectorPanel, BorderLayout.SOUTH);
	mainFrame.add(canvas);
	
	// Action Listeners
	mainFrame.addWindowListener(new WindowAdapter()
	{
		public void Closewindow(WindowEvent e)
		{
			exitApp();
		}
	});
	
	mainFrame.pack();
	mainFrame.setVisible(true);
}

private void exitApp()
{
	int response = JOptionPane.showConfirmDialog(mainFrame, "Are you sure that you want to quit?", "Quit?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
	if (response == JOptionPane.YES_OPTION)
	{
		System.exit(0);
	}
}

public static void main(String[] args)
{
	GraphicsMain gm = new GraphicsMain();
}

}