package cn.test;

import java.sql.SQLException;

import cn.dao.PersonDao;
import cn.dao.PersonDaoImpl;

public class test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		PersonDao dao = new PersonDaoImpl();
		// dao.add(new Person("lalala", 22, "我是通过Java命令而增加的记录"));

		// dao.update(new Person(3, "生命壹号", 23, "我是通过Java命令而修改的记录"));

		dao.delete(3);

		// Person p = dao.findById(1);
		// System.out.println(p);

		// List<Person> persons = dao.findAll();
		// System.out.println(persons);

		long count = dao.personCount();
		System.out.println(count);
	}

}
