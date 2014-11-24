package fr.ign.cogit.cartagen.pearep.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.xml.parsers.ParserConfigurationException;

import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.xml.sax.SAXException;

import fr.ign.cogit.cartagen.core.defaultschema.DefaultCreationFactory;
import fr.ign.cogit.cartagen.software.CartagenApplication;
import fr.ign.cogit.cartagen.software.dataset.CartAGenDocOld;
import fr.ign.cogit.cartagen.software.dataset.PostgisDB;

public class GUIMainClassEclipse extends JFrame implements ActionListener {

  /****/
  private static final long serialVersionUID = 1L;
  private JRadioButton rdScale, rdParams;
  private File themesFile;

  public GUIMainClassEclipse(File themesFile) {
    super("Choisissez l'interface d'édition à ouvrir");
    this.themesFile = themesFile;
    this.setSize(200, 200);

    JPanel rdPanel = new JPanel();
    rdScale = new JRadioButton("Fichier ScaleMaster.xml");
    rdParams = new JRadioButton("Fichier PeaRepParameters.xml");
    ButtonGroup bg = new ButtonGroup();
    bg.add(rdScale);
    bg.add(rdParams);
    rdScale.setSelected(true);
    rdPanel.add(rdScale);
    rdPanel.add(rdParams);
    rdPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    rdPanel.setLayout(new BoxLayout(rdPanel, BoxLayout.X_AXIS));
    JButton okButton = new JButton("OK");
    okButton.addActionListener(this);
    okButton.setActionCommand("ok");
    this.add(rdPanel);
    this.add(okButton);
    this.getContentPane().setLayout(
        new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
    this.pack();
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    // ******************************************************
    // launch CartAGen as batch application
    // Objects creation factory
    CartagenApplication.getInstance().setCreationFactory(
        new DefaultCreationFactory());

    // Application initialisation
    CartagenApplication.getInstance().initApplication();
    CartAGenDocOld doc = CartAGenDocOld.getInstance();
    doc.setName("PEA_REP");
    doc.setPostGisDb(PostgisDB.get("PEA_REP", true));

    String jarPath = "E:\\Users\\gtouya\\Documents\\Projets\\PEA REP\\Module\\version2.0\\";
    String path = jarPath + "\\" + "ScaleMasterThemes.xml";
    File themesFile = new File(path);

    GUIMainClassEclipse frame = new GUIMainClassEclipse(themesFile);
    frame.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("ok")) {
      if (rdScale.isSelected()) {
        EditScaleMasterFrame frame = null;
        try {
          frame = new EditScaleMasterFrame(themesFile, false);
        } catch (OWLOntologyCreationException e1) {
          e1.printStackTrace();
        } catch (ParserConfigurationException e1) {
          e1.printStackTrace();
        } catch (SAXException e1) {
          e1.printStackTrace();
        } catch (IOException e1) {
          e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
          e1.printStackTrace();
        }
        frame.setVisible(true);
      } else if (rdParams.isSelected()) {
        EditPeaRepParamsFrame frame = new EditPeaRepParamsFrame(false);
        frame.setVisible(true);
      }
      this.setVisible(false);
    }
  }

}
