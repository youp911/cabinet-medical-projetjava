package interfaceHM;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Accueil extends JInternalFrame {
	private JLabel lblImage;
	private JLabel lblImage2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accueil frame = new Accueil();
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
	public Accueil() {
		setBounds(100, 100, 852, 523);
		getContentPane().setLayout(null);
		
		lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon(Accueil.class.getResource("/image/Sacred_Heart_Hospital.png")));
		lblImage.setBounds(582, 11, 231, 234);
		getContentPane().add(lblImage);
		
		lblImage2 = new JLabel("");
		lblImage2.setBounds(189, 174, 46, 14);
		getContentPane().add(lblImage2);
		
		
		
	}
}
