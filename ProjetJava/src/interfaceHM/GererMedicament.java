package interfaceHM;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import metier.Medicament;
import metier.Pathologie;
import dao.DaoMedicament;
import dao.DaoPathologie;

//GererMedicament permet d'afficher et d'interagir avec l'interface de gestion des medicaments
//L'affichage des médicaments est réalisé avec une JTab (tableau)

public class GererMedicament extends JInternalFrame implements ActionListener{
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

// Lance l'application
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GererMedicament frame = new GererMedicament();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Créé la fenêtre et tout ses composants graphiques
	
	public GererMedicament() {
		setBounds(100, 100, 890, 503);

				getContentPane().setLayout(null);
				lblNewLabel = new JLabel("Gerer les Médicaments");
				lblNewLabel.setBounds(188, 11, 413, 197);
				lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 32));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				getContentPane().add(lblNewLabel);
				
				this.table = new JTable();
				this.table.setBounds(10, 11, 656, 135);
				
				//Creation d'un JScrollPane pour obtenir les titres du JTable
				this.scrollPane_1 = new JScrollPane(this.table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
			    	     ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
				scrollPane_1.setBounds(31, 156, 739, 219);
				
				getContentPane().add(this.scrollPane_1);
				
				btnModifier = new JButton("Modifier");
				btnModifier.setBounds(437, 399, 91, 23);
				btnModifier.addActionListener(this);
				getContentPane().add(btnModifier);
				
				btnAnnuler = new JButton("Annuler");
				btnAnnuler.setBounds(281, 399, 91, 23);
				btnAnnuler.addActionListener(this);
				getContentPane().add(btnAnnuler);
				
				//Met à jour le JTable
				updateTable();
				for(Medicament unMedicament : DaoMedicament.getLesMedocs())
				{
					GererMedicament.ajoutPatientTableau(unMedicament);
				}
				
				setRootPaneCheckingEnabled(false);
				javax.swing.plaf.InternalFrameUI ui	= this.getUI();
				((javax.swing.plaf.basic.BasicInternalFrameUI)ui).setNorthPane(null);
				this.setBorder(null);
			}
	
	// Permet de mettre à jour la liste des médicaments (JTab)
	
			private void updateTable() {
				
				String[] titre = {"Numéro du médicament",
		                "Nom",
		                "Description"};
				
				Object[][] listeMedecin = new Object[0][3];
				dtm = new DefaultTableModel(listeMedecin, titre){
					public boolean isCellEditable(int row, int col) {
						return false;
					};
				};
				table.setModel(dtm);
			}
			
			// Permet d'ajouter un nouveau médicament à la liste des médicaments (JTab)
			
			public static void ajoutPatientTableau(Medicament unMedicament)
			{
				/* ajout d'une nouvelle ligne au tableau des Médecins */
				dtm.addRow(new Object[]{unMedicament.getNumMedicament(),unMedicament.getNomMedicament(),unMedicament.getDescriptionMedicament()}); 
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
					Medicament unMedicament = new Medicament((Integer)table.getValueAt(ligne, 0),(String)table.getValueAt(ligne, 1),(String)table.getValueAt(ligne, 2));
					ModifierMedicament fModifierMedicament;
			    	fModifierMedicament = new ModifierMedicament(unMedicament);
			    	getContentPane().removeAll();
			    	fModifierMedicament.setVisible(true);
			    	getContentPane().add(fModifierMedicament);
				}				
		    }
	}


