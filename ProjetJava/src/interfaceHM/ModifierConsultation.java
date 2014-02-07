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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import metier.Consultation;
import metier.Medecin;
import metier.Pathologie;
import metier.Patient;

import dao.DaoConsultation;
import dao.DaoMedecin;
import dao.DaoPathologie;
import dao.DaoPatient;

public class ModifierConsultation extends JInternalFrame implements ActionListener {
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
	private JLabel lblNumroDeLa_1;
	private JLabel lblNumero;
	private JButton btnGererLesOrdonnances;
	private Consultation uneConsultation;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifierConsultation frame = new ModifierConsultation(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param c 
	 */
	public ModifierConsultation(Consultation c) {
		// On renseigne l'attribut privé uneConsultation par
		// l'attribut passé en paramètre c pour pouvoir s'en 
		// servir dans la gestion d'événement
		uneConsultation = c;
		setBounds(0, 0, 852, 523);
		getContentPane().setLayout(null);
		
		
		lblAjoutDuneConsultation = new JLabel("Modification d'une Consultation");
		lblAjoutDuneConsultation.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAjoutDuneConsultation.setBounds(212, 28, 390, 85);
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
		
		txtDate = new JTextField(c.getDateConsultat());
		txtDate.setBounds(416, 392, 86, 20);
		getContentPane().add(txtDate);
		txtDate.setColumns(10);
		
		lblHeure = new JLabel("Heure : ");
		lblHeure.setBounds(238, 420, 46, 14);
		getContentPane().add(lblHeure);
		
		txtHeure = new JTextField(String.valueOf(c.getHeureConsultat()));
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
		
		lblNumroDeLa_1 = new JLabel("Num\u00E9ro de la consultation : ");
		lblNumroDeLa_1.setBounds(238, 116, 152, 14);
		getContentPane().add(lblNumroDeLa_1);
		
		lblNumero = new JLabel(String.valueOf(c.getNumConsultat()));
		lblNumero.setBounds(416, 116, 46, 14);
		getContentPane().add(lblNumero);
		
		btnGererLesOrdonnances = new JButton("Gerer les Ordonnances");
		btnGererLesOrdonnances.addActionListener(this);
		btnGererLesOrdonnances.setBounds(497, 460, 167, 23);
		getContentPane().add(btnGererLesOrdonnances);
		
		setRootPaneCheckingEnabled(false);
		javax.swing.plaf.InternalFrameUI ui	= this.getUI();
		((javax.swing.plaf.basic.BasicInternalFrameUI)ui).setNorthPane(null);
		this.setBorder(null);
		
	}

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
					//On créer la consulation avec 
					
					uneConsultation= new Consultation (uneConsultation.getNumConsultat(),(Pathologie)this.cbPathologie.getSelectedItem(),
							(Patient)this.cbPatient.getSelectedItem(),
							(Medecin)this.cbMedecin.getSelectedItem(),
							this.txtDate.getText(),
							Integer.valueOf(this.txtHeure.getText()));
					DaoConsultation.ModifierUneConsultation(uneConsultation);
				}
			}
		if(evt.getSource() == this.btnGererLesOrdonnances)
		{
			getContentPane().removeAll();
			GererLesOrdonnances fGererLesOrdonnances;
			fGererLesOrdonnances = new GererLesOrdonnances(uneConsultation);
			getContentPane().add(fGererLesOrdonnances);
			fGererLesOrdonnances.setVisible(true);
		}
	}
}
