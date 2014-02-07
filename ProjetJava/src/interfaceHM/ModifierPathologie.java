package interfaceHM;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.DaoMedecin;
import dao.DaoPathologie;

import metier.Medecin;
import metier.Pathologie;

//ModifierPathologie permet d'afficher l'IHM de modification d'une pathologie (après l'avoir sélectionné dans la liste des pathologie de GererPathologies.Java)

public class ModifierPathologie extends JInternalFrame implements ActionListener {
	
	private JLabel lblNewLabel;
	private JLabel lblNumro;
	private JLabel lblModNum;
	private JLabel lblLibell;
	private JTextField txtLibelle;
	private JButton btnValider;
	private JButton btnAnnuler;

	// Créé la fenêtre et tout ses composants graphiques
	
	public ModifierPathologie(Pathologie unePathologie) {
		setBounds(100, 100, 768, 388);
		getContentPane().setLayout(null);
		System.out.println("ojk");
		lblNewLabel = new JLabel("Modifier une Pathologie");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(276, 34, 222, 62);
		getContentPane().add(lblNewLabel);
		
		lblNumro = new JLabel("Num\u00E9ro : ");
		lblNumro.setBounds(276, 132, 74, 14);
		getContentPane().add(lblNumro);
		
		lblModNum = new JLabel(String.valueOf(unePathologie.getNumPathologie()));
		lblModNum.setBounds(412, 132, 86, 14);
		getContentPane().add(lblModNum);
		
		lblLibell = new JLabel("Libell\u00E9 : ");
		lblLibell.setBounds(276, 181, 46, 14);
		getContentPane().add(lblLibell);
		
		txtLibelle = new JTextField(unePathologie.getLibellePathologie());
		txtLibelle.setBounds(412, 178, 86, 20);
		getContentPane().add(txtLibelle);
		txtLibelle.setColumns(10);
		
		btnValider = new JButton("Valider");
		btnValider.addActionListener(this);
		btnValider.setBounds(407, 241, 91, 23);
		getContentPane().add(btnValider);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(this);
		btnAnnuler.setBounds(276, 241, 91, 23);
		getContentPane().add(btnAnnuler);

	}
	
	// Permet l'interaction entre les composants graphiques et l'interface
	
	public void actionPerformed(ActionEvent evt) 
	{
		if (evt.getSource() == this.btnAnnuler)
		{
			dispose(); 
			FenetreMenu.contentPane.removeAll();
			GererMedecins fGererMedecin;
	    	fGererMedecin = new GererMedecins();
	    	FenetreMenu.contentPane.add(fGererMedecin);
	    	fGererMedecin.setVisible(true);
		}
		if ( evt.getSource() == this.btnValider)
		{
			if (this.txtLibelle.getText().isEmpty())
				JOptionPane.showMessageDialog(null, "Tous les champs sont obligatoires !");
			else
			{
				Pathologie unePathologie;
				unePathologie = new Pathologie(Integer.valueOf(this.lblModNum.getText()),this.txtLibelle.getText());
				DaoPathologie.ModifierUnePathologie(unePathologie);
				JOptionPane.showMessageDialog(null, "Pathologie modifié.");
				
			}
		}
	}
}
