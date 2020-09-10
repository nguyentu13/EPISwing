package service;

import dto.request.ReqDiagnosticTestDto;
import dto.respone.RespDiagnosticTestDto;
import exception.CalculateException;

public class DiagnosticTestService {

    double z = 1.96;
    double CI = 95;

    // Apparent prevalence
    double Ap = 0;
    double ApLow = 0;
    double ApUp = 0;

    // True prevalence
    double Tp = 0;
    double TpLow = 0;
    double TpUp = 0;

    // Sensitivity
    double Se = 0;
    double SeLow = 0;
    double SeUp = 0;

    // Sensitivity
    double Sp = 0;
    double SpLow = 0;
    double SpUp = 0;

    // Positive predictive value
    double Ppv = 0;
    double PpvLow = 0;
    double PpvUp = 0;

    // Negative predictive value
    double Npv = 0;
    double NpvLow = 0;
    double NpvUp = 0;

    // Likelihood ratio of a positive test
    double Plv = 0;
    double PlvLow = 0;
    double PlvUp = 0;

    // Likelihood ratio of a negative test
    double Nlv = 0;
    double NlvLow = 0;
    double NlvUp = 0;

    private static String apparent_prevalence = "Apparent prevalence:",
            true_prevalence = "True prevalence:",
            sensitivity = "Sensitivity:",
            specificity = "Specificity:",
            positive_PV = "Positive PV:",
            negative_PV = "Negative PV:",
            positive_LR = "Positive LR",
            negative_LR = "Negative LR:";

    public RespDiagnosticTestDto calculate(ReqDiagnosticTestDto t) throws CalculateException {
//        if (validate(t) != null)
//            return validate(t);
        return doCalculation(t);
    }

//    public ResponseEntity<Object> validate(ReqDiagnosticTestDto t) {
//
//        Double a = t.getA();
//        Double b = t.getB();
//        Double c = t.getC();
//        Double d = t.getD();
//
//        if (a == null && b == null && c == null && d == null) {
//            return this.responseError(new CalculateException(11));
//        }
//        return null;
//    }
//
    public double genZ(int selectedIntervalIndex) {
        switch (selectedIntervalIndex) {
            case 0:
                z = 1.64;
                break;
            case 1:
                z = 1.96;
                break;
            case 2:
                z = 2.58;
                break;
        }
        return z;
    }

    protected RespDiagnosticTestDto doCalculation(ReqDiagnosticTestDto t) {
        z = genZ(t.getSelectedIntervalIndex());
        double a = t.getA();
        double b = t.getB();
        double c = t.getC();
        double d = t.getD();


        double tplus = a + b;
        double tminus = c + d;
        double dplus = a + c;
        double dminus = b + d;
        double n = a + b + c + d;

        //Apparent prevalence
        double r = tplus;
        double n_c = n;
        double p = r / n_c;
        double q = 1 - p;
        double A = (2 * r) + (z * z);
        double B = z * Math.sqrt((z * z) + (4 * r * q));
        double C = 2 * (n_c + (z * z));
        Ap = p;
        ApLow = (A - B) / C;
        ApUp = (A + B) / C;

        //True prevalence
        r = dplus;
        n_c = n;
        p = r / n_c;
        q = 1 - p;
        A = (2 * r) + (z * z);
        B = z * Math.sqrt((z * z) + (4 * r * q));
        C = 2 * (n_c + (z * z));
        Tp = p;
        TpLow = (A - B) / C;
        TpUp = (A + B) / C;

        //Sensitivity
        r = a;
        n_c = dplus;
        p = r / n_c;
        q = 1 - p;
        A = (2 * r) + (z * z);
        B = z * Math.sqrt((z * z) + (4 * r * q));
        C = 2 * (n_c + (z * z));
        Se = p;
        SeLow = (A - B) / C;
        SeUp = (A + B) / C;

        //Specificity
        r = d;
        n_c = dminus;
        p = r / n_c;
        q = 1 - p;
        A = (2 * r) + (z * z);
        B = z * Math.sqrt((z * z) + (4 * r * q));
        C = 2 * (n_c + (z * z));
        Sp = p;
        SpLow = (A - B) / C;
        SpUp = (A + B) / C;

        //Positive predictive value
        r = a;
        n_c = tplus;
        p = r / n_c;
        q = 1 - p;
        A = (2 * r) + (z * z);
        B = z * Math.sqrt((z * z) + (4 * r * q));
        C = 2 * (n_c + (z * z));
        Ppv = p;
        PpvLow = (A - B) / C;
        PpvUp = (A + B) / C;

        //Negative predictive value
        r = d;
        n_c = tminus;
        p = r / n_c;
        q = 1 - p;
        A = (2 * r) + (z * z);
        B = z * Math.sqrt((z * z) + (4 * r * q));
        C = 2 * (n_c + (z * z));
        Npv = p;
        NpvLow = (A - B) / C;
        NpvUp = (A + B) / C;

        //Likelihood ratio of a positive test
        Plv = (a / dplus) / (1 - (d / dminus));
        PlvLow = Math.exp(Math.log(Plv) - z * Math.sqrt((1 - Se) / (tplus * Se) + (Sp) / (tminus * (1 - Sp))));
        PlvUp = Math.exp(Math.log(Plv) + z * Math.sqrt((1 - Se) / (tplus * Se) + (Sp) / (tminus * (1 - Sp))));

        //Likelihood ratio of a negative test
        Nlv = (1 - (a / dplus)) / (d / dminus);
        NlvLow = Math.exp(Math.log(Nlv) - z * Math.sqrt((Se) / (tplus * (1 - Se)) + (1 - Sp) / (tminus * (Sp))));
        NlvUp = Math.exp(Math.log(Nlv) + z * Math.sqrt((Se) / (tplus * (1 - Se)) + (1 - Sp) / (tminus * (Sp))));

        return viewResult(t);


    }

