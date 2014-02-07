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

import metier.Consultation;
import metier.Medecin;
import dao.DaoConsultation;

// GererConsultation permet d'afficher et d'interagir avec l'interface de gestion des consultation
// L'affichage des consultations est réalisé avec une JTab (tableau)

public class GererConsultations extends JInternalFrame implements ActionListener {

	private JTable lstConsultation;
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
					GererConsultations frame = new GererConsultations();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Créé la fenêtre et tout ses composants graphiques
	
	public GererConsultations() {
		setBounds(100, 100, 852, 523);
		getContentPane().setLayout(null);
		lblNewLabel = new JLabel("Gerer les Consultations");
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
		
		btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(this);
		btnModifier.setBounds(317, 421, 91, 23);
		getContentPane().add(btnModifier);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(this);
		btnAnnuler.setBounds(216, 421, 91, 23);
		getContentPane().add(btnAnnuler);
		
		setRootPaneCheckingEnabled(false);
		javax.swing.plaf.InternalFrameUI ui	= this.getUI();
		((javax.swing.plaf.basic.BasicInternalFrameUI)ui).setNorthPane(null);
		this.setBorder(null);
		
		//Met à jour le JTable
		updateTable();
		for(Consultation uneConsultation : DaoConsultation.getLesConsultations())
		{
			GererConsultations.ajoutConsultationTableau(uneConsultation);
		}
	}
	
	// Permet de mettre à jour la liste des consultations (JTab)
	
	private void updateTable() {
		
		String[] titre = {"Numéro de la Consultation",
                "Nom de la Pathologie",
                "Nom du Patient",
                "Prénom du Patient",
                "Nom du Medecin",
                "Prénom du Medecin",
                "Date de la Consultation",
                "Heure de la Consultation"};
		
		Object[][] listeMedecin = new Object[0][8];
		dtm = new DefaultTableModel(listeMedecin, titre){
			public boolean isCellEditable(int row, int col) {
				return false;
			};
		};
		table.setModel(dtm);
	}
	
	// Permet d'ajouter une consultation à la liste des consultations (JTab)
	
	public static void ajoutConsultationTableau(Consultation uneConsultation)
	{
		/* ajout d'une nouvelle ligne au tableau des Médecins */
		dtm.addRow(new Object[]{uneConsultation.getNumConsultat(),uneConsultation.getUnePathologie().getLibellePathologie(),
				uneConsultation.getLePatient().getNomPatient(),uneConsultation.getLePatient().getPrenomPatient(),
				uneConsultation.getLeMedecin().getNomMedecin(),uneConsultation.getLeMedecin().getPrenomMedecin(),
				uneConsultation.getDateConsultat(),uneConsultation.getHeureConsultat()}); 
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
			Consultation c = DaoConsultation.RetrouverUneConsultAvecSonNum((Integer)table.getValueAt(ligne, 0));
			getContentPane().removeAll();
			ModifierConsultation fModifierConsultation;
			fModifierConsultation = new ModifierConsultation(c);
	    	getContentPane().add(fModifierConsultation);
	    	fModifierConsultation.setVisible(true);
		}
		
			
    }
}


