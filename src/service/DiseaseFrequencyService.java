package service;

import dto.request.ReqDiseaseFrequencyDto;
import dto.respone.RespDiseaseFrequencyDto;
import exception.CalculateException;

public class DiseaseFrequencyService  {

    double numeratorValC = 0;
    double denominatorValC = 0;
    double multiplierValC = 0;
    double z = 1.96;
    private String casePer = "case per";
    private String subjectTime = "subject(s) time";
    private String toText = "to";
    private String result2P1 = "No. diseased in a population of";
    private String result2P2 = "consistent with an incidence risk of";
    private String subjectText = "subject(s)";

 
    public RespDiseaseFrequencyDto calculate(ReqDiseaseFrequencyDto t) throws CalculateException {
//        if (validate(t) != null)
//            return validate(t);
        return doCalculation(t);
    }

//    public ResponseEntity validate(ReqDiseaseFrequencyDto t) {
//        Double numeratorVal = t.getNumeratorVal();
//        Double denominatorVal = t.getDenominatorVal();
//        Double multiplierVal = t.getMultiplierVal();
//
//
//        if (numeratorVal == null &&
//                denominatorVal == null &&
//                multiplierVal == null) {
//            numeratorValC = numeratorVal;
//            denominatorValC = denominatorVal;
//            multiplierValC = multiplierVal;
//            return this.responseError(new CalculateException(11));
//        }
//        return null;
//    }

    public double genZ(int index) {
        switch (index) {
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

    protected RespDiseaseFrequencyDto doCalculation(ReqDiseaseFrequencyDto t) {
        z = genZ(t.getSelectedIntervalIndex());
        double low;
        double up;
        double cases = (numeratorValC / denominatorValC) * multiplierValC;
        double CI = t.getSelectedIntervalValue() * 100;

        String result1 = "", result1Value = "", result2 = "", result2Value = "";

        if (t.getSelectedTypeIndex() == 2) {
            double aPrime = numeratorValC + 0.5;
            low = ((aPrime * Math.pow((1 - (1 / (9 * aPrime)) - (z / 3 * Math
                    .sqrt(1 / aPrime))), 3)) / denominatorValC)
                    * multiplierValC;

            up = ((aPrime * Math.pow((1 - (1 / (9 * aPrime)) + (z / 3 * Math
                    .sqrt(1 / aPrime))), 3)) / denominatorValC)
                    * multiplierValC;


            result1 = (t.getSelectedTypeValue() + " (" + casePer + " "
                    + Math.round(multiplierValC) + " " + subjectTime + "):");
            result1Value = (Math.round(cases) + " (" + Math.round(CI) + "% CI "
                    + roundNum(low, 1) + " " + toText + " " + roundNum(up, 1) + ") ");

            result2 = (" " + result2P1 + " "
                    + Math.round(denominatorValC)
                    + " " + result2P2 + " "
                    + Math.round(cases) + " " + casePer + " "
                    + Math.round(multiplierValC) + " " + subjectText + ":");
            result2Value = (Math.round(low / 100 * denominatorValC) + " " + toText + " "
                    + Math.round(up / 100 * denominatorValC));
        } else {
            double a = denominatorValC / (denominatorValC + Math.pow(z, 2));
            double b = numeratorValC / denominatorValC;
            double c = (z * z) / (2 * denominatorValC);
            double d = (numeratorValC * (denominatorValC - numeratorValC))
                    / Math.pow(denominatorValC, 3);
            double e = Math.pow(z, 2) / (4 * Math.pow(denominatorValC, 2));

            low = (a * (b + c - (z * Math.sqrt(d + e)))) * multiplierValC;
            up = (a * (b + c + (z * Math.sqrt(d + e)))) * multiplierValC;

            result1 = (t.getSelectedTypeValue() + " (" + casePer + " "
                    + Math.round(multiplierValC) + " " + subjectText + "):");
            result1Value = (Math.round(cases) + " (" + Math.round(CI) + "% CI "
                    + roundNum(low, 1) + " " + toText + " " + roundNum(up, 1) + ") ");
            if (t.getSelectedTypeIndex() == 0) {

                result2 = (result2P1 + " "
                        + Math.round(denominatorValC)
                        + " " + result2P2 + " "
                        + Math.round(cases) + " " + casePer + " "
                        + Math.round(multiplierValC) + " " + subjectText + ": ");
                result2Value = (Math.round(low / 100 * denominatorValC) + " " + toText + " "
                        + Math.round(up / 100 * denominatorValC));
            } else {
                result2 = (result2P1 + " "
                        + Math.round(denominatorValC)
                        + " " + result2P2 + " "
                        + Math.round(cases) + " " + casePer + " "
                        + Math.round(multiplierValC) + " " + subjectText + ":");
                result2Value = (Math.round(low / 100 * denominatorValC) + " " + toText + " "
                        + Math.round(up / 100 * denominatorValC));
            }

        }
        return new RespDiseaseFrequencyDto(result1, result1Value, result2, result2Value);
    }

    public double roundNum(double theNumber, int decPlaces) {
        double returnV = 0;
        ;
        if (decPlaces >= 0) {
            double temp = Math.pow(10, decPlaces);
            returnV = Math.round(theNumber * temp) / temp;
        }
        return returnV;
    }
}
