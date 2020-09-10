package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dto.request.ReqDiagnosticTestDto;
import dto.request.ReqNomogramDto;
import dto.request.ReqRandomNumberGeneratorDto;
import dto.request.ReqSamplingEstimateMeanDto;
import dto.request.ReqSamplingEstimatePrevalenceDto;
import dto.request.ReqSaplingDetectDiseaseDto;
import exception.CalculateException;
import service.DiagnosticTestService;
import service.NomogramService;
import service.RandomNumberGeneratorService;
import service.SamplingEstimateMeanService;
import service.SamplingEstimatePrevalenceService;
import service.SaplingDetectDiseaseService;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.ImageIcon;

public class dashboard extends JFrame {

	private JPanel contentPane;
	private JTextField txtA;
	private JTextField txtB;
	private JTextField textField_1_1;
	private JTextField txtAB;
	private JTextField textField_2_1;
	private JTextField txtCD;
	private JTextField textField_5_1;
	private JTextField txtC;
	private JTextField textField_3_1;
	private JTextField txtD;
	private JTextField textField_4_1;
	private JTextField txtAC;
	private JTextField textField_6_1;
	private JTextField txtBD;
	private JTextField textField_7_1;
	private JTextField txtABCD;
	private JTextField textField_8_1;
	private JTextField textField_9_1;
	private JTextField textField_10_1;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField txtPreTest;
	private JTextField txtTestSen;
	private JTextField txtTestSpec;
//	private JTextField txtLikelihood;
//	private JTextField txtPostTest;
	private JTextField txtPopulationV;
	private JTextField txtMaximumPreV;
	private JTextField txtMaximunV;
	private JTextField txtStandardV;
	private JTextField txtExpectPrevalence;
	private JTextField txtPopuSize;
	private JTextField txtConInterval;
	private JTextField txtTestSensitivity;
	private JTextField txtTestSpecificity;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField txtRhoV;
	private JTextField txtAveClusterSizeV;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dashboard frame = new dashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 779, 386);
		contentPane.add(tabbedPane);

		JPanel homePanel = new JPanel();
		tabbedPane.addTab("Home", null, homePanel, null);
		homePanel.setLayout(null);

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane_1.setBounds(0, 0, 774, 360);
		homePanel.add(tabbedPane_1);

		// Diagnostic Test Panel

		JPanel diagnosticTestPanel = new JPanel();
		tabbedPane_1.addTab("Diagnostic test", null, diagnosticTestPanel, null);
		diagnosticTestPanel.setLayout(null);

		JLabel lblDiagnosticTestLabel = new JLabel("Diagnostic Test");
		lblDiagnosticTestLabel.setBounds(210, 20, 185, 30);
		lblDiagnosticTestLabel.setFont(new Font("Time New Roman", Font.BOLD, 20));
		lblDiagnosticTestLabel.setForeground(Color.BLUE);
		diagnosticTestPanel.add(lblDiagnosticTestLabel);

		JLabel lblNewLabel = new JLabel("Dis+");
		lblNewLabel.setBounds(237, 65, 46, 14);
		diagnosticTestPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Dis-");
		lblNewLabel_1.setBounds(293, 65, 46, 14);
		diagnosticTestPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Total");
		lblNewLabel_2.setBounds(360, 65, 46, 14);
		diagnosticTestPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Test+");
		lblNewLabel_3.setBounds(171, 93, 46, 14);
		diagnosticTestPanel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Test-");
		lblNewLabel_4.setBounds(171, 118, 46, 14);
		diagnosticTestPanel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Total");
		lblNewLabel_5.setBounds(171, 150, 46, 14);
		diagnosticTestPanel.add(lblNewLabel_5);

		txtA = new JTextField();
		txtA.setBounds(227, 87, 40, 20);
		diagnosticTestPanel.add(txtA);
		txtA.setColumns(10);

		txtB = new JTextField();
		txtB.setBounds(285, 87, 40, 20);
		diagnosticTestPanel.add(txtB);
		txtB.setColumns(10);

		txtC = new JTextField();
		txtC.setBounds(227, 117, 40, 20);
		diagnosticTestPanel.add(txtC);
		txtC.setColumns(10);

		txtD = new JTextField();
		txtD.setBounds(285, 117, 40, 20);
		diagnosticTestPanel.add(txtD);
		txtD.setColumns(10);

		txtAB = new JTextField();
		txtAB.setBounds(349, 87, 46, 20);
		diagnosticTestPanel.add(txtAB);
		txtAB.setColumns(10);
		txtAB.setEditable(false);

		txtCD = new JTextField();
		txtCD.setBounds(349, 117, 46, 20);
		diagnosticTestPanel.add(txtCD);
		txtCD.setColumns(10);
		txtCD.setEditable(false);

		txtAC = new JTextField();
		txtAC.setBounds(227, 147, 40, 20);
		diagnosticTestPanel.add(txtAC);
		txtAC.setColumns(10);
		txtAC.setEditable(false);

		txtBD = new JTextField();
		txtBD.setBounds(285, 147, 40, 20);
		diagnosticTestPanel.add(txtBD);
		txtBD.setColumns(10);
		txtBD.setEditable(false);

		txtABCD = new JTextField();
		txtABCD.setBounds(349, 147, 46, 20);
		diagnosticTestPanel.add(txtABCD);
		txtABCD.setColumns(10);
		txtABCD.setEditable(false);

		JLabel lblNewLabel_6 = new JLabel("Confidence interval:");
		lblNewLabel_6.setBounds(171, 180, 145, 14);
		diagnosticTestPanel.add(lblNewLabel_6);

		Double[] confidenceIntervals = { 0.90, 0.95, 0.99 };
		JComboBox cbbInterval = new JComboBox(confidenceIntervals);
		cbbInterval.setBounds(341, 177, 54, 20);
		diagnosticTestPanel.add(cbbInterval);

		JLabel lblNewLabel_7 = new JLabel("Type:");
		lblNewLabel_7.setBounds(171, 269, 46, 14);
		diagnosticTestPanel.add(lblNewLabel_7);

		String Types[] = { "Privalence", "Incidence risk", "Incidence rate" };
		JComboBox cbbType = new JComboBox(Types);
		cbbType.setBounds(324, 266, 130, 20);
		diagnosticTestPanel.add(cbbType);

		JLabel lblApparentPreResult = new JLabel("");
		lblApparentPreResult.setBounds(171, 294, 396, 14);
		diagnosticTestPanel.add(lblApparentPreResult);

		JLabel lblTruePreResult = new JLabel("");
		lblTruePreResult.setBounds(171, 319, 396, 14);
		diagnosticTestPanel.add(lblTruePreResult);

		JLabel lblMessageDiag = new JLabel();
		lblMessageDiag.setBounds(95, 244, 289, 14);
		diagnosticTestPanel.add(lblMessageDiag);
		lblMessageDiag.setForeground(Color.RED);

		JButton btnResult = new JButton("Result");
		btnResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String A = txtA.getText();
				String B = txtB.getText();
				String C = txtC.getText();
				String D = txtD.getText();

