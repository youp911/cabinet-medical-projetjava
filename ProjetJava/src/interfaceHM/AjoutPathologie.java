package interfaceHM;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

import metier.Medecin;
import metier.Pathologie;
import dao.DaoMedecin;
import dao.DaoPathologie;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// AjouPathologie permet l'affichage de l'IHM d'ajout d'une pathologie

public class AjoutPathologie extends JInternalFrame implements ActionListener {
	private JLabel lblAjoutPath;
	private JLabel lblNumro;
	private JLabel lblLibell;
	private JTextField txtPath;
	private JTextField txtLib;
	private JButton btnValider;
	private JButton btnAnnuler;


// Lance l'application
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutPathologie frame = new AjoutPathologie();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
// Créé la fenêtre et tout ses composants graphiques
	
	public AjoutPathologie() {
		setBounds(100, 100, 661, 402);
		getContentPane().setLayout(null);
		
		lblAjoutPath = new JLabel("Ajout d'une Pathologie");
		lblAjoutPath.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAjoutPath.setBounds(186, 36, 213, 47);
		getContentPane().add(lblAjoutPath);
		
		//lblNumro = new JLabel("Num\u00E9ro : ");
		//lblNumro.setBounds(186, 128, 59, 14);
		//getContentPane().add(lblNumro);
		
		lblLibell = new JLabel("Libell\u00E9 : ");
		lblLibell.setBounds(188, 153, 46, 14);
		getContentPane().add(lblLibell);
		
		//txtPath = new JTextField();
		//txtPath.setBounds(313, 125, 86, 20);
		//getContentPane().add(txtPath);
		//txtPath.setColumns(10);
		
		txtLib = new JTextField();
		txtLib.setBounds(313, 150, 86, 20);
		getContentPane().add(txtLib);
		txtLib.setColumns(10);
		
		btnValider = new JButton("Valider");
		btnValider.addActionListener(this);
		btnValider.setBounds(310, 224, 89, 23);
		getContentPane().add(btnValider);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(this);
		btnAnnuler.setBounds(186, 224, 89, 23);
		getContentPane().add(btnAnnuler);

	}

	// Permet l'interaction entre les composants graphiques et l'interface
	
	public void actionPerformed(ActionEvent evt) 
	{
		if (evt.getSource() == this.btnAnnuler)
		{
			dispose(); 
		}
		else
			if (evt.getSource() == this.btnValider)
			{
				if (this.txtLib.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Tous les champs sont obligatoires !");
				else
				{
					Pathologie unePathologie;
					unePathologie= new Pathologie (null,this.txtLib.getText());
					DaoPathologie.AjouterUnePathologie(unePathologie);
					JOptionPane.showMessageDialog(null, "Pathologie ajoutée.");
					getContentPane().removeAll();
					GererPathologies fGererPathologie;
					fGererPathologie = new GererPathologies();
					getContentPane().add(fGererPathologie);
					fGererPathologie.setVisible(true);
				}
			}	
	}
}
