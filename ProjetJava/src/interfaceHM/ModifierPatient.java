package interfaceHM;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import metier.Patient;
import dao.DaoPatient;

//ModifierPatient permet d'afficher l'IHM de modification d'une patient (après l'avoir sélectionné dans la liste des patients de GererPatient.Java)

public class ModifierPatient extends JFrame implements ActionListener {


	private JPanel ContentPane;
	private JLabel lblNumeroPatient;
	private JLabel lblNomDuPatient;
	private JTextField txtNomPatient;
	private JLabel lblPrenomDuMdecin;
	private JTextField txtPrenomPatient;
	private JLabel lblAdresseDuMdecin;
	private JTextField txtAdresse;
	private JLabel lblCodePostal;
	private JTextField txtCodePostalPatient;
	private JLabel lblVilleDuMdecin;
	private JTextField txtVillePatient;
	private JLabel lblNewLabel;
	private JButton btnValider;
	private JButton btnAnnuler;
	private JLabel lblNumOrdre;
	private JLabel lblDateDeNaissance;
	private JTextField txtDateNaiss;
	
	// Créé la fenêtre et tout ses composants graphiques
	
	public ModifierPatient(Patient unPatient) {
		ContentPane = new JPanel();
		ContentPane.setBounds(100, 100, 769, 455);
		ContentPane.setLayout(null);
		
		lblNumeroPatient = new JLabel("Num\u00E9ro : ");
		lblNumeroPatient.setBounds(41, 87, 125, 14);
		ContentPane.add(lblNumeroPatient);
		
		lblNomDuPatient = new JLabel("Nom du patient : ");
		lblNomDuPatient.setBounds(41, 127, 125, 14);
		ContentPane.add(lblNomDuPatient);
		
		txtNomPatient = new JTextField(unPatient.getNomPatient());
		txtNomPatient.setBounds(218, 124, 86, 20);
		ContentPane.add(txtNomPatient);
		txtNomPatient.setColumns(10);
		
		lblPrenomDuMdecin = new JLabel("Prenom du patient : ");
		lblPrenomDuMdecin.setBounds(41, 164, 125, 14);
		ContentPane.add(lblPrenomDuMdecin);
		
		txtPrenomPatient = new JTextField(unPatient.getPrenomPatient());
		txtPrenomPatient.setBounds(218, 161, 86, 20);
		ContentPane.add(txtPrenomPatient);
		txtPrenomPatient.setColumns(10);
		
		lblAdresseDuMdecin = new JLabel("Adresse du patient : ");
		lblAdresseDuMdecin.setBounds(41, 204, 148, 14);
		ContentPane.add(lblAdresseDuMdecin);
		
		txtAdresse = new JTextField(unPatient.getAdressePatient());
		txtAdresse.setBounds(217, 201, 408, 20);
		ContentPane.add(txtAdresse);
		txtAdresse.setColumns(10);
		
		lblCodePostal = new JLabel("Code Postal : ");
		lblCodePostal.setBounds(41, 240, 114, 14);
		ContentPane.add(lblCodePostal);
		
		txtCodePostalPatient = new JTextField(unPatient.getCPPatient());
		txtCodePostalPatient.setBounds(218, 237, 86, 20);
		ContentPane.add(txtCodePostalPatient);
		txtCodePostalPatient.setColumns(10);
		
		lblVilleDuMdecin = new JLabel("Ville du patient : ");
		lblVilleDuMdecin.setBounds(41, 276, 125, 14);
		ContentPane.add(lblVilleDuMdecin);
		
		txtVillePatient = new JTextField(unPatient.getVillePatient());
		txtVillePatient.setBounds(218, 273, 86, 20);
		ContentPane.add(txtVillePatient);
		txtVillePatient.setColumns(10);
		
		lblNewLabel = new JLabel("Modifier un Patient");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblNewLabel.setBounds(202, 22, 341, 38);
		ContentPane.add(lblNewLabel);
		
		btnValider = new JButton("Valider");
		btnValider.addActionListener(this);
		btnValider.setBounds(577, 363, 91, 23);
		ContentPane.add(btnValider);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(this);
		btnAnnuler.setBounds(462, 363, 91, 23);
		ContentPane.add(btnAnnuler);
		
		lblNumOrdre = new JLabel(String.valueOf(unPatient.getNumPatient()));
		lblNumOrdre.setBounds(218, 87, 114, 14);
		ContentPane.add(lblNumOrdre);
		
		lblDateDeNaissance = new JLabel("Date de Naissance (aaaa/mm/jj) : ");
		lblDateDeNaissance.setBounds(41, 316, 164, 14);
		ContentPane.add(lblDateDeNaissance);
		
		// Create an instance of SimpleDateFormat used for formatting 
		// the string representation of date (year/Month/day)
		//DateFormat df = new SimpleDateFormat("yyyy/MM/dd");

		// Get the date today using Calendar object.
		//java.util.Date today = unPatient.getDateNaiss();        
		// Using DateFormat format method we can create a string 
		// representation of a date with the defined format.
		//String reportDate = df.format(today);

		// Print what date is today!
		//System.out.println("Report Date: " + reportDate);
		
		txtDateNaiss = new JTextField(unPatient.getDateNaiss());
		txtDateNaiss.setBounds(218, 313, 86, 20);
		ContentPane.add(txtDateNaiss);
		txtDateNaiss.setColumns(10);
		setContentPane(ContentPane);

	}
	
	// Permet l'interaction entre les composants graphiques et l'interface
	
	public void actionPerformed(ActionEvent evt) 
	{
		Patient unPatient = null;
		
		if (evt.getSource() == this.btnAnnuler)
		{
			dispose(); 
			FenetreMenu.contentPane.removeAll();
			GererPatients fGererPatient;
			fGererPatient = new GererPatients();
			FenetreMenu.contentPane.add(fGererPatient);
			fGererPatient.setVisible(true);
		}
		else
			if (evt.getSource() == this.btnValider)
			{
				System.out.println(this.txtDateNaiss.getText());
				if (this.txtNomPatient.getText().isEmpty() || this.txtPrenomPatient.getText().isEmpty()|| this.txtAdresse.getText().isEmpty()
						|| this.txtCodePostalPatient.getText().isEmpty()|| this.txtVillePatient.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Tous les champs sont obligatoires !");
				else
				{					
					String s = this.txtDateNaiss.getText();
				
					unPatient = new Patient (Integer.valueOf(this.lblNumOrdre.getText()),this.txtNomPatient.getText(),this.txtPrenomPatient.getText(),this.txtAdresse.getText(),
							this.txtCodePostalPatient.getText(), this.txtVillePatient.getText(), this.txtDateNaiss.getText());
					
					
					
					DaoPatient.ModifierUnPatient(unPatient);
					JOptionPane.showMessageDialog(null, "Patient modifié.");
				}
			}	
	}
}


