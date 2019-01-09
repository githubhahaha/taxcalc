package lizhongbo.taxcalc;

import lizhongbo.taxcalc.beans.TaxRate;

import static lizhongbo.taxcalc.beans.TaxRate.taxRates;

public class TaxRateManager {

    /*起征点*/
    public static int startTaxIncome = 5000;

/*    *//*恢复默认税率*//*
    public static TaxRate level1 = new TaxRate(1, 0, 3000, 0.03, 0);
    public static TaxRate level2 = new TaxRate(2, 3000, 12000, 0.1, 210);
    public static TaxRate level3 = new TaxRate(3, 12000, 25000, 0.2, 1410);
    public static TaxRate level4 = new TaxRate(4, 25000, 35000, 0.25, 2660);
    public static TaxRate level5 = new TaxRate(5, 35000, 55000, 0.30, 4410);
    public static TaxRate level6 = new TaxRate(6, 55000, 80000, 0.35, 7160);
    public static TaxRate level7 = new TaxRate(7, 80000, Integer.MAX_VALUE, 0.45, 15160);
    public static TaxRate taxRates[] = { level1,level2,level3,level4,level5,level6,level7};*/




    /**!
     * 计算税率
     * @param beforeTaxIncome 税前收入
     * @return 税后收入
     */
    public static double CalcTaxRate(int beforeTaxIncome){
        //List<TaxRate> taxRates = SQLite.select().from(TaxRate.class).queryList();
        int taxIncome = beforeTaxIncome - startTaxIncome;
        for(TaxRate taxRate:taxRates){
            if(taxIncome >= taxRate.start && taxIncome <= taxRate.end){
                return taxIncome * taxRate.taxRate - taxRate.quickDeduction;
            }
        }
        return 0;
    }
}
