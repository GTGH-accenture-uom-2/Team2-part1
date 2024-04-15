package org.example;

import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        /*ΓΕΝΙΚΑ:Με το που δημιουργείται ένα timeslot ανατίθεται και σε γιατρό
                 Μετά ο γιατρός ανατίθεται σε center με όλα του τα timeslots
                 Ασφαλισμένος διαλέγει γιατρό και ώρα που θέλει να εμβολιαστεί*/


        ArrayList<Insured> insureds = new ArrayList<>();
        Insured insured1 =new Insured("171054858","8216745678","Kostas",new Date(1944,Calendar.DECEMBER,4),"Papadopoulos","papadko@gmail.com");
        Insured insured2 =new Insured("174564856","3457858356","Eleni",new Date(2004,Calendar.JANUARY,8),"Avani","eleniav@gmail.com");
        Insured insured3 =new Insured("123054856","7574675767","Maria",new Date(1991,Calendar.JULY,8),"Davi","davimar@gmail.com");
        Insured insured4 =new Insured("975644855","5682764167","Ioanna",new Date(1934,Calendar.FEBRUARY,7),"Dagmati","iodag@gmail.com");
        Insured insured5 =new Insured("458054856","4582167867","Leonidas",new Date(2010,Calendar.JUNE,6),"Aggelidis","lagge@gmail.com");
        Insured insured6 =new Insured("171058256","8216756435","Giorgos",new Date(1946,Calendar.AUGUST,3),"Eugenidis","gioeuge@gmail.com");
        Insured insured7 =new Insured("163784857","6558234167","Giannis",new Date(1952,Calendar.DECEMBER,12),"Moustakas","moustakasg@gmail.com");
        Insured insured8 =new Insured("128054856","4546882167","Christos",new Date(2002,Calendar.JULY,15),"Staikos","christaikos@gmail.com");
        Insured insured9 =new Insured("368094856","8986432167","Anna",new Date(1932,Calendar.DECEMBER,18),"Thanou","annathanou@gmail.com");
        Insured insured10 =new Insured("171026796","821676780","Sofia",new Date(1993,Calendar.JULY,22),"Okalidou","sogiako@gmail.com");
        Insured insured11 =new Insured("465054856","984662167","Petros",new Date(1924,Calendar.AUGUST,26),"Kalogeras","petrosk@gmail.com");
        Insured insured12 =new Insured("171069459","356821967","Vasilis",new Date(2016,Calendar.AUGUST,12),"Vlassis","vasvas@gmail.com");
        Insured insured13 =new Insured("573984856","488215667","Kostas",new Date(1993,Calendar.DECEMBER,10),"Empeiros","empeirosko@gmail.com");
        Insured insured14 =new Insured("171038566","856862167","Maria",new Date(1997,Calendar.AUGUST,9),"Papadopoulou","mariapapado@gmail.com");
        Insured insured15 =new Insured("592560956","845792167","Alexandros",new Date(2003,Calendar.FEBRUARY,1),"Pasalidis","alexpas@gmail.com");

        insureds.add(insured1);
        insureds.add(insured2);
        insureds.add(insured3);
        insureds.add(insured4);
        insureds.add(insured5);
        insureds.add(insured6);
        insureds.add(insured7);
        insureds.add(insured8);
        insureds.add(insured9);
        insureds.add(insured10);
        insureds.add(insured11);
        insureds.add(insured12);
        insureds.add(insured13);
        insureds.add(insured14);
        insureds.add(insured15);

        VaccinationCenter vc1 = new VaccinationCenter("VC123","EDW 13");
        VaccinationCenter vc2 = new VaccinationCenter("VC756","EKEI 56");

        Doctor doctor1 = new Doctor("23456734502","Axilleas","Paraskevopoulos");
        Doctor doctor2 = new Doctor("23356534502","Mihalis","Stravelas");
        Doctor doctor3 = new Doctor("56786734502","Parmenion","Kampanidis");
        Doctor doctor4 = new Doctor("79456734558","Sotiris","Silalis");

        Timeslot timeslot1=new Timeslot(new Date(24, Calendar.JUNE,1,10, 40),doctor1);
        Timeslot timeslot2=new Timeslot(new Date(24, Calendar.JUNE,2,10, 40),doctor1);
        Timeslot timeslot3=new Timeslot(new Date(24, Calendar.JUNE,3,10, 40),doctor1);
        Timeslot timeslot4=new Timeslot(new Date(24, Calendar.JUNE,4,10, 40),doctor1);
        Timeslot timeslot5=new Timeslot(new Date(24, Calendar.JUNE,5,10, 40),doctor1);
        Timeslot timeslot6=new Timeslot(new Date(24, Calendar.JUNE,6,10, 40),doctor2);
        Timeslot timeslot7=new Timeslot(new Date(24, Calendar.JUNE,7,10, 40),doctor2);
        Timeslot timeslot8=new Timeslot(new Date(24, Calendar.JUNE,8,10, 40),doctor2);
        Timeslot timeslot9=new Timeslot(new Date(24, Calendar.JUNE,9,10, 40),doctor2);
        Timeslot timeslot10=new Timeslot(new Date(24, Calendar.JUNE,10,10, 40),doctor2);

        vc1.addDoctor(doctor1);
        vc1.addDoctor(doctor2);

        Timeslot timeslot11=new Timeslot(new Date(24, Calendar.JUNE,11,10, 40),doctor3);
        Timeslot timeslot12=new Timeslot(new Date(24, Calendar.JUNE,12,10, 40),doctor3);
        Timeslot timeslot13=new Timeslot(new Date(24, Calendar.JUNE,13,10, 40),doctor3);
        Timeslot timeslot14=new Timeslot(new Date(24, Calendar.JUNE,14,10, 40),doctor3);
        Timeslot timeslot15=new Timeslot(new Date(24, Calendar.JUNE,15,10, 40),doctor3);
        Timeslot timeslot16=new Timeslot(new Date(24, Calendar.JUNE,16,10, 40),doctor4);
        Timeslot timeslot17=new Timeslot(new Date(24, Calendar.JUNE,17,10, 40),doctor4);
        Timeslot timeslot18=new Timeslot(new Date(24, Calendar.JUNE,18,10, 40),doctor4);
        Timeslot timeslot19=new Timeslot(new Date(24, Calendar.JUNE,19,10, 40),doctor4);
        Timeslot timeslot20=new Timeslot(new Date(24, Calendar.JUNE,20,10, 40),doctor4);

        vc2.addDoctor(doctor3);
        vc2.addDoctor(doctor4);

        insured1.selectTimeslot(doctor1,timeslot1);
        insured2.selectTimeslot(doctor1,timeslot2);
        insured3.selectTimeslot(doctor2,timeslot6);
        insured4.selectTimeslot(doctor2,timeslot7);

        insured5.selectTimeslot(doctor3,timeslot11);
        insured6.selectTimeslot(doctor3,timeslot12);
        insured7.selectTimeslot(doctor4,timeslot19);
        insured8.selectTimeslot(doctor4,timeslot20);

        insured2.makeTheVaccination();
        insured3.makeTheVaccination();
        insured4.makeTheVaccination();
        insured6.makeTheVaccination();
        insured7.makeTheVaccination();
        insured8.makeTheVaccination();

        System.out.println("Τα επικείμενα ραντεβού για κάθε εμβολιαστικό κέντρο");
        System.out.println(vc1.returnAllMyReservations());
        System.out.println(vc2.returnAllMyReservations());
        System.out.println("");

        System.out.println("Τις ελεύθερες χρονικές θυρίδες κάθε εμβολιαστικού κέντρου");
        System.out.println(vc1.availableTimeslotsOfVc());
        System.out.println(vc2.availableTimeslotsOfVc());
        System.out.println("");

        System.out.println("Τους εμβολιασμούς (ημερομηνία εμβολιασμού και ονοματεπώνυμο ασφαλισμένου) που " +
                "πραγματοποίησε κάθε γιατρός, για όλους τους γιατρούς.");
        System.out.println(doctor1.returnTheVaccinationsDone());
        System.out.println(doctor2.returnTheVaccinationsDone());
        System.out.println(doctor3.returnTheVaccinationsDone());
        System.out.println(doctor4.returnTheVaccinationsDone());
        System.out.println("");

        System.out.println("Τους ασφαλισμένους άνω των 60 ετών που δεν έχουν κλείσει ραντεβού για εμβολιασμό.");
        for(Insured ins:insureds){
            if(ins.getVaccinationCoverage()==null && ins.getReservation()==null && Year.now().getValue()-ins.getBirthdate().getYear()>60){
                 System.out.println(ins.getName()+" "+ins.getSurname()+ " AFM: "+ins.getAfm()+" is over 60 and never made a reservation for vaccination");
            }
        }













        //Merika dika mou test cases
        /*Insured insured1 =new Insured(171054858,82167,"Kostas",new Date(24,Calendar.DECEMBER,4),"Papadopoulos","papadko@gmail.com");
        Insured insured2 =new Insured(174564856,58356,"Eleni",new Date(4,Calendar.JANUARY,8),"Avani","eleniav@gmail.com");
        Insured insured3 =new Insured(123054856,75746,"Maria",new Date(2,Calendar.DECEMBER,30),"Davi","davimar@gmail.com");

        Doctor doc1=new Doctor(686787867,"Nikolaos","Papadopoulos");
        Doctor doc2=new Doctor(656545467,"Giannis","Papadopoulos");
        Doctor doc3=new Doctor(645687867,"Maria","Papadopoulos");
        Doctor doc4=new Doctor(548737867,"Eleni","Papadopoulos");

        Timeslot t1=new Timeslot(new Date(24, Calendar.JANUARY,1,10, 40),doc1);
        Timeslot t2=new Timeslot(new Date(24, Calendar.FEBRUARY,10,10, 40),doc2);
        Timeslot t3=new Timeslot(new Date(24, Calendar.JULY,15,10, 40),doc3);
        Timeslot t4=new Timeslot(new Date(24, Calendar.DECEMBER,12,10, 40),doc4);

        VaccinationCenter vc1 = new VaccinationCenter("VC123","EDW 13");
        VaccinationCenter vc2 = new VaccinationCenter("VC756","EKEI 56");

        vc1.addDoctor(doc1);
        vc1.addDoctor(doc3);
        vc2.addDoctor(doc2);
        vc2.addDoctor(doc4);
        vc2.addDoctor(doc1);

        System.out.println(doc1.returnMyTimeslots());

        insured1.selectTimeslot(doc1,t1);
        System.out.println(doc1.returnMyAvailableTimeslots());

        insured1.selectTimeslot(doc1,t3);
        insured1.unselectSelectedTimeslot(t1);
        insured1.selectTimeslot(doc1,t1);

        insured2.selectTimeslot(doc3,t3);

        System.out.println(doc1.returnMyTimeslots());

        insured1.makeTheVaccination();

        System.out.println(doc1.returnMyTimeslots());

        System.out.println(insured1.haveVaccinationCoverage());
        System.out.println(insured2.haveVaccinationCoverage());

        System.out.println(doc1.reservationsPerVaccinationCenter(vc1));
        System.out.println(doc1.reservationsPerVaccinationCenter(vc2));*/
    }
}