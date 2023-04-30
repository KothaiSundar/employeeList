package employee.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import employee.dto.Company;
import employee.dto.Employee;

public class EmployeeDAO {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("sigma");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	
	public void saveEmployee(Employee employee)
	{
		et.begin();
		em.persist(employee);
		et.commit();
	}
	public void updateEmployee(Employee employee)
	{et.begin();
	em.merge(employee);
	et.commit();
     }
	
	public void deleteEmployee(int id)
	
	
	{et.begin();
	em.remove(em.find(Employee.class, id));
	et.commit();
	
     }
	
	public Employee getEmployee(int id)
	{  return em.find(Employee.class, id);
	}
	
	
	public List<Employee> getAllEmployee(Company company)
	{ Query query= em.createQuery("select i from Employee i where i.company=?1");
	
query.setParameter(1, company);
	List employees=query.getResultList();
	return employees;
}

	}
	
	
	
	
	
	