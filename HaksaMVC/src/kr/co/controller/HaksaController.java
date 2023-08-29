package kr.co.controller;

import kr.co.view.HaksaDAO;
import kr.co.view.HaksaView;

public class HaksaController {
	public HaksaView view;
	public HaksaDAO dao;
	public HaksaController() {
		view = new HaksaView();
		dao = new HaksaDAO();
	}
	
	public void startApp() {
		while (true) {
			view.menuTitle();
			view.inputNum(5, -1);
			if (HaksaView.num == 1) {
				view.registTitle();
				view.inputNum(5, 0);
				view.inputName();
				view.inputAge();
				if (HaksaView.num == 1) {
					view.inputHakbun();
					dao.registStudent();
				} else if (HaksaView.num == 2) {
					view.inputSub();
					dao.registProfessor();
				} else if (HaksaView.num == 3) {
					view.inputPart();
					dao.registManager();
				}
				view.endRegist(HaksaView.num);
			} else if (HaksaView.num == 2) {
				view.searchTitle("검색");
				view.inputNum(4, 0);
				view.inputNameTitle("검색");
				view.inputName();
				if (HaksaView.num == 1) {
					HaksaView.num = dao.checkExist("student");
					view.checkPerson("학생", HaksaView.num);
					if (HaksaView.num > 0) {
						dao.showStudent();
					}
				} else if (HaksaView.num == 2) {
					HaksaView.num = dao.checkExist("professor");
					view.checkPerson("교수", HaksaView.num);
					if (HaksaView.num > 0) {
						dao.showProfessor();
					}
				} else if (HaksaView.num == 3){
					HaksaView.num = dao.checkExist("manager");
					view.checkPerson("관리자", HaksaView.num);
					if (HaksaView.num > 0) {
						dao.showManager();
					}
				}
			} else if (HaksaView.num == 3) {
				view.searchTitle("삭제");
				view.inputNum(4, 0);
				view.inputNameTitle("삭제");
				view.inputName();
				if (HaksaView.num == 1) {
					HaksaView.num = dao.checkExist("student");
					view.checkPerson("학생", HaksaView.num);
					if (HaksaView.num > 0) {
						dao.showStudentForDelete();
						dao.deletePerson("student");
					}
				} else if (HaksaView.num == 2) {
					HaksaView.num = dao.checkExist("professor");
					view.checkPerson("교수", HaksaView.num);
					if (HaksaView.num > 0) {
						dao.showProfessorForDelete();
						dao.deletePerson("professor");
					}
				} else if (HaksaView.num == 3){
					HaksaView.num = dao.checkExist("manager");
					view.checkPerson("관리자", HaksaView.num);
					if (HaksaView.num > 0) {
						dao.showManagerForDelete();
						dao.deletePerson("manager");
					}
				}
			} else if (HaksaView.num == 4) {
				view.searchTitle("전체출력");
				dao.showAllStudent();
				dao.showAllProfessor();
				dao.showAllManager();
			} else {
				break;
			}
		}
	}
}
