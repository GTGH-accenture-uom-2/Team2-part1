package org.example.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Insured {
    private String afm;
    private String amka;
    private String name;
    private Date birthdate;
    private String surname;
    private String email;
    private Reservation reservation;
    private VaccinationCenter vaccinationCenter;
    private Doctor doctor = null;
    private Vaccination vaccinationCoverage = null;

    public Insured(String afm, String amka, String name, Date birthdate, String surname, String email) {
        this.afm = afm;
        this.amka = amka;
        this.name = name;
        this.birthdate = birthdate;
        this.surname = surname;
        this.email = email;
        reservation = null;
    }

    //Ασφαλισμενος κανει κρατηση ελευθερο ταιμσλοτ δηλωνοντας τον γιατρο και το ταιμσλοτ
    public void selectTimeslot(Doctor d, Timeslot t) {
        //αν ειναι διαθεσιμο το ταιμσλοτ αν δεν εχει ηδη ρεζερβειτιον αν ο γιατρος εχει μπει σε κεντρο
        if (d.ifSelectedTimeslotAvailable(t) && reservation == null && d.getVc() != null) {
            d.selectTheTimeslot(t);//δεσμευση του ταιμσλοτ
            System.out.println("Insured " + name + " " + surname + " AMKA: " + amka + " made a reservation for " + t.getTimeslotDateAndTime());
            reservation = new Reservation(this, t);
            d.getVc().addReservation(reservation);//προσθηκη του ρεζερβειτον στο κεντρο που εχει δηλωθει ο γιατρος
            vaccinationCenter = d.getVc();//το κεντρο που θα πρεπει να παει
            doctor = d;
        } else if (reservation != null) {
            System.out.println("Insured " + name + " " + surname + " AMKA: " + amka + " has a reservation, delete it first if you want to make a change");
        } else if (d.getVc() == null) {
            System.out.println("Doctor " + d.getName() + " " + d.getSurname() + " isn't added in a vaccination center");
        } else {
            System.out.println("Doctor " + d.getName() + " " + d.getSurname() + " hasn't this timeslot available, choose a different timeslot");
        }
    }

    public void unselectSelectedTimeslot(Timeslot t) {
        doctor.unSelectTheTimeslot(t);//κανει ξανα διαθεσιμο το ταιμσλοτ
        doctor.getVc().deleteReservation(reservation);//ακυρωνει το ρεζερβειτον
        reservation = null;//δηλωνει οτι δεν εχει κρατηση πια
        vaccinationCenter = null;
        doctor = null;
        System.out.println("Insured " + name + " " + surname + " AMKA: " + amka + " deleted his reservation");
    }

    public void makeTheVaccination() {
        if (reservation != null) {
            System.out.println("**Vaccination for " + name + " " + surname + " AMKA: " + amka + " done!");
            vaccinationCenter.deleteReservation(reservation);//deletes the reservation from the center
            doctor.removeTimeslot(reservation.getTimeslot());//Αφαιρειται απο τον γιατρο το συγκεκριμενο timeslot
            //Οταν γινεται ο εμβολιασμος πρεπει να φτιαχνεται και η καλυψη με ισχυ 2 χρονια
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("DD");
            String day = simpleDateFormat.format(reservation.getTimeslot().getDate()).toUpperCase();

            simpleDateFormat = new SimpleDateFormat("MM");
            String month = simpleDateFormat.format(reservation.getTimeslot().getDate()).toUpperCase();

            simpleDateFormat = new SimpleDateFormat("YY");
            int year = Integer.parseInt(simpleDateFormat.format(reservation.getTimeslot().getDate())) + 2;

            String s = day + "/" + month + "/" + year;
            vaccinationCoverage = new Vaccination(this, doctor, reservation.getTimeslot().getTimeslotDateAndTime(), s);
            doctor.addVaccinationsDone(this, reservation.getTimeslot());//prosthetei to vaccination sto timeslot
            reservation = null;
            vaccinationCenter = null;
            doctor = null;
            System.out.println(vaccinationCoverage.returnInfo());
        } else {
            System.out.println("Insured " + name + " " + surname + " doesn't have a reservation");
        }
    }

    //ενημερωνεται αν εχει καλυψη
    public String haveVaccinationCoverage() {

        if (vaccinationCoverage == null) {
            return "Insured " + name + " " + surname + " doesn't have Vaccination Coverage, vaccinate first to get one!";
        } else {
            return "Insured " + name + " " + surname + " has Vaccination Coverage " + vaccinationCoverage.returnInfo();
        }
    }

    public String getAfm() {
        return afm;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public Vaccination getVaccinationCoverage() {
        return vaccinationCoverage;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Insured{" +
                "afm='" + afm + '\'' +
                ", amka='" + amka + '\'' +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", reservation=" + reservation +
                ", vaccinationCenter=" + vaccinationCenter +
                ", doctor=" + doctor +
                ", vaccinationCoverage=" + vaccinationCoverage +
                '}';
    }
}
