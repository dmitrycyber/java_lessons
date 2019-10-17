import main.java.NegativeNumberException;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Main {
	public static void main (String[] args) {
		intToStringConverter(5, 6, 7);

		stringToInt("1", "2");

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
		sc.close();

		isOdd(5);

		isSevenLastNumeral(66);

		isSymbolInString('a', "qwerta");

		System.out.println(isSymbolInString2('a', "asdfg") + "\n");

		hoursToMinSec(5);

		secondsToDMHS(321654);

		transformString("qwertyu");

		diameter(15);

		try {
			isCover(-3, 14, 21);
		}

		catch (NegativeNumberException e) {
			System.out.println(e.getMessage());
		}

		calculateAge1(2, 12, 1993);

//		calculateAge2 (2, 12, 1993);


	}

	public static void intToStringConverter(int a, int b, int c) {
		String s1 = Integer.toString(a);
		System.out.println(s1 + " " + ((Object) s1).getClass().getSimpleName());
		String s2 = String.valueOf(b);
		System.out.println(s2 + " " + ((Object) s2).getClass().getSimpleName());
		String s3 = "" + c;
		System.out.println(s3 + " " + ((Object) s3).getClass().getSimpleName() + '\n');
	}

	public static void stringToInt(String s1, String s2){
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
		}
		if (x == 0) {
			System.out.println("Символ " + "'" + a + "'" + " не состоит в строке" + '\n');
		}
	}

	public static boolean isSymbolInString2 (char a, String s) {
	    return s.indexOf(a) == 0;
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

	public static void transformString(String s) {
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			if (i == 0 || i % 2 == 0){
				char upper = Character.toUpperCase(s.charAt(i));
				result += upper;
			}
			else {
				result += s.charAt(i);
			}
		}
		System.out.println(result + "\n");
	}

	public static void diameter(int radius) {
		double circumference = 2 * Math.PI * radius;
		double square = Math.PI * radius * radius;
		System.out.println("r = " + radius + " S = " + square + " C = " + circumference + "\n");
	}
	public static boolean isCover(int a, int b, double radius) throws NegativeNumberException {
		double diagonal = Math.sqrt(a * a + b * b);
		if (a < 0 || b < 0 || radius < 0) {
			throw new NegativeNumberException("Введите положительное(ые) число(а)" + "\n");
		}
		else {
			if (radius*2 >= diagonal){
				return true;
			}
			else {
				return false;
			}
		}

	}

	public static void calculateAge1(int dayOfBirth, int monthOfBirth, int yearOfBirth) {
		LocalDate birthday = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
		Period age = Period.between(birthday, LocalDate.now());
		System.out.println(age.getYears() + " years " + age.getMonths() + " months " + age.getDays() + " days");
	}

	/*public static void calculateAge2 (int dayOfBirth, int monthOfBirth, int yearOfBirth){
		Calendar calendar = new GregorianCalendar(yearOfBirth, monthOfBirth, dayOfBirth);
		Date currentDate = new Date();
		long seconds = (currentDate.getTime() -  calendar.getTimeInMillis()) / 1000;
		long years = seconds / 31536000;
		long month = (seconds - years * 31536000) / 2592000;
		long days = (seconds - month * 2592000 - years * 31536000) / 86400;
		System.out.println(years + " years " + month + " months " + days + " days");
	}*/


}

