package com.lawson.chavoris.calculator.calculators;

public class ScientificCalculator extends StandardCalculator {
    

    // public void raise(int a, int b) {
    //     total = a ^ b;
    // }

    // public void raise(int a) {
    //     total ^= a;
    // }
    // public void pow(){
    //     if(!total.equals("0")){
    //         super.s
    //     }
    // }

    public int pow(int num, int exponent){
        if(num==0) return 0;
        if(exponent==1) return num;
        if(exponent==0) return 1;

        if(exponent<0){
            num = 1/num;
            exponent = -exponent;
        }
        return num * pow(num,exponent-1);
    }
}