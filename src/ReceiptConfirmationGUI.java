import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class ReceiptConfirmationGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReceiptConfirmationGUI dialog = new ReceiptConfirmationGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReceiptConfirmationGUI() {
		setBounds(100, 100, 290, 110);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 229);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblAreYouSure = new JLabel("Are you sure you want to delete this receipt?");
		lblAreYouSure.setHorizontalAlignment(SwingConstants.CENTER);
		lblAreYouSure.setBounds(0, 11, 276, 14);
		contentPanel.add(lblAreYouSure);
		
		JButton btnYes = new JButton("Yes");
		btnYes.setBounds(10, 36, 89, 23);
		contentPanel.add(btnYes);
		
		JButton btnNo = new JButton("No");
		btnNo.setBounds(175, 36, 89, 23);
		contentPanel.add(btnNo);
	}
}
