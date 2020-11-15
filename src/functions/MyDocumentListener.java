/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import views.TextEditor;

/**
 *
 * @author DELL
 */
public class MyDocumentListener implements DocumentListener {

    TextEditor myTextEditor;
    boolean unsave ;
    
    
    public void setSaved(){
        this.unsave = false;
    }
    @Override
    public void insertUpdate(DocumentEvent de) {
//        System.out.println("insert" + unsave);
        if (unsave == false) {
            myTextEditor.setTitle(myTextEditor.getTitle() + "(unsaved)");
            unsave = true;
        } 
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
//        System.out.println("remove" + unsave);
        if (unsave == false) {
            myTextEditor.setTitle(myTextEditor.getTitle() + "(unsaved)");
            unsave = true;
        }
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
//        System.out.println("change" + unsave);
        if (unsave == false) {
            myTextEditor.setTitle(myTextEditor.getTitle() + "(unsaved)");
            unsave = true;
        }
    }

    public MyDocumentListener(TextEditor myTextEditor) {
        this.myTextEditor = myTextEditor;
        this.unsave = false;
    }

}
