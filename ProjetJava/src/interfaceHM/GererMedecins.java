package interfaceHM;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import metier.Medecin;
import dao.DaoMedecin;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//GererMedecins permet d'afficher et d'interagir avec l'interface de gestion des medecins
//L'affichage des medecins est réalisé avec une JTab (tableau)

public class GererMedecins extends JInternalFrame implements ActionListener {


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
	
	public GererMedecins() 
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
		for(Medecin unMedecin : DaoMedecin.getLesMedecins())
		{
			this.ajoutMedecinTableau(unMedecin);
		}
		
		setRootPaneCheckingEnabled(false);
		javax.swing.plaf.InternalFrameUI ui	= this.getUI();
		((javax.swing.plaf.basic.BasicInternalFrameUI)ui).setNorthPane(null);
		this.setBorder(null);setRootPaneCheckingEnabled(false);
		
	}
	
	// Permet de mettre à jour la liste des médecins (JTab)
	
	private void updateTable() {
		
		String[] titre = {"Numéro d'ordre",
                "Nom",
                "Prénom",
                "Adresse",
                "Code Postal",
                "Ville"};
		
		Object[][] listeMedecin = new Object[0][6];
		dtm = new DefaultTableModel(listeMedecin, titre){
			public boolean isCellEditable(int row, int col) {
				return false;
			};
		};
		table.setModel(dtm);
	}
	
	// Permet d'ajouter un nouveau médecin à la liste des médecins (JTab)
	
	public static void ajoutMedecinTableau(Medecin unMedecin)
	{
		/* ajout d'une nouvelle ligne au tableau des Médecins */
		dtm.addRow(new Object[]{unMedecin.getNumOrdreMedecin(),unMedecin.getNomMedecin(),
				unMedecin.getPrenomMedecin(),unMedecin.getAdresseMedecin(),unMedecin.getCPMedecin(),unMedecin.getVilleMedecin()}); 
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
			//int colonne = table.getSelectedColumn();//Si tu veut la colonne selectionnée
			//Object cellule = table.getValueAt(ligne,colonne);// si tu veux la valeur de ta cellule
			Medecin m = new Medecin((String)table.getValueAt(ligne, 0),(String)table.getValueAt(ligne, 1),(String)table.getValueAt(ligne, 2),
					(String)table.getValueAt(ligne, 3),(String)table.getValueAt(ligne, 4),(String)table.getValueAt(ligne, 5));
			getContentPane().removeAll();
			ModifierMedecin fModifierMedecin;
	    	fModifierMedecin = new ModifierMedecin(m);
	    	getContentPane().add(fModifierMedecin);
	    	fModifierMedecin.setVisible(true);
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

