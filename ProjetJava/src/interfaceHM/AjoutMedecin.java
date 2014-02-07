package interfaceHM;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import metier.Medecin;
import dao.DaoMedecin;

//AjoutMedecin permet l'affichage de l'IHM d'ajout d'un médecin

public class AjoutMedecin extends JInternalFrame implements ActionListener {
	private JLabel lblNumeroDordre;
	private JTextField txtNumOrdre;
	private JLabel lblNomDuMdecin;
	private JTextField txtNomMedecin;
	private JLabel lblPrenomDuMdecin;
	private JTextField txtPrenomMedecin;
	private JLabel lblAdresseDuMdecin;
	private JTextField txtAdresse;
	private JLabel lblCodePostal;
	private JTextField txtCodePostalMedecin;
	private JLabel lblVilleDuMdecin;
	private JTextField txtVilleMedecin;
	private JLabel lblNewLabel;
	private JButton btnValider;
	private JButton btnAnnuler;


// Créé la fenêtre et ses composants graphiques
	
	public AjoutMedecin() {
		setBounds(100, 100, 769, 440);
		getContentPane().setLayout(null);
		
		lblNumeroDordre = new JLabel("Num\u00E9ro d'ordre : ");
		lblNumeroDordre.setBounds(41, 87, 125, 14);
		getContentPane().add(lblNumeroDordre);
		
		txtNumOrdre = new JTextField();
		txtNumOrdre.setBounds(187, 84, 86, 20);
		getContentPane().add(txtNumOrdre);
		txtNumOrdre.setColumns(10);
		
		lblNomDuMdecin = new JLabel("Nom du m\u00E9decin : ");
		lblNomDuMdecin.setBounds(41, 127, 125, 14);
		getContentPane().add(lblNomDuMdecin);
		
		txtNomMedecin = new JTextField();
		txtNomMedecin.setBounds(187, 124, 86, 20);
		getContentPane().add(txtNomMedecin);
		txtNomMedecin.setColumns(10);
		
		lblPrenomDuMdecin = new JLabel("Prenom du m\u00E9decin : ");
		lblPrenomDuMdecin.setBounds(41, 164, 125, 14);
		getContentPane().add(lblPrenomDuMdecin);
		
		txtPrenomMedecin = new JTextField();
		txtPrenomMedecin.setBounds(187, 161, 86, 20);
		getContentPane().add(txtPrenomMedecin);
		txtPrenomMedecin.setColumns(10);
		
		lblAdresseDuMdecin = new JLabel("Adresse du m\u00E9decin : ");
		lblAdresseDuMdecin.setBounds(41, 204, 148, 14);
		getContentPane().add(lblAdresseDuMdecin);
		
		txtAdresse = new JTextField();
		txtAdresse.setBounds(187, 201, 408, 20);
		getContentPane().add(txtAdresse);
		txtAdresse.setColumns(10);
		
		lblCodePostal = new JLabel("Code Postal : ");
		lblCodePostal.setBounds(41, 240, 114, 14);
		getContentPane().add(lblCodePostal);
		
		txtCodePostalMedecin = new JTextField();
		txtCodePostalMedecin.setBounds(187, 237, 86, 20);
		getContentPane().add(txtCodePostalMedecin);
		txtCodePostalMedecin.setColumns(10);
		
		lblVilleDuMdecin = new JLabel("Ville du m\u00E9decin : ");
		lblVilleDuMdecin.setBounds(41, 276, 125, 14);
		getContentPane().add(lblVilleDuMdecin);
		
		txtVilleMedecin = new JTextField();
		txtVilleMedecin.setBounds(187, 273, 86, 20);
		getContentPane().add(txtVilleMedecin);
		txtVilleMedecin.setColumns(10);
		
		lblNewLabel = new JLabel("Ajout d'un M\u00E9decin");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblNewLabel.setBounds(202, 22, 341, 38);
		getContentPane().add(lblNewLabel);
		
		btnValider = new JButton("Valider");
		btnValider.addActionListener(this);
		btnValider.setBounds(577, 342, 91, 23);
		getContentPane().add(btnValider);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(this);
		btnAnnuler.setBounds(462, 342, 91, 23);
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
				if (this.txtNumOrdre.getText().isEmpty() || this.txtNomMedecin.getText().isEmpty() || this.txtPrenomMedecin.getText().isEmpty()|| this.txtAdresse.getText().isEmpty()|| this.txtCodePostalMedecin.getText().isEmpty()|| this.txtVilleMedecin.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Tous les champs sont obligatoires !");
				else
				{
					getContentPane().removeAll();
					Medecin unMedecin;
					unMedecin= new Medecin (this.txtNumOrdre.getText(),this.txtNomMedecin.getText(),this.txtPrenomMedecin.getText(),this.txtAdresse.getText(),this.txtCodePostalMedecin.getText(), this.txtVilleMedecin.getText());
					DaoMedecin.AjouterUnMedecin(unMedecin);
					JOptionPane.showMessageDialog(null, "Medecin ajoutée.");
				}
			}	
	}
}
