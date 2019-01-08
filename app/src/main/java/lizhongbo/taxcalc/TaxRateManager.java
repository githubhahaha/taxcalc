package lizhongbo.taxcalc;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import lizhongbo.taxcalc.beans.TaxRate;

public class TaxRateManager {

    /*起征点*/
    public static int startTaxIncome = 5000;

    /*恢复默认税率*/
    public static void setDefaultTaxRate(){
        TaxRate level1 = new TaxRate(1, 0, 3000, 0.03, 0);
        level1.insert();
        TaxRate level2 = new TaxRate(2, 3000, 12000, 0.1, 210);
        level2.insert();
        TaxRate level3 = new TaxRate(3, 12000, 25000, 0.2, 1410);
        level3.insert();
        TaxRate level4 = new TaxRate(4, 25000, 35000, 0.25, 2660);
        level4.insert();
        TaxRate level5 = new TaxRate(5, 35000, 55000, 0.30, 4410);
        level5.insert();
        TaxRate level6 = new TaxRate(6, 55000, 80000, 0.35, 7160);
        level6.insert();
        TaxRate level7 = new TaxRate(7, 80000, Integer.MAX_VALUE, 0.45, 15160);
        level7.insert();
    }


    /**!
     * 计算税率
     * @param beforeTaxIncome 税前收入
     * @return 税后收入
     */
    public static double CalcTaxRate(int beforeTaxIncome){
        List<TaxRate> taxRates = SQLite.select().from(TaxRate.class).queryList();
        int taxIncome = beforeTaxIncome - startTaxIncome;
        for(TaxRate taxRate : taxRates){
            if(taxIncome >= taxRate.start && taxIncome <= taxRate.end){
                return taxIncome * taxRate.taxRate - taxRate.quickDeduction;
            }
        }
        return 0;
    }
}
