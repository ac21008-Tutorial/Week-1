import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;


public class ReceiptTotalGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textDailyTotal;
	private JTextField textTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceiptTotalGUI frame = new ReceiptTotalGUI();
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
	public ReceiptTotalGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 180, 130);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDailyTotal = new JLabel("Daily Total:");
		lblDailyTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDailyTotal.setBounds(0, 11, 64, 14);
		contentPane.add(lblDailyTotal);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setBounds(10, 39, 54, 14);
		contentPane.add(lblTotal);
		
		textDailyTotal = new JTextField();
		textDailyTotal.setBounds(71, 8, 86, 20);
		contentPane.add(textDailyTotal);
		textDailyTotal.setColumns(10);
		
		textTotal = new JTextField();
		textTotal.setBounds(71, 36, 86, 20);
		contentPane.add(textTotal);
		textTotal.setColumns(10);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(10, 64, 67, 23);
		contentPane.add(btnReset);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(93, 64, 67, 23);
		contentPane.add(btnClose);
	}
}
