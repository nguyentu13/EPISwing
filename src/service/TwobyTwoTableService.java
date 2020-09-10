package service;

import dto.request.ReqTwobyTwoTableDto;
import dto.respone.RespTwobyTwoTableDto;
import dto.respone.Result;
import exception.CalculateException;

public class TwobyTwoTableService {

    //Incidence rate ratio:
    private double IRRp = 0;
    private double IRRl = 0;
    private double IRRu = 0;
    //Odds ratio:
    private double ORp = 0;
    private double ORl = 0;
    private double ORu = 0;

    //Attributable risk-prevalence (Rothman p 135 equation 7-2):
    private double ARiskp = 0;
    private double ARiskl = 0;
    private double ARisku = 0;


    //Attributable rate (Rothman p 137 equation 7-4):
    private double Aratep = 0;
    private double Aratel = 0;
    private double Arateu = 0;


    //Attributable risk-prevalence in population (same as Rothman p 135 equation 7-2):
    private double PARiskp = 0;
    private double PARiskl = 0;
    private double PARisku = 0;


    //Attributable rate in population (same as Rothman p 137 equation 7-4):
    private double PARatep = 0;
    private double PARatel = 0;
    private double PARateu = 0;


    //Attributable fraction in exposed for risk-prevalence data (from Hanley 2001):
    private double AFRiskp = 0;
    private double AFRiskl = 0;
    private double AFRisku = 0;


    //Attributable fraction in exposed for rate data (from Hanley 2001):
    private double AFRatep = 0;
    private double AFRatel = 0;
    private double AFRateu = 0;


    //Attributable fraction (estimated) in exposed (from Hanley 2001):
    private double Afestp = 0;
    private double Afestl = 0;
    private double Afestu = 0;

    //Attributable fraction in population for risk-prevalence data (from Jewell, page 84):
    private double PAFRiskp = 0;
    private double PAFRiskl = 0;
    private double PAFRisku = 0;


    //Attributable fraction in population for rate data (from OpenEpi TwobyTwo - Jewell doesn't provide a method for rate data):
    private double PAFRatep = 0;
    private double PAFRatel = 0;
    private double PAFRateu = 0;


    //Attributable fraction (exposed) in population (from Jewell, page 84):
    private double PAFestp = 0;
    private double PAFestl = 0;
    private double PAFestu = 0;

    double CI = 95;
    double RRl = 0;
    double RRu = 0;
    double RRp = 0;

    public static final String toText = "to";

    public RespTwobyTwoTableDto calculate(ReqTwobyTwoTableDto t) throws CalculateException {
//        if (validate(t) != null)
//            return this.validate(t);
        return doCalculation(t);
    }


//    public ResponseEntity<Object> validate(ReqTwobyTwoTableDto t) {
//        Double aVal = t.getAval();
//        Double bVal = t.getAval();
//        Double cVal = t.getAval();
//        Double dVal = t.getAval();
//        Double multiplierVal = t.getMultiplierVal();
//        if (aVal != null ||
//                bVal != null ||
//                cVal != null ||
//                dVal != null ||
//                multiplierVal != null
//        ) return this.responseError(new CalculateException(11));
//        return null;
//    }

    private double genZVal(int pos) {
        double zValue;
        switch (pos) {
            case 0:
                zValue = 1.64;
                break;
            case 1:
                zValue = 1.96;
                break;
            default:
                zValue = 2.58;
                break;
        }
        return zValue;
    }

