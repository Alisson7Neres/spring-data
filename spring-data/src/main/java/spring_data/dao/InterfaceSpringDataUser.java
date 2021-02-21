package spring_data.dao;

import java.util.List;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring_data.model.UsuarioSpringDataDao;

@Repository
public interface InterfaceSpringDataUser extends CrudRepository<UsuarioSpringDataDao, Long>{
	
	@Transactional(readOnly = true)
	@Query(value = "select p from UsuarioSpringDataDao p where p.nome like %?1%")
	public List<UsuarioSpringDataDao> buscarNome (String nome);
	
	@Lock(LockModeType.READ)
	@Transactional(readOnly = true)
	@Query(value = "select p from UsuarioSpringDataDao p where p.nome = :paramnome")
	public UsuarioSpringDataDao buscarPorNomeParam(@Param ("paramnome")String paranome);
	
	@Modifying
	@Transactional(rollbackFor = NullPointerException.class)
	@Query("delete from UsuarioSpringDataDao u where u.nome = ?1")
	public void deleteProNome(String nome);
	
	@Modifying
	@Transactional
	@Query("update UsuarioSpringDataDao u set u.login = ?1 where u.nome = ?2")
	public void updateEmail(String login, String nome);
}