//				if (isNumeric(A) || isNumeric(B) || isNumeric(C) || isNumeric(D)) {
//					lblMessageDiag.setText("Vui lòng chỉ nhập số !!!");
//					return;
//				} else {
//					lblMessageDiag.setText("");
				ReqDiagnosticTestDto t = new ReqDiagnosticTestDto(Double.parseDouble(A), Double.parseDouble(B),
						Double.parseDouble(C), Double.parseDouble(D), cbbInterval.getSelectedIndex(),
						(double) cbbInterval.getSelectedItem(), cbbType.getSelectedIndex());
				DiagnosticTestService dts = new DiagnosticTestService();

				txtAB.setText(String.valueOf(Double.parseDouble(A) + Double.parseDouble(B)));
				txtCD.setText(String.valueOf(Double.parseDouble(C) + Double.parseDouble(D)));
				txtAC.setText(String.valueOf(Double.parseDouble(A) + Double.parseDouble(C)));
				txtBD.setText(String.valueOf(Double.parseDouble(B) + Double.parseDouble(D)));
				txtABCD.setText(String.valueOf(
						Double.parseDouble(A) + Double.parseDouble(B) + Double.parseDouble(C) + Double.parseDouble(D)));
				try {
					lblApparentPreResult
							.setText(dts.calculate(t).getResult1() + " " + dts.calculate(t).getResult1Value());
					lblTruePreResult.setText(dts.calculate(t).getResult2() + " " + dts.calculate(t).getResult2Value());
				} catch (CalculateException e) {
					e.printStackTrace();
				}
