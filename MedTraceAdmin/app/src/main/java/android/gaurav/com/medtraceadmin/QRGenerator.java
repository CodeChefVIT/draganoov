package android.gaurav.com.medtraceadmin;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class QRGenerator extends AppCompatActivity {


    EditText textQRcode;
    Button convert;
    ImageView qrCodeHolder;
    String qrText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrgenerator);

        textQRcode = findViewById(R.id.text_qr_code);
        convert = findViewById(R.id.convert);
        qrCodeHolder = findViewById(R.id.qr_code_holder);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                qrText = textQRcode.getText().toString();

                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try {
                    BitMatrix bitMatrix = multiFormatWriter.encode(qrText, BarcodeFormat.UPC_A,200,200);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                    qrCodeHolder.setImageBitmap(bitmap);
                }catch(WriterException e) {
                    e.printStackTrace();
                }

            }
        });

    }
}
