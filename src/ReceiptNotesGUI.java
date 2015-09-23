import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;


public class ReceiptNotesGUI extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceiptNotesGUI frame = new ReceiptNotesGUI();
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
	public ReceiptNotesGUI() {
		setBounds(100, 100, 180, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNotes = new JLabel("Notes:");
		lblNotes.setBounds(10, 11, 46, 14);
		getContentPane().add(lblNotes);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(47, 236, 70, 23);
		getContentPane().add(btnClose);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 30, 144, 195);
		getContentPane().add(textArea);

	}

}
