package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DiagnosticTest extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_5;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Oval Sample");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    DiagnosticTest panel = new DiagnosticTest();
	    frame.add(panel);
	    frame.setSize(300, 200);
	    frame.setVisible(true);
	}

	public DiagnosticTest() {
		initComponents();
//        kiemtracauhinh();
//        this.setLocationRelativeTo(null);
	}

	private void initComponents() {
		JPanel diagnosticTestPanel = new JPanel();
		diagnosticTestPanel.setLayout(null);
//		diagnosticTestPanel.setVisible(true);

		JLabel lblDiagnosticTestLabel = new JLabel("Diagnostic Test");
		lblDiagnosticTestLabel.setBounds(163, 25, 104, 28);
		diagnosticTestPanel.add(lblDiagnosticTestLabel);
//		lblDiagnosticTestLabel.setVisible(true);

		JLabel lblNewLabel = new JLabel("Dis+");
		lblNewLabel.setBounds(150, 65, 46, 14);
		diagnosticTestPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Dis-");
		lblNewLabel_1.setBounds(211, 65, 46, 14);
		diagnosticTestPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Total");
		lblNewLabel_2.setBounds(272, 65, 46, 14);
		diagnosticTestPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Test+");
		lblNewLabel_3.setBounds(95, 90, 46, 14);
		diagnosticTestPanel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Test-");
		lblNewLabel_4.setBounds(95, 120, 46, 14);
		diagnosticTestPanel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Total");
		lblNewLabel_5.setBounds(95, 150, 46, 14);
		diagnosticTestPanel.add(lblNewLabel_5);

		textField = new JTextField();
		textField.setBounds(140, 87, 40, 20);
		diagnosticTestPanel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(200, 87, 40, 20);
		diagnosticTestPanel.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(262, 87, 46, 20);
		diagnosticTestPanel.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(140, 117, 40, 20);
		diagnosticTestPanel.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(200, 117, 40, 20);
		diagnosticTestPanel.add(textField_4);
		textField_4.setColumns(10);
//	String xxx = textField_4.getText();

		textField_5 = new JTextField();
		textField_5.setBounds(262, 117, 46, 20);
		diagnosticTestPanel.add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setBounds(140, 147, 40, 20);
		diagnosticTestPanel.add(textField_6);
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setBounds(200, 147, 40, 20);
		diagnosticTestPanel.add(textField_7);
		textField_7.setColumns(10);

		textField_8 = new JTextField();
		textField_8.setBounds(262, 147, 46, 20);
		diagnosticTestPanel.add(textField_8);
		textField_8.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Confidence interval:");
		lblNewLabel_6.setBounds(95, 180, 145, 14);
		diagnosticTestPanel.add(lblNewLabel_6);

		Double confidenceIntervals[] = { 0.95, 0.9, 0.85 };
		JComboBox comboBox = new JComboBox(confidenceIntervals);
		comboBox.setBounds(254, 177, 54, 20);
		diagnosticTestPanel.add(comboBox);

		JButton btnResult = new JButton("Result");
		btnResult.setBounds(150, 205, 89, 23);
		diagnosticTestPanel.add(btnResult);

		JLabel lblNewLabel_7 = new JLabel("Type:");
		lblNewLabel_7.setBounds(95, 238, 46, 14);
		diagnosticTestPanel.add(lblNewLabel_7);

		String Types[] = { "Privalence", "hahaha", "huhuhu" };
		JComboBox comboBox_1 = new JComboBox(Types);
		comboBox_1.setBounds(211, 235, 97, 20);
		diagnosticTestPanel.add(comboBox_1);

		JLabel lblNewLabel_8 = new JLabel("Apparent prevalence:");
		lblNewLabel_8.setBounds(95, 267, 137, 14);
		diagnosticTestPanel.add(lblNewLabel_8);

		textField_9 = new JTextField();
		textField_9.setBounds(254, 264, 130, 20);
		diagnosticTestPanel.add(textField_9);
		textField_9.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("True prelence:");
		lblNewLabel_9.setBounds(95, 292, 121, 14);
		diagnosticTestPanel.add(lblNewLabel_9);

		textField_10 = new JTextField();
		textField_10.setBounds(254, 289, 130, 20);
		diagnosticTestPanel.add(textField_10);
		textField_10.setColumns(10);
	}

}
