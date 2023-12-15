package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("##########Informations of account##########");
		try {
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("check-in date (dd/MM/yyyy): ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkout = sdf.parse(sc.next());

		Reservation reservation = new Reservation(number, checkin, checkout);
		System.out.println("Reservation: " + reservation);

		System.out.println();
		System.out.println("##########Enter data to update the reservation##########");
		System.out.print("check-in date (dd/MM/yyyy): ");
		checkin = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		checkout = sdf.parse(sc.next());

		reservation.upDate(checkin, checkout);
		System.out.println("Reservation: " + reservation);

		}catch(ParseException p) {
			System.out.println("INVALID DATE FORMAT");
		}catch (DomainException d) {
			System.out.println("Error in reservation: " + d.getMessage());
		}catch (RuntimeException r) {
			System.out.println("Unexpected error: " + r.getMessage());
		}
		sc.close();
	}

}
