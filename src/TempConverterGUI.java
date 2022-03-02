/*
Author: Prajwal Dhungana
Date: Mar 01, 2022
Purpose: This program converts temperature from F to C or C to F in GUI
 */

//importing necessary libraries
import java.util.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

//begin TempConverter Class
public class TempConverterGUI extends JFrame
{
    //declaring window width and height
    private int win_width = 500;
    private int win_height = 200;

    //declaring JLabel and JtextField
    private JLabel fahrenLab, celsiusLab;
    private JTextField fahrenField, celsiusField;

    //declaring the buttons
    private JButton convertBut , clearBut;

    //creating constructor class
    public TempConverterGUI()
    {
        //setting the title
        this.setTitle("Temperature Conversion \t\t by PrajwalDhungana");

        //setting the default close operation
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //setting window width and height
        this.setSize(win_width,win_height);

        //method to initialise the window
        initWin();

        //making the window visible
        this.setVisible(true);
    }

    //Starting the initWin method
    public void initWin()
    {
        //initialising the font sizes
        int largeFontSize = 25;
        int mediumFontSize = 15;

        //creating large and medium font
        Font largeFont = new Font("arial", Font.BOLD, largeFontSize);
        Font mediumFont = new Font("arial", Font.BOLD, mediumFontSize);

        //Creating the north label and panel
        JLabel northLabel = new JLabel("Temperature Conversion");
        JPanel northPanel = new JPanel();
        northPanel.add(northLabel);

        //setting font and color
        northLabel.setFont(largeFont);
        northLabel.setForeground(Color.decode("#FE5370"));
        northPanel.setBackground(Color.decode("#212121"));

        //adding to north panel
        this.add(northPanel, BorderLayout.NORTH);

        //creating a border for northPanel
        northPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        //initialising the grid size for center panel
        int centerGridSize = 2;

        //creating the center panel
        JPanel centerPanel = new JPanel(new GridLayout(centerGridSize,1));
        JLabel fahrenLab = new JLabel("Fahrenheit Temp : ");
        JTextField fahrenField = new JTextField();
        JLabel celsiusLab = new JLabel("Celsius Temp : ");
        JTextField celsiusField = new JTextField();
        centerPanel.add(fahrenLab);
        centerPanel.add(fahrenField);
        centerPanel.add(celsiusLab);
        centerPanel.add(celsiusField);

        //setting font size for fahrenLab, fahrenField, celsiusField and celsiusLab and color
        fahrenLab.setFont(mediumFont);
        fahrenLab.setForeground(Color.decode("#50FB78"));
        fahrenField.setFont(mediumFont);
        fahrenField.setBackground(Color.decode("#DEE4E7"));
        fahrenField.setForeground(Color.decode("#501D43"));
        celsiusLab.setFont(mediumFont);
        celsiusLab.setForeground(Color.decode("#50FB78"));
        celsiusField.setFont(mediumFont);
        celsiusField.setBackground(Color.decode("#DEE4E7"));
        celsiusField.setForeground(Color.decode("#501D43"));
        centerPanel.setBackground(Color.decode("#1E2226"));

        //setting the alignment for fahrenLab and celsiusLab
        celsiusLab.setHorizontalAlignment(JLabel.RIGHT);
        fahrenLab.setHorizontalAlignment(JLabel.RIGHT);

        //adding to west panel
        this.add(centerPanel, BorderLayout.CENTER);

        //creating the south panel
        JPanel southPanel = new JPanel();

        //creating convert button and action listener
        JButton convertBut = new JButton("Convert");
        convertBut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent me)
            {

                String fahrenFieldValue = fahrenField.getText();
                String celsiusFieldValue = celsiusField.getText();

                //converts F to C
                if(checkValidity(fahrenFieldValue) == true)
                {
                    double parsedFahrenValue = Double.parseDouble(fahrenFieldValue);
                    double finalCelsiusValue = (parsedFahrenValue - 32) * 5/9;
                    String finalCelsiusOutput = String.valueOf(finalCelsiusValue);
                    fahrenField.setText(fahrenFieldValue);
                    celsiusField.setText(finalCelsiusOutput);
                }

                //converts C to F
                else if(checkValidity(celsiusFieldValue) == true)
                {
                    double parsedCelsiusValue = Double.parseDouble(celsiusFieldValue);
                    double finalFahrenValue = (parsedCelsiusValue * 1.8) + 32;
                    String finalFahrenOutput = String.valueOf(finalFahrenValue);
                    fahrenField.setText(finalFahrenOutput);
                    celsiusField.setText(celsiusFieldValue);
                }

                //wrong input so clear the fields
                else
                {
                    clear(fahrenField, celsiusField);
                }
            }
        });

        //creating clear button and action listener
        JButton clearBut = new JButton("Clear");
        clearBut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent me)
            {
                //calling the clear method
                clear(fahrenField,celsiusField);
            }
        });

        southPanel.add(convertBut);
        southPanel.add(clearBut);

        //setting font size for convert and clear buttons and color
        convertBut.setFont(mediumFont);
        clearBut.setFont(mediumFont);
        southPanel.setBackground(Color.decode("#212121"));

        //creating a border for southPanel
        southPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        //adding to the south panel
        this.add(southPanel, BorderLayout.SOUTH);
    }

    //begin checkValidity method
    public boolean checkValidity(String inputValue)
    {
        try
        {
            if(inputValue.isEmpty())
            {
                return false;
            }
            double validityCheck = Double.parseDouble(inputValue);
            return true;
        }
        catch (Exception e)
        {
            String errorMessage = "Wrong input! Please try again\n";
            JOptionPane.showMessageDialog(null, errorMessage, "Error User Input", 1);
            return false;
        }
    }
    //end check validity method

    //begin clear mathod
    public void clear(JTextField fahrenField, JTextField celsiusField)
    {
        //clearing the previously entered values
        fahrenField.setText("");
        celsiusField.setText("");
    }
    //end clear method

    //main class
    public static void main(String[] args)
    {
        //call to the constructor
        new TempConverterGUI();
    }
    //end of main

}
//end of TempConverter Class