    protected RespTwobyTwoTableDto doCalculation(ReqTwobyTwoTableDto t) {

        Double a = t.getAval();
        Double b = t.getBval();
        Double c = t.getCval();
        Double d = t.getDval();
        Double multiplierVal = t.getMultiplierVal();
        Double n = 0d;

        double zValue = genZVal(t.getSelectedIntervalIndex());
        double CI = t.getSelectedIntervalValue() == null ? 95 : t.getSelectedIntervalValue() * 100;

        double eplus = a + b;
        double eminus = c + d;
        double dplus = a + c;
        double dminus = b + d;
        n = a + b + c + d;

        //Incidence risk ratio:
        RRp = (a / eplus) / (c / eminus);
        double lnRR = Math.log(RRp);
        double lnRRse = Math.sqrt((1 / a) - (1 / eplus) + (1 / c) - (1 / eminus));
        double lnRRl = lnRR - (zValue * lnRRse);
        double lnRRu = lnRR + (zValue * lnRRse);
        RRl = Math.exp(lnRRl);
        RRu = Math.exp(lnRRu);


        //Incidence rate ratio:
        IRRp = (a / b) / (c / d);
        double lnIRR = Math.log(IRRp);
        double lnIRRse = Math.sqrt((1 / a) + (1 / c));
        double lnIRRl = lnIRR - (zValue * lnIRRse);
        double lnIRRu = lnIRR + (zValue * lnIRRse);
        IRRl = Math.exp(lnIRRl);
        IRRu = Math.exp(lnIRRu);


        //Odds ratio:
        ORp = (a * d) / (b * c);
        double lnOR = Math.log(ORp);
        double lnORse = Math.sqrt(1 / a + 1 / b + 1 / c + 1 / d);
        double lnORl = lnOR - (zValue * lnORse);
        double lnORu = lnOR + (zValue * lnORse);
        ORl = Math.exp(lnORl);
        ORu = Math.exp(lnORu);


        //Attributable risk-prevalence (Rothman p 135 equation 7-2):
        ARiskp = ((a / eplus) - (c / eminus)) * multiplierVal;
        double ARiskse = Math.sqrt(((a * (eplus - a)) / Math.pow(eplus, 3)) + ((c * (eminus - c)) / Math.pow(eminus, 3))) * multiplierVal;
        ARiskl = ARiskp - (zValue * ARiskse);
        ARisku = ARiskp + (zValue * ARiskse);


        //Attributable rate (Rothman p 137 equation 7-4):
        Aratep = ((a / b) - (c / d)) * multiplierVal;
        double Aratedouble = (a / Math.pow(b, 2)) + (c / Math.pow(d, 2));
        double Aratese = Math.sqrt(Aratedouble) * multiplierVal;
        Aratel = Aratep - (zValue * Aratese);
        Arateu = Aratep + (zValue * Aratese);


        //Attributable risk-prevalence in population (same as Rothman p 135 equation 7-2):
        PARiskp = ((dplus / n) - (c / eminus)) * multiplierVal;
        double PARiskse = Math.sqrt(((dplus * (n - dplus)) / Math.pow(n, 3)) + ((c * (eminus - c)) / Math.pow(eminus, 3))) * multiplierVal;
        PARiskl = PARiskp - (zValue * PARiskse);
        PARisku = PARiskp + (zValue * PARiskse);


        //Attributable rate in population (same as Rothman p 137 equation 7-4):
        PARatep = ((dplus / dminus) - (c / d)) * multiplierVal;
        double PAratese = (Math.sqrt((dplus / Math.pow(dminus, 2)) + (c / Math.pow(d, 2)))) * multiplierVal;
        PARatel = PARatep - (zValue * PAratese);
        PARateu = PARatep + (zValue * PAratese);


        //Attributable fraction in exposed for risk-prevalence data (from Hanley 2001):
        AFRiskp = ((RRp - 1) / RRp);
        AFRiskl = Math.min(((RRl - 1) / RRl), ((RRu - 1) / RRu));
        AFRisku = Math.max(((RRl - 1) / RRl), ((RRu - 1) / RRu));


        //Attributable fraction in exposed for rate data (from Hanley 2001):
        AFRatep = (IRRp - 1) / IRRp;
        AFRatel = Math.min((IRRl - 1) / IRRl, (IRRu - 1) / IRRu);
        AFRateu = Math.max((IRRl - 1) / IRRl, (IRRu - 1) / IRRu);


        //Attributable fraction (estimated) in exposed (from Hanley 2001):
        Afestp = Math.min((ORl - 1) / ORl, (ORu - 1) / ORu);
        Afestl = Math.min((ORl - 1) / ORl, (ORu - 1) / ORu);
        Afestu = Math.max((ORl - 1) / ORl, (ORu - 1) / ORu);


        //Attributable fraction in population for risk-prevalence data (from Jewell, page 84):
        PAFRiskp = ((a * d) - (b * c)) / ((a + c) * (c + d));
        double PAFRiskdouble = (b + (PAFRiskp * (a + d))) / (n * c);
        PAFRiskl = 1 - Math.exp(Math.log(1 - PAFRiskp) + (zValue * Math.sqrt(PAFRiskdouble)));
        PAFRisku = 1 - Math.exp(Math.log(1 - PAFRiskp) - (zValue * Math.sqrt(PAFRiskdouble)));


        //Attributable fraction in population for rate data (from OpenEpi TwobyTwo - Jewell doesn't provide a method for rate data):
        double Iratepopp = dplus / dminus;
        double Iratepopl = (dplus * Math.pow((1 - (1 / (9 * dplus)) - (zValue / 3 * Math.sqrt(1 / dplus))), 3)) / dminus;
        double Iratepopu = (dplus * Math.pow((1 - (1 / (9 * dplus)) + (zValue / 3 * Math.sqrt(1 / dplus))), 3)) / dminus;
        double Irateop = c / d;
        double Irateol = (c * Math.pow((1 - (1 / (9 * c)) - (zValue / 3 * Math.sqrt(1 / c))), 3)) / d;
        double Irateou = (c * Math.pow((1 - (1 / (9 * c)) + (zValue / 3 * Math.sqrt(1 / c))), 3)) / d;
        PAFRatep = (Iratepopp - Irateop) / Iratepopp;
        PAFRatel = Math.min((Iratepopl - Irateol) / Iratepopl, (Iratepopu - Irateou) / Iratepopu);
        PAFRateu = Math.max((Iratepopl - Irateol) / Iratepopl, (Iratepopu - Irateou) / Iratepopu);


        //Attributable fraction (exposed) in population (from Jewell, page 84):
        PAFestp = ((a * d) - (b * c)) / (d * (a + c));
        double PAFestdouble = (a / (c * (a + c))) + (b / (d * (b + d)));
        PAFestl = 1 - Math.exp(Math.log(1 - PAFestp) + (zValue * Math.sqrt(PAFestdouble)));
        PAFestu = 1 - Math.exp(Math.log(1 - PAFestp) - (zValue * Math.sqrt(PAFestdouble)));

        Result re = viewresult1(t);
        return new RespTwobyTwoTableDto(re.getResult1Value(), re.getResult1(), dminus, dplus, eminus, eplus, n);
    }

