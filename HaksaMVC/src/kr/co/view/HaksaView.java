package kr.co.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HaksaView {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	public static int num;
	public static String name;
	public static int age;
	public static String hakbun;
	public static String sub;
	public static String part;
	public static int choiceNo;
	
	public void menuTitle() {
		System.out.println("========= 메뉴 선택 =========");
		System.out.println("1. 등록");
		System.out.println("2. 찾기");
		System.out.println("3. 삭제");
		System.out.println("4. 전체 출력");
		System.out.println("--------------------------");
		System.out.println("0. 종료");
		System.out.println("--------------------------");
		System.out.print("번호를 선택해 주세요..");
	}
	public void inputNum(int a, int b) {
		try {
			int inputNum = Integer.parseInt(br.readLine());
			if (!(inputNum < a && inputNum > b)) {
				throw new ExceptionMy((b + 1) + " ~ " + (a - 1) + "사이의 숫자만 입력하시오");
			}
			if ((inputNum + "").trim() == null) {
				throw new ExceptionInputNull();
			}
			num = inputNum;
		} catch (ExceptionMy me) {
			System.out.println(me.getMessage());
			inputNum(a, b);
		} catch (ExceptionInputNull e) {
			System.out.println(e.getMessage());
			inputNum(a, b);
		} catch (Exception e) {
			System.out.println((b + 1) + " ~ " + (a - 1) + "사이의 숫자만 입력하시오");
			inputNum(a, b);
		}
	}
	public void registTitle() {
		System.out.println("========= 메뉴 선택 =========");
		System.out.println("1. 학생");
		System.out.println("2. 교수");
		System.out.println("3. 관리자");
		System.out.println("4. 이전메뉴");
		System.out.print("번호를 선택해 주세요..");
	}
	public void inputName() {
		System.out.print("이름 입력 : ");
		try {
			String name = br.readLine();
			if (name.trim().isEmpty()) {
				throw new ExceptionInputNull();
			} else if (name.length() > 10) {
				throw new ExceptionMy("이름이 너무 깁니다. 10자내로 입력해주세요");
			}
			HaksaView.name = name;
		} catch (ExceptionInputNull e) {
			System.out.println(e.getMessage());
			inputName();
		} catch (ExceptionMy em) {
			System.out.println(em.getMessage());
			inputName();
		} catch (IOException ioe) {
			ioe.getStackTrace();
		}
	}
	public void inputAge() {
		System.out.print("나이 입력 : ");
		try {
			int age = Integer.parseInt(br.readLine());
			if ((age + "").trim().isEmpty()) {
				throw new ExceptionInputNull();
			}
			HaksaView.age = age;
		} catch (ExceptionInputNull ein) {
			System.out.println(ein.getMessage());
			inputAge();
		} catch (Exception e) {
			System.out.println("나이는 숫자로만 입력하세요");
			inputAge();
		}
	}
	public void inputHakbun() {
		System.out.print("학번 입력 : ");
		try {
			String hakbun = br.readLine();
			if (hakbun.trim().isEmpty()) {
				throw new ExceptionInputNull();
			} else if (hakbun.length() > 10) {
				throw new ExceptionMy("학번이 너무 깁니다. 10자내로 입력해주세요");
			}
			for (int i = 0; i < hakbun.length(); i++) {
				if (!(hakbun.charAt(i) > 47 || hakbun.charAt(i) < 58)) {
					throw new ExceptionMy2("학번은 10자내의 숫자로만 입력하세요");
				}
			}
			HaksaView.hakbun = hakbun;
		} catch (ExceptionInputNull ein) {
			System.out.println(ein.getMessage());
			inputHakbun();
		} catch (ExceptionMy em) {
			System.out.println(em.getMessage());
			inputHakbun();
		} catch (ExceptionMy2 em2) {
			System.out.println(em2.getMessage());
			inputHakbun();
		} catch (Exception e) {
			e.getStackTrace();
			inputHakbun();
		}
	}
	public void inputSub() {
		System.out.print("과목 입력 : ");
		try {
			String sub = br.readLine();
			if (sub.trim().isEmpty()) {
				throw new ExceptionInputNull();
			} else if (sub.length() > 10) {
				throw new ExceptionMy("과목이 너무 깁니다. 10자내로 입력해주세요");
			}
			HaksaView.sub = sub;
		} catch (ExceptionInputNull ein) {
			System.out.println(ein.getMessage());
			inputPart();
		} catch (ExceptionMy em) {
			System.out.println(em.getMessage());
			inputPart();
		} catch (IOException ioe) {
			ioe.getStackTrace();
		}
	}
	public void inputPart() {
		System.out.print("부서 입력 : ");
		try {
			String part = br.readLine();
			if (part.trim().isEmpty()) {
				throw new ExceptionInputNull();
			} else if (part.length() > 10) {
				throw new ExceptionMy("부서가 너무 깁니다. 10자내로 입력해주세요");
			}
			HaksaView.part = part;
		} catch (ExceptionInputNull ein) {
			System.out.println(ein.getMessage());
			inputPart();
		} catch (ExceptionMy em) {
			System.out.println(em.getMessage());
			inputPart();
		} catch (IOException ioe) {
			ioe.getStackTrace();
		}
	}
	public void endRegist(int a) {
		if (a == 1) {
			System.out.println("학생 등록 완료\n");
		} else if (a == 2) {
			System.out.println("교수 등록 완료\n");
		} else if (a == 3) {
			System.out.println("매니저 등록 완료\n");
		}
	}
	public void searchTitle(String str) {
		System.out.println(str + "메뉴");
		System.out.println("1 - 학생, 2 - 교수, 3 - 관리자");
		System.out.print("번호를 선택해 주세요..");
	}
	public void inputNameTitle(String str) {
		System.out.println(str + "하고싶은사람의 이름을 입력해주세요");
	}
	public void checkPerson(String str, int cnt) {
		if (cnt == 0) System.out.println(HaksaView.name + "의 " + str + "정보가 없습니다");
		else {
			System.out.println(HaksaView.name + "의 " + str + "정보가 " + cnt + "개 있습니다"); 
		}
	}
	public void choiceNoTitle() {
		System.out.println("삭제하고싶은 정보의 고유번호를 입력해주세요");
		System.out.println("고유번호를 잘못입력하면 삭제가 취소되고 처음화면으로 돌아갑니다");
	}
	public void choiceNo() {
		try {
			int num = Integer.parseInt(br.readLine());
			choiceNo = num;
		} catch (NumberFormatException e) {
			System.out.println("숫자만 입력하세요");
			choiceNo();
		} catch (IOException e) {
			choiceNo();
		}
	}
}
