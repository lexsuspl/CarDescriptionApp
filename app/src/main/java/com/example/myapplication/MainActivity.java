package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    int samochod = 1; // Zmienna wskazująca aktualnie wyświetlany samochód
    ImageButton dalej;
    ImageButton wroc;
    TextView nazwa;
    TextView opis;

    String opis1 = "FSO Polonez miał napęd na tylne koła, oferując silniki benzynowe o pojemności od 1.3 do 2.0 litra, 4-cylindrowe. Wyposażony był w 4- lub 5-biegową skrzynię manualną. Początkowo dostępny jako hatchback, później także w wersji sedan, kombi i pick-up.";
    String opis2 = "Audi RS6 to sportowa wersja modelu A6 produkowana przez Audi Sport GmbH. Charakteryzuje się potężnym silnikiem V8 o pojemności 4.0 litra z podwójnym turbodoładowaniem, generującym moc około 600 KM. Napęd na cztery koła quattro oraz 8-biegowa automatyczna skrzynia biegów zapewniają wyjątkowe osiągi i doskonałą trakcję.";
    String opis3 = "Audi A3 to kompaktowy samochód premium, oferowany w wersjach hatchback i sedan. Wyposażony w nowoczesne technologie, silniki benzynowe i diesla o pojemnościach od 1.0 do 2.0 litra. Charakteryzuje się eleganckim designem, komfortowym wnętrzem i dynamiczną jazdą.";
    String opis4 = "BMW E39 to czwarta generacja modelu serii 5, produkowana w latach 1995–2004. Jest ceniona za doskonałe właściwości jezdne, komfort oraz solidną jakość wykonania.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        dalej = findViewById(R.id.dalej);
        wroc = findViewById(R.id.wstecz);
        nazwa = findViewById(R.id.nazwa);
        opis = findViewById(R.id.opis);

        // Wywołujemy metodę, aby ustawić początkowy samochód
        ChangeCar();

        // Listener dla przycisku "dalej" - przełącza na kolejny samochód
        dalej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                samochod++;
                if (samochod > 4) samochod = 1; // Cykluje przez samochody (wraca do 1 po ostatnim)
                ChangeCar();
            }
        });

        // Listener dla przycisku "wstecz" - przełącza na poprzedni samochód
        wroc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                samochod--;
                if (samochod < 1) samochod = 4; // Cykluje przez samochody (wraca do 4 po pierwszym)
                ChangeCar();
            }
        });
    }

    // Metoda zmieniająca wyświetlany samochód
    void ChangeCar() {
        switch (samochod) {
            case 1:
                nazwa.setText("FSO Polonez");
                opis.setText(opis1);
                break;
            case 2:
                nazwa.setText("Audi RS6");
                opis.setText(opis2);
                break;
            case 3:
                nazwa.setText("Audi A3");
                opis.setText(opis3);
                break;
            case 4:
                nazwa.setText("BMW E39");
                opis.setText(opis4);
                break;
        }
    }
}
