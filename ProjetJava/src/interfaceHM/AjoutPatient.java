package interfaceHM;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

import metier.Medecin;
import metier.Patient;
import dao.DaoMedecin;
import dao.DaoPatient;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;

//AjouPatient permet l'affichage de l'IHM d'ajout d'une patient

public class AjoutPatient extends JInternalFrame implements ActionListener {
	private JLabel lblAjoutDunPatient;
	private JLabel lblNom;
	private JLabel lblAdresse;
	private JLabel lblCodePostal;
	private JLabel lblVille;
	private JLabel lblPrnom;
	private JLabel lblDateDeNaissance;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtAdresse;
	private JTextField txtCP;
	private JTextField txtVille;
	private JTextField txtDate;
	private JButton btnValider;
	private JButton btnAnnuler;
	private JLabel lblNumro;
	private JTextField txtNum;

// Lance l'application 
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutPatient frame = new AjoutPatient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Créé la fenêtre et tout ses composants graphiques
	
	public AjoutPatient() {
		setBounds(100, 100, 735, 433);
		getContentPane().setLayout(null);
		
		lblAjoutDunPatient = new JLabel("Ajout d'un Patient");
		lblAjoutDunPatient.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAjoutDunPatient.setBounds(257, 29, 211, 53);
		getContentPane().add(lblAjoutDunPatient);
		
		lblNom = new JLabel("Nom : ");
		lblNom.setBounds(221, 121, 46, 14);
		getContentPane().add(lblNom);
		
		lblAdresse = new JLabel("Adresse : ");
		lblAdresse.setBounds(221, 171, 65, 14);
		getContentPane().add(lblAdresse);
		
		lblCodePostal = new JLabel("Code Postal : ");
		lblCodePostal.setBounds(221, 196, 76, 14);
		getContentPane().add(lblCodePostal);
		
		lblVille = new JLabel("Ville :");
		lblVille.setBounds(221, 221, 46, 14);
		getContentPane().add(lblVille);
		
		lblPrnom = new JLabel("Pr\u00E9nom : ");
		lblPrnom.setBounds(221, 146, 46, 14);
		getContentPane().add(lblPrnom);
		
		lblDateDeNaissance = new JLabel("Date de Naissance : ");
		lblDateDeNaissance.setBounds(221, 246, 99, 14);
		getContentPane().add(lblDateDeNaissance);
		
		txtNom = new JTextField();
		txtNom.setBounds(358, 118, 86, 20);
		getContentPane().add(txtNom);
		txtNom.setColumns(10);
		
		txtPrenom = new JTextField();
		txtPrenom.setText("");
		txtPrenom.setBounds(358, 143, 86, 20);
		getContentPane().add(txtPrenom);
		txtPrenom.setColumns(10);
		
		txtAdresse = new JTextField();
		txtAdresse.setBounds(358, 168, 211, 20);
		getContentPane().add(txtAdresse);
		txtAdresse.setColumns(10);
		
		txtCP = new JTextField();
		txtCP.setBounds(358, 193, 86, 20);
		getContentPane().add(txtCP);
		txtCP.setColumns(10);
		
		txtVille = new JTextField();
		txtVille.setText("");
		txtVille.setBounds(358, 218, 86, 20);
		getContentPane().add(txtVille);
		txtVille.setColumns(10);
		
		txtDate = new JTextField();
		txtDate.setText("");
		txtDate.setBounds(358, 243, 86, 20);
		getContentPane().add(txtDate);
		txtDate.setColumns(10);
		
		btnValider = new JButton("Valider");
		btnValider.addActionListener(this);
		btnValider.setBounds(355, 302, 89, 23);
		getContentPane().add(btnValider);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(this);
		btnAnnuler.setBounds(221, 302, 89, 23);
		getContentPane().add(btnAnnuler);
		
		//lblNumro = new JLabel("Num\u00E9ro : ");
		//lblNumro.setBounds(221, 96, 76, 14);
		//getContentPane().add(lblNumro);
		
		//txtNum = new JTextField();
		//txtNum.setBounds(358, 93, 86, 20);
		//getContentPane().add(txtNum);
		//txtNum.setColumns(10);

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
				if (this.txtNom.getText().isEmpty() || this.txtPrenom.getText().isEmpty()|| this.txtAdresse.getText().isEmpty()|| this.txtCP.getText().isEmpty()|| this.txtVille.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Tous les champs sont obligatoires !");
				else
				{
					Patient unPatient;
					String s = this.txtDate.getText();
					//d = sdf.parse(s);
					unPatient = new Patient (null,this.txtNom.getText(),this.txtPrenom.getText(),this.txtAdresse.getText(),
							this.txtCP.getText(), this.txtVille.getText(), s);
					DaoPatient.AjouterUnPatient(unPatient);
					JOptionPane.showMessageDialog(null, "Patient ajoutée.");
				}
			}	
	}
}
