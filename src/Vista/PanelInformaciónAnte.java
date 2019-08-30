package Vista;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class PanelInformaciónAnte extends JPanel {
	JTextArea infoant;

	public PanelInformaciónAnte() {
		setBorder(new CompoundBorder(new EmptyBorder(5, 5, 2, 2), new TitledBorder("INFORMACION ANTECEDENTES")));

		infoant = new JTextArea();

		infoant.setRows(40);
		infoant.setColumns(30);
		infoant.setEditable(true);
		add(infoant);
	
	}
}
