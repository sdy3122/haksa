package kr.co.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HaksaDAO {
	Statement stmt;
	ResultSet rs;
	HaksaView view = new HaksaView();

	public void registStudent() {
		stmt = DBUtil.statement();
		try {
			stmt.executeUpdate("insert into student (age, irum, hakbun) values ('"+HaksaView.age+"', '"+HaksaView.name+"', '"+HaksaView.hakbun+"')");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("학생등록실패\n");
		} finally {
			if (stmt != null) DBUtil.disconnect(stmt);
		}
	}
	public void registProfessor() {
		stmt = DBUtil.statement();
		try {
			stmt.executeUpdate("insert into professor (age, irum, sub) values ('"+HaksaView.age+"', '"+HaksaView.name+"', '"+HaksaView.sub+"')");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("교수등록실패\n");
		} finally {
			if (stmt != null) DBUtil.disconnect(stmt);
		}
	}
	public void registManager() {
		stmt = DBUtil.statement();
		try {
			stmt.executeUpdate("insert into manager (age, irum, part) values ('"+HaksaView.age+"', '"+HaksaView.name+"', '"+HaksaView.part+"')");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("관리자등록실패\n");
		} finally {
			if (stmt != null) DBUtil.disconnect(stmt);
		}
	}
	public int checkExist(String str) {
		stmt = DBUtil.statement();
		int cnt = 0;
		try {
			rs = stmt.executeQuery("select * from "+str+" where irum = '"+HaksaView.name+"'");
			while (rs.next()) {
				cnt++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try {rs.close();} catch (Exception e) {}
			if (stmt != null) DBUtil.disconnect(stmt);
		}
		return cnt;
	}
	public void showStudent() {
		stmt = DBUtil.statement();
		try {
			rs = stmt.executeQuery("select * from student where irum = '"+HaksaView.name+"'");
			while (rs.next()) {
				System.out.println("고유번호 : " + rs.getString("no"));
				System.out.println("나이 : " + rs.getString("age"));
				System.out.println("이름 : " + rs.getString("irum"));
				System.out.println("학번 : " + rs.getString("hakbun"));
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try {rs.close();} catch (Exception e) {}
			if (stmt != null) DBUtil.disconnect(stmt);
		}
	}
	public void showProfessor() {
		stmt = DBUtil.statement();
		try {
			rs = stmt.executeQuery("select * from professor where irum = '"+HaksaView.name+"'");
			while (rs.next()) {
				System.out.println("고유번호 : " + rs.getString("no"));
				System.out.println("나이 : " + rs.getString("age"));
				System.out.println("이름 : " + rs.getString("irum"));
				System.out.println("과목 : " + rs.getString("sub"));
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try {rs.close();} catch (Exception e) {}
			if (stmt != null) DBUtil.disconnect(stmt);
		}
	}
	public void showManager() {
		stmt = DBUtil.statement();
		try {
			rs = stmt.executeQuery("select * from manager where irum = '"+HaksaView.name+"'");
			while (rs.next()) {
				System.out.println("고유번호 : " + rs.getString("no"));
				System.out.println("나이 : " + rs.getString("age"));
				System.out.println("이름 : " + rs.getString("irum"));
				System.out.println("부서 : " + rs.getString("part"));
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try {rs.close();} catch (Exception e) {}
			if (stmt != null) DBUtil.disconnect(stmt);
		}
	}
	public void showStudentList() {
		int counting = 0;
		stmt = DBUtil.statement();
		try {
			rs = stmt.executeQuery("select * from student");
			while (rs.next()) {
				System.out.println("고유번호 : " + rs.getString("no"));
				System.out.println("나이 : " + rs.getString("age"));
				System.out.println("이름 : " + rs.getString("irum"));
				System.out.println("학번 : " + rs.getString("hakbun"));
				System.out.println();
				counting++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try {rs.close();} catch (Exception e) {}
			if (stmt != null) DBUtil.disconnect(stmt);
		}
		if (counting == 0) System.out.println("등록된 학생정보가 없습니다\n");
	}
	public void showProfessorList() {
		int counting = 0;
		stmt = DBUtil.statement();
		try {
			rs = stmt.executeQuery("select * from professor");
			while (rs.next()) {
				System.out.println("고유번호 : " + rs.getString("no"));
				System.out.println("나이 : " + rs.getString("age"));
				System.out.println("이름 : " + rs.getString("irum"));
				System.out.println("과목 : " + rs.getString("sub"));
				System.out.println();
				counting++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try {rs.close();} catch (Exception e) {}
			if (stmt != null) DBUtil.disconnect(stmt);
		}
		if (counting == 0) System.out.println("등록된 교수정보가 없습니다\n");
	}
	public void showManagerList() {
		int counting = 0;
		stmt = DBUtil.statement();
		try {
			rs = stmt.executeQuery("select * from manager");
			while (rs.next()) {
				System.out.println("고유번호 : " + rs.getString("no"));
				System.out.println("나이 : " + rs.getString("age"));
				System.out.println("이름 : " + rs.getString("irum"));
				System.out.println("부서 : " + rs.getString("part"));
				System.out.println();
				counting++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try {rs.close();} catch (Exception e) {}
			if (stmt != null) DBUtil.disconnect(stmt);
		}
		if (counting == 0) System.out.println("등록된 관리자정보가 없습니다\n");
	}
	public void deletePerson(String str) {
		stmt = DBUtil.statement();
		try {
			stmt.executeUpdate("delete from "+str+" where irum = '"+HaksaView.name+"' and no = '"+HaksaView.choiceNo+"'");
			System.out.println(HaksaView.name + "의 정보가 삭제되었습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) DBUtil.disconnect(stmt);
		}
	}
	public void showStudentForDelete() {
		stmt = DBUtil.statement();
		try {
			rs = stmt.executeQuery("select * from student where irum = '"+HaksaView.name+"'");
			while (rs.next()) {
				System.out.println("고유번호 : " + rs.getString("no"));
				System.out.println("나이 : " + rs.getString("age"));
				System.out.println("이름 : " + rs.getString("irum"));
				System.out.println("학번 : " + rs.getString("hakbun"));
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try {rs.close();} catch (Exception e) {}
			if (stmt != null) DBUtil.disconnect(stmt);
		}
		view.choiceNoTitle();
		view.choiceNo();
	}
	public void showProfessorForDelete() {
		stmt = DBUtil.statement();
		try {
			rs = stmt.executeQuery("select * from professor where irum = '"+HaksaView.name+"'");
			while (rs.next()) {
				System.out.println("고유번호 : " + rs.getString("no"));
				System.out.println("나이 : " + rs.getString("age"));
				System.out.println("이름 : " + rs.getString("irum"));
				System.out.println("과목 : " + rs.getString("sub"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try {rs.close();} catch (Exception e) {}
			if (stmt != null) DBUtil.disconnect(stmt);
		}
		view.choiceNoTitle();
		view.choiceNo();
	}
	public void showManagerForDelete() {
		stmt = DBUtil.statement();
		try {
			rs = stmt.executeQuery("select * from manager where irum = '"+HaksaView.name+"'");
			while (rs.next()) {
				System.out.println("고유번호 : " + rs.getString("no"));
				System.out.println("나이 : " + rs.getString("age"));
				System.out.println("이름 : " + rs.getString("irum"));
				System.out.println("부서 : " + rs.getString("part"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try {rs.close();} catch (Exception e) {}
			if (stmt != null) DBUtil.disconnect(stmt);
		}
		view.choiceNoTitle();
		view.choiceNo();
	}
	public void showAllStudent() {
		System.out.println("학생출력");
		stmt = DBUtil.statement();
		int cnt = 0;
		try {
			rs = stmt.executeQuery("select * from student");
			while (rs.next()) {
				System.out.println("고유번호 : " + rs.getString("no"));
				System.out.println("나이 : " + rs.getString("age"));
				System.out.println("이름 : " + rs.getString("irum"));
				System.out.println("학번 : " + rs.getString("hakbun"));
				System.out.println();
				cnt++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try {rs.close();} catch (Exception e) {}
			if (stmt != null) DBUtil.disconnect(stmt);
		}
		if (cnt == 0) System.out.println("등록된 학생정보는 없습니다");
	}
	public void showAllProfessor() {
		System.out.println("교수출력");
		stmt = DBUtil.statement();
		int cnt = 0;
		try {
			rs = stmt.executeQuery("select * from professor");
			while (rs.next()) {
				System.out.println("고유번호 : " + rs.getString("no"));
				System.out.println("나이 : " + rs.getString("age"));
				System.out.println("이름 : " + rs.getString("irum"));
				System.out.println("과목 : " + rs.getString("sub"));
				System.out.println();
				cnt++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try {rs.close();} catch (Exception e) {}
			if (stmt != null) DBUtil.disconnect(stmt);
		}
		if (cnt == 0) System.out.println("등록된 교수정보는 없습니다");
	}
	public void showAllManager() {
		System.out.println("관리자출력");
		stmt = DBUtil.statement();
		int cnt = 0;
		try {
			rs = stmt.executeQuery("select * from manager");
			while (rs.next()) {
				System.out.println("고유번호 : " + rs.getString("no"));
				System.out.println("나이 : " + rs.getString("age"));
				System.out.println("이름 : " + rs.getString("irum"));
				System.out.println("부서 : " + rs.getString("part"));
				System.out.println();
				cnt++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try {rs.close();} catch (Exception e) {}
			if (stmt != null) DBUtil.disconnect(stmt);
		}
		if (cnt == 0) System.out.println("등록된 관리자정보는 없습니다");
	}
}
