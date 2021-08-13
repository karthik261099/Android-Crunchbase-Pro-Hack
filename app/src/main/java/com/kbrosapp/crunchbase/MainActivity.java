package com.kbrosapp.crunchbase;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        button=findViewById(R.id.button);
        webView=findViewById(R.id.webView);

        webView.loadUrl("https://www.crunchbase.com/discover/organization.companies/048050ce111ce1c8ba1846cb1e280114");
        webView.getSettings().setJavaScriptEnabled(true);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.loadUrl("javascript:function x(){document.getElementsByClassName(\"all-results-upsell-wrapper ng-star-inserted\")[0].remove(); var len=document.getElementsByClassName(\"blurred-row\").length; for(var i=0;i<len;i++){document.getElementsByClassName(\"blurred-row\")[0].classList.remove(\"blurred-row\");}document.querySelector(\"body > chrome > div > mat-sidenav-container > mat-sidenav-content > div > discover > page-layout > div > div > div.header-nav.ng-star-inserted\").remove();document.querySelector(\"body > chrome > div > mat-sidenav-container > mat-sidenav-content > div > discover > page-layout > div > div > div > section.results-container > results > div > div > div.cb-background-white.cb-padding-small-vertical.cb-padding-medium-horizontal.flex-none.layout-column.layout-align-center-stretch.layout-gt-xs-row.layout-align-gt-xs-start-center\").remove();}; x();");
//                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

}