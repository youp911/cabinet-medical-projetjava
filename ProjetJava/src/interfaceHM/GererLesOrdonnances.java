package interfaceHM;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
import dao.DaoMedicament;
import dao.DaoOrdonnance;

public class GererLesOrdonnances extends JInternalFrame implements ActionListener {

	private JLabel lblOrdonnance;
	private JTable lstConsultation;
	private Object[][] lignes;
	private JPanel panel;
	private JButton btnValider;
	private static JTable table;
	private JScrollPane scrollPane_1;
	private static DefaultTableModel dtm;
	private JButton btnSupprimer;
	private JButton btnAnnuler;
	private JButton btnAjouter;
	private JComboBox comboBox;
	private Consultation laConsultation;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GererLesOrdonnances frame = new GererLesOrdonnances(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GererLesOrdonnances(Consultation uneConsultation) {
		setBounds(0, 0, 826, 523);
		getContentPane().setLayout(null);
		
		lblOrdonnance = new JLabel("Ordonnance");
		lblOrdonnance.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblOrdonnance.setBounds(336, 44, 368, 64);
		getContentPane().add(lblOrdonnance);
		
		laConsultation = uneConsultation;

		this.table = new JTable();
		this.table.setBounds(10, 11, 656, 135);
		
		//Creation d'un JScrollPane pour obtenir les titres du JTable
		this.scrollPane_1 = new JScrollPane(this.table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
	    	     ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.scrollPane_1.setBounds(34, 168, 747, 242);
		
		getContentPane().add(this.scrollPane_1);
		
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(this);
		btnSupprimer.setBounds(357, 421, 91, 23);
		getContentPane().add(btnSupprimer);
		
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
		
		setRootPaneCheckingEnabled(false);
		javax.swing.plaf.InternalFrameUI ui	= this.getUI();
		((javax.swing.plaf.basic.BasicInternalFrameUI)ui).setNorthPane(null);
		this.setBorder(null);
		
		//Met à jour le JTable
		updateTable();
		for(Ordonnance uneOrdonnance : DaoOrdonnance.getLesOrdonnancesDUneConsultation(uneConsultation))
		{
		GererLesOrdonnances.ajoutOrdonnanceTableau(uneOrdonnance);
		}
	}
	
	// Permet de mettre à jour la liste des médicaments d'une ordonnance (JTab)
	private void updateTable() {
		
		String[] titre = {"Nom du Médicament",
                "Libellé du Médicament",
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
	
	
	// Permet à l'utilisateur d'insérer une prescription pour un médicament (lors de l'ajout de médicaments pour une ordonnance)
	// Le tableau des médicaments prescrits est constitué de colonnes : "Nom du Médicament", "Libellé du Médicament", et "Posologie". 
	// Initialement, le champ "Posologie" est vide.
	// Les champs "Nom du Médicament" et "Libellé du Médicament" ne sont pas modifiables dans l'ordonnance
	
	public static void ajoutPrescriptionTableau(Medicament unMedicament)
	{
		/* ajout d'une nouvelle ligne au tableau des Ordonnances avec un médicament */
		dtm.addRow(new Object[]{unMedicament.getNomMedicament(), unMedicament.getDescriptionMedicament(), null}); 
		table.setModel(dtm);
	}
	
	
	public static void ajoutOrdonnanceTableau(Ordonnance uneOrdonnance)
	{
		/* ajout d'une nouvelle ligne au tableau des Ordonnances mais cette fois avec une ordonnance */
		dtm.addRow(new Object[]{uneOrdonnance.getUnMedicament().getNomMedicament(), uneOrdonnance.getUnMedicament().getDescriptionMedicament(), uneOrdonnance.getUnePosologie()}); 
		table.setModel(dtm);
	}

	// Permet l'interaction entre les composants graphiques et l'interface
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		if(evt.getSource()==btnAjouter)
		{
			Medicament unMedicament = (Medicament)comboBox.getSelectedItem();
			GererLesOrdonnances.ajoutPrescriptionTableau(unMedicament);
			
		}
		
		if(evt.getSource()==btnAnnuler)
		{
			dispose(); 
			getContentPane().removeAll();
			ModifierConsultation fModifierConsultation;
			fModifierConsultation = new ModifierConsultation(laConsultation);
			getContentPane().add( fModifierConsultation);
			fModifierConsultation.setVisible(true);
		}
		if(evt.getSource() == btnValider)
		{
			int b = 0;
			
			for (b = 0; b<table.getRowCount(); b++)
			{
				Ordonnance uneOrdonnance = new Ordonnance(DaoMedicament.TrouverUnMedocAvecSonNom((String)table.getValueAt(b, 0)), laConsultation,(String)table.getValueAt(b, 2));
				
				//Supprime l'ordonnance pour éviter de créer un problème avec les clé primaire
				DaoOrdonnance.supprimerUneOrdonnance(uneOrdonnance);
				//Ajoute l'ordonnance à la base de données
				DaoOrdonnance.AjouterUneOrdonnance(uneOrdonnance);
			}
		}
		if(evt.getSource() == btnSupprimer)
		{
			int b = table.getSelectedRow();
			String leNom = (String)table.getValueAt(b, 0);
			Ordonnance uneOrdonnance = new Ordonnance(DaoMedicament.TrouverUnMedocAvecSonNom((String)table.getValueAt(table.getSelectedRow(), 0)), laConsultation,(String)table.getValueAt(table.getSelectedRow(), 2));
			
			//Supprime l'ordonnance
			DaoOrdonnance.supprimerUneOrdonnance(uneOrdonnance);
			
			//rafraichi la page pour afficher les ordonnances non supprimer
			getContentPane().removeAll();
			GererLesOrdonnances fGererLesOrdonnances;
			fGererLesOrdonnances = new GererLesOrdonnances(laConsultation);
			getContentPane().add(fGererLesOrdonnances);
			fGererLesOrdonnances.setVisible(true);
		}
	}
}