//				}
			}
		});
		btnResult.setBounds(250, 205, 89, 23);
		diagnosticTestPanel.add(btnResult);

		// Random Number Generator Panel

		JPanel randomNumberGeneratorPanel = new JPanel();
		tabbedPane_1.addTab("Random number generator", null, randomNumberGeneratorPanel, null);
		randomNumberGeneratorPanel.setLayout(null);

		JLabel lblNewLabel_10 = new JLabel("Random number generator");
		lblNewLabel_10.setBounds(175, 20, 300, 30);
		lblNewLabel_10.setFont(new Font("Time New Roman", Font.BOLD, 20));
		lblNewLabel_10.setForeground(Color.BLUE);
		randomNumberGeneratorPanel.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("Number to gennerate");
		lblNewLabel_11.setBounds(184, 72, 120, 14);
		randomNumberGeneratorPanel.add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("Lower bound");
		lblNewLabel_12.setBounds(184, 107, 120, 14);
		randomNumberGeneratorPanel.add(lblNewLabel_12);

		JLabel lblNewLabel_13 = new JLabel("Upper bound");
		lblNewLabel_13.setBounds(184, 144, 120, 14);
		randomNumberGeneratorPanel.add(lblNewLabel_13);

		JLabel lblNewLabel_14 = new JLabel("Random number seed");
		lblNewLabel_14.setBounds(184, 180, 133, 14);
		randomNumberGeneratorPanel.add(lblNewLabel_14);

		textField_11 = new JTextField();
		textField_11.setBounds(336, 69, 86, 20);
		randomNumberGeneratorPanel.add(textField_11);
		textField_11.setColumns(10);

		textField_12 = new JTextField();
		textField_12.setBounds(336, 104, 86, 20);
		randomNumberGeneratorPanel.add(textField_12);
		textField_12.setColumns(10);

		textField_13 = new JTextField();
		textField_13.setBounds(336, 141, 86, 20);
		randomNumberGeneratorPanel.add(textField_13);
		textField_13.setColumns(10);

		textField_14 = new JTextField();
		textField_14.setBounds(336, 177, 86, 20);
		randomNumberGeneratorPanel.add(textField_14);
		textField_14.setColumns(10);

		JCheckBox cbReplacement = new JCheckBox("With replacement");
		cbReplacement.setBounds(242, 221, 140, 23);
		randomNumberGeneratorPanel.add(cbReplacement);

		JLabel lblNewLabel_15 = new JLabel("Random number");
		lblNewLabel_15.setBounds(184, 307, 120, 14);
		randomNumberGeneratorPanel.add(lblNewLabel_15);

		textField_15 = new JTextField();
		textField_15.setBounds(336, 304, 86, 20);
		randomNumberGeneratorPanel.add(textField_15);
		textField_15.setColumns(10);

		JButton btnRun = new JButton("Run");
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int chkReplacement = 0;
				if (cbReplacement.isSelected()) {
					chkReplacement = 1;
				}

				ReqRandomNumberGeneratorDto t = new ReqRandomNumberGeneratorDto(
						Integer.parseInt(textField_11.getText()), Integer.parseInt(textField_12.getText()),
						Integer.parseInt(textField_13.getText()), Integer.parseInt(textField_14.getText()),
						chkReplacement);
				RandomNumberGeneratorService rngs = new RandomNumberGeneratorService();
				try {
					textField_15.setText(rngs.calculate(t).getRandomNo());
				} catch (CalculateException e) {
					e.printStackTrace();
				}
			}
		});
		btnRun.setBounds(252, 251, 89, 23);
		randomNumberGeneratorPanel.add(btnRun);

		// Nomogram Panel

		JPanel nomogramPanel = new JPanel();
		tabbedPane_1.addTab("Nomogram", null, nomogramPanel, null);
		nomogramPanel.setLayout(null);

		ButtonGroup bg = new ButtonGroup();
		JRadioButton rdbtnNewRadioButton = new JRadioButton(
				"Calculate likelihood ratio from \n sensitivity and specificity");
		rdbtnNewRadioButton.setBounds(146, 63, 360, 29);
		nomogramPanel.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Likelihood ratio known");
		rdbtnNewRadioButton_1.setBounds(146, 95, 285, 23);
		nomogramPanel.add(rdbtnNewRadioButton_1);
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);

		JLabel lblNewLabel_16 = new JLabel("Pre-test prob of disease");
		lblNewLabel_16.setBounds(146, 136, 172, 14);
		nomogramPanel.add(lblNewLabel_16);

		JLabel lblNewLabel_17 = new JLabel("Test sensitivity");
		lblNewLabel_17.setBounds(146, 161, 172, 14);
		nomogramPanel.add(lblNewLabel_17);

		JLabel lblNewLabel_18 = new JLabel("Test specificity");
		lblNewLabel_18.setBounds(146, 186, 172, 14);
		nomogramPanel.add(lblNewLabel_18);

		txtPreTest = new JTextField();
		txtPreTest.setBounds(365, 133, 86, 20);
		nomogramPanel.add(txtPreTest);
		txtPreTest.setColumns(10);

		txtTestSen = new JTextField();
		txtTestSen.setBounds(365, 158, 86, 20);
		nomogramPanel.add(txtTestSen);
		txtTestSen.setColumns(10);

		txtTestSpec = new JTextField();
		txtTestSpec.setBounds(365, 183, 86, 20);
		nomogramPanel.add(txtTestSpec);
		txtTestSpec.setColumns(10);

		String[] outcome = { "Negative", "Positive" };
		JComboBox cbNomogram = new JComboBox(outcome);
		cbNomogram.setBounds(365, 242, 86, 20);
		nomogramPanel.add(cbNomogram);

		JLabel lblLikelihood = new JLabel();
		lblLikelihood.setBounds(146, 273, 280, 14);
		nomogramPanel.add(lblLikelihood);

		JLabel lblPostTest = new JLabel();
		lblPostTest.setBounds(146, 308, 280, 14);
		nomogramPanel.add(lblPostTest);

		JButton btnNomogramResult = new JButton("Result");
		btnNomogramResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReqNomogramDto t = new ReqNomogramDto(Double.parseDouble(txtPreTest.getText()), bg.getButtonCount(),
						Double.parseDouble(txtTestSen.getText()), Double.parseDouble(txtTestSpec.getText()),
						cbNomogram.getSelectedIndex());
				NomogramService nomogramService = new NomogramService();
				lblLikelihood.setText(nomogramService.calculate(t).getLikelihoodValue());
				lblPostTest.setText(nomogramService.calculate(t).getPostTestValue());
			}
		});
		btnNomogramResult.setBounds(257, 211, 89, 23);
		nomogramPanel.add(btnNomogramResult);

		JLabel lblNewLabel_19 = new JLabel("Outcome:");
		lblNewLabel_19.setBounds(146, 245, 79, 14);
		nomogramPanel.add(lblNewLabel_19);

		JLabel lblNewLabel_22 = new JLabel("Nomogram");
		lblNewLabel_22.setBounds(237, 20, 120, 30);
		lblNewLabel_22.setFont(new Font("Time New Roman", Font.BOLD, 20));
		lblNewLabel_22.setForeground(Color.BLUE);
		nomogramPanel.add(lblNewLabel_22);

		// Estimate prevalence Panel

		JPanel estimatePrevalencePanel = new JPanel();
		tabbedPane_1.addTab("Estimate Prevalence", null, estimatePrevalencePanel, null);
		estimatePrevalencePanel.setLayout(null);

		JLabel lblNewLabel_23 = new JLabel("Estimate Prevalence");
		lblNewLabel_23.setBounds(200, 20, 200, 30);
		lblNewLabel_23.setFont(new Font("Time New Roman", Font.BOLD, 20));
		lblNewLabel_23.setForeground(Color.BLUE);
		estimatePrevalencePanel.add(lblNewLabel_23);

		JLabel lblNewLabel_24 = new JLabel("Est.pop.prevalence");
		lblNewLabel_24.setBounds(24, 91, 243, 14);
		estimatePrevalencePanel.add(lblNewLabel_24);

		JLabel lblNewLabel_25 = new JLabel("Max absolute diff between sample\r\n estimate and pop.prevalence");
		lblNewLabel_25.setBounds(24, 116, 459, 14);
		estimatePrevalencePanel.add(lblNewLabel_25);

		JLabel lblNewLabel_26 = new JLabel("Are study units aggregated into cluster?");
		lblNewLabel_26.setBounds(24, 141, 243, 14);
		estimatePrevalencePanel.add(lblNewLabel_26);

		JLabel lblNewLabel_27 = new JLabel("Level of confidence");
		lblNewLabel_27.setBounds(24, 166, 243, 14);
		estimatePrevalencePanel.add(lblNewLabel_27);

