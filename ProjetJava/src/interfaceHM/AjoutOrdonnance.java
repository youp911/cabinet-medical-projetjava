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
import javax.swing.table.DefaultTableModel;

import metier.Consultation;
import metier.Medicament;
import metier.Ordonnance;
import dao.DaoConsultation;
import dao.DaoMedicament;

import javax.swing.JComboBox;

//AjoutOrdonnance permet l'affichage de l'IHM d'ajout d'une ordonnance

public class AjoutOrdonnance extends JInternalFrame implements ActionListener {
	
	private JLabel lblOrdonnance;
	private JTable lstConsultation;
	private Object[][] lignes;
	private JPanel panel;
	private JButton btnValider;
	private static JTable table;
	private JScrollPane scrollPane_1;
	private static DefaultTableModel dtm;
	private JButton btnSupprimer;
	private JButton btnModifier;
	private JButton btnAnnuler;
	private JButton btnAjouter;
	private JComboBox comboBox;
	
// Cr�� la fen�tre et tout ses composants graphiques
	
	public AjoutOrdonnance(Consultation uneConsultation) {
		setBounds(100, 100, 901, 555);
		getContentPane().setLayout(null);
		
		lblOrdonnance = new JLabel("Ordonnance");
		lblOrdonnance.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblOrdonnance.setBounds(336, 44, 259, 64);
		getContentPane().add(lblOrdonnance);

		this.table = new JTable();
		this.table.setBounds(10, 11, 656, 135);
		
		//Creation d'un JScrollPane pour obtenir les titres du JTable
		this.scrollPane_1 = new JScrollPane(this.table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
	    	     ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.scrollPane_1.setBounds(34, 168, 788, 242);
		
		getContentPane().add(this.scrollPane_1);
		
		btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(this);
		btnModifier.setBounds(357, 421, 91, 23);
		getContentPane().add(btnModifier);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(this);
		btnAnnuler.setBounds(215, 421, 91, 23);
		getContentPane().add(btnAnnuler);
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(this);
		btnAjouter.setBounds(654, 119, 91, 23);
		getContentPane().add(btnAjouter);
		
		btnValider = new JButton("Valider");
		btnValider.addActionListener(this);
		btnValider.setBounds(504, 421, 91, 23);
		getContentPane().add(btnValider);
		
		comboBox = new JComboBox(DaoMedicament.getLesMedocs());
		comboBox.setBounds(81, 111, 550, 38);
		getContentPane().add(comboBox);
		
		//Met � jour le JTable
		updateTable();
		//for(Consultation uneConsultation : DaoConsultation.getLesConsultations())
	//	{
	//	AjoutOrdonnance.ajoutPrescriptionTableau(uneConsultation);
		//}
	}
	
	// Permet de mettre � jour la liste des m�dicaments d'une ordonnance (JTab)
	private void updateTable() {
		
		String[] titre = {"Nom du M�dicament",
                "Libell� du M�dicament",
                "Posologie"
                };
		
		Object[][] listeMedecin = new Object[0][3];
		dtm = new DefaultTableModel(listeMedecin, titre){
			public boolean isCellEditable(int row, int col) {
				boolean res = false;
				if(col==2)
				{
					res = true;
				}
				return res;
			};
		};
		table.setModel(dtm);
	}
	
	
	// Permet � l'utilisateur d'ins�rer une prescription pour un m�dicament (lors de l'ajout de m�dicaments pour une ordonnance)
	// Le tableau des m�dicaments prescrits est constitu� de colonnes : "Nom du M�dicament", "Libell� du M�dicament", et "Posologie". 
	// Initialement, le champ "Posologie" est vide.
	// Les champs "Nom du M�dicament" et "Libell� du M�dicament" ne sont pas modifiables dans l'ordonnance
	
	public static void ajoutPrescriptionTableau(Medicament unMedicament)
	{
		/* ajout d'une nouvelle ligne au tableau des M�decins */
		dtm.addRow(new Object[]{unMedicament.getNomMedicament(), unMedicament.getDescriptionMedicament(), null}); 
		table.setModel(dtm);
	}

	// Permet l'interaction entre les composants graphiques et l'interface
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		if(evt.getSource()==btnAjouter)
		{
			Medicament unMedicament = (Medicament)comboBox.getSelectedItem();
			AjoutOrdonnance.ajoutPrescriptionTableau(unMedicament);
		}
		
		if(evt.getSource()==btnAnnuler)
		{
			dispose(); 
			getContentPane().removeAll();
			AjoutConsultation fAjoutConsultation;
			fAjoutConsultation = new AjoutConsultation();
			getContentPane().add( fAjoutConsultation);
			fAjoutConsultation.setVisible(true);
		}
		if(evt.getSource() == btnValider)
		{
			int b;
			for (b = 1; b==table.getRowCount(); b++)
			{
				/*Ordonnance uneOrdonnance = new Ordonnance(null, table.getValueAt(b, 0),table.getValueAt(b, 0),table.getValueAt(b, 0))*/
			}
		}
		
	}
}

