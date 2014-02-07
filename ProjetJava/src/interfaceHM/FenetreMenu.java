package interfaceHM;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metier.Pathologie;

 // FenetreMenu va permettre de créer l'IHM de l'écran d'accueil de l'application. 

public class FenetreMenu extends JFrame implements ActionListener {

	// Fenêtre
	static  JPanel contentPane;
	// Menu horizontal
	private JMenuBar menuBar;
	// Menus
	private JMenu mnFichier;
	private JMenu mnConsultation;
	private JMenu mnMedecin;
	private JMenu mnMedicament;
	private JMenu mnPathologie;
	private JMenu mnPatient;
	
	// Sous-menus
	private JMenuItem mntmQuitter;
	private JMenuItem mntmNouvelleConsultation;
	private JMenuItem mntmNouveauMedecin;
	private JMenuItem mntmNouveauMedicament;
	private JMenuItem mntmNouvellePathologie;
	private JMenuItem mntmNouveauPatient;
	private JMenuItem mntmGererLesMedecins;
	private JMenuItem mntmGererLesPatients;
	private JMenuItem mntmGererPathologie;
	private JMenuItem mntmGererLesMedicaments;
	private JMenuItem mntmGererLesConsultations;
	
    // Lance l'application

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Appel de la méthode FenêtreMenu qui va créer la fenêtre dans le cas ou il n'y a aucune erreur 
					FenetreMenu frame = new FenetreMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					// En cas d'erreur, affiche l'exception et l'état de la pile d'exécution
					e.printStackTrace();
				}
			}
		});
	}

		 // Crée la fenêtre et les composants (barre de menu...)
	
	public FenetreMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 640);
		
		// Crée une barre de menu horizontale
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		// Crée les menus de la barre de menu horizontale ainsi que leurs sous-menus
		
		// 1 - Fichier 
		mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		
		// 1.1 - Quitter
		mntmQuitter = new JMenuItem("Quitter");
		mntmQuitter.addActionListener(this);
		mnFichier.add(mntmQuitter);
		
		// 2 - Medecin
		mnMedecin = new JMenu("Medecin");
		menuBar.add(mnMedecin);
		
		// 2.1 - Nouveau médecin
		mntmNouveauMedecin = new JMenuItem("Nouveau Medecin");
		mntmNouveauMedecin.addActionListener(this);
		mnMedecin.add(mntmNouveauMedecin);
		
		// 2.2 Gerer les medecins
		mntmGererLesMedecins = new JMenuItem("Gerer les Medecins");
		mntmGererLesMedecins.addActionListener(this);
		mnMedecin.add(mntmGererLesMedecins);
		
		// 3 - Patient
		mnPatient = new JMenu("Patient");
		mnPatient.addActionListener(this);
		menuBar.add(mnPatient);
		
		// 3.1 - Nouveau patient
		mntmNouveauPatient = new JMenuItem("Nouveau Patient");
		mntmNouveauPatient.addActionListener(this);
		mnPatient.add(mntmNouveauPatient);
		
		// 3.2 - Gerer les patients
		mntmGererLesPatients = new JMenuItem("Gerer les Patients");
		mntmGererLesPatients.addActionListener(this);
		mnPatient.add(mntmGererLesPatients);
		
		// 4 - Consultation
		mnConsultation = new JMenu("Consultation");
		mnConsultation.addActionListener(this);
		menuBar.add(mnConsultation);
		
		// 4.1 - Nouvelle consultation
		mntmNouvelleConsultation = new JMenuItem("Nouvelle Consultation");
		mntmNouvelleConsultation.addActionListener(this);
		mnConsultation.add(mntmNouvelleConsultation);
		
		// 4.2 - Gerer les consultations
		mntmGererLesConsultations = new JMenuItem("Gerer les Consultations");
		mntmGererLesConsultations.addActionListener(this);
		mnConsultation.add(mntmGererLesConsultations);
		
		// 5 - Medicament
		mnMedicament = new JMenu("Medicament");
		mnMedicament.addActionListener(this);
		menuBar.add(mnMedicament);
		
		// 5.1 - Nouveau médicament
		mntmNouveauMedicament = new JMenuItem("Nouveau Medicament");
		mntmNouveauMedicament.addActionListener(this);
		mnMedicament.add(mntmNouveauMedicament);
		
		// 5.2 - Gerer les medicaments
		mntmGererLesMedicaments = new JMenuItem("Gerer les Medicaments");
		mntmGererLesMedicaments.addActionListener(this);
		mnMedicament.add(mntmGererLesMedicaments);
		
		// 6 - Pathologie
		mnPathologie = new JMenu("Pathologie");
		mnPathologie.addActionListener(this);
		menuBar.add(mnPathologie);
		
		// 6.1 - Nouvelle pathologie
		mntmNouvellePathologie = new JMenuItem("Nouvelle Pathologie");
		mntmNouvellePathologie.addActionListener(this);
		mnPathologie.add(mntmNouvellePathologie);
		
		//6.2 - Gerer les pathologies
		mntmGererPathologie = new JMenuItem("Gerer les Pathologies");
		mntmGererPathologie.addActionListener(this);
		mnPathologie.add(mntmGererPathologie);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
		
	// actionPerformed va permettre de définir des interaction entre les composants et l'application (par exemple, les boutons valider, modifier...)
	 
	public void actionPerformed(ActionEvent evt)
	{
		// Interaction (clic) sur le bouton quitter permet de fermer l'application 
		if (evt.getSource() == this.mntmQuitter)
		{
			System.exit(0); 
		}
		
		// Interaction sur le sous-menu "Nouveau medecin" du menu "Medecin"
		// Fait appel à l'IHM AjoutMedecin.java et l'affiche
		if ( evt.getSource() == this.mntmNouveauMedecin)
    	{
			contentPane.removeAll();
			AjoutMedecin fAjoutMedecin;
	    	fAjoutMedecin = new AjoutMedecin();
	    	contentPane.add(fAjoutMedecin);
	    	fAjoutMedecin.setVisible(true);
    	}
		
		// Interaction sur le sous-menu "Gerer les medecins" du menu "Medecin"
		// Fait appel à l'IHM GererMedecins.java et l'affiche 
		if ( evt.getSource() == this.mntmGererLesMedecins)
    	{
			contentPane.removeAll();
			GererMedecins fGererMedecin;
	    	fGererMedecin = new GererMedecins();
	    	contentPane.add(fGererMedecin);
	    	fGererMedecin.setVisible(true);
    	}
		
		// Interaction sur le sous-menu "Gerer les patients" du menu "Patient"
		// Fait appel à l'IHM GererPatients.java et l'affiche 
		if (evt.getSource() == this.mntmGererLesPatients)
		{
			contentPane.removeAll();
			GererPatients fGererPatient;
			fGererPatient = new GererPatients();
			contentPane.add(fGererPatient);
			fGererPatient.setVisible(true);
		}
		
		// Interaction sur le sous-menu "Nouveau patient" du menu "Patient"
		// Fait appel à l'IHM AjoutPatient.java et l'affiche 
		if (evt.getSource() == this.mntmNouveauPatient)
		{
			contentPane.removeAll();
			AjoutPatient fAjoutPatient;
			fAjoutPatient = new AjoutPatient();
			contentPane.add(fAjoutPatient);
			fAjoutPatient.setVisible(true);
		}
		
		// Interaction sur le sous-menu "Ajouter une pathologie" du menu "Pathologie"
		// Fait appel à l'IHM AjoutPathologie.java et l'affiche 
		if (evt.getSource() == this.mntmNouvellePathologie)
		{
			contentPane.removeAll();
			AjoutPathologie fAjoutPathologie;
			fAjoutPathologie = new AjoutPathologie();
			contentPane.add(fAjoutPathologie);
			fAjoutPathologie.setVisible(true);
		}
		
		// Interaction sur le sous-menu "Gerer les pathologie" du menu "Pathologie"
		// Fait appel à l'IHM GererPathologies.java et l'affiche 
		if (evt.getSource() == this.mntmGererPathologie)
		{
			contentPane.removeAll();
			GererPathologies fGererPathologie;
			fGererPathologie = new GererPathologies();
			contentPane.add(fGererPathologie);
			fGererPathologie.setVisible(true);
		}
		
		// Interaction sur le sous-menu "Gerer les medicaments" du menu "Medicament"
		// Fait appel à l'IHM GererMedicament.java et l'affiche 
		if(evt.getSource()== this.mntmGererLesMedicaments)
		{
			contentPane.removeAll();
			GererMedicament fGererMedicament;
			fGererMedicament = new GererMedicament();
			contentPane.add(fGererMedicament);
			fGererMedicament.setVisible(true);
		}
		
		// Interaction sur le sous-menu "Gerer les consultations" du menu "Consultation"
		// Fait appel à l'IHM GererConsultation.java et l'affiche 
		if(evt.getSource()== this.mntmGererLesConsultations)
		{
			contentPane.removeAll();
			GererMedicament fGererMedicament;
			fGererMedicament = new GererMedicament();
			contentPane.add(fGererMedicament);
			fGererMedicament.setVisible(true);
		}
		
		// Interaction sur le sous-menu "AjoutConsultation" du menu "Consultation"
		// Fait appel à l'IHM AjoutConsulation.java et l'affiche 
		if(evt.getSource()==this.mntmNouvelleConsultation)
		{
			contentPane.removeAll();
			AjoutConsultation fAjoutConsultation;
			fAjoutConsultation = new AjoutConsultation();
			contentPane.add( fAjoutConsultation);
			fAjoutConsultation.setVisible(true);
		}	
	}
}
