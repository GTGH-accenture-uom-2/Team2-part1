package org.example.utilities;

import org.example.entities.Doctor;
import org.example.entities.Insured;
import org.example.entities.VaccinationCenter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Year;
import java.util.List;

import static org.example.utilities.Constants.OUTPUT_FILE_NAME;

public class FileUtils {
    public static void printResults(List<VaccinationCenter> vaccinationCenters, List<Doctor> doctors, List<Insured> insureds) {
        try {
            File myObj = new File(OUTPUT_FILE_NAME);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }


            FileWriter myWriter = new FileWriter(OUTPUT_FILE_NAME);
            myWriter.write("----Reservations for each vaccination center----\n");
            for (VaccinationCenter vc : vaccinationCenters) {
                myWriter.write(vc.returnAllMyReservations() + "\n");
            }

            myWriter.write("----Available timeslots for each vaccination center----\n");
            for (VaccinationCenter vc : vaccinationCenters) {
                myWriter.write(vc.availableTimeslotsOfVc() + "\n");
            }

            myWriter.write("----Vaccinations every doctor made----\n");
            for (Doctor dc : doctors) {
                myWriter.write(dc.returnTheVaccinationsDone() + "\n");
            }

            myWriter.write("----Insured over 60 without reservation for vaccination.----\n");
            for (Insured ins : insureds) {
                if (ins.getVaccinationCoverage() == null && ins.getReservation() == null && Year.now().getValue() - ins.getBirthdate().getYear() > 60) {
                    myWriter.write(ins.getName() + " " + ins.getSurname() + " AFM: " + ins.getAfm() + " is over 60 and never made a reservation for vaccination\n");
                }
            }

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
