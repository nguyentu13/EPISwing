package service;

import dto.request.ReqSamplingEstimatePrevalenceDto;
import dto.respone.RespSamplingEstimatePrevalenceDto;
import exception.CalculateException;

public class SamplingEstimatePrevalenceService {

    String resultP1 = "Number to test to be";
    String resultP2 = "confident sample prevalence is within";
    String resultP3 = "of the population prevalence";

    public RespSamplingEstimatePrevalenceDto calculate(ReqSamplingEstimatePrevalenceDto t) throws CalculateException {
//        if (validate(t) != null)
//            return validate(t);
        return doCalculation(t);
    }


//    public ResponseEntity<Object> validate(ReqSamplingEstimatePrevalenceDto t) {
//        Double populationV = t.getPopulationV();
//        Double maximumPreV = t.getMaximumPreV();
//        Double rhoV = t.getRhoV();
//        Double aveClusterSizeV = t.getAveClusterSizeV();
//
//        if (populationV != null ||
//                maximumPreV != null ||
//                rhoV != null ||
//                aveClusterSizeV != null) {
//            return this.responseError(new CalculateException(11));
//        }
//        return null;
//    }

    public Double genK6(int selectedIntervalIndex) {
        Double k6;
        switch (selectedIntervalIndex) {
            case 0:
                k6 = 1.64521144;
                break;
            case 1:
                k6 = 1.96039492;
                break;
            default:
                k6 = 2.57623608;
                break;
        }
        return k6;
    }

    protected RespSamplingEstimatePrevalenceDto doCalculation(ReqSamplingEstimatePrevalenceDto t) {
        Double k6 = genK6(t.getSelectedIntervalIndex());
        double CI = t.getSelectedIntervalValue();
        double n_result = 0;
        if (t.getSelectedClustersIndex() == 0) {
            double D = t.getRhoV() * (t.getAveClusterSizeV() - 1) + 1;
            double n_crude = Math.round((k6 * k6 * (1 - t.getPopulationV()) * t.getPopulationV()) / (t.getMaximumPreV() * t.getMaximumPreV()));
            double n_adj = Math.round(n_crude * D);
            n_result = n_adj;
        } else {
            double n_crude = Math.round((k6 * k6 * (1 - t.getPopulationV()) * t.getPopulationV()) / (t.getMaximumPreV() * t.getMaximumPreV()));
            n_result = n_crude;
        }

        String result1 = resultP1 + " " + Math.round(CI * 100) + "% " + resultP2 + " " + roundNum(t.getMaximumPreV(), 2) + " " + resultP3 + ":";
        String resultValue = Math.round(n_result) + "";

        return new RespSamplingEstimatePrevalenceDto(result1, resultValue);

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
