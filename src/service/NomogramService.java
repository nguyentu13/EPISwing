package service;

import dto.request.ReqNomogramDto;
import dto.respone.RespNomogramDto;

public class NomogramService  {
   
    public RespNomogramDto calculate(ReqNomogramDto t) {
//        if (validateCombo(t) != null) {
//            return validateCombo(t);
//        }
        return doCalculation(t);
    }

//    public ResponseEntity validateCombo(ReqNomogramDto t) {
//        if (validateTestSpec(t) != null)
//            return validateTestSpec(t);
//        if (validateTestSensitivity(t) != null)
//            return validateTestSensitivity(t);
//        if (validatePreTest(t) != null)
//            return validatePreTest(t);
//        if (validate(t) != null)
//            return validate(t);
//        return null;
//    }
//
//
//    public ResponseEntity validateTestSpec(ReqNomogramDto t) {
//        Double testSpecValue = t.getTestSpecValue();
//        if (testSpecValue != null) {
//            if (testSpecValue > 1) {
//                return this.responseError(new CalculateException(14));
//            }
//        }
//        return null;
//    }

//    public ResponseEntity validateTestSensitivity(ReqNomogramDto t) {
//        Double testSenLiValue = t.getTestSpecValue();
//        if (testSenLiValue != null) {
//            if ((testSenLiValue > 1) && (t.getRlikelihoodUnknown() == 1)) {
//                return this.responseError(new CalculateException(13));
//            }
//        }
//        return null;
//    }
//
//    public ResponseEntity validatePreTest(ReqNomogramDto t) {
//        Double preTestValue = t.getPreTestValue();
//        if (preTestValue != null) {
//            if ((preTestValue > 1)) {
//                return this.responseError(new CalculateException(12));
//            }
//        }
//        return null;
//    }

//    public ResponseEntity validate(ReqNomogramDto t) {
//        Double preTestValue = t.getPreTestValue();
//        Double testSenLiVal = t.getTestSenLiValue();
//        Double testSpecVal = t.getTestSpecValue();
//        Integer rLikelihoodUnknown = t.getRlikelihoodUnknown();
//        if ((preTestValue != null) && (testSenLiVal != null) && (testSpecVal != null)) {
//            if (rLikelihoodUnknown == 1) {
//                if (((preTestValue > 0) || (preTestValue == 0)) && ((preTestValue < 1) || (preTestValue == 1))
//                        && ((testSenLiVal > 0) || (testSenLiVal == 0)) && ((testSenLiVal < 1) || (testSenLiVal == 1))
//                        && ((testSpecVal > 0) || (testSpecVal == 0)) && ((testSpecVal < 1) || (testSpecVal == 1))) {
//
//                    return null;
//
//                } else {
//                    if ((preTestValue > 1)) {
//                        return this.responseError(new CalculateException(12));
//                    }
//                    if ((testSenLiVal > 1)) {
//                        return this.responseError(new CalculateException(13));
//                    }
//                    if (testSpecVal > 1) {
//                        return this.responseError(new CalculateException(14));
//                    }
//                }
//
//            } else {
//                if (((preTestValue > 0) || (preTestValue == 0)) && ((preTestValue < 1) || (preTestValue == 1))) {
//
//                    return null;
//                } else {
//
//                    return this.responseError(new CalculateException(12));
//                }
//
//            }
//        }
//
//        return this.responseError(new CalculateException(-1));
//
//
//    }


    protected RespNomogramDto doCalculation(ReqNomogramDto t) {

        double likelihood = 0;
        double postTestOdd = 0;
        double postTest = 0;
        double preTest = t.getPreTestValue() / (1 - t.getPreTestValue());

        String likelihoodText = "Likelihood ratio:";
        String postTestText = "The post-test prob of disease:";


        String likelihoodValue;
        String postTestValue;
        if (t.getRlikelihoodUnknown() == 1) {
            if (t.getTestSenLiValue() == 1) t.setTestSenLiValue(0.9);
            if (t.getTestSpecValue() == 1) t.setTestSpecValue(0.9999999);

            if (t.getSelectedTestTypeIndex() == 0) {
                likelihood = t.getTestSenLiValue() / (1 - t.getTestSpecValue());
                postTestOdd = preTest * likelihood;
                postTest = postTestOdd / (1 + postTestOdd);
            } else {
                likelihood = (1 - t.getTestSenLiValue()) / t.getTestSpecValue();
                postTestOdd = preTest * likelihood;
                postTest = postTestOdd / (1 + postTestOdd);
            }
        } else {
            likelihood = t.getTestSenLiValue();
            postTestOdd = preTest * likelihood;
            if (t.getSelectedTestTypeIndex() == 0) {
                postTest = postTestOdd / (1 + postTestOdd);
            } else {
                postTest = preTest / (1 + postTestOdd);
            }
        }

        if (likelihood < 1)
            likelihoodValue = likelihoodText + " " + roundNum(likelihood, 2);
        else
            likelihoodValue = likelihoodText + " " + Math.round(likelihood);

        postTestValue = postTestText + " " + roundNum(postTest, 2);

        return new RespNomogramDto(likelihoodValue, postTestValue);
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
