package com.quiz.quizapp;

import java.util.ArrayList;
import java.util.List;

public class QuestionsBank {
    private static List<QuestionsList> scienceQuestions() {

    final List<QuestionsList> questionsLists = new ArrayList<>();

    final QuestionsList question1 = new QuestionsList("Skąd rośliny pobierają składniki odżywcze?","Z chlorofilu","Z ziemi","Z atmosfery","Z ziemi","");
    final QuestionsList question2 = new QuestionsList("Ile kości ma ciało dorosłego człowieka?","206","110","250","206","");
    final QuestionsList question3 = new QuestionsList("Jaka jest największa planeta układu słonecznego?","Mars","Jowisz","Saturn","Jowisz","");
    final QuestionsList question4 = new QuestionsList("Jaki jest najtwardszy materiał na ziemi?","Diament","Karbid","Piwo","Diament","");

        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);

    return questionsLists;
}
    private static List<QuestionsList> eu4Questions() {

        final List<QuestionsList> questionsLists = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("W którym roku rozpoczyna się gra?","1444","1505","1410","1444","");
        final QuestionsList question2 = new QuestionsList("Jakie jest najsilniejsze państwo na początku gry?","Ottomani","Austria","Francja","Ottomani","");
        final QuestionsList question3 = new QuestionsList("Kto jest najlepszym generałem startowym?","Skandeberg","Sikorski","Floyd","Skandeberg","");
        final QuestionsList question4 = new QuestionsList("W którym roku kończy się gra?","1656","1821","1914","1821","");

        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);

        return questionsLists;
    }

    private static List<QuestionsList> javaQuestions() {

        final List<QuestionsList> questionsLists = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("Który typ danych jest poprawny w języku java?","Int","byte","Short","byte","");
        final QuestionsList question2 = new QuestionsList("Co zostanie wypisane na ekranie: byte b = (byte)256; System.out.println(b); ?","b","Kod nie skompiluje się","256","Kod nie skompiluje się","");
        final QuestionsList question3 = new QuestionsList("Czy JavaScript to biblioteka języka Java?","Tak","Nie","Nie wiem, choć się domyślam","Nie","");
        final QuestionsList question4 = new QuestionsList("Czy Java jest fajna?","Nie","Tak","Raczej tak","Raczej tak","");

        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);

        return questionsLists;
    }
    private static List<QuestionsList> geographyQuestions() {

        final List<QuestionsList> questionsLists = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("Co jest stolicą Australii?","Wiczlino","Canberra","Sydney","Canberra","");
        final QuestionsList question2 = new QuestionsList("W którym województwie jest najwięcej jezior?","Pomorskim","Mazurskim","Podkarpackim","Mazurskim","");
        final QuestionsList question3 = new QuestionsList("Ile metrów ma najwyższy budynek w Polsce?","213,7m","230m","187m","230m","");
        final QuestionsList question4 = new QuestionsList("Jakie jest najglębsze jezioro w Polsce?","Hańcza","Bajkał","Śniardwy","Hańcza","");

        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);

        return questionsLists;
    }
public static List<QuestionsList> getQuestions(String selectedTopicName){
        switch (selectedTopicName){
            case "Wiedza ogólna":
                return scienceQuestions();
            case "Geografia":
                return geographyQuestions();
            case "Java":
                return javaQuestions();
            default:
                return eu4Questions();
        }
    }
}
