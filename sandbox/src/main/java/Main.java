import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	public static void main (String[] args) {
		intToString(5, 6, 7);

		stringToIntMet("1", "2");

		/*String to int manual*/
		StringToInt s = new StringToInt();
		System.out.println("Введите строку:");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		try {
			s.stringToInt(str);
		}
		catch (SpecialCharException e) {
			System.out.println(e.getMessage() + ", попробуйте снова." + "\n");
		}

		isOdd(5);

		isSevenLastNumeral(66);

		isSymbolInString('a', "qwerta");

		hoursToMinSec(5);

		secondsToDMHS(321654);

		toUpperCase("qwertyu");

		diameter(15);

		System.out.println(isCover(15, 14, 21) + "\n");

		System.out.println(age(2, 12, 1993));
	}

	public static void intToString (int a, int b, int c) {
		String s1 = Integer.toString(a);
		System.out.println(s1 + " " + ((Object) s1).getClass().getSimpleName());
		String s2 = String.valueOf(b);
		System.out.println(s2 + " " + ((Object) s2).getClass().getSimpleName());
		String s3 = "" + c;
		System.out.println(s3 + " " + ((Object) s3).getClass().getSimpleName() + '\n');
	}

	public static void stringToIntMet (String s1, String s2){
		int a = Integer.parseInt(s1);
		System.out.println(a + " " + ((Object) a).getClass().getSimpleName());
		int b = Integer.valueOf(s2);
		System.out.println(b + " " + ((Object) b).getClass().getSimpleName() + '\n');
	}

    public static void isOdd (int a) {
		if (a % 2 == 0) {
			System.out.println("Четное" + '\n');
		} else {
			System.out.println("Нечетное" + '\n');
		}
	}

	public static void isSevenLastNumeral (int a) {
		if (a % 10 != 7) {
			System.out.println("Число не заканчивается на 7" + '\n');
		}
		else {
			System.out.println("Число заканчивается на 7" + '\n');
		}
	}

	public static void isSymbolInString (char a, String s) {
		int x = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == a) {
				System.out.println("Символ " + "'" + a + "'" + " состоит в строке" + '\n');
				x = 1;
				break;
			}
			else {
				continue;
			}
		}
		if (x == 0) {
			System.out.println("Символ " + "'" + a + "'" + " не состоит в строке" + '\n');
		}
	}

	public static void hoursToMinSec (int hours) {
		int minutes = hours * 60;
		int seconds = minutes * 60;
		System.out.println(minutes + " минут " +  seconds + " секунд" + '\n');
	}

	public static void secondsToDMHS(int secondsTotal) {
		int days = secondsTotal / 86400;
		int hours = (secondsTotal - days * 86400) / 3600;
		int minutes = (secondsTotal - days * 86400 - hours * 3600) / 60;
		int seconds = secondsTotal - days * 86400 - hours * 3600 - minutes * 60;
		System.out.println(secondsTotal + " second(s) = " + days + " day(s) " + hours + " hour(s) " + minutes + " minute(s) " + seconds + " second(s)" + "\n");
	}

	public static void toUpperCase (String s) {
		String done = "";
		for (int i = 0; i < s.length(); i++) {
			if (i == 0 || i % 2 == 0){
				char upper = Character.toUpperCase(s.charAt(i));
				done += upper;
				continue;
			}
			else {
				done += s.charAt(i);
			}
		}
		System.out.println(done + "\n");
	}

	public static void diameter(int radius) {
		double circumference = 2 * Math.PI * radius;
		double square = Math.PI * radius * radius;
		System.out.println("r = " + radius + " S = " + square + " C = " + circumference + "\n");
	}
	public static boolean isCover(int a, int b, double radius) {
		double diagonal = Math.sqrt(a * a + b * b);
		if (radius >= diagonal){
			return true;
		}
		else {
			return false;
		}
	}

	public static int age (int dateOfBirth, int monthOfBirth, int yearOfBirth) {
		LocalDate date = LocalDate.now();
		int currentDate = date.getDayOfMonth();
		int currentMonth = date.getMonthValue();
		int currentYear = date.getYear();
		int age = currentYear - yearOfBirth;
		if (currentMonth < monthOfBirth || (currentDate < dateOfBirth & currentDate == dateOfBirth)) {
			age --;
		}
		return age;
	}


}