//		Double[] levelOfConfidence = { 0.95, 0.9, 0.85 };
		JComboBox comboBox_4 = new JComboBox(confidenceIntervals);
		comboBox_4.setBounds(493, 163, 71, 20);
		estimatePrevalencePanel.add(comboBox_4);

		txtPopulationV = new JTextField();
		txtPopulationV.setBounds(493, 88, 71, 20);
		estimatePrevalencePanel.add(txtPopulationV);
		txtPopulationV.setColumns(10);

		txtMaximumPreV = new JTextField();
		txtMaximumPreV.setBounds(493, 113, 71, 20);
		estimatePrevalencePanel.add(txtMaximumPreV);
		txtMaximumPreV.setColumns(10);

		JLabel lblEPResult = new JLabel("");
		lblEPResult.setBounds(30, 292, 534, 52);
		estimatePrevalencePanel.add(lblEPResult);

		JLabel lblNewLabel_8 = new JLabel("RHO");
		lblNewLabel_8.setBounds(24, 191, 46, 14);
		estimatePrevalencePanel.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Average cluster size");
		lblNewLabel_9.setBounds(24, 216, 323, 14);
		estimatePrevalencePanel.add(lblNewLabel_9);

		txtRhoV = new JTextField();
		txtRhoV.setBounds(493, 188, 71, 20);
		estimatePrevalencePanel.add(txtRhoV);
		txtRhoV.setColumns(10);

		txtAveClusterSizeV = new JTextField();
		txtAveClusterSizeV.setBounds(493, 213, 71, 20);
		estimatePrevalencePanel.add(txtAveClusterSizeV);
		txtAveClusterSizeV.setColumns(10);

		String[] cluster = { "No", "Yes" };
		JComboBox cbCluster = new JComboBox(cluster);
		cbCluster.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (cbCluster.getSelectedIndex() == 1) {
					lblNewLabel_8.setVisible(false);
					lblNewLabel_9.setVisible(false);
					txtRhoV.setVisible(false);
					txtAveClusterSizeV.setVisible(false);
				} else {
					lblNewLabel_8.setVisible(true);
					lblNewLabel_9.setVisible(true);
					txtRhoV.setVisible(true);
					txtAveClusterSizeV.setVisible(true);
				}
			}
		});
		cbCluster.setBounds(493, 138, 71, 20);
		estimatePrevalencePanel.add(cbCluster);

		JButton btnNewButton_1 = new JButton("Result");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReqSamplingEstimatePrevalenceDto t = new ReqSamplingEstimatePrevalenceDto();
				if (cbCluster.getSelectedIndex() == 0) {
					t = new ReqSamplingEstimatePrevalenceDto(
							Double.parseDouble(String.valueOf(comboBox_4.getSelectedItem())),
							comboBox_4.getSelectedIndex(), cbCluster.getSelectedIndex(),
							Double.parseDouble(txtPopulationV.getText()), Double.parseDouble(txtMaximumPreV.getText()),
							Double.parseDouble(txtRhoV.getText()), Double.parseDouble(txtAveClusterSizeV.getText()));
				} else {
					t = new ReqSamplingEstimatePrevalenceDto(
							Double.parseDouble(String.valueOf(comboBox_4.getSelectedItem())),
							comboBox_4.getSelectedIndex(), cbCluster.getSelectedIndex(),
							Double.parseDouble(txtPopulationV.getText()), Double.parseDouble(txtMaximumPreV.getText()),
							100.0, 100.0);
				}

				SamplingEstimatePrevalenceService seps = new SamplingEstimatePrevalenceService();

				try {
					lblEPResult.setText("<html>" + seps.calculate(t).getResult1() + " "
							+ seps.calculate(t).getResultValue() + "</html>");
				} catch (CalculateException e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(243, 250, 89, 23);
		estimatePrevalencePanel.add(btnNewButton_1);

		// Estimate A Mean Panel

		JPanel estimateAMeanPanel = new JPanel();
		tabbedPane_1.addTab("Estimate a mean", null, estimateAMeanPanel, null);
		estimateAMeanPanel.setLayout(null);

		JLabel lblNewLabel_28 = new JLabel("Estemate a mean");
		lblNewLabel_28.setBounds(196, 20, 188, 30);
		lblNewLabel_28.setFont(new Font("Time New Roman", Font.BOLD, 20));
		lblNewLabel_28.setForeground(Color.BLUE);
		estimateAMeanPanel.add(lblNewLabel_28);

		JLabel lblNewLabel_29 = new JLabel("Standard deviation of variable of interest:");
		lblNewLabel_29.setBounds(10, 66, 299, 14);
		estimateAMeanPanel.add(lblNewLabel_29);

		JLabel lblNewLabel_30 = new JLabel("Maximun absolute difference between sample estimate and population mean:");
		lblNewLabel_30.setBounds(10, 102, 449, 14);
		estimateAMeanPanel.add(lblNewLabel_30);

		JLabel lblNewLabel_31 = new JLabel("Level of confidence:");
		lblNewLabel_31.setBounds(10, 141, 215, 14);
		estimateAMeanPanel.add(lblNewLabel_31);

		JComboBox comboBox_5 = new JComboBox(confidenceIntervals);
		comboBox_5.setBounds(479, 138, 66, 20);
		estimateAMeanPanel.add(comboBox_5);

		txtMaximunV = new JTextField();
		txtMaximunV.setBounds(479, 99, 66, 20);
		estimateAMeanPanel.add(txtMaximunV);
		txtMaximunV.setColumns(10);

		txtStandardV = new JTextField();
		txtStandardV.setBounds(479, 63, 66, 20);
		estimateAMeanPanel.add(txtStandardV);
		txtStandardV.setColumns(10);

		JLabel lblEAMResult = new JLabel("");
		lblEAMResult.setBounds(10, 258, 535, 54);
		estimateAMeanPanel.add(lblEAMResult);

		JButton btnNewButton_2 = new JButton("Result");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReqSamplingEstimateMeanDto t = new ReqSamplingEstimateMeanDto(
						Double.parseDouble(txtStandardV.getText()), Double.parseDouble(txtMaximunV.getText()),
						String.valueOf(comboBox_5.getSelectedItem()), String.valueOf(comboBox_5.getSelectedIndex()));
				SamplingEstimateMeanService sems = new SamplingEstimateMeanService();
				try {
					lblEAMResult.setText("<html>" + sems.calculate(t).getResult1() + sems.calculate(t).getResult1Value()
							+ "</html>");
				} catch (CalculateException e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(222, 192, 89, 23);
		estimateAMeanPanel.add(btnNewButton_2);

		// Detect Disease Pannel

		JPanel detectDiseasePanel = new JPanel();
		tabbedPane_1.addTab("Detect disease", null, detectDiseasePanel, null);
		detectDiseasePanel.setLayout(null);

		JLabel lblNewLabel_32 = new JLabel("Detect disease");
		lblNewLabel_32.setBounds(200, 20, 241, 30);
		lblNewLabel_32.setFont(new Font("Time New Roman", Font.BOLD, 20));
		lblNewLabel_32.setForeground(Color.BLUE);
		detectDiseasePanel.add(lblNewLabel_32);

		JLabel lblNewLabel_33 = new JLabel("Exp prevalence (0 to 1)");
		lblNewLabel_33.setBounds(135, 71, 172, 14);
		detectDiseasePanel.add(lblNewLabel_33);

		JLabel lblNewLabel_34 = new JLabel("Population size");
		lblNewLabel_34.setBounds(135, 96, 172, 14);
		detectDiseasePanel.add(lblNewLabel_34);

		JLabel lblNewLabel_35 = new JLabel("Level of confidence");
		lblNewLabel_35.setBounds(135, 121, 172, 14);
		detectDiseasePanel.add(lblNewLabel_35);

		JLabel lblNewLabel_36 = new JLabel("Test sensitivity (0 to 1)");
		lblNewLabel_36.setBounds(135, 146, 172, 14);
		detectDiseasePanel.add(lblNewLabel_36);

		JLabel lblNewLabel_37 = new JLabel("Test specificity (0 to 1)");
		lblNewLabel_37.setBounds(135, 171, 172, 14);
		detectDiseasePanel.add(lblNewLabel_37);

		JLabel lblNewLabel_38 = new JLabel("Finite Correction");
		lblNewLabel_38.setBounds(135, 196, 172, 14);
		detectDiseasePanel.add(lblNewLabel_38);

		txtExpectPrevalence = new JTextField();
		txtExpectPrevalence.setBounds(355, 68, 86, 20);
		detectDiseasePanel.add(txtExpectPrevalence);
		txtExpectPrevalence.setColumns(10);

		txtPopuSize = new JTextField();
		txtPopuSize.setBounds(355, 93, 86, 20);
		detectDiseasePanel.add(txtPopuSize);
		txtPopuSize.setColumns(10);

		txtConInterval = new JTextField();
		txtConInterval.setBounds(355, 118, 86, 20);
		detectDiseasePanel.add(txtConInterval);
		txtConInterval.setColumns(10);

		txtTestSensitivity = new JTextField();
		txtTestSensitivity.setBounds(355, 143, 86, 20);
		detectDiseasePanel.add(txtTestSensitivity);
		txtTestSensitivity.setColumns(10);

		txtTestSpecificity = new JTextField();
		txtTestSpecificity.setBounds(355, 168, 86, 20);
		detectDiseasePanel.add(txtTestSpecificity);
		txtTestSpecificity.setColumns(10);

		JComboBox cbFiniteCorrectionPos = new JComboBox(cluster);
		cbFiniteCorrectionPos.setBounds(355, 193, 86, 20);
		detectDiseasePanel.add(cbFiniteCorrectionPos);

		JButton btnNewButton_3 = new JButton("Result");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReqSaplingDetectDiseaseDto t = new ReqSaplingDetectDiseaseDto(
						Double.parseDouble(txtExpectPrevalence.getText()),
						Double.parseDouble(txtTestSensitivity.getText()), Double.parseDouble(txtConInterval.getText()),
						Double.parseDouble(txtTestSpecificity.getText()), Double.parseDouble(txtPopuSize.getText()),
						cbFiniteCorrectionPos.getSelectedIndex());
				SaplingDetectDiseaseService sdds = new SaplingDetectDiseaseService();
				
			}
		});
		btnNewButton_3.setBounds(224, 223, 120, 91);
		btnNewButton_3.setIcon(new ImageIcon("D:\\My project\\Swing\\src\\image\\icons8-frequency-64.png"));
		btnNewButton_3.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_3.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_3.setBorderPainted(false); 
		btnNewButton_3.setContentAreaFilled(false); 
