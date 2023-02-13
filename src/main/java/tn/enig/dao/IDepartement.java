package tn.enig.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.enig.model.Departement;

@Repository
public interface IDepartement extends JpaRepository<Departement,Integer> {

}
