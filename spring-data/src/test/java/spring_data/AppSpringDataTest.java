package spring_data;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring_data.dao.InterfaceSpringDataUser;
import spring_data.dao.InterfaceTelefone;
import spring_data.model.Telefone;
import spring_data.model.UsuarioSpringDataDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring-config.xml" })
public class AppSpringDataTest {

	@Autowired
	private InterfaceSpringDataUser interfaceSpring;
	
	@Autowired
	private InterfaceTelefone interfaceTelefone;
	


	@Test
	public void testInsert() {
	  UsuarioSpringDataDao usuarioDao = new UsuarioSpringDataDao();
	  
	  usuarioDao.setIdade(27);
	  usuarioDao.setNome("Neres");
	  usuarioDao.setLogin("Neres@hotmail.com");
	  usuarioDao.setSenha("neres");
	  
	  interfaceSpring.save(usuarioDao);
	  
	}

	@Test
	public void testConsultar() {
		Optional<UsuarioSpringDataDao> usuarioDao = interfaceSpring.findById(1L);
		
		System.out.println("ID = " +usuarioDao.get().getId());
		System.out.println("Nome = " +usuarioDao.get().getNome());
		System.out.println("Idade = " +usuarioDao.get().getIdade());
		System.out.println("Login = " +usuarioDao.get().getLogin());
	}
	
	@Test
	public void testConsultarTodos() {

		Iterable<UsuarioSpringDataDao> consultarUsuario = interfaceSpring.findAll();
		
		for (UsuarioSpringDataDao usuarioSpringDataDao : consultarUsuario) {
			System.out.println("ID = " +usuarioSpringDataDao.getId());
			System.out.println("Nome = " +usuarioSpringDataDao.getNome());
			System.out.println("Idade = " +usuarioSpringDataDao.getIdade());
			System.out.println("Login = " +usuarioSpringDataDao.getLogin());
			System.out.println();
		}
	}
	
	@Test
	public void testUpdate() {
		Optional<UsuarioSpringDataDao> atualizar = interfaceSpring.findById(2L);
		
		UsuarioSpringDataDao data = atualizar.get();
		
		data.setNome("Alynne Oliveira");
		
		interfaceSpring.save(data);
		
	}
	
	@Test
	public void testDelete() {
		interfaceSpring.deleteById(3L);
		
	}
	
	@Test
	public void testBuscar() {
		List<UsuarioSpringDataDao> list = interfaceSpring.buscarNome("Pelé");
		
			
		for (UsuarioSpringDataDao usuarioSpringDataDao : list) {
			System.out.println("ID = " +usuarioSpringDataDao.getId());
			System.out.println("Nome = " +usuarioSpringDataDao.getNome());
			System.out.println("Idade = " +usuarioSpringDataDao.getIdade());
			System.out.println("Login = " +usuarioSpringDataDao.getLogin());
			System.out.println();

		} 
	}
	
	@Test
	public void testBuscarNomeExato() {
		UsuarioSpringDataDao usuarioSpringDataDao = interfaceSpring.buscarPorNomeParam("Neres");
		
		System.out.println("ID = " +usuarioSpringDataDao.getId());
		System.out.println("Nome = " +usuarioSpringDataDao.getNome());
		System.out.println("Idade = " +usuarioSpringDataDao.getIdade());
		System.out.println("Login = " +usuarioSpringDataDao.getLogin());
		
	}
	
	@Test
	public void testDeletePorNome() {
		interfaceSpring.deleteProNome("Neres");
	}
	
	@Test
	public void testUpdateLogin() {
		interfaceSpring.updateEmail("alisson.neres@live.com", "Neres");
	}
	
	@Test
	public void testInsertTelefone() {
		Optional<UsuarioSpringDataDao> usuarioSpringDataDao = interfaceSpring.findById(1L);
		
		Telefone telefone = new Telefone();
		
		telefone.setTipo("Celular");
		telefone.setNumero("91709633");
		telefone.setUsuarioSpringDataDao(usuarioSpringDataDao.get());
		
		interfaceTelefone.save(telefone);
	}

}