    private RespDiagnosticTestDto viewResult(ReqDiagnosticTestDto t) {
        String result1 = "", result1Value = "", result2 = "", result2Value = "";
        CI = t.getSelectedIntervalValue() * 100;


        switch (t.getSelectedDiagnosticTypeIndex()) {
            case 0:
                //Apparent prevalence

                result1 = (apparent_prevalence + "");
                result1Value = (roundNum(Ap, 2) + " ("
                        + Math.round(CI) + "% CI "
                        + roundNum(ApLow, 2) + " to "
                        + roundNum(ApUp, 2) + ")");
                result2 = (true_prevalence + "");
                result2Value = (roundNum(Tp, 2) + " ("
                        + Math.round(CI) + "% CI "
                        + roundNum(TpLow, 2) + " to "
                        + roundNum(TpUp, 2) + ")");
                break;
            case 1: //Sensitivity - specificity
                result1 = (sensitivity + "");
                result1Value = (roundNum(Se, 2) + " ("
                        + Math.round(CI) + "% CI "
                        + roundNum(SeLow, 2) + " to "
                        + roundNum(SeUp, 2) + ")");
                result2 = (specificity + "");
                result2Value = (roundNum(Sp, 2) + " ("
                        + Math.round(CI) + "% CI "
                        + roundNum(SpLow, 2) + " to "
                        + roundNum(SpUp, 2) + ")");
                break;
            case 2: // Positive and negative predictive value

                result1 = (positive_PV + "");
                result1Value = (roundNum(Ppv, 2) + " ("
                        + Math.round(CI) + "% CI "
                        + roundNum(PpvLow, 2) + " to "
                        + roundNum(PpvUp, 2) + ")");
                result2 = (negative_PV + "");
                result2Value = (roundNum(Npv, 2) + " ("
                        + Math.round(CI) + "% CI "
                        + roundNum(NpvLow, 2) + " to "
                        + roundNum(NpvUp, 2) + ")");

                break;
            default: // Positive and negative likelihood ratio
                result1 = (positive_LR + "");
                result1Value = (roundNum(Plv, 2) + " ("
                        + Math.round(CI) + "% CI "
                        + roundNum(PlvLow, 2) + " to "
                        + roundNum(PlvUp, 2) + ")");
                result2 = (negative_LR + "");
                result2Value = (roundNum(Nlv, 2) + " ("
                        + Math.round(CI) + "% CI "
                        + roundNum(NlvLow, 2) + " to "
                        + roundNum(NlvUp, 2) + ")");
                break;
        }
        return new RespDiagnosticTestDto(result1, result1Value, result2, result2Value);
    }

    public double roundNum(double theNumber, int decPlaces) {
        double returnV = 0;
        if (decPlaces >= 0) {
            double temp = Math.pow(10, decPlaces);
            returnV = Math.round(theNumber * temp) / temp;
        }
        return returnV;
    }
}
