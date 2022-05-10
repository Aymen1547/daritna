package tn.dari.Repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import tn.dari.Model.ClientEntity;
@Repository
public interface ClientRepository extends CrudRepository<ClientEntity,Long> {

}
