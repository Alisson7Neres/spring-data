package spring_data.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spring_data.model.Telefone;

@Repository
public interface InterfaceTelefone extends CrudRepository<Telefone, Long>{

}
