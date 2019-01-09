package lizhongbo.taxcalc.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import lizhongbo.taxcalc.R;
import lizhongbo.taxcalc.TaxRateManager;
import lizhongbo.taxcalc.beans.TaxRate;

import static lizhongbo.taxcalc.beans.TaxRate.taxRates;

public class TaxRateActivity extends AppCompatActivity {
    private ListView mListView;
    private TaxRateAdapter mTaxRateAdapter;
    private TextView mStartTaxEdit;
    TaxRate[] taxRateList = taxRates;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taxrate);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mListView = findViewById(R.id.taxrate_list);
        mTaxRateAdapter = new TaxRateAdapter(this);
        mTaxRateAdapter.setTaxRateList(taxRateList);
        mListView.setAdapter(mTaxRateAdapter);
        mStartTaxEdit = findViewById(R.id.startTaxEditText);
        mStartTaxEdit.setText(Integer.toString(TaxRateManager.startTaxIncome));

    }
}