    protected Result viewresult1(ReqTwobyTwoTableDto t) {
        switch (t.getSelectedTypeOfAnanysisIndex()) {
            case 0:
                return viewresult1CohortCount(t);
            case 1:
                return viewresult1CohortTime(t);
            case 2:
                return viewresult1CrossSectionalStudy(t);
            default:
                return viewresult1CaseControlStudy(t);
        }
    }

    private Result viewresult1CohortCount(ReqTwobyTwoTableDto t) {
        CI = t.getSelectedIntervalValue() * 100;
        String result1, result1Value;
        Result result = new Result();
        switch (t.getSelectedTableTypeIndex()) {
            case 0:
                // Incidence risk ratio:
                result1 = (t.getSelectedTableTypeValue() + ": ");
                result1Value = (roundNum(RRp, 2) + " (" + Math.round(CI) + "% CI " + roundNum(RRl, 2) + " " + toText + " " + roundNum(RRu, 2) + ").");
                break;
            case 1: // Odds ratio:
                result1 = (t.getSelectedTableTypeValue() + ": ");
                result1Value = (roundNum(ORp, 2) + " (" + Math.round(CI) + "% CI " + roundNum(ORl, 2) + " " + toText + " " + roundNum(ORu, 2) + ").");
                break;
            case 2: // Attributable risk
                result1 = (t.getSelectedTableTypeValue() + ": ");
                result1Value = (roundNum(ARiskp, 2) + " (" + Math.round(CI) + "% CI " + roundNum(ARiskl, 2) + " " + toText + " " + roundNum(ARisku, 2) + ").");
                break;
            case 3: // Attributable risk in population:
                result1 = (t.getSelectedTableTypeValue() + ": ");
                result1Value = (roundNum(PARiskp, 2) + " (" + Math.round(CI) + "% CI " + roundNum(PARiskl, 2) + " " + toText + " " + roundNum(PARisku, 2) + ").");
                break;
            case 4: // Attributable fraction in exposed:
                result1 = (t.getSelectedTableTypeValue() + ": ");
                result1Value = (roundNum(AFRiskp, 2) + " (" + Math.round(CI) + "% CI " + roundNum(AFRiskl, 2) + " " + toText + " " + roundNum(AFRisku, 2) + ").");
                break;
            default: // Attributable fraction in population:
                result1 = (t.getSelectedTableTypeValue() + ": ");
                result1Value = (roundNum(PAFRiskp, 2) + " (" + Math.round(CI) + "% CI " + roundNum(PAFRiskl, 2) + " " + toText + " " + roundNum(PAFRisku, 2) + ").");
                break;
        }
        result.setResult1(result1);
        result.setResult1Value(result1Value);
        return result;
    }

