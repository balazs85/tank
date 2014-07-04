import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JTextField;


public class MainView {

	private JFrame frame;
	private JTextField textField;
	JComboBox<String> classComboBox;

	public void showWindow(){
		this.frame.setVisible(true);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{85, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblOsztly = new JLabel("Osztály");
		GridBagConstraints gbc_lblOsztly = new GridBagConstraints();
		gbc_lblOsztly.insets = new Insets(0, 0, 5, 5);
		gbc_lblOsztly.gridx = 0;
		gbc_lblOsztly.gridy = 0;
		frame.getContentPane().add(lblOsztly, gbc_lblOsztly);
		
		classComboBox = new JComboBox<String>();
		GridBagConstraints gbc_classComboBox = new GridBagConstraints();
		gbc_classComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_classComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_classComboBox.gridx = 1;
		gbc_classComboBox.gridy = 0;
		frame.getContentPane().add(classComboBox, gbc_classComboBox);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		frame.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
	}

}
