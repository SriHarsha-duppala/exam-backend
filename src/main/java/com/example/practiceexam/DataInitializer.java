package com.example.practiceexam;

import com.example.practiceexam.model.Exam;
import com.example.practiceexam.model.Question;
import com.example.practiceexam.repository.ExamRepository;
import com.example.practiceexam.repository.QuestionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ExamRepository examRepo;
    private final QuestionRepository qRepo;

    public DataInitializer(ExamRepository examRepo, QuestionRepository qRepo) {
        this.examRepo = examRepo;
        this.qRepo = qRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        if (examRepo.count() == 0) {

            // ----------------- Create Exams -----------------
            Exam ssc = examRepo.save(new Exam("SSC Practice Test", "Aptitude, Reasoning & GK", 45));
            Exam rrb = examRepo.save(new Exam("RRB Practice Test", "Numerical Ability, Reasoning & General Awareness", 60));
            Exam upsc = examRepo.save(new Exam("UPSC Practice Test", "General Studies & Current Affairs", 90));
            Exam bank = examRepo.save(new Exam("Bank PO Test", "Quantitative Aptitude, Reasoning & GK", 60));

            List<Exam> exams = List.of(ssc, rrb, upsc, bank);

            // ----------------- Create Questions -----------------
            List<Question> questionBank = new ArrayList<>();
            Random rand = new Random();

            // 1-34 Aptitude Questions
            questionBank.add(new Question(null,"Aptitude","2 + 2 = ?","1","2","3","4","D"));
            questionBank.add(new Question(null,"Aptitude","5 * 6 = ?","30","25","35","40","A"));
            questionBank.add(new Question(null,"Aptitude","Square root of 81?","7","8","9","10","C"));
            questionBank.add(new Question(null,"Aptitude","12 ÷ 4 = ?","2","3","4","6","B"));
            questionBank.add(new Question(null,"Aptitude","15 + 17 = ?","32","30","33","34","A"));
            questionBank.add(new Question(null,"Aptitude","7 * 8 = ?","54","56","58","60","B"));
            questionBank.add(new Question(null,"Aptitude","9^2 = ?","81","72","91","79","A"));
            questionBank.add(new Question(null,"Aptitude","50 ÷ 5 = ?","5","10","12","15","B"));
            questionBank.add(new Question(null,"Aptitude","25% of 200?","25","30","40","50","D"));
            questionBank.add(new Question(null,"Aptitude","0.5 * 100 = ?","40","45","50","55","C"));
            questionBank.add(new Question(null,"Aptitude","Next number: 2, 4, 6, ?","8","10","12","14","A"));
            questionBank.add(new Question(null,"Aptitude","LCM of 4 and 6?","10","12","14","16","B"));
            questionBank.add(new Question(null,"Aptitude","HCF of 8 and 12?","2","3","4","6","C"));
            questionBank.add(new Question(null,"Aptitude","10% of 150?","10","15","20","25","B"));
            questionBank.add(new Question(null,"Aptitude","7 + 14 ÷ 2 = ?","14","21","24","17","C"));
            questionBank.add(new Question(null,"Aptitude","3 * 7 + 5 = ?","26","24","23","22","A"));
            questionBank.add(new Question(null,"Aptitude","(8+2) * 3 = ?","25","30","32","28","B"));
            questionBank.add(new Question(null,"Aptitude","50 - 15 = ?","35","30","25","40","A"));
            questionBank.add(new Question(null,"Aptitude","5^3 = ?","100","120","125","130","C"));
            questionBank.add(new Question(null,"Aptitude","Square of 12?","142","144","148","150","B"));
            questionBank.add(new Question(null,"Aptitude","If 3x=12, x=?","3","4","6","5","B"));
            questionBank.add(new Question(null,"Aptitude","15% of 200?","25","30","35","40","B"));
            questionBank.add(new Question(null,"Aptitude","10+20*3=?","70","60","50","40","B"));
            questionBank.add(new Question(null,"Aptitude","7*7-7=?","42","49","48","50","A"));
            questionBank.add(new Question(null,"Aptitude","0.25*400=?","80","90","100","110","C"));
            questionBank.add(new Question(null,"Aptitude","20% of 150=?","25","30","35","40","B"));
            questionBank.add(new Question(null,"Aptitude","5+3*2=?","16","11","10","9","C"));
            questionBank.add(new Question(null,"Aptitude","8*8=?","54","56","64","60","C"));
            questionBank.add(new Question(null,"Aptitude","100/4=?","20","25","30","40","B"));
            questionBank.add(new Question(null,"Aptitude","7^2=?","48","49","50","51","B"));
            questionBank.add(new Question(null,"Aptitude","15-7=?","6","8","9","7","B"));
            questionBank.add(new Question(null,"Aptitude","18+7=?","24","25","26","27","C"));
            questionBank.add(new Question(null,"Aptitude","21-9=?","11","12","13","14","B"));

            // 35-67 Reasoning Questions
            questionBank.add(new Question(null,"Reasoning","Find next: 2,4,8,16, ?","18","24","32","20","C"));
            questionBank.add(new Question(null,"Reasoning","A>B, B>C, A> C. This?","True","False","Cannot say","Maybe","A"));
            questionBank.add(new Question(null,"Reasoning","Odd one: Dog, Cat, Lion, Car","Dog","Cat","Lion","Car","D"));
            questionBank.add(new Question(null,"Reasoning","Analogy: Finger:Hand :: Toe: ?","Foot","Leg","Arm","Head","A"));
            questionBank.add(new Question(null,"Reasoning","Missing letter: A,C,E, ?","G","H","F","I","A"));
            questionBank.add(new Question(null,"Reasoning","SW opposite?","NE","NW","SE","S","A"));
            questionBank.add(new Question(null,"Reasoning","Next: 1,4,9,16, ?","20","24","25","30","C"));
            questionBank.add(new Question(null,"Reasoning","Complete series: 2,5,10,17, ?","24","26","28","30","B"));
            questionBank.add(new Question(null,"Reasoning","Cube of 3?","9","27","12","18","B"));
            questionBank.add(new Question(null,"Reasoning","Mirror image of 'b'?","d","p","q","b","A"));
            questionBank.add(new Question(null,"Reasoning","All cats are dogs. Some dogs are cats?","Yes","No","Cannot say","Maybe","A"));
            questionBank.add(new Question(null,"Reasoning","Find missing number: 5,10,20, ?","25","30","40","35","C"));
            questionBank.add(new Question(null,"Reasoning","Odd: 2,3,5,7,9","2","3","7","9","D"));
            questionBank.add(new Question(null,"Reasoning","Alphabet: B,D,F, ?","G","H","J","I","C"));
            questionBank.add(new Question(null,"Reasoning","Opposite of East?","West","North","South","NE","A"));
            questionBank.add(new Question(null,"Reasoning","If P>Q, Q>R, P>R?","True","False","Cannot say","Maybe","A"));
            questionBank.add(new Question(null,"Reasoning","Choose odd: Apple, Orange, Banana, Car","Apple","Orange","Banana","Car","D"));
            questionBank.add(new Question(null,"Reasoning","Next number: 3,6,9, ?","12","11","10","13","A"));
            questionBank.add(new Question(null,"Reasoning","Find the pair: 2:4 :: 3:?","5","6","7","8","B"));
            questionBank.add(new Question(null,"Reasoning","Cube of 2?","6","8","4","2","B"));
            questionBank.add(new Question(null,"Reasoning","Series: 1,2,4,8, ?","16","18","20","12","A"));
            questionBank.add(new Question(null,"Reasoning","If X>Y, Y>Z, X>Z?","True","False","Cannot say","Maybe","A"));
            questionBank.add(new Question(null,"Reasoning","Odd one: Car, Bus, Bike, Apple","Car","Bus","Bike","Apple","D"));
            questionBank.add(new Question(null,"Reasoning","Sequence: 5,10,20, ?","25","30","40","35","C"));

            // 68-100 GK Questions
            questionBank.add(new Question(null,"General Knowledge","Capital of India?","Mumbai","Chennai","Kolkata","New Delhi","D"));
            questionBank.add(new Question(null,"General Knowledge","Currency of USA?","Dollar","Euro","Yen","Rupee","A"));
            questionBank.add(new Question(null,"General Knowledge","President of India?","Narendra Modi","Droupadi Murmu","Ram Nath Kovind","Pranab Mukherjee","B"));
            questionBank.add(new Question(null,"General Knowledge","Largest continent?","Asia","Africa","Europe","Australia","A"));
            questionBank.add(new Question(null,"General Knowledge","National animal of India?","Tiger","Lion","Elephant","Leopard","A"));
            questionBank.add(new Question(null,"General Knowledge","National bird of India?","Peacock","Sparrow","Eagle","Crow","A"));
            questionBank.add(new Question(null,"General Knowledge","First PM of India?","Jawaharlal Nehru","Gandhi","Indira Gandhi","Rajiv Gandhi","A"));
            questionBank.add(new Question(null,"General Knowledge","Which planet is Red Planet?","Earth","Mars","Venus","Jupiter","B"));
            questionBank.add(new Question(null,"General Knowledge","Founder of Microsoft?","Bill Gates","Steve Jobs","Elon Musk","Mark Zuckerberg","A"));
            questionBank.add(new Question(null,"General Knowledge","National flower of India?","Rose","Lotus","Lily","Tulip","B"));
            questionBank.add(new Question(null,"General Knowledge","Olympics held every?","2 years","3 years","4 years","5 years","C"));
            questionBank.add(new Question(null,"General Knowledge","Largest ocean?","Pacific","Atlantic","Indian","Arctic","A"));
            questionBank.add(new Question(null,"General Knowledge","Smallest country?","Vatican","Maldives","Bhutan","Nepal","A"));
            questionBank.add(new Question(null,"General Knowledge","Who wrote Ramayana?","Valmiki","Vyasa","Tulsidas","Kalidas","A"));
            questionBank.add(new Question(null,"General Knowledge","National fruit of India?","Mango","Apple","Banana","Orange","A"));
            questionBank.add(new Question(null,"General Knowledge","Longest river in India?","Ganga","Yamuna","Godavari","Krishna","A"));
            questionBank.add(new Question(null,"General Knowledge","Current PM of India?","Narendra Modi","Manmohan Singh","Rajiv Gandhi","Indira Gandhi","A"));
            questionBank.add(new Question(null,"General Knowledge","Largest desert in world?","Sahara","Gobi","Thar","Kalahari","A"));
            questionBank.add(new Question(null,"General Knowledge","Highest mountain?","Everest","K2","Kangchenjunga","Lhotse","A"));

            // ----------------- Assign Questions to Exams -----------------
            for (Exam exam : exams) {
                for (Question q : questionBank) {
                    Question copy = new Question(exam, q.getCategory(), q.getQuestionText(),
                            q.getOptionA(), q.getOptionB(), q.getOptionC(), q.getOptionD(), q.getCorrectOption());
                    qRepo.save(copy);
                }
            }
        }
    }
}