    private Result viewresult1CohortTime(ReqTwobyTwoTableDto t) {
        CI = t.getSelectedIntervalValue() * 100;
        String result1, result1Value;
        Result result = new Result();
        switch (t.getSelectedTableTypeIndex()) {
            case 0:
                // Incidence rate ratio:
                result1 = (t.getSelectedTableTypeValue() + ":");
                result1Value = (roundNum(IRRp, 2) + " (" + Math.round(CI) + "% CI " + roundNum(IRRl, 2) + " " + toText + " " + roundNum(IRRu, 2) + ").");
                break;
            case 1: // Attributable rate
                result1 = (t.getSelectedTableTypeValue() + ":");
                result1Value = (roundNum(Aratep, 2) + " (" + Math.round(CI) + "% CI " + roundNum(Aratel, 2) + " " + toText + " " + roundNum(Arateu, 2) + ").");

                break;
            case 2: // Attributable rate in population:
                result1 = (t.getSelectedTableTypeValue() + ":");
                result1Value = (roundNum(PARatep, 2) + " (" + Math.round(CI) + "% CI " + roundNum(PARatel, 2) + " " + toText + " " + roundNum(PARateu, 2) + ").");
                break;
            case 3: // Attributable fraction in exposed:
                result1 = (t.getSelectedTableTypeValue() + ":");
                result1Value = (roundNum(AFRatep, 2) + " (" + Math.round(CI) + "% CI " + roundNum(AFRatel, 2) + " " + toText + " " + roundNum(AFRateu, 2) + ").");
                break;
            default: // Attributable fraction in population:
                result1 = (t.getSelectedTableTypeValue() + ":");
                result1Value = (roundNum(PAFRatep, 2) + " (" + Math.round(CI) + "% CI " + roundNum(PAFRatel, 2) + " " + toText + " " + roundNum(PAFRateu, 2) + ").");
                break;
        }
        result.setResult1(result1);
        result.setResult1Value(result1Value);
        return result;
    }

