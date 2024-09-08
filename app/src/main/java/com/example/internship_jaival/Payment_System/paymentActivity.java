package com.example.internship_jaival.Payment_System;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.internship_jaival.R;
import com.shreyaspatil.EasyUpiPayment.EasyUpiPayment;
import com.shreyaspatil.EasyUpiPayment.listener.PaymentStatusListener;
import com.wangsun.upi.payment.UpiPayment;
import com.wangsun.upi.payment.model.PaymentDetail;
import com.wangsun.upi.payment.model.TransactionDetails;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class paymentActivity extends AppCompatActivity  {

//    implements PaymentStatusListener

    EditText amountEdt, upiEdt, nameEdt, descEdt;
    TextView transactionDetailsTV;

    Uri uri;
    final int UPI_PAYMENT = 0;

    String  GPAY_PACKAGE_NAME = "com.google.android.apps.nbu.paisa.user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        amountEdt = findViewById(R.id.idEdtAmount);
        upiEdt = findViewById(R.id.idEdtUpi);
        nameEdt = findViewById(R.id.idEdtName);
        descEdt = findViewById(R.id.idEdtDescription);
        Button makePaymentBtn = findViewById(R.id.idBtnMakePayment);
        transactionDetailsTV = findViewById(R.id.idTVTransactionDetails);

//        makePaymentBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                final EasyUpiPayment easyUpiPayment = new EasyUpiPayment.Builder()
//                        .with(paymentActivity.this)
//                        .setPayeeVpa("shreyaspatil@upi")
//                        .setPayeeName("Shreyas Patil")
//                        .setTransactionId("20190603022401")
//                        .setTransactionRefId("0120192019060302240")
//                        .setDescription("For Today's Food")
//                        .setAmount("1.00")
//                        .build();
//                easyUpiPayment.startPayment();
//
////                getDetails();
//                Log.d("click", "onClick: ");
//
//            }
//        });

        // on below line we are getting date and then we are setting this date as transaction id.
//        Date c = Calendar.getInstance().getTime();
//        SimpleDateFormat df = new SimpleDateFormat("ddMMyyyyHHmmss", Locale.getDefault());
//        String transcId = df.format(c); // on below line we are adding click listener for our payment button.
//        makePaymentBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // on below line we are getting data from our edit text.
//                String amount = amountEdt.getText().toString();
//                String upi = upiEdt.getText().toString();
//                String name = nameEdt.getText().toString();
//                String desc = descEdt.getText().toString();
//                // on below line we are validating our text field.
//                if (TextUtils.isEmpty(amount) && TextUtils.isEmpty(upi) && TextUtils.isEmpty(name) && TextUtils.isEmpty(desc)) {
//                    Toast.makeText(paymentActivity.this, "Please enter all the details..", Toast.LENGTH_SHORT).show();
//                } else {
//                    // if the edit text is not empty then
//                    // we are calling method to make payment.
//                    makePayment(amount, upi, name, desc, transcId);
//                }
//            }
//        });

        makePaymentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });






    }



    public void getDetails() {

        uri = googlepay("jainik talaviya","darpan111@ybl","sd","1.0");
        payWithGpay(GPAY_PACKAGE_NAME);

    }

    public void payWithGpay(String packageName){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(uri);
        Intent chooser = Intent.createChooser(intent, "Pay with");

        // check if intent resolves
//        if(null != chooser.resolveActivity(getPackageManager())) {
//            startActivityForResult(chooser, UPI_PAYMENT);
//        } else {
//            Toast.makeText(this,"No UPI app found, please install one to continue",Toast.LENGTH_SHORT).show();
// }
        intent.setPackage(packageName);
        startActivityForResult(intent, 0);


    }
    public Uri googlepay(String name, String upid,String note,String amount) {

        return  new Uri.Builder()
                .scheme("upi")
                .authority("pay")
                .appendQueryParameter("pa", upid)
                .appendQueryParameter("pn", name)
                .appendQueryParameter("tn", note)
                .appendQueryParameter("am", amount)
                .appendQueryParameter("cu", "INR")
                .build();
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        switch (requestCode) {
//            case UPI_PAYMENT:
//                if ((RESULT_OK == resultCode) || (resultCode == 11)) {
//                    if (data != null) {
//                        String trxt = data.getStringExtra("response");
//                        //Log.d("UPI", "onActivityResult: " + trxt);
//                        ArrayList<String> dataList = new ArrayList<>();
//                        dataList.add(trxt);
//                        upiPaymentDataOperation(dataList);
//                    } else {
//                        //Log.d("UPI", "onActivityResult: " + "Return data is null");
//                        ArrayList<String> dataList = new ArrayList<>();
//                        dataList.add("nothing");
//                        upiPaymentDataOperation(dataList);
//                    }
//                } else {
//                    //Log.d("UPI", "onActivityResult: " + "Return data is null"); //when user simply back without payment
//                    ArrayList<String> dataList = new ArrayList<>();
//                    dataList.add("nothing");
//                    upiPaymentDataOperation(dataList);
//                }
//                break;
//
//        }
//    }
//
//    private void upiPaymentDataOperation(ArrayList<String> data) {
//        if (isConnectionAvailable(paymentActivity.this)) {
//            String str = data.get(0);
//            //Log.d("UPIPAY", "upiPaymentDataOperation: "+str);
//            String paymentCancel = "";
//            if(str == null) str = "discard";
//            String status = "";
//            String approvalRefNo = "";
//            String response[] = str.split("&");
//            for (int i = 0; i < response.length; i++) {
//                String equalStr[] = response[i].split("=");
//                if(equalStr.length >= 2) {
//                    if (equalStr[0].toLowerCase().equals("Status".toLowerCase())) {
//                        status = equalStr[1].toLowerCase();
//                    }
//                    else if (equalStr[0].toLowerCase().equals("ApprovalRefNo".toLowerCase()) || equalStr[0].toLowerCase().equals("txnRef".toLowerCase())) {
//                        approvalRefNo = equalStr[1];
//                    }
//                }
//                else {
//                    paymentCancel = "Payment cancelled by user.";
//                }
//            }
//
//            if (status.equals("success")) {
//                //Code to handle successful transaction here.
//                Toast.makeText(paymentActivity.this, "Transaction successful.", Toast.LENGTH_SHORT).show();
//                // Log.d("UPI", "responseStr: "+approvalRefNo);
//                Toast.makeText(this, "YOUR ORDER HAS BEEN PLACED\n THANK YOU AND ORDER AGAIN", Toast.LENGTH_LONG).show();
//            }
//            else if("Payment cancelled by user.".equals(paymentCancel)) {
//                Toast.makeText(paymentActivity.this, "Payment cancelled by user.", Toast.LENGTH_SHORT).show();
//            }
//            else {
//                Toast.makeText(paymentActivity.this, "Transaction failed.Please try again", Toast.LENGTH_SHORT).show();
//            }
//        } else {
//            Toast.makeText(paymentActivity.this, "Internet connection is not available. Please check and try again", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    public static boolean isConnectionAvailable(Context context) {
//        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//        if (connectivityManager != null) {
//            NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
//            if (netInfo != null && netInfo.isConnected()
//                    && netInfo.isConnectedOrConnecting()
//                    && netInfo.isAvailable()) {
//                return true;
//            }
//        }
//        return false;
//}



//    private void makePayment(String amount, String upi, String name, String desc, String transactionId) {
//        // on below line we are calling an easy payment method and passing
//        // all parameters to it such as upi id,name, description and others.
//        final EasyUpiPayment easyUpiPayment = new EasyUpiPayment.Builder()
//                .with(this)
//                // on below line we are adding upi id.
//                .setPayeeVpa(upi)
//                // on below line we are setting name to which we are making payment.
//                .setPayeeName(name)
//                // on below line we are passing transaction id.
//                .setTransactionId(transactionId)
//                // on below line we are passing transaction ref id.
//                .setTransactionRefId(transactionId)
//                // on below line we are adding description to payment.
//                .setDescription(desc)
//                // on below line we are passing amount which is being paid.
//                .setAmount(amount)
//                // on below line we are calling a build method to build this ui.
//                .build();
//        // on below line we are calling a start
//        // payment method to start a payment.
//        easyUpiPayment.startPayment();
//        // on below line we are calling a set payment
//        // status listener method to call other payment methods.
//        easyUpiPayment.setPaymentStatusListener(paymentActivity.this);
//    }
//
//    @Override
//    public void onTransactionCompleted(TransactionDetails transactionDetails) {
//        // on below line we are getting details about transaction when completed.
//        String transcDetails = transactionDetails.getStatus().toString() + "\n" + "Transaction ID : " + transactionDetails.getTransactionId();
//        transactionDetailsTV.setVisibility(View.VISIBLE);
//        // on below line we are setting details to our text view.
//        transactionDetailsTV.setText(transcDetails);
//    }
//
//    @Override
//    public void onTransactionSuccess() {
//        // this method is called when transaction is successful and we are displaying a toast message.
//        Toast.makeText(this, "Transaction successfully completed..", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onTransactionSubmitted() {
//        // this method is called when transaction is done
//        // but it may be successful or failure.
//        Log.e("TAG", "TRANSACTION SUBMIT");
//    }
//
//    @Override
//    public void onTransactionFailed() {
//        // this method is called when transaction is failure.
//        Toast.makeText(this, "Failed to complete transaction", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onTransactionCancelled() {
//        // this method is called when transaction is cancelled.
//        Toast.makeText(this, "Transaction cancelled..", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onAppNotFound() {
//        // this method is called when the users device is not having any app installed for making payment.
//        Toast.makeText(this, "No app found for making transaction..", Toast.LENGTH_SHORT).show();
//    }


}