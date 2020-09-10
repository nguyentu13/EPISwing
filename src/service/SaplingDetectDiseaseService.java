package service;

import dto.request.ReqSaplingDetectDiseaseDto;
import dto.respone.RespSaplingDetectDiseaseDto;
import exception.CalculateException;

public class SaplingDetectDiseaseService {

    String result1P1 = "Number of subjects to be";
    String result1P2 = "confident of detecting disease with a perfect test";
    String result2P1 = "If the test you are using has a sensitivity of";
    String result2P2 = "then the number tested should be increased to";
    String result3P1 = "Approximate number of false positives expected if sample size adjusted for test sensitivity";

    public RespSaplingDetectDiseaseDto calculate(ReqSaplingDetectDiseaseDto dto) throws CalculateException {
//        if (this.checkGroupCond(dto) != null)
//            return checkGroupCond(dto);
        return doCalculation(dto);
    }

    public CalculateException checkGroupCond(ReqSaplingDetectDiseaseDto dto) throws CalculateException {
        if (this.validateExpectedPrevalance(dto) != null)
            return this.validateExpectedPrevalance(dto);
        if (this.validateTestSensivity(dto) != null)
            return this.validateExpectedPrevalance(dto);
        if (this.validateConfidentInterval(dto) != null)
            return this.validateConfidentInterval(dto);
        if (this.validateTestSpecificity(dto) != null)
            return this.validateTestSpecificity(dto);
        if (this.validate(dto) != null)
            return this.validate(dto);
        return null;
    }

    public CalculateException validateExpectedPrevalance(ReqSaplingDetectDiseaseDto dto) throws CalculateException {

        if (dto.getExpectPrevalence() > 1) {
            return new CalculateException(0);
        }
        return null;
    }


    public CalculateException validateTestSensivity(ReqSaplingDetectDiseaseDto dto) throws CalculateException {

        if (dto.getTestSensitivity() > 1) {
            return new CalculateException(0);
        }
        return null;
    }


    public CalculateException validateConfidentInterval(ReqSaplingDetectDiseaseDto dto) throws CalculateException {
        if (dto.getConInterval() > 1) {
            return new CalculateException(2);
        }
        return null;
    }

    public CalculateException validateTestSpecificity(ReqSaplingDetectDiseaseDto dto) throws CalculateException {
        if (dto.getTestSpecificity() > 1) {
            return new CalculateException(4);
        }
        return null;
    }


    public CalculateException validate(ReqSaplingDetectDiseaseDto dto) throws CalculateException {

        double expectPrevalenceV = dto.getExpectPrevalence();
        double testSensitivityV = dto.getTestSensitivity();
        double testSpecificityV = dto.getTestSpecificity();
        double confidentIntervalV = dto.getConInterval();
        double popuSizeV = dto.getPopuSize();

        if (dto.getExpectPrevalence() != null &&
                dto.getPopuSize() != null &&
                dto.getTestSensitivity() != null &&
                dto.getTestSpecificity() != null &&
                dto.getConInterval() != null) {
            if (((expectPrevalenceV > 0) || (expectPrevalenceV == 0)) && ((expectPrevalenceV < 1) || (expectPrevalenceV == 1))
                    && ((testSensitivityV > 0) || (testSensitivityV == 0)) && ((testSensitivityV < 1) || (testSensitivityV == 1))
                    && ((testSpecificityV > 0) || (testSpecificityV == 0)) && ((confidentIntervalV < 1) || (confidentIntervalV == 1))) {

                return null;
            } else {
                if ((expectPrevalenceV > 1)) {
                    return new CalculateException(0);
                }
                if ((testSensitivityV > 1)) {
                    return new CalculateException(6);
                }
                if ((testSpecificityV > 1)) {
                    return new CalculateException(4);
                }
                if ((confidentIntervalV > 1)) {
                    return new CalculateException(2);
                }

            }
        }
        return new CalculateException(-1);
    }


    protected RespSaplingDetectDiseaseDto doCalculation(ReqSaplingDetectDiseaseDto dto) {
        double expectPrevalenceV = dto.getExpectPrevalence();
        double testSensitivityV = dto.getTestSensitivity();
        double testSpecificityV = dto.getTestSpecificity();
        double confidentIntervalV = dto.getConInterval();
        double popuSizeV = dto.getPopuSize();

        double alpha = 1 - confidentIntervalV;
        double N = popuSizeV;
        double prev = expectPrevalenceV;
        double CI = confidentIntervalV;
        double se = testSensitivityV;
        double sp = testSpecificityV;

        double n1;
        double nse;
        double nfp;

        n1 = (1 - Math.pow(alpha, (1 / (N * prev * se)))) * (N - (N * prev * se - 1) / 2);
        if (dto.getFiniteCorrectionPos() == 1) {
            nse = n1 * (1 / se);
            nfp = (1 - sp) * nse;
        } else {
            n1 = (n1 / (1 + (n1 / N)));
            nse = n1 * (1 / se);
            nfp = (1 - sp) * n1;
        }
        String result1 = result1P1 + " " + Math.round(CI * 100) + "% " + result1P2 + ":";
        String result2 = result2P1 + " " + testSensitivityV + " " + result2P2 + ":";
        String result3 = result3P1 + ":";
        String result1Value = String.valueOf(Math.round(n1));
        String result2Value = String.valueOf(Math.round(nse));
        String result3Value = String.valueOf(Math.round(nfp));
        RespSaplingDetectDiseaseDto resp = new RespSaplingDetectDiseaseDto(result1, result2, result3, result1Value, result2Value, result3Value);

        return resp;

    }


}
