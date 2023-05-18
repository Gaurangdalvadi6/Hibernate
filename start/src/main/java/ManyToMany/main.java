package ManyToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class main {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Teacher t1 = new Teacher();
		t1.setId(1);
		t1.setName("jay");
		
		Teacher t2 = new Teacher();
		t2.setId(2);
		t2.setName("darshan");
		
		Student s1 = new Student();
		s1.setId(1);
		s1.setName("gaurang");
		
		Student s2 = new Student();
		s2.setId(2);
		s2.setName("punit");
		
		List<Teacher> tlist = new ArrayList<Teacher>();
		tlist.add(t1);
		tlist.add(t2);
		
		List<Student> slist = new ArrayList<Student>();
		slist.add(s1);
		slist.add(s2);
		
		s1.setTeacher(tlist);
		s2.setTeacher(tlist);
		
		t1.setStudent(slist);
		t2.setStudent(slist);
		
		session.save(s1);
		session.save(s2);
		session.save(t1);
		session.save(t2);
		
		tx.commit();
		session.close();
		sf.close();
	}
}
