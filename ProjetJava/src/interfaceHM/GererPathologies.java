package interfaceHM;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.ScrollPane;
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

import org.w3c.dom.events.EventException;

import metier.Pathologie;
import metier.Patient;
import dao.DaoPathologie;
import dao.DaoPatient;

//GererPathologies permet d'afficher et d'interagir avec l'interface de gestion des pathologies
//L'affichage des pathologies est réalisé avec une JTab (tableau)

public class GererPathologies extends JInternalFrame implements ActionListener {
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
					GererPathologies frame = new GererPathologies();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Créé la fenêtre et tout ses composants graphiques
	
	public GererPathologies() {
		
			setBounds(100, 100, 852, 523);
			getContentPane().setLayout(null);
			lblNewLabel = new JLabel("Gerer les Pathologies");
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
			for(Pathologie unePathologie : DaoPathologie.getLesPathologies())
			{
				GererPathologies.ajoutPatientTableau(unePathologie);
			}
		}
		
	// Permet de mettre à jour la liste des pathologies (JTab)
	
		private void updateTable() {
			
			String[] titre = {"Numéro de la Pathologie",
	                "Libelle"};
			
			Object[][] listeMedecin = new Object[0][2];
			dtm = new DefaultTableModel(listeMedecin, titre){
				public boolean isCellEditable(int row, int col) {
					return false;
				};
			};
			table.setModel(dtm);
		}
		
		
		// Permet d'ajouter un nouveau médecin à la liste des médecins(JTab)
		
		public static void ajoutPatientTableau(Pathologie unePathologie)
		{
			/* ajout d'une nouvelle ligne au tableau des Médecins */
			dtm.addRow(new Object[]{unePathologie.getNumPathologie(),unePathologie.getLibellePathologie()}); 
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
				Pathologie unePathologie = new Pathologie((Integer)table.getValueAt(ligne, 0),(String)table.getValueAt(ligne, 1));
				ModifierPathologie fModifierPathologie;
		    	fModifierPathologie = new ModifierPathologie(unePathologie);
		    	getContentPane().removeAll();
		    	fModifierPathologie.setVisible(true);
		    	getContentPane().add(fModifierPathologie);
			}				
	    }
	}


