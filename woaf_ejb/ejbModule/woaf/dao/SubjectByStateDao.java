package woaf.dao;

import java.util.List;

import javax.persistence.EntityManager;

public class SubjectByStateDao {
	private EntityManager em;
	
	public SubjectByStateDao(EntityManager em){
		this.em = em;
	}
	
	public <T> List<T> getSubjectByState(int stateId, Class<T> clazz){
		String jpql =
			" SELECT c FROM " + clazz.getTypeName() + " c " +
			" WHERE c.state.stateId = :stateId";
		return em.createQuery(jpql, clazz)
				.setParameter("stateId", stateId)
				.getResultList();
	}
}