    private Result viewresult1CrossSectionalStudy(ReqTwobyTwoTableDto t) {
        CI = t.getSelectedIntervalValue() * 100;
        String result1, result1Value;
        Result result = new Result();
        switch (t.getSelectedTableTypeIndex()) {
            case 0:
                // Prevalence ratio:
                result1 = (t.getSelectedTableTypeValue() + ":");
                result1Value = (roundNum(RRp, 2) + " (" + Math.round(CI) + "% CI "
                        + roundNum(RRl, 2) + " " + toText + " " + roundNum(RRu, 2) + ").");
                break;
            case 1: // Odds ratio:
                result1 = (t.getSelectedTableTypeValue() + ":");
                result1Value = (roundNum(ORp, 2) + " (" + Math.round(CI) + "% CI "
                        + roundNum(ORl, 2) + " " + toText + " " + roundNum(ORu, 2) + ").");
                break;
            case 2: // Attributable prevalence
                result1 = (t.getSelectedTableTypeValue() + ":");
                result1Value = (roundNum(ARiskp, 2) + " (" + Math.round(CI) + "% CI "
                        + roundNum(ARiskl, 2) + " " + toText + " " + roundNum(ARisku, 2) + ").");

                break;
            case 3: // Attributable prevalence in population:
                result1 = (t.getSelectedTableTypeValue() + ":");
                result1Value = (roundNum(PARiskp, 2) + " (" + Math.round(CI) + "% CI "
                        + roundNum(PARiskl, 2) + " " + toText + " " + roundNum(PARisku, 2) + ").");
                break;
            case 4: // Attributable fraction in exposed:
                result1 = (t.getSelectedTableTypeValue() + ":");
                result1Value = (roundNum(AFRiskp, 2) + " (" + Math.round(CI) + "% CI "
                        + roundNum(AFRiskp, 2) + " " + toText + " " + roundNum(AFRiskp, 2) + ").");
                break;
            default: // Attributable fraction in population:

                result1 = (t.getSelectedTableTypeValue() + ":");
                result1Value = (roundNum(PAFRiskp, 2) + " (" + Math.round(CI) + "% CI "
                        + roundNum(PAFRiskl, 2) + " " + toText + " " + roundNum(PAFRisku, 2) + ").");
                break;
        }

        result.setResult1(result1);
        result.setResult1Value(result1Value);
        return result;
    }

    private Result viewresult1CaseControlStudy(ReqTwobyTwoTableDto t) {
        CI = t.getSelectedIntervalValue() * 100;
        String result1, result1Value;
        Result result = new Result();
        switch (t.getSelectedTableTypeIndex()) {
            case 0:
                // Odds ratio:
                result1 = (t.getSelectedTableTypeValue() + ":");
                result1Value = (roundNum(ORp, 2) + " (" + Math.round(CI) + "% CI "
                        + roundNum(ORl, 2) + " " + toText + " " + roundNum(ORu, 2) + ").");
                break;
            case 1: // Attributable prevalence:
                result1 = (t.getSelectedTableTypeValue() + ":");
                result1Value = (roundNum(ARiskp, 2) + " (" + Math.round(CI) + "% CI "
                        + roundNum(ARiskl, 2) + " " + toText + " " + roundNum(ARisku, 2) + ").");

                break;
            case 2: // Attributable prevalence in population:
                result1 = (t.getSelectedTableTypeValue() + ":");
                result1Value = (roundNum(PARiskp, 2) + " (" + Math.round(CI) + "% CI "
                        + roundNum(PARiskl, 2) + " " + toText + " " + roundNum(PARisku, 2) + ").");
                break;
            case 3: //Attributable fraction (est) in exposed:
                result1 = (t.getSelectedTableTypeValue() + ":");
                result1Value = (roundNum(Afestp, 2) + " (" + Math.round(CI) + "% CI "
                        + roundNum(Afestl, 2) + " " + toText + " " + roundNum(Afestu, 2) + ").");
                break;
            default: // Attributable fraction (est) in population:
                result1 = (t.getSelectedTableTypeValue() + ":");
                result1Value = (roundNum(PAFestp, 2) + " (" + Math.round(CI) + "% CI "
                        + roundNum(PAFestl, 2) + " " + toText + " " + roundNum(PAFestu, 2) + ").");
                break;
        }
        result.setResult1(result1);
        result.setResult1Value(result1Value);
        return result;
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
