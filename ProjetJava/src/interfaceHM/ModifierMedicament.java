package interfaceHM;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

import dao.DaoMedecin;
import dao.DaoMedicament;

import metier.Medecin;
import metier.Medicament;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.nio.charset.UnmappableCharacterException;

//ModifierMedicament permet d'afficher l'IHM de modification d'un médicament (après l'avoir sélectionné dans la liste des médicament( de GererMédicament.Java)

public class ModifierMedicament extends JInternalFrame implements ActionListener {
	
	private JLabel lblModifierUnMdicament;
	private JLabel lblNumro;
	private JLabel lblNom;
	private JLabel lblDescription;
	private JLabel lblModNum;
	private JTextField txtNom;
	private JTextField txtDescription;
	private JButton btnAnnuler;
	private JButton btnValider;

	// Créé la fenêtre et tout ses composants graphiques
	
	public ModifierMedicament(Medicament unMedicament) {
		setBounds(100, 100, 845, 571);
		getContentPane().setLayout(null);
		
		lblModifierUnMdicament = new JLabel("Modifier un M\u00E9dicament");
		lblModifierUnMdicament.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblModifierUnMdicament.setBounds(287, 30, 232, 109);
		getContentPane().add(lblModifierUnMdicament);
		
		lblNumro = new JLabel("Num\u00E9ro : ");
		lblNumro.setBounds(287, 147, 59, 14);
		getContentPane().add(lblNumro);
		
		lblNom = new JLabel("Nom");
		lblNom.setBounds(287, 189, 46, 14);
		getContentPane().add(lblNom);
		
		lblDescription = new JLabel("Description :");
		lblDescription.setBounds(287, 237, 69, 14);
		getContentPane().add(lblDescription);
		
		lblModNum = new JLabel(String.valueOf(unMedicament.getNumMedicament()));
		lblModNum.setBounds(401, 150, 46, 14);
		getContentPane().add(lblModNum);
		
		txtNom = new JTextField(unMedicament.getNomMedicament());
		txtNom.setBounds(401, 186, 86, 20);
		getContentPane().add(txtNom);
		txtNom.setColumns(10);
		
		txtDescription = new JTextField(unMedicament.getDescriptionMedicament());
		txtDescription.setBounds(401, 234, 261, 109);
		getContentPane().add(txtDescription);
		txtDescription.setColumns(10);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(this);
		btnAnnuler.setBounds(287, 390, 91, 23);
		getContentPane().add(btnAnnuler);
		
		btnValider = new JButton("Valider");
		btnValider.addActionListener(this);
		btnValider.setBounds(428, 390, 91, 23);
		getContentPane().add(btnValider);

	}
	
	// Permet l'interaction entre les composants graphiques et l'interface

	public void actionPerformed(ActionEvent evt)
	{
		if (evt.getSource() == this.btnAnnuler)
		{
			
	    	dispose(); 
			FenetreMenu.contentPane.removeAll();
			GererMedicament fGererMedicament;
	    	fGererMedicament = new GererMedicament();
	    	FenetreMenu.contentPane.add(fGererMedicament);
	    	fGererMedicament.setVisible(true);
		}
		else
			if (evt.getSource() == this.btnValider)
			{
				if (this.txtDescription.getText().isEmpty() || this.txtNom.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Tous les champs sont obligatoires !");
				else
				{
					Medicament unMedicament;
					unMedicament= new Medicament (Integer.valueOf(this.lblModNum.getText()),this.txtNom.getText(),this.txtDescription.getText());
					DaoMedicament.ModifierUnMedicament(unMedicament);
					JOptionPane.showMessageDialog(null, "Medecin modifié.");
				}
			}	
	}
}
