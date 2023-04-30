package employee.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import employee.dto.Company;
import employee.dto.Employee;


public class CompanyDAO {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("sigma");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	public void CompanySignUP(Company company)
	{
		et.begin();
		em.persist(company);
		et.commit();
	}
	public void updateEmployeeList(Company company) {
		et.begin();
		em.merge(company);
		et.commit();
	}
	public Company CompanyLogin(String email, String password)
	{try
	{
		Query query= em.createQuery("select e from Company e where e.companyEmail=?1 and e.companyPassword=?2");
		query.setParameter(1,email);
	    query.setParameter(2,password);
	    Company company= (Company)query.getSingleResult();
	    return company;
	}catch(Exception e)
	{return null;
}
}}
