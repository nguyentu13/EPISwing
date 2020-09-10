package service;

import java.util.Random;

import dto.request.ReqRandomNumberGeneratorDto;
import dto.respone.RespRandomNumberGeneratorDto;
import exception.CalculateException;

public class RandomNumberGeneratorService {

    public RespRandomNumberGeneratorDto calculate(ReqRandomNumberGeneratorDto t) throws CalculateException {
//        if (validate(t) != null) {
//            return validate(t);
//        }
        return doRamdom(t);
    }


//    public ResponseEntity validate(ReqRandomNumberGeneratorDto t) throws CalculateException {
//
//        Integer aV = t.getA();
//        Integer bV = t.getB();
//        Integer nV = t.getN();
//        Integer seedV = t.getSeed();
//        if (aV != null && bV != null && nV != null & seedV != null) {
//            if (bV < aV) {
//                return responseError(new CalculateException(8));
//            }
//            if (nV > 100) {
//                return responseError(new CalculateException(9));
//            }
//            if (nV > (bV - aV)) {
//                return responseError(new CalculateException(10));
//            }
//            return null;
//        } else {
//            return responseError(new CalculateException(7));
//        }
//    }


    protected RespRandomNumberGeneratorDto doRamdom(ReqRandomNumberGeneratorDto t) {
        int START = t.getA();
        int END = t.getB();
        int nV = t.getN();
        Random random = new Random(t.getSeed());
        int randomN;
        String strV = "";
        int i;
        int a1[] = new int[100];

        //Toast.makeText(RandomNumberGenerator.this, "process ", Toast.LENGTH_LONG).show();
        int j = 0;
        for (i = 0; i < nV; i++) {
            randomN = showRandomInteger(START, END, random);

            if (t.getChkReplacement() == 1) {
                strV = strV + randomN + " ";
            } else {
                if (i == 0) {
                    strV = strV + randomN + " ";
                } else {

                    if (exist(a1, randomN)) {
                        nV++;
                    } else {
                        a1[j] = randomN;
                        j++;
                        strV = strV + randomN + " ";
                    }
                }
            }
        }

        return new RespRandomNumberGeneratorDto(strV);

    }

    public int showRandomInteger(int aStart, int aEnd, Random aRandom) {

        //get the range, casting to long to avoid overflow problems
        long range = (long) aEnd - (long) aStart + 1;
        // compute a fraction of the range, 0 <= frac < range
        long fraction = (long) (range * aRandom.nextDouble());
        int randomNumber;


        randomNumber = (int) (fraction + aStart);
        // random_numbers.setText("without replacement : "+ randomNumber);
        // log("Generated : " + randomNumber);

        return randomNumber;
    }

    public boolean exist(int a[], int rn) {

        for (int i = 0; i < a.length; i++) {
            if (a[i] == rn) {
                //Toast.makeText(RandomNumberGenerator.this, "exist" + rn, Toast.LENGTH_LONG).show();
                i = a.length;
                return true;
            }
        }

        return false;

    }
}
