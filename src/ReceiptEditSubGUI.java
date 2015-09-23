import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JEditorPane;
import javax.swing.JButton;


public class ReceiptEditSubGUI extends JInternalFrame {
	private JTextField textShop;
	private JTextField textDate;
	private JTextField textTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceiptEditSubGUI frame = new ReceiptEditSubGUI();
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
	public ReceiptEditSubGUI() {
		setBounds(100, 100, 180, 300);
		getContentPane().setLayout(null);
		
		JLabel lblShop = new JLabel("Shop:");
		lblShop.setHorizontalAlignment(SwingConstants.RIGHT);
		lblShop.setBounds(4, 14, 34, 14);
		getContentPane().add(lblShop);
		
		textShop = new JTextField();
		textShop.setHorizontalAlignment(SwingConstants.LEFT);
		textShop.setColumns(10);
		textShop.setBounds(48, 11, 101, 20);
		getContentPane().add(textShop);
		
		textDate = new JTextField();
		textDate.setColumns(10);
		textDate.setBounds(48, 39, 101, 20);
		getContentPane().add(textDate);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(10, 42, 37, 14);
		getContentPane().add(lblDate);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(10, 70, 46, 14);
		getContentPane().add(lblTotal);
		
		textTotal = new JTextField();
		textTotal.setColumns(10);
		textTotal.setBounds(48, 67, 101, 20);
		getContentPane().add(textTotal);
		
		JLabel lblNotes = new JLabel("Notes:");
		lblNotes.setBounds(10, 96, 46, 14);
		getContentPane().add(lblNotes);
		
		JEditorPane editorNotes = new JEditorPane();
		editorNotes.setBounds(48, 95, 101, 134);
		getContentPane().add(editorNotes);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(4, 240, 75, 23);
		getContentPane().add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(89, 240, 70, 23);
		getContentPane().add(btnCancel);

	}

}
