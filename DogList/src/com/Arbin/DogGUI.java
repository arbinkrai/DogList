package com.Arbin;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lt3733yt on 11/9/2015.
 */
public class DogGUI extends JFrame {
    private JPanel rootPanel;
    private JTextField dogNameTextField;
    private JTextField dogAgeTextField;
    private JCheckBox puppyCheckBox;
    private JButton addDogToListButton;
    private JList<Dog> dogJList;
    private JButton deleteDog;
    DefaultListModel<Dog> dogListModel;

    public DogGUI(){
        super("List of Dogs");
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(new Dimension(300, 500));

        dogListModel=new DefaultListModel<Dog>();
        dogJList.setModel(dogListModel);
        dogJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        addDogToListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Read in data from JTextFields and checkbox and make a new Dog object
                //Add the Dog object to the list
                String dogName = dogNameTextField.getText();
                String dogAgeAsString = dogAgeTextField.getText();
                int dogAge;
                try {
                    dogAge = Integer.parseInt(dogAgeAsString);
                } catch (NumberFormatException nfe) {//Display dialog box with error message
                    JOptionPane.showMessageDialog(DogGUI.this, "Enter an integer number for dog's age.");
                    return;
                }
                boolean isPuppy = puppyCheckBox.isSelected();
                Dog newDog = new Dog(dogName, dogAge, isPuppy);
                DogGUI.this.dogListModel.addElement(newDog);
            }
        });
        deleteDog.addActionListener(new ActionListener() {
            @Override
        public void actionPerformed(ActionEvent e){
        //Fetch and delete the selected Dog object
               Dog toDelete = DogGUI.this.dogJList.getSelectedValue();
                DogGUI.this.dogListModel.removeElement(toDelete);
            }
        });
    }
}
