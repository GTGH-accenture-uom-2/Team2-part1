package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Doctor {
    private String amka;
    private String name;
    private String surname;
    private HashMap<Timeslot,Boolean> timeslots=new HashMap<>();
    private VaccinationCenter vc=null;

    private HashMap<Insured,Timeslot> vaccinationsDone=new HashMap<>();

    public void setVc(VaccinationCenter vc) {
        this.vc = vc;
    }

    public VaccinationCenter getVc() {
        return vc;
    }

    public Doctor(String amka, String name, String surname) {
        this.amka = amka;
        this.name = name;
        this.surname = surname;
    }

    public void addTimeslot(Timeslot t){
        boolean bool=false;
        for(HashMap.Entry<Timeslot, Boolean> entry : timeslots.entrySet()) {
             if(entry.getKey().getTimeslotDateAndTime().equals(t.getTimeslotDateAndTime())){
                 System.out.println("You have already added this timeslot: "+t.getTimeslotDateAndTime()+" to doctor "+name+" "+surname);
                 bool=true;
             }
        }
        if(bool==false){
            timeslots.put(t,true);
        }
    }

    public String getAmka() {
        return amka;
    }

    public String returnMyTimeslots(){
        String s="Doctor's "+name+" "+surname+" timeslots: \n";
        for(HashMap.Entry<Timeslot, Boolean> entry : timeslots.entrySet()){
            if(entry.getValue()){
                s+=entry.getKey().getTimeslotDateAndTime()+" is available +\n";
            }else{
                s+=entry.getKey().getTimeslotDateAndTime()+" isnt available -\n";
            }
        }
        if(timeslots.size()==0){
            return "Doctor "+name+" "+surname+" AMKA: "+amka+" doesn't have timeslots";
        }else{
            return s;
        }
    }

    public String returnMyAvailableTimeslots(){
        String s="Doctor's "+name+" "+surname+" AMKA: "+amka+" timeslots: \n";
        for(HashMap.Entry<Timeslot, Boolean> entry : timeslots.entrySet()){
            if(entry.getValue()){
                s+=entry.getKey().getTimeslotDateAndTime()+" is available +\n";
            }
        }
        if(timeslots.size()==0){
            return "Doctor "+name+" "+surname+" doesn't have timeslots";
        }else{
            return s;
        }
    }

    //επιστρεφει αν το ταιμσλοτ που επιλεχθηκε ειναι διαθεσιμο
    public boolean ifSelectedTimeslotAvailable(Timeslot t){
        boolean bool=false;
        for(Map.Entry<Timeslot, Boolean> entry : timeslots.entrySet()){
            if(entry.getKey()==t){
                bool=entry.getValue();
            }
        }
        return bool;
    }

    public void addVaccinationsDone(Insured ins,Timeslot t){
        vaccinationsDone.put(ins,t);
    }

    public String returnTheVaccinationsDone(){
        String s="Doctor's "+name+" "+surname+" AMKA: "+amka+" vaccinations:\n";
        for(Map.Entry<Insured, Timeslot> entry : vaccinationsDone.entrySet()){
            s+=entry.getKey().getName()+" "+entry.getKey().getSurname()+" at "+entry.getValue().getTimeslotDateAndTime()+"\n";
        }
        return s;
    }
    //κανει το ταιμσλοτ μη διαθεσιμο
    public void selectTheTimeslot(Timeslot t){
        timeslots.put(t,false);
    }

    //το κανει ξαωα διαθεσιμο
    public void unSelectTheTimeslot(Timeslot t){
        timeslots.put(t,true);
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public void removeTimeslot(Timeslot t){//Αφαιρειται οταν γινεται ενας εμβολιασμος με αυτο το ταιμσλοτ
        timeslots.remove(t);
    }

    public String reservationsPerVaccinationCenter(VaccinationCenter vc){
        return "Doctor "+name+" "+surname+" AMKA: "+amka+" searched for the reservations of the vaccination center with code"+vc.getCode()+"\n"+vc.returnAllMyReservations();
    }
}