//		btnNewButton_3.setFocusPainted(false); 
		btnNewButton_3.setOpaque(false);
		detectDiseasePanel.add(btnNewButton_3);
		
		JLabel lblDDResult = new JLabel("");
		lblDDResult.setBounds(50, 256, 480, 50);
		detectDiseasePanel.add(lblDDResult);

		// Two By Two Table

		JPanel diseaseFrequencyPanel = new JPanel();
		tabbedPane_1.addTab("Disease frequency", null, diseaseFrequencyPanel, null);
		diseaseFrequencyPanel.setLayout(null);

		JLabel lblNewLabel_39 = new JLabel("Disease frequency");
		lblNewLabel_39.setBounds(187, 20, 307, 30);
		lblNewLabel_39.setFont(new Font("Time New Roman", Font.BOLD, 20));
		lblNewLabel_39.setForeground(Color.BLUE);
		diseaseFrequencyPanel.add(lblNewLabel_39);

		JLabel lblNewLabel_40 = new JLabel("Number of event:");
		lblNewLabel_40.setBounds(135, 71, 113, 14);
		diseaseFrequencyPanel.add(lblNewLabel_40);

		JLabel lblNewLabel_41 = new JLabel("Population at risk");
		lblNewLabel_41.setBounds(135, 96, 113, 14);
		diseaseFrequencyPanel.add(lblNewLabel_41);

		JLabel lblNewLabel_42 = new JLabel("Multiplier");
		lblNewLabel_42.setBounds(135, 121, 113, 14);
		diseaseFrequencyPanel.add(lblNewLabel_42);

		JLabel lblNewLabel_43 = new JLabel("Confidence interval");
		lblNewLabel_43.setBounds(135, 146, 113, 14);
		diseaseFrequencyPanel.add(lblNewLabel_43);

		textField_30 = new JTextField();
		textField_30.setBounds(329, 68, 86, 20);
		diseaseFrequencyPanel.add(textField_30);
		textField_30.setColumns(10);

		textField_31 = new JTextField();
		textField_31.setBounds(329, 93, 86, 20);
		diseaseFrequencyPanel.add(textField_31);
		textField_31.setColumns(10);

		textField_32 = new JTextField();
		textField_32.setBounds(329, 118, 86, 20);
		diseaseFrequencyPanel.add(textField_32);
		textField_32.setColumns(10);

		JComboBox comboBox_7 = new JComboBox(confidenceIntervals);
		comboBox_7.setBounds(329, 143, 86, 20);
		diseaseFrequencyPanel.add(comboBox_7);

		JButton btnNewButton_4 = new JButton("Result");
		btnNewButton_4.setBounds(214, 186, 89, 23);
		diseaseFrequencyPanel.add(btnNewButton_4);

		JLabel lblNewLabel_44 = new JLabel("Type:");
		lblNewLabel_44.setBounds(135, 223, 46, 14);
		diseaseFrequencyPanel.add(lblNewLabel_44);

		JComboBox comboBox_8 = new JComboBox(Types);
		comboBox_8.setBounds(329, 220, 86, 20);
		diseaseFrequencyPanel.add(comboBox_8);

		//

		JPanel twoByTwoTablePanel = new JPanel();
		tabbedPane_1.addTab("Two by two Table", null, twoByTwoTablePanel, null);
		twoByTwoTablePanel.setLayout(null);

		JLabel lblNewLabel_45 = new JLabel("Two By Two Table");
		lblNewLabel_45.setBounds(199, 20, 382, 30);
		lblNewLabel_45.setFont(new Font("Time New Roman", Font.BOLD, 20));
		lblNewLabel_45.setForeground(Color.BLUE);
		twoByTwoTablePanel.add(lblNewLabel_45);

