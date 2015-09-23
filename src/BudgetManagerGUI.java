import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JEditorPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class BudgetManagerGUI {

	private JFrame frame;
	private JTextField txtShop;
	private JTextField textDate;
	private JTextField textTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BudgetManagerGUI window = new BudgetManagerGUI();
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
	public BudgetManagerGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 470, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnManage = new JMenu("Manage");
		menuBar.add(mnManage);
		
		JMenuItem mntmTotal = new JMenuItem("Total");
		mnManage.add(mntmTotal);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmManual = new JMenuItem("Manual");
		mnHelp.add(mntmManual);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnHelp.add(mntmExit);
		frame.getContentPane().setLayout(null);
		
		JLabel lblShop = new JLabel("Shop:");
		lblShop.setHorizontalAlignment(SwingConstants.RIGHT);
		lblShop.setBounds(0, 14, 38, 14);
		frame.getContentPane().add(lblShop);
		
		txtShop = new JTextField();
		txtShop.setHorizontalAlignment(SwingConstants.LEFT);
		txtShop.setBounds(48, 11, 101, 20);
		frame.getContentPane().add(txtShop);
		txtShop.setColumns(10);
		
		textDate = new JTextField();
		textDate.setBounds(48, 39, 101, 20);
		frame.getContentPane().add(textDate);
		textDate.setColumns(10);
		
		JLabel lblName = new JLabel("Date:*");
		lblName.setBounds(10, 42, 37, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(10, 70, 46, 14);
		frame.getContentPane().add(lblTotal);
		
		textTotal = new JTextField();
		textTotal.setBounds(48, 67, 101, 20);
		frame.getContentPane().add(textTotal);
		textTotal.setColumns(10);
		
		JLabel lblNotes = new JLabel("Notes:");
		lblNotes.setBounds(10, 95, 46, 14);
		frame.getContentPane().add(lblNotes);
		
		JEditorPane editorNotes = new JEditorPane();
		editorNotes.setBounds(48, 95, 101, 134);
		frame.getContentPane().add(editorNotes);
		
		JLabel lbldateFormat = new JLabel("*Date has to be inputted in the DD/MM/YYYY format.");
		lbldateFormat.setBounds(159, 11, 470, 20);
		frame.getContentPane().add(lbldateFormat);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAdd.setBounds(165, 206, 83, 23);
		frame.getContentPane().add(btnAdd);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					ReceiptEditGUI edit = new ReceiptEditGUI();
					edit.setVisible(true);
					}
		});
		btnEdit.setBounds(267, 206, 78, 23);
		frame.getContentPane().add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setBounds(366, 206, 78, 23);
		frame.getContentPane().add(btnDelete);
	}
}
