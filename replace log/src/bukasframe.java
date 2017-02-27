import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.IOException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;  
import javax.swing.filechooser.*;

import javafx.stage.FileChooser;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;



public class bukasframe extends JFrame {

	private JPanel contentPane;
	static JTextField searchText;
	static JTextField replaceText;
	static JButton btnSelectFile;
	static JTextField textPath;

	/**
	 * Launch the application.
	 */
	
	//Create a file chooser
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				
				
				try {
					bukasframe frame = new bukasframe();
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
	public bukasframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setFocusCycleRoot(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		searchText = new JTextField();
		searchText.setBounds(10, 57, 86, 20);
		contentPane.add(searchText);
		searchText.setColumns(10);
		
		replaceText = new JTextField();
		replaceText.setBounds(10, 88, 86, 20);
		contentPane.add(replaceText);
		replaceText.setColumns(10);
		
		JButton btnSnR = new JButton("Search & Replace");
		btnSnR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					search2.main(null);

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  
	//			try {
	//				replace.main(null);
//
	//			} catch (IOException e1) {
	//				// TODO Auto-generated catch block
	//				e1.printStackTrace();
	//			} 
				
			//	if(replaceText.getText().length() != 0)
			//	try{
			//		replace.main(null);
			//	} catch (IOException e1) {
			//		e1.printStackTrace();
			//	}
				
			//	regexsearch.displayFind(searchText.getText().toString(), replace.content);
			//	regexsearch.main(null);
			//	regexsearch.displayFind();
			//	stream.main(null);
				
			}
		});
		btnSnR.setBounds(10, 119, 91, 23);
		contentPane.add(btnSnR);
		
		JTextPane textPane = new JTextPane();
		textPane.setFocusCycleRoot(false);
		textPane.setBounds(128, 57, 147, 205);
		contentPane.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setFocusCycleRoot(false);
		textPane_1.setBounds(285, 57, 147, 205);
		contentPane.add(textPane_1);
		
		btnSelectFile = new JButton("Select File");
		btnSelectFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			SelectFile.main();
			}
			
			
		});
		
		
		btnSelectFile.setBounds(10, 11, 91, 23);
		contentPane.add(btnSelectFile);
		
		textPath = new JTextField();
		textPath.setBounds(127, 12, 262, 22);
		contentPane.add(textPath);
		textPath.setColumns(10);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnSelectFile, searchText, replaceText, btnSnR, textPath, textPane, textPane_1}));
	}
	public JTextField getSearchText() {
		return searchText;
	}
	public JTextField getReplaceText() {
		return replaceText;
	}
}