//		JLabel lblNewLabel_46 = new JLabel("Dis+");
//		lblNewLabel_46.setBounds(138, 81, 22, 14);
//		lblNewLabel.setBounds(150, 65, 46, 14);
//		twoByTwoTablePanel.add(lblNewLabel_46);
//		
//		JLabel lblNewLabel_47 = new JLabel("Dis-");
//		lblNewLabel_47.setBounds(234, 81, 18, 14);
//		lblNewLabel_1.setBounds(211, 65, 46, 14);
//		twoByTwoTablePanel.add(lblNewLabel_47);
//		
//		JLabel lblNewLabel_48 = new JLabel("Total");
//		lblNewLabel_48.setBounds(73, 159, 24, 14);
//		lblNewLabel_2.setBounds(272, 65, 46, 14);
//		twoByTwoTablePanel.add(lblNewLabel_48);
//		
//		JLabel lblNewLabel_49 = new JLabel("Test+");
//		lblNewLabel_49.setBounds(73, 109, 29, 14);
//		lblNewLabel_3.setBounds(95, 90, 46, 14);
//		twoByTwoTablePanel.add(lblNewLabel_49);
//		
//		JLabel lblNewLabel_50 = new JLabel("Test-");
//		lblNewLabel_50.setBounds(73, 134, 25, 14);
//		lblNewLabel_4.setBounds(95, 120, 46, 14);
//		twoByTwoTablePanel.add(lblNewLabel_50);
//		
//		JLabel lblNewLabel_51 = new JLabel("Total");
//		lblNewLabel_51.setBounds(330, 81, 24, 14);
//		lblNewLabel_5.setBounds(95, 150, 46, 14);
//		twoByTwoTablePanel.add(lblNewLabel_51);
//		
		textField_1_1 = new JTextField();
		textField_1_1.setBounds(107, 106, 86, 20);
		twoByTwoTablePanel.add(textField_1_1);
		textField_1_1.setColumns(10);

		textField_2_1 = new JTextField();
		textField_2_1.setBounds(205, 106, 86, 20);
		twoByTwoTablePanel.add(textField_2_1);
		textField_2_1.setColumns(10);

		textField_3_1 = new JTextField();
		textField_3_1.setBounds(301, 106, 86, 20);
		twoByTwoTablePanel.add(textField_3_1);
		textField_3_1.setColumns(10);

		textField_4_1 = new JTextField();
		textField_4_1.setBounds(108, 131, 86, 20);
		twoByTwoTablePanel.add(textField_4_1);
		textField_4_1.setColumns(10);

		textField_5_1 = new JTextField();
		textField_5_1.setBounds(205, 131, 86, 20);
		twoByTwoTablePanel.add(textField_5_1);
		textField_5_1.setColumns(10);

		textField_6_1 = new JTextField();
		textField_6_1.setBounds(301, 131, 86, 20);
		twoByTwoTablePanel.add(textField_6_1);
		textField_6_1.setColumns(10);

		textField_7_1 = new JTextField();
		textField_7_1.setBounds(107, 156, 86, 20);
		twoByTwoTablePanel.add(textField_7_1);
		textField_7_1.setColumns(10);

		textField_8_1 = new JTextField();
		textField_8_1.setBounds(205, 156, 86, 20);
		twoByTwoTablePanel.add(textField_8_1);
		textField_8_1.setColumns(10);

