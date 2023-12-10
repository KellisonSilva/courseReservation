package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("##########Informations of account##########");
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("check-in date (dd/MM/yyyy): ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkout = sdf.parse(sc.next());

		boolean verifyCheckinAndCheckout = !checkin.after(checkout);
		if (verifyCheckinAndCheckout) {
			Reservation reservation = new Reservation(number, checkin, checkout);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("##########Enter data to update the reservation##########");
			System.out.print("check-in date (dd/MM/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = sdf.parse(sc.next());

			Date now = new Date();
			if (checkin.before(now) || checkout.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			} else if (verifyCheckinAndCheckout) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}else {
				reservation.upDate(checkin, checkout);
				System.out.println("Reservation: " + reservation);
			}


		} else {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}

		sc.close();
	}

}
