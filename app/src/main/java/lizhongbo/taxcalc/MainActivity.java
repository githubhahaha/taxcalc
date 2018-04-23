package lizhongbo.taxcalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public EditText mBeforeTaxIncome;
    public TextView mTaxTextView;
    public TextView mRealIncomeTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button calc = findViewById(R.id.calcBtn);
        calc.setOnClickListener(this);
        mBeforeTaxIncome = findViewById(R.id.beforeIncomeEdit);
        mTaxTextView = findViewById(R.id.TaxPayableTextView);
        mRealIncomeTextView = findViewById(R.id.RealPayTextView);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.calcBtn:{
                if(!TextUtils.isEmpty(mBeforeTaxIncome.getText().toString())){
                    int beforeTaxIncome = Integer.parseInt(mBeforeTaxIncome.getText().toString());
                    double tax = TaxRateManager.CalcTaxRate(beforeTaxIncome);
                    mTaxTextView.setText(Double.toString(tax));
                    double realIncome = beforeTaxIncome - tax;
                    mRealIncomeTextView.setText(Double.toString(realIncome));
                    //插入计算历史记录
                    History history = new History(beforeTaxIncome, tax);
                    history.insert();
                }
            }
                break;
            default:
                break;
        }
    }
}
