package interfaceHM;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import metier.Patient;
import dao.DaoPatient;

//GererPatients permet d'afficher et d'interagir avec l'interface de gestion des patients
//L'affichage des patients est réalisé avec une JTab (tableau)

public class GererPatients extends JInternalFrame implements ActionListener {

	private JTable lstMedecin;
	private Object[][] lignes;
	private JPanel panel;
	private JButton btnValider;
	private JLabel lblNewLabel;
	private static JTable table;
	private JTable table_1;
	private JScrollPane scrollPane_1;
	private static DefaultTableModel dtm;
	private JButton btnSupprimer;
	private JButton btnModifier;
	private JButton btnAnnuler;

	// Créé la fenêtre et tout ses composants graphiques
	
	public GererPatients() 
	{
		
		setBounds(100, 100, 852, 523);
		getContentPane().setLayout(null);
		lblNewLabel = new JLabel("Gerer les M\u00E9decins");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(188, 11, 413, 197);
		getContentPane().add(lblNewLabel);
		
		this.table = new JTable();
		this.table.setBounds(10, 11, 656, 135);
		
		//Creation d'un JScrollPane pour obtenir les titres du JTable
		this.scrollPane_1 = new JScrollPane(this.table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
	    	     ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.scrollPane_1.setBounds(31, 156, 739, 219);
		
		getContentPane().add(this.scrollPane_1);
		
		//btnSupprimer = new JButton("Supprimer");
		//btnSupprimer.addActionListener(this);
		//btnSupprimer.setBounds(418, 421, 101, 23);
		//getContentPane().add(btnSupprimer);
		
		btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(this);
		btnModifier.setBounds(317, 421, 91, 23);
		getContentPane().add(btnModifier);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(this);
		btnAnnuler.setBounds(216, 421, 91, 23);
		getContentPane().add(btnAnnuler);
		
		//Met à jour le JTable
		updateTable();
		for(Patient unPatient : DaoPatient.getLesPatients())
		{
			this.ajoutPatientTableau(unPatient);
		}
	}
	
	// Permet de mettre à jour la liste des patients (JTab)
	
	private void updateTable() {
		
		String[] titre = {"Numéro du Patient",
                "Nom",
                "Prénom",
                "Adresse",
                "Code Postal",
                "Ville",
                "Date de Naissance"};
		
		Object[][] listeMedecin = new Object[0][7];
		dtm = new DefaultTableModel(listeMedecin, titre){
			public boolean isCellEditable(int row, int col) {
				return false;
			};
		};
		table.setModel(dtm);
	}
	
	// Permet d'ajouter un nouveau patient à la liste des patients (JTab)
	
	public static void ajoutPatientTableau(Patient unPatient)
	{
		/* ajout d'une nouvelle ligne au tableau des Médecins */
		dtm.addRow(new Object[]{unPatient.getNumPatient(),unPatient.getNomPatient(),unPatient.getPrenomPatient(),unPatient.getAdressePatient(),
				unPatient.getCPPatient(),unPatient.getVillePatient(),unPatient.getDateNaiss()}); 
		table.setModel(dtm);
	}
	
	// Permet l'interaction entre les composants graphiques et l'interface
	
	public void actionPerformed(ActionEvent evt) 
	{
		if (evt.getSource() == this.btnAnnuler)
		{
			dispose(); 
		}
		if ( evt.getSource() == this.btnModifier)
		{
			int ligne = table.getSelectedRow();//Si tu veut la ligne selectionnée
			Patient unPatient = new Patient((Integer)table.getValueAt(ligne, 0),(String)table.getValueAt(ligne, 1),(String)table.getValueAt(ligne, 2),
					(String)table.getValueAt(ligne, 3),(String)table.getValueAt(ligne, 4),(String)table.getValueAt(ligne, 5),(String)table.getValueAt(ligne, 6));
			getContentPane().removeAll();
			ModifierPatient fModifierPatient;
	    	fModifierPatient = new ModifierPatient(unPatient);
	    	fModifierPatient.setBounds(100, 100, 852, 523);
	    	fModifierPatient.setVisible(true);
		}
		//if ( evt.getSource() == this.btnSupprimer)
		//{
		//	int ligne = table.getSelectedRow();//Si tu veut la ligne selectionnée
		//	Medecin m = new Medecin((String)table.getValueAt(ligne, 0),(String)table.getValueAt(ligne, 1),(String)table.getValueAt(ligne, 2),
		//			(String)table.getValueAt(ligne, 3),(String)table.getValueAt(ligne, 4),(String)table.getValueAt(ligne, 5));
		//	getContentPane().removeAll();
		//	DaoMedecin.SupprimerUnMedecin(m);
		//}
			
    }
}
