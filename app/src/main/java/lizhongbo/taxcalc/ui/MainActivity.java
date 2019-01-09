package lizhongbo.taxcalc.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import lizhongbo.taxcalc.R;
import lizhongbo.taxcalc.TaxRateManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public EditText mBeforeTaxIncome;
    public EditText mInsurance;
    public EditText mSdeduction;
    public TextView mTaxTextView;
    public TextView mRealIncomeTextView;
    int insurance=0;
    int beforeTaxIncome=0;
    int sDeduction=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button calc = findViewById(R.id.calcBtn);
        calc.setOnClickListener(this);

        Button checkTax = findViewById(R.id.checkTaxBtn);
        checkTax.setOnClickListener(this);

        mBeforeTaxIncome = findViewById(R.id.beforeIncomeEdit);
        mInsurance = findViewById(R.id.insurancEdit);
        mSdeduction = findViewById(R.id.SdeductionEdit);
        mTaxTextView = findViewById(R.id.TaxPayableTextView);
        mRealIncomeTextView = findViewById(R.id.RealPayTextView);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.calcBtn: {
                if (!TextUtils.isEmpty(mInsurance.getText().toString())) {
                    insurance = Integer.parseInt(mInsurance.getText().toString());
                }
                if (!TextUtils.isEmpty(mSdeduction.getText().toString())) {
                    sDeduction = Integer.parseInt(mSdeduction.getText().toString());
                }
                if (!TextUtils.isEmpty(mBeforeTaxIncome.getText().toString())) {
                    beforeTaxIncome = Integer.parseInt(mBeforeTaxIncome.getText().toString());
                    beforeTaxIncome = beforeTaxIncome - insurance - sDeduction;
                    double tax = TaxRateManager.CalcTaxRate(beforeTaxIncome);
                    mTaxTextView.setText(Double.toString(tax));
                    double realIncome = beforeTaxIncome - tax;
                    mRealIncomeTextView.setText(Double.toString(realIncome));
                }
            }
            break;

            case R.id.checkTaxBtn:{
                Intent intent = new Intent(this, TaxRateActivity.class);
                startActivity(intent);
            }
            break;
            default:
                break;
        }
    }
}
