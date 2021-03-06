package gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class RightPanel
{
	/**
	 * The right panel of the GUI
	 * @author Charandeep Rai
	 */
	// Frames used
	private static JFrame viewFrame;
	// Panels used
	private static JPanel openingPane;
	// Buttons used
	private static JButton createButton;
	private static JButton randomButton;

	public RightPanel()
	{
		initiate();		
	}
	public void initiate()
	
	{
		//set frame and panel
		viewFrame = new JFrame("Menu");
		openingPane = new JPanel();
		//set close
		viewFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		// setTitle
		viewFrame.setTitle("Menu");
		// Create Buttons
		createButton = new JButton();
		createButton.setText("Create");
		randomButton = new JButton();
		randomButton.setText("Random");
		// Set Layout
		openingPane.setLayout(new BoxLayout(openingPane, BoxLayout.Y_AXIS));
		openingPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		// add components to panel
		openingPane.add(createButton);
		openingPane.add(randomButton);
		// add panel to frame
		viewFrame.add(openingPane);
		// make visible
	
	
	createButton.addActionListener( new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
			
		}
		
	});
	
	randomButton.addActionListener( new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
			
		}
		
	});
	
	
	}
	public JPanel getContents()
	{
		return (JPanel)viewFrame.getContentPane();
	}
}