package service;

import dto.request.ReqSamplingEstimateMeanDto;
import dto.respone.RespSamplingEstimateMeanDto;
import exception.CalculateException;

public class SamplingEstimateMeanService {

    String resultP1 = "Number of subjects to test to be";
    String resultP2 = "confident sample mean is within";
    String resultP3 = "units of the population mean";
    private static final String DOT = ".";

    public RespSamplingEstimateMeanDto calculate(ReqSamplingEstimateMeanDto t) throws CalculateException {
//        if (validate(t) != null) {
//            return validate(t);
//
//        }
        return doCalculation(t);
    }

    public Double genK6(String index) {
        Double k6;
        switch (index) {
            case "0.90":
                k6 = 1.64521144;
                break;
            case "0.95":
                k6 = 1.96039492;
                break;
            default:
                k6 = 2.57623608;
                break;
        }
        return k6;
    }

    protected RespSamplingEstimateMeanDto doCalculation(ReqSamplingEstimateMeanDto dto) {

        double CI = Double.parseDouble(dto.getSelectedIntervalValue());
        double k7 = Math.round((genK6(dto.getSelectedIntervalValue()) * genK6(dto.getSelectedIntervalValue()) * dto.getStandardV() * dto.getStandardV()) / (dto.getMaximumV() * dto.getMaximumV()));


        String result1 = resultP1 + " " + Math.round(CI * 100) + "% " + resultP2 + " " + Math.round(dto.getMaximumV()) + " " + resultP3 + ":";
        String result1Value = Math.round(k7) + "";

        return new RespSamplingEstimateMeanDto(result1, result1Value);
    }


//    public ResponseEntity<Object> validate(ReqSamplingEstimateMeanDto dto) {
//        Double standardStr = dto.getStandardV();
//        Double maximumStr = dto.getMaximumV();
//        if (standardStr != null && maximumStr != null) {
//            return this.responseError(new CalculateException(11));
//        }
//        return null;
//    }
}
