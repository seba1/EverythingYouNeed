package com.example.everythingyouneed.everythingyouneed;

public class CalcFuelCost {
    int days;
    public CalcFuelCost(int d){
        this.days=d;
    }
    double DtoW(double d){
        return d*this.days;
    }
    double WtoD(double d){
        return d/this.days;
    }
    double DtoM(double d){
        return DtoW(d)*4;
    }
    double MtoD(double d){
        double wD = d/4;
        return WtoD(wD);
    }
    double DtoYr(double d){
        return DtoM(d)*12;
    }
    double YrtoD(double d){
        double mD = d/12;
        return MtoD(mD);
    }
}