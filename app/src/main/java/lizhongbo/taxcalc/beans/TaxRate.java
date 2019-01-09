
package lizhongbo.taxcalc.beans;


public class TaxRate  {
    public int level; //级别
    public int start;//起始
    public int end;//中止
    public double taxRate; //税率
    public int quickDeduction; //快速扣除数
    public TaxRate(int level, int start, int end,double taxRate, int quickDeduction){
        this.level = level;
        this.start = start;
        this.end = end;
        this.taxRate = taxRate;
        this.quickDeduction = quickDeduction;
    }
    public TaxRate(){

    }

    /*恢复默认税率*/
    public static TaxRate level1 = new TaxRate(1, 0, 3000, 0.03, 0);
    public static TaxRate level2 = new TaxRate(2, 3000, 12000, 0.1, 210);
    public static TaxRate level3 = new TaxRate(3, 12000, 25000, 0.2, 1410);
    public static TaxRate level4 = new TaxRate(4, 25000, 35000, 0.25, 2660);
    public static TaxRate level5 = new TaxRate(5, 35000, 55000, 0.30, 4410);
    public static TaxRate level6 = new TaxRate(6, 55000, 80000, 0.35, 7160);
    public static TaxRate level7 = new TaxRate(7, 80000, Integer.MAX_VALUE, 0.45, 15160);
    public static TaxRate taxRates[] = { level1,level2,level3,level4,level5,level6,level7};


}

