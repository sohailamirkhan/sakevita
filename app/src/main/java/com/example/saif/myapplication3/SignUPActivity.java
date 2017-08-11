package com.example.saif.myapplication3;

/**
 * Created by Saif on 8/10/17.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUPActivity extends Activity
{
    EditText editTextUserName,editTextPassword,editTextConfirmPassword;
    EditText editTextCustName,editMobNo,editTextAddress,editTextCylType,editTextDiscount,editTextPanCard,editTextGstIn;
    Button btnCreateAccount;

    LoginDataBaseAdapter loginDataBaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        // get Instance  of Database Adapter
        loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();

        // Get Refferences of Views
        editTextUserName=(EditText)findViewById(R.id.editTextUserName);
        editTextPassword=(EditText)findViewById(R.id.editTextPassword);
        editTextConfirmPassword=(EditText)findViewById(R.id.editTextConfirmPassword);

        editTextCustName=(EditText)findViewById(R.id.editTextCustName);
        editMobNo=(EditText)findViewById(R.id.editMobNo);
        editTextAddress=(EditText)findViewById(R.id.editTextAddress);
        editTextCylType=(EditText)findViewById(R.id.editTextCylType);
        editTextDiscount=(EditText)findViewById(R.id.editTextDiscount);
        editTextPanCard=(EditText)findViewById(R.id.editTextPanCard);
        editTextGstIn=(EditText)findViewById(R.id.editTextGstIn);


        btnCreateAccount=(Button)findViewById(R.id.buttonCreateAccount);
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                String userName=editTextUserName.getText().toString();
                String password=editTextPassword.getText().toString();
                String confirmPassword=editTextConfirmPassword.getText().toString();
                String custname=editTextCustName.getText().toString();
                String mobileno=editMobNo.getText().toString();
                String address=editTextAddress.getText().toString();
                String cyltype=editTextCylType.getText().toString();
                String discount=editTextDiscount.getText().toString();
                String pancard=editTextPanCard.getText().toString();
                String gstin=editTextGstIn.getText().toString();


                // check if any of the fields are vaccant
                if(userName.equals("")||password.equals("")||confirmPassword.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Field Vaccant", Toast.LENGTH_LONG).show();
                    return;
                }
                // check if both password matches
                if(!password.equals(confirmPassword))
                {
                    Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
                    return;
                }
                else
                {
                    // Save the Data in Database
                    loginDataBaseAdapter.insertEntry(userName,password,custname,mobileno,address,cyltype,discount,pancard,gstin);
                    Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();

                    Intent intentmain=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intentmain);
                }
            }
        });
    }
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

        loginDataBaseAdapter.close();
    }
}
