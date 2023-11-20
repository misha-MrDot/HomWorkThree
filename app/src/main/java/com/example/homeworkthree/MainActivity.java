package com.example.homeworkthree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String poem = "У лукоморья дуб зелёный;\n" +
            "Златая цепь на дубе том:\n" +
            "И днём и ночью кот учёный\n" +
            "Всё ходит по цепи кругом;\n" +
            "\n" +
            "Идёт направо - песнь заводит,\n" +
            "Налево - сказку говорит.\n" +
            "Там чудеса: там леший бродит,\n" +
            "Русалка на ветвях сидит;\n" +
            "\n" +
            "Там на неведомых дорожках\n" +
            "Следы невиданных зверей;\n" +
            "Избушка там на курьих ножках\n" +
            "Стоит без окон, без дверей;\n" +
            "\n" +
            "Там лес и дол видений полны;\n" +
            "Там о заре прихлынут волны\n" +
            "На брег песчаный и пустой,\n" +
            "И тридцать витязей прекрасных\n" +
            "\n" +
            "Чредой из вод выходят ясных,\n" +
            "И с ними дядька их морской;\n" +
            "Там королевич мимоходом\n" +
            "Пленяет грозного царя;\n" +
            "\n" +
            "Там в облаках перед народом\n" +
            "Через леса, через моря\n" +
            "Колдун несёт богатыря;\n" +
            "В темнице там царевна тужит,\n" +
            "\n" +
            "А бурый волк ей верно служит;\n" +
            "Там ступа с Бабою Ягой\n" +
            "Идёт, бредёт сама собой,\n" +
            "Там царь Кащей над златом чахнет;\n" +
            "\n" +
            "Там русский дух... там Русью пахнет!\n" +
            "И там я был, и мёд я пил;\n" +
            "У моря видел дуб зелёный;\n" +
            "Под ним сидел, и кот учёный\n" +
            "Свои мне сказки говорил.";

    private int numberOfCharacters;//число символов в строке
    private int numberOfWords;//число слов в строке
    private int numberOfCharactersL;//число букв л в строке
    private boolean isWordFiveChar;//Наличие слов состоящих из 5 букв
    private String wordCharestersA;//Строка из слов начинающихся на букву а

    private TextView intoApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberOfCharacters = numberOfCharactersMethod(poem);
        numberOfWords = numberOfWordsMethod(poem);
        numberOfCharactersL = numberOfCharactersLMethod(poem);
        isWordFiveChar = isWordFiveCharMethod(poem);
        wordCharestersA = wordCharestersAMethod(poem);

        intoApp = findViewById(R.id.intoApp);
        intoApp.setText("Число символов в строке: "+numberOfCharacters+"\n"+"Число слов в строке: "+numberOfWords+"\n"+"Число букв л в строке: "+numberOfCharactersL+"\n"+"Наличие слов из 5 букв: "+isWordFiveChar+"\n"+"Строка из слов начинающихся на букву а: "+wordCharestersA);
    }
    //количество символов в строке
    private int numberOfCharactersMethod(String stringPoem){
        return stringPoem.length();
    }
    private int numberOfWordsMethod(String stringPoem){
        String stPoem = stringPoem.trim();//удаление пробелов
        int count = 0;
        for(int i = 0;i<stPoem.length();i++){
            if (stPoem.charAt(i) ==' ' | stPoem.charAt(i)=='\n'){
                count++;
            }
        }
        return count;
    }
    //сколько букв л в строке
    private int numberOfCharactersLMethod(String stringPoem){
        int count = 0;
        for (int i = 0;i<stringPoem.length();i++){
            if (stringPoem.charAt(i) == 'л' | stringPoem.charAt(i)=='Л'){
                count++;
            }
        }
        return count;
    }
    //есть ли слово из 5 букв в строке
    private boolean isWordFiveCharMethod(String stringPoem) {
        String[] words = stringPoem.split(" ");

        for (int i = 0; i < words.length; i++) {

            if (words[i].toString().length() == 5) {
                return true;
            }
        }
        return false;

    }
    //формирование строки из букв а
    private String wordCharestersAMethod(String stringPoem){
        String stringM = "";
        String stPoem = stringPoem.replace("\n"," ").trim();
        String[] arrayPoem = stPoem.split(" ");
        for (String string : arrayPoem){
            if (string.charAt(0)=='а' | string.charAt(0)=='А'){
                stringM+=string+" ";
            }
        }
        return stringM.trim();
    }
}