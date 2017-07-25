package com.kika.koalaaddemo;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class AboutActivity extends Activity {

    private TextView mAboutTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        initWidget();
    }

    private void initWidget(){
        mAboutTxt = (TextView) findViewById(R.id.about_txt);

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<font color='#86B404'><strong>Koala Ad SDK</strong></font><br>");
        stringBuffer.append("<font>Koala Native AD SDK powered by Kika Tech. Our platform focus on the mobile native advertising, and we have:<br>");
        stringBuffer.append("<font>1.Campaigns from 200+ regions & 95%+ fill-rate</font><br>");
        stringBuffer.append("<font>2.Massive advertising behavior data</font><br>");
        stringBuffer.append("<font>3.Global reach with direct advertisers(CPI/CPC/CPM)</font><br>");
        stringBuffer.append("<font>4.Rich of users profiles and their label of interests</font><br>");
        stringBuffer.append("<font>5.High accuracy of ad serving</font><br>");
        stringBuffer.append("<br><br><font color='#86B404'><strong>Contact us:</strong></font><br>");
        stringBuffer.append("<font>http://www.acekoala.com/</font>");
        stringBuffer.append("<font>operating@kikatech.com</font>");

        mAboutTxt.setText(Html.fromHtml(stringBuffer.toString()));
    }
}
