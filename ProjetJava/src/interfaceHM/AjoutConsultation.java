package interfaceHM;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import metier.*;
import dao.*;

// AjoutConsultation permet d'afficher l'interface d'ajout de consultation

public class AjoutConsultation extends JInternalFrame implements ActionListener {
	private JLabel lblAjoutDuneConsultation;
	private JLabel lblVeulliezChoisirUn;
	private JComboBox cbMedecin;
	private JLabel lblVeulliezChoisirUn_1;
	private JComboBox cbPatient;
	private JLabel lblNumroDeLa;
	private JTextField txtNum;
	private JLabel lblVeulliezChoisirUne;
	private JComboBox cbPathologie;
	private JLabel lblDate;
	private JTextField txtDate;
	private JLabel lblHeure;
	private JTextField txtHeure;
	private JButton btnAnnuler;
	private JButton btnValider;

// Lance l'application
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutConsultation frame = new AjoutConsultation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


// Créé la fenêtre avec tout ses composants graphiques
	
	@SuppressWarnings("unchecked")
	public AjoutConsultation() {
		setBounds(100, 100, 828, 572);
		getContentPane().setLayout(null);
		
		lblAjoutDuneConsultation = new JLabel("Ajout d'une Consultation");
		lblAjoutDuneConsultation.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAjoutDuneConsultation.setBounds(257, 29, 245, 85);
		getContentPane().add(lblAjoutDuneConsultation);
		
		lblVeulliezChoisirUn = new JLabel("Veulliez choisir un Medecin : ");
		lblVeulliezChoisirUn.setBounds(238, 141, 202, 14);
		getContentPane().add(lblVeulliezChoisirUn);
		
		cbMedecin = new JComboBox(DaoMedecin.getLesMedecins());
		cbMedecin.setBounds(153, 166, 520, 39);
		getContentPane().add(cbMedecin);
		
		lblVeulliezChoisirUn_1 = new JLabel("Veulliez choisir un Patient : ");
		lblVeulliezChoisirUn_1.setBounds(238, 226, 202, 14);
		getContentPane().add(lblVeulliezChoisirUn_1);
		
		cbPatient = new JComboBox(DaoPatient.getLesPatients());
		cbPatient.setBounds(153, 251, 494, 39);
		getContentPane().add(cbPatient);
		
		lblVeulliezChoisirUne = new JLabel("Veulliez choisir une Pathologie : ");
		lblVeulliezChoisirUne.setBounds(238, 308, 202, 14);
		getContentPane().add(lblVeulliezChoisirUne);
		
		cbPathologie = new JComboBox(DaoPathologie.getLesPathologies());
		cbPathologie.setBounds(153, 333, 494, 39);
		getContentPane().add(cbPathologie);
		
		lblDate = new JLabel("Date : ");
		lblDate.setBounds(238, 395, 46, 14);
		getContentPane().add(lblDate);
		
		txtDate = new JTextField();
		txtDate.setBounds(416, 392, 86, 20);
		getContentPane().add(txtDate);
		txtDate.setColumns(10);
		
		lblHeure = new JLabel("Heure : ");
		lblHeure.setBounds(238, 420, 46, 14);
		getContentPane().add(lblHeure);
		
		txtHeure = new JTextField();
		txtHeure.setBounds(416, 414, 86, 20);
		getContentPane().add(txtHeure);
		txtHeure.setColumns(10);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(this);
		btnAnnuler.setBounds(257, 460, 91, 23);
		getContentPane().add(btnAnnuler);
		
		btnValider = new JButton("Valider");
		btnValider.addActionListener(this);
		btnValider.setBounds(381, 460, 91, 23);
		getContentPane().add(btnValider);

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
				if (this.txtDate.getText().isEmpty()||this.txtHeure.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Tous les champs sont obligatoires !");
				else
				{
					getContentPane().removeAll();
					Consultation uneConsultation;
					uneConsultation= new Consultation (null,(Pathologie)this.cbPathologie.getSelectedItem(),
							(Patient)this.cbPatient.getSelectedItem(),
							(Medecin)this.cbMedecin.getSelectedItem(),
							this.txtDate.getText(),
							Integer.valueOf(this.txtHeure.getText()));
					DaoConsultation.AjouterUneConsultation(uneConsultation);
					getContentPane().removeAll();
					AjoutOrdonnance fAjoutOrdonnance;
					fAjoutOrdonnance = new AjoutOrdonnance(uneConsultation);
					getContentPane().add(fAjoutOrdonnance);
					fAjoutOrdonnance.setVisible(true);
					
				}
			}	
	}
}

