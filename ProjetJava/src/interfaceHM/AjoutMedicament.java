package interfaceHM;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import metier.Medicament;
import dao.DaoMedecin;
import dao.DaoMedicament;

//AjoutMedicament permet l'affichage de l'IHM d'ajout d'un médicament

public class AjoutMedicament extends JInternalFrame implements ActionListener {
	private JLabel lblNewLabel;
	private JLabel lblNumro;
	private JLabel lblNom;
	private JLabel lblDescription;
	private JTextField txtNum;
	private JTextField txtNom;
	private JTextField txtDescription;
	private JButton btnAnnuler;
	private JButton btnValider;


// Lance l'application
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutMedicament frame = new AjoutMedicament();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	// Créé la fenêtre et ses composants graphiques
	
	public AjoutMedicament() {
		setBounds(100, 100, 887, 578);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Ajout d'un m\u00E9dicament");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(303, 38, 221, 87);
		getContentPane().add(lblNewLabel);
		
		
		lblNom = new JLabel("Nom : ");
		lblNom.setBounds(303, 178, 66, 14);
		getContentPane().add(lblNom);
		
		lblDescription = new JLabel("Description : ");
		lblDescription.setBounds(303, 242, 66, 14);
		getContentPane().add(lblDescription);
		
		txtNom = new JTextField();
		txtNom.setBounds(428, 175, 239, 20);
		getContentPane().add(txtNom);
		txtNom.setColumns(10);
		
		txtDescription = new JTextField();
		txtDescription.setBounds(428, 228, 239, 101);
		getContentPane().add(txtDescription);
		txtDescription.setColumns(10);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(this);
		btnAnnuler.setBounds(303, 360, 91, 23);
		getContentPane().add(btnAnnuler);
		
		btnValider = new JButton("Valider");
		btnValider.addActionListener(this);
		btnValider.setBounds(433, 360, 91, 23);
		getContentPane().add(btnValider);

	}
	
// Permet l'interaction entre les composants graphiques et l'interface
	
	public void actionPerformed(ActionEvent evt) 
	{
		if(evt.getSource()==btnAnnuler)
		{
			dispose();
		}
		if(evt.getSource()==btnValider)
		{
			if (this.txtNom.getText().isEmpty() || this.txtDescription.getText().isEmpty())
				JOptionPane.showMessageDialog(null, "Tous les champs sont obligatoires !");
			else
			{
				getContentPane().removeAll();
				Medicament unMedicament;
				unMedicament= new Medicament (null,this.txtNom.getText(),this.txtDescription.getText());
				DaoMedicament.AjouterUnMedicament(unMedicament);
				JOptionPane.showMessageDialog(null, "Medecin ajoutée.");
			}
		}
	}
}
