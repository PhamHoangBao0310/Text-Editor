/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;

import static functions.FileImplementation.saveFile;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import views.TextEditor;

/**
 *
 * @author DELL
 */
public class ExitHandler {

    public static void handleExit(TextEditor frame) {
        File containedFile = frame.getContainedFile();
        JTextArea txtMainText = frame.getTxtMainText();
        if (frame.getTitle().endsWith("(unsaved)")) {
            Object[] options = {"Yes", "No"};
            int result = JOptionPane.showOptionDialog(
                    null,
                    "You didn't save file. Do you want to save it ?",
                    "Notification",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, //no custom icon
                    options, //button titles
                    options[0] //default button
            );
            if (result == JOptionPane.CLOSED_OPTION){
                frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            }
            if (result == JOptionPane.YES_OPTION) {
                if (containedFile == null) {
                    JFileChooser fileChooser = new JFileChooser();;
                    int option = fileChooser.showSaveDialog(frame);
                    if (option == JFileChooser.APPROVE_OPTION) {
                        File fileToSave = fileChooser.getSelectedFile();
                        if (saveFile(fileToSave, txtMainText.getText())) {
                            System.out.println("Save as" + fileToSave.getAbsolutePath());
                        }
                    }
                } else {
                    if (saveFile(containedFile, txtMainText.getText())) {
                        System.out.println("Ok");
                    } else {
                        System.out.println("not OK");
                    }
                }
                frame.dispose();
            }
            if (result == JOptionPane.NO_OPTION) {
                frame.dispose();
            }
        } else {
            frame.dispose();
        }
    }
}