//		JLabel lblNewLabel_52 = new JLabel("Confidence interval:");
//		lblNewLabel_52.setBounds(73, 184, 97, 14);
//		lblNewLabel_6.setBounds(95, 180, 145, 14);
//		twoByTwoTablePanel.add(lblNewLabel_52);

//		JComboBox comboBox_9 = new JComboBox(confidenceIntervals);
//		comboBox_9.setBounds(340, 187, 47, 20);
//		twoByTwoTablePanel.add(comboBox_9);

		JButton btnResult_1 = new JButton("Result");
		btnResult_1.setBounds(199, 208, 63, 23);
		twoByTwoTablePanel.add(btnResult_1);

		JLabel lblNewLabel_53 = new JLabel("Type:");
		lblNewLabel_53.setBounds(73, 254, 28, 14);
		twoByTwoTablePanel.add(lblNewLabel_53);

//		JComboBox comboBox_10 = new JComboBox(Types);
//		comboBox_10.setBounds(199, 251, 74, 20);
//		twoByTwoTablePanel.add(comboBox_10);
//		
		JLabel lblNewLabel_54 = new JLabel("Att frac in exposed");
		lblNewLabel_54.setBounds(73, 282, 105, 14);
		twoByTwoTablePanel.add(lblNewLabel_54);

		textField_9_1 = new JTextField();
		textField_9_1.setBounds(301, 156, 86, 20);
		twoByTwoTablePanel.add(textField_9_1);
		textField_9_1.setColumns(10);

		JLabel lblNewLabel_55 = new JLabel("Type of analysis");
		lblNewLabel_55.setBounds(105, 194, 120, 14);
		twoByTwoTablePanel.add(lblNewLabel_55);

		textField_10_1 = new JTextField();
		textField_10_1.setBounds(199, 279, 86, 20);
		twoByTwoTablePanel.add(textField_10_1);
		textField_10_1.setColumns(10);

		String[] typeOfanalysis = { "Cohort count", "Cohort time", "Cross sectional", "Case-control" };
		JComboBox cbTypeOfAnalysis = new JComboBox(typeOfanalysis);
		cbTypeOfAnalysis.setBounds(295, 191, 92, 20);
		twoByTwoTablePanel.add(cbTypeOfAnalysis);

		//

		JPanel glossaryPanel = new JPanel();
		tabbedPane.addTab("Glossary", null, glossaryPanel, null);
		glossaryPanel.setLayout(null);

		JPanel infoPanel = new JPanel();
		tabbedPane.addTab("Info", null, infoPanel, null);

		JPanel FilePanel = new JPanel();
		tabbedPane.addTab("File", null, FilePanel, null);

	}

	public static boolean isDouble(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
