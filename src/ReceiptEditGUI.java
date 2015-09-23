import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.*;
import javax.swing.JTextArea;


public class ReceiptEditGUI extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceiptEditGUI frame = new ReceiptEditGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReceiptEditGUI() {
		setBounds(100, 100, 280, 420);
		getContentPane().setLayout(null);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(10, 11, 32, 14);
		getContentPane().add(lblDate);
		
		textField = new JTextField();
		textField.setBounds(52, 8, 127, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFind.setBounds(189, 7, 65, 23);
		getContentPane().add(btnFind);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 36, 244, 277);
		getContentPane().add(textArea);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(10, 324, 32, 14);
		getContentPane().add(lblId);
		
		textField_1 = new JTextField();
		textField_1.setBounds(30, 321, 149, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(189, 320, 65, 23);
		getContentPane().add(btnEdit);
		
		JButton btnDisplayNotes = new JButton("Display Notes");
		btnDisplayNotes.setBounds(10, 352, 244, 23);
		getContentPane().add(btnDisplayNotes);

	}
}